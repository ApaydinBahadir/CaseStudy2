package src.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity
@Table(name="stok_tip_kart")
public class StokTipiKart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stoktip_id")
	private int id;
	@Column(name="stoktip_kodu")
	private int kodu;
	@Column(name="stoktip_adi")
	private String adi;
	@Column(name="stoktip_aciklama")
	private String aciklama;

	public void saveOrUpdate(int kodu, String adi, String aciklama){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.saveOrUpdate(StokTipiKart.builder()
					.kodu(kodu)
					.adi(adi)
					.aciklama(aciklama)
					.build()
					);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	

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
	

	public List<List<String>> findByIndex(int limitInteger) {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			return session.createSQLQuery("SELECT * FROM stok_tip_kart limit "+limitInteger+",1").setResultTransformer(Transformers.TO_LIST).list();

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Integer getLastItemIndex() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Query query = session.createSQLQuery("SELECT COUNT(*) FROM stok_tip_kart");
			
			return ((Number) query.uniqueResult()).intValue();

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
