package src.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.swing.JInternalFrame;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import src.util.HibernateUtil;
import src.view.BaseMenuFrame;
import src.view.KdvTipiKartMenuView;
import src.view.StokTipKartMenuView;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "kdv_tip_kart")
public class KdvTipKart implements BaseModel {
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void travelseForward(String kodu, JInternalFrame frame) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			KdvTipKart returnList = session
					.createQuery("SELECT a FROM KdvTipKart a WHERE a.kodu > '" + kodu + "' ORDER BY a.kodu",
							KdvTipKart.class)
					.setMaxResults(1).uniqueResult();

			if (returnList == null) {
				travelseForward("", frame);
				return;
			}

			setData(returnList, (KdvTipiKartMenuView) frame);

			return;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return;
	}

	public void travelseBackward(String kodu, JInternalFrame frame) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			KdvTipKart returnList = session
					.createQuery("SELECT a FROM KdvTipKart a WHERE a.kodu <'" + kodu + "' ORDER BY a.kodu desc",
							KdvTipKart.class)
					.setMaxResults(1).uniqueResult();

			if (returnList == null) {
				returnList = session.createQuery("SELECT a FROM KdvTipKart a ORDER BY a.kodu DESC", KdvTipKart.class)
						.setMaxResults(1).uniqueResult();
			}

			setData(returnList, (KdvTipiKartMenuView) frame);

			return;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return;

	}

	public void setData(KdvTipKart tipKart, KdvTipiKartMenuView frame) {
		frame.kod.setText(tipKart.getKodu());
		frame.kdvAdiField.setText(tipKart.getAdi());
		frame.kdvOraniField.setText(Double.toString(tipKart.getOrani()));
	}

	@SuppressWarnings("deprecation")
	public Integer getLastItemIndex() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Query<?> query = session.createSQLQuery("SELECT COUNT(kdvtip_id) FROM kdv_tip_kart");

			return ((Number) query.uniqueResult()).intValue();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public void delete(String kdvTipKod) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria criteria = session.createCriteria(KdvTipKart.class);
			KdvTipKart deleteTipKart = (KdvTipKart) criteria.add(Restrictions.eq("kodu", kdvTipKod)).uniqueResult();

			session.delete(deleteTipKart);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.saveOrUpdate(
					KdvTipKart.builder().adi(this.getAdi()).kodu(this.getKodu()).orani(this.getOrani()).build());
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
		KdvTipiKartMenuView frame = (KdvTipiKartMenuView) menuClass;
		this.setKodu(frame.kod.getText());
		this.setAdi(frame.kdvAdiField.getText());
		this.setAdi(frame.kdvAdiField.getText());
		this.setOrani(Double.parseDouble(frame.kdvOraniField.getText()));
	}

	@Override
	public void travelseLast(JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
//TODO Database fixing
			List<KdvTipKart> returnList = session
					.createQuery("SELECT a FROM KdvTipKart a ORDER BY a.kodu DESC", KdvTipKart.class).list();

			setData(returnList.get(0), (KdvTipiKartMenuView) frame);

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
			List<KdvTipKart> returnList = session
					.createQuery("SELECT a FROM KdvTipKart a ORDER BY a.kodu ASC", KdvTipKart.class).list();

			setData(returnList.get(0), (KdvTipiKartMenuView) frame);

			return;

		} catch (Exception e) {
			// TODO: handle exception

		}
		return;
	}

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<List<String>> getAllRows() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			List<List<String>> query = session.createSQLQuery(
					"SELECT kdvtip_kodu, kdvtip_adi, kdvtip_orani from kdv_tip_kart")
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
}
