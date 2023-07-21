
package src.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import src.util.HibernateUtil;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "stok_kart")
@Entity
public class StokKart {

	@Id
	@Column(name = "stok_kodu")
	private String stokKodu;

	@Column(name = "stok_adi")
	private String stokAdi;

//	@ManyToOne(fetch=FetchType.EAGER)
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(name="stok_tipi")
//	private StokTipiKart stokTipi;

	@Column(name = "stok_tipi")
	private int stokTipi;

	@Column(name = "birimi")
	private String birim;

	@Column(name = "barkodu")
	private String barkod;

//	@ManyToOne(fetch=FetchType.EAGER)
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(name="KDVTipi")
//	private KdvTipKart kdvtipi;

	@Column(name = "KDVTipi")
	private double kdvtipi;

	@Column(name = "aciklama")
	private String aciklama;

	@Column(name = "OlusturmaTarihi")
	private Date olusturmaTarihi;

	public List<StokKart> listStoks() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			return (List<StokKart>) session.createQuery("SELECT a FROM StokKart a ").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;

	}

	public void saveOrUpdate(String stokKodu, String stokAdi, int stokTipi, String birim, String barkod, double kdvTipi,
			String aciklama, Date olusTarih) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			session.saveOrUpdate(StokKart.builder().stokKodu(stokKodu).stokAdi(stokAdi).stokTipi(stokTipi).birim(birim)
					.barkod(barkod).kdvtipi(kdvTipi).aciklama(aciklama).olusturmaTarihi(olusTarih).build());
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

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

	public List search() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			org.hibernate.query.Query query = session
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

	public List<List<String>> getAllRows() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			List query = session.createSQLQuery(
					"SELECT  stok_kodu,stok_adi,stoktip_kodu, stoktip_adi, stoktip_aciklama, birimi, barkodu,kdvtip_orani, kdvtip_kodu, kdvtip_adi, aciklama,OlusturmaTarihi\r\n"
							+ "FROM stok_kart LEFT  JOIN  kdv_tip_kart ON stok_kart.kdvTipi = kdv_tip_kart.kdvtip_orani \r\n"
							+ "LEFT JOIN stok_tip_kart ON stok_kart.stok_tipi = stok_tip_kart.stoktip_kodu")
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

	public Integer getLastItemIndex() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Query query = session.createSQLQuery("SELECT COUNT(*) FROM stok_kart");

			return ((Number) query.uniqueResult()).intValue();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}