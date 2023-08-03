
package src.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JInternalFrame;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.transform.Transformers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import src.util.HibernateUtil;
import src.view.BaseMenuFrame;
import src.view.StokKartMenuView;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "stok_kart")
@Entity
public class StokKart implements BaseModel {

	@Id
	@Column(name = "stok_kodu")
	private String stokKodu;

	@Column(name = "stok_adi")
	private String stokAdi;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "stok_tipi", nullable = false, referencedColumnName = "stoktip_kodu")
	private StokTipiKart stokTipi;

	@Column(name = "birimi")
	private String birim;

	@Column(name = "barkodu")
	private String barkod;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "KDVTipi", nullable = false, referencedColumnName = "kdvtip_orani")

	private KdvTipKart kdvtipi;

	@Column(name = "aciklama")
	private String aciklama;

	@Column(name = "OlusturmaTarihi")
	private Date olusturmaTarihi;

	@Transient
	public String searchString = "";

	public void delete(String stokKodu) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.delete((StokKart) session.load(StokKart.class, stokKodu));
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}

	}

	public List<?> search() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			org.hibernate.query.Query<?> query = session
					.createQuery("Select a FROM StokKart a WHERE a.stokKodu Like :stokKodu");
			query.setParameter("stokKodu", stokKodu + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<List<String>> getAllRows() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			List<List<String>> query = session.createSQLQuery(
					"SELECT  stok_kodu,stok_adi,stoktip_kodu, stoktip_adi, stoktip_aciklama, birimi, barkodu,kdvtip_orani, kdvtip_kodu, kdvtip_adi, aciklama,OlusturmaTarihi\r\n"
							+ "FROM stok_kart LEFT  JOIN  kdv_tip_kart ON stok_kart.kdvTipi = kdv_tip_kart.kdvtip_orani \r\n"
							+ "LEFT JOIN stok_tip_kart ON stok_kart.stok_tipi = stok_tip_kart.stoktip_kodu WHERE stok_kodu like '"
							+ searchString + "%'")
					.setResultTransformer(Transformers.TO_LIST).list();

			return query;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@SuppressWarnings("deprecation")
	public List<List<String>> findByIndex(int limitInteger) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			return session.createSQLQuery("SELECT * FROM stok_kart limit " + limitInteger + ",1")
					.setResultTransformer(Transformers.TO_LIST).list();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	@SuppressWarnings("deprecation")
	public Integer getLastItemIndex() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Query<?> query = session.createSQLQuery("SELECT COUNT(*) FROM stok_kart");

			return ((Number) query.uniqueResult()).intValue();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void setData(StokKart stokKart, StokKartMenuView frame) {
		frame.kod.setText(stokKart.getStokKodu());
		frame.stokAdiField.setText(stokKart.getStokAdi());
		frame.stokTipiField.setSelectedItem(stokKart.getStokTipi().getKodu());
		frame.birimField.setSelectedItem(stokKart.getBirim());
		frame.barkodField.setText(stokKart.getBarkod());
		frame.aciklamaField.setText(stokKart.getAciklama());
		frame.olusTarihField.setDate(stokKart.getOlusturmaTarihi());
		frame.kdvTipiField.setSelectedItem(stokKart.getKdvtipi().getOrani());
	}

	public void setData(List datas, StokKartMenuView frame) {

		frame.kod.setText((String) datas.get(0));
		frame.stokAdiField.setText((String) datas.get(1));
		frame.stokTipiField.setSelectedItem((String) datas.get(2));
		frame.birimField.setSelectedItem((String) datas.get(3));
		frame.barkodField.setText((String) datas.get(4));
		frame.kdvTipiField.setSelectedItem(datas.get(5));

		frame.aciklamaField.setText((String) datas.get(6));

		frame.olusTarihField.setDate((Date) datas.get(7));
	}

	public void setData(HashMap<String, Object> datas, StokKartMenuView frame) {

		frame.kod.setText((String) datas.get("stok_kodu"));
		frame.stokAdiField.setText((String) datas.get("stok_adi"));
		frame.stokTipiField.setSelectedItem((String) datas.get("stok_tipi"));
		frame.birimField.setSelectedItem((String) datas.get("birimi"));
		frame.barkodField.setText((String) datas.get("barkodu"));
		frame.kdvTipiField.setSelectedItem(datas.get("KDVTipi"));
		frame.aciklamaField.setText((String) datas.get("aciklama"));
		frame.olusTarihField.setDate((Date) datas.get("OlusturmaTarihi"));
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void travelseForward(String kodu, JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
//			StokKart returnList = session.createQuery("SELECT a.stokKodu FROM StokKart a WHERE a.stokKodu > '" + kodu + "' ORDER BY a.stokKodu",StokKart.class).setMaxResults(1).uniqueResult();
			Object returnList = session.createSQLQuery(
					"SELECT stok_adi,stok_tipi,aciklama,barkodu,stok_kodu,KDVTipi,birimi,OlusturmaTarihi FROM stok_kart Where stok_kodu > '"
							+ kodu + "' ORDER BY stok_kodu")
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getSingleResult();

			if (returnList == null) {
				travelseForward("", frame);
				return;
			}

			setData((HashMap) returnList, (StokKartMenuView) frame);

			return;

		} catch (Exception e) {
		}
		return;
	}

	@Override
	public void travelseBackward(String kodu, JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Object returnList = session.createSQLQuery(
					"SELECT stok_adi,stok_tipi,aciklama,barkodu,stok_kodu,KDVTipi,birimi,OlusturmaTarihi FROM stok_kart Where stok_kodu < '"
							+ kodu + "' ORDER BY stok_kodu")
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getSingleResult();

			if (returnList == null) {
				returnList = session.createQuery(
						"SELECT stok_adi,stok_tipi,aciklama,barkodu,stok_kodu,KDVTipi,birimi,OlusturmaTarihi FROM stok_kart ORDER BY stok_kodu desc")
						.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getSingleResult();
			}

			setData((HashMap) returnList, (StokKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return;
	}

	public void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.saveOrUpdate(StokKart.builder().aciklama(this.getAciklama()).barkod(this.getBarkod())
					.birim(this.getBirim()).kdvtipi(this.getKdvtipi()).olusturmaTarihi(this.getOlusturmaTarihi())
					.stokAdi(this.getStokAdi()).stokKodu(this.getStokKodu()).stokTipi(this.getStokTipi()).build());
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void getData(BaseMenuFrame menuClass) {
		StokKartMenuView frame = (StokKartMenuView) menuClass;
		this.setAciklama(frame.aciklamaField.getText());
		this.setBarkod(frame.barkodField.getText());
		this.setBirim(frame.birimField.getSelectedItem().toString());
		this.setKdvtipi((KdvTipKart) frame.kdvTipiField.getSelectedItem());
		this.setOlusturmaTarihi(frame.olusTarihField.getDate());
		this.setStokAdi(frame.stokAdiField.getText());
		this.setStokKodu(frame.kod.getText());
		this.setStokTipi((StokTipiKart) frame.stokTipiField.getSelectedItem());
	}

	@Override
	public void travelseLast(JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Object returnList = session.createSQLQuery(
					"SELECT stok_adi,stok_tipi,aciklama,barkodu,stok_kodu,KDVTipi,birimi,OlusturmaTarihi FROM stok_kart ORDER BY stok_kodu DESC")
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getSingleResult();

			setData((HashMap) returnList, (StokKartMenuView) frame);

			return;

		} catch (Exception e) {
		}
	}

	@Override
	public void travelseFirst(JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Object returnList = session.createSQLQuery(
					"SELECT stok_adi,stok_tipi,aciklama,barkodu,stok_kodu,KDVTipi,birimi,OlusturmaTarihi FROM stok_kart ORDER BY stok_kodu ASC")
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getSingleResult();

			setData((HashMap) returnList, (StokKartMenuView) frame);

			return;

		} catch (Exception e) {

		}
		return;
	}
}