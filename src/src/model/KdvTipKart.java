package src.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "kdv_tip_kart")
public class KdvTipKart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kdvtip_id")
	private int id;
	@Column(name = "kdvtip_kodu")
	private String kodu;
	@Column(name = "kdvtip_adi")
	private String adi;
	@Column(name = "kdvtip_orani")
	private double orani;

	public void saveOrUpdate(String kodu, String adi, double orani) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.saveOrUpdate(KdvTipKart.builder().kodu(kodu).adi(adi).orani(orani).build());
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<KdvTipKart> getKDV() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			return (List<KdvTipKart>) session.createQuery("SELECT a FROM KdvTipKart a ").list();
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
			
			return session.createSQLQuery("SELECT * FROM kdv_tip_kart limit "+limitInteger+",1").setResultTransformer(Transformers.TO_LIST).list();

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Integer getLastItemIndex() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Query query = session.createSQLQuery("SELECT COUNT(kdvtip_id) FROM kdv_tip_kart");
			
			return ((Number) query.uniqueResult()).intValue();

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
