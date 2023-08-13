package src.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JInternalFrame;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.Audited;
import org.hibernate.transform.Transformers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import src.util.HibernateUtil;
import src.view.baseViews.BaseMenuFrame;
import src.view.menus.StokTipKartMenuView;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Builder
@Entity
@Table(name = "stok_tip_kart")
public class StokTipiKart implements BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stoktip_id")
	private int id;

	@Column(name = "stoktip_kodu")
	private String kodu;

	@Column(name = "stoktip_adi")
	private String adi;
	@Column(name = "stoktip_aciklama")
	private String aciklama;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(getKodu());
	}

	public StokTipiKart findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Query query = session.createQuery("Select a from StokTipiKart a WHERE a.id=?1", StokTipiKart.class);
			return (StokTipiKart) query.setParameter(1, id).uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<StokTipiKart> getTipList() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			return (List<StokTipiKart>) session.createQuery("SELECT a FROM StokTipiKart a ").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<List<String>> findByIndex(String afterRow) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			return session.createSQLQuery(
					"SELECT * FROM stok_tip_kart WHERE stoktip_kodu > '" + afterRow + "' ORDER BY stoktip_kodu LIMIT 1")
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

			Query<?> query = session.createSQLQuery("SELECT COUNT(*) FROM stok_tip_kart");

			return ((Number) query.uniqueResult()).intValue();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public void delete(String stokTipKodu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(StokTipiKart.class);
			StokTipiKart deleteTipKart = (StokTipiKart) criteria.add(Restrictions.eq("kodu", stokTipKodu))
					.uniqueResult();

			session.delete(deleteTipKart);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			if (session != null)
				session.close();
		}

	}

	public void setData(StokTipiKart tipiKart, StokTipKartMenuView frame) {
		frame.kod.setText(tipiKart.getKodu());
		frame.tipAdiField.setText(tipiKart.getAdi());
		frame.tipAciklamaField.setText(tipiKart.getAciklama());
	}

	public void setData(StokTipiKart tipiKart) {
		this.setKodu(tipiKart.getKodu());
		this.setAdi(tipiKart.getAdi());
		this.setAciklama(tipiKart.getAciklama());
		this.setId(id);
	}

	@Override
	public void travelseForward(String kodu, JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
//TODO Database fixing
			StokTipiKart returnList = session
					.createQuery("SELECT a FROM StokTipiKart a WHERE a.kodu > '" + kodu + "' ORDER BY a.kodu",
							StokTipiKart.class)
					.setMaxResults(1).uniqueResult();

			if (returnList == null) {
				travelseForward("", frame);
				return;
			}

			setData(returnList, (StokTipKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return;
	}

	@Override
	public void travelseBackward(String kodu, JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
//TODO Database fixing
			StokTipiKart returnList = session
					.createQuery("SELECT a FROM StokTipiKart a WHERE a.kodu < '" + kodu + "' ORDER BY a.kodu desc",
							StokTipiKart.class)
					.setMaxResults(1).uniqueResult();

			if (returnList == null) {
				returnList = session
						.createQuery("SELECT a FROM StokTipiKart a ORDER BY a.kodu desc", StokTipiKart.class)

						.setMaxResults(1).uniqueResult();
			}

			setData(returnList, (StokTipKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return;
	}

	public void save(JInternalFrame frame) {
		StokTipKartMenuView saveFrame = (StokTipKartMenuView) frame;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(StokTipiKart.builder().kodu(saveFrame.kod.getText())
					.adi(saveFrame.tipAdiField.getText()).aciklama(saveFrame.tipAciklamaField.getText()).build());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void getData(BaseMenuFrame menuClass) {
		StokTipKartMenuView frame = (StokTipKartMenuView) menuClass;
		this.setKodu(frame.kod.getText());
		this.setAciklama(frame.tipAciklamaField.getText());
		this.setAdi(frame.tipAdiField.getText());
	}

	@Override
	public void travelseLast(JInternalFrame frame) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
//TODO Database fixing
			List<StokTipiKart> returnList = session
					.createQuery("SELECT a FROM StokTipiKart a ORDER BY a.kodu DESC", StokTipiKart.class).list();

			setData(returnList.get(0), (StokTipKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception

		}
		return;
	}

	@Override
	public void travelseFirst(JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
//TODO Database fixing
			List<StokTipiKart> returnList = session
					.createQuery("SELECT a FROM StokTipiKart a ORDER BY a.kodu ASC", StokTipiKart.class).list();

			setData(returnList.get(0), (StokTipKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception

		}
		return;
	}

	@Override
	public List getAllRows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKod(Object eskiDegisen, Object yeniDegisen, BaseMenuFrame frame) {
		// TODO Auto-generated method stub

	}
}
