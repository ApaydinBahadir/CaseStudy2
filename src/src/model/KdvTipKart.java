package src.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JInternalFrame;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import src.util.HibernateUtil;
import src.view.baseViews.BaseMenuFrame;
import src.view.menus.KdvTipiKartMenuView;
import org.apache.logging.log4j.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
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

	@Transient
	private Logger logger = LogManager.getLogger(KdvTipKart.class.getName());
	
	@SuppressWarnings("unchecked")
	public List<KdvTipKart> getKDV() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			logger.info("KdvTipKart dataları çekildi.");
			return (List<KdvTipKart>) session.createQuery("SELECT a FROM KdvTipKart a ").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;

	}

	public KdvTipKart findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			logger.info("KdvTipKart id="+id+" databaseden çekildi.");
			KdvTipKart returnObject = session.load(KdvTipKart.class, id);
			return returnObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

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
		Transaction tx = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(KdvTipKart.class);
			KdvTipKart deleteTipKart = (KdvTipKart) criteria.add(Restrictions.eq("kodu", kdvTipKod)).uniqueResult();
			session.delete(deleteTipKart);
			logger.info("KdvTipKart kdv_tip_kod"+kdvTipKod+" silindi.");
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
	public void save(JInternalFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		KdvTipiKartMenuView saveFrame = (KdvTipiKartMenuView) frame;
		Transaction tx = session.beginTransaction();
		try {
			KdvTipKart saveKart = KdvTipKart.builder().adi(saveFrame.kdvAdiField.getText()).kodu(saveFrame.kod.getText())
			.orani(Double.parseDouble(saveFrame.kdvOraniField.getText())).build();
			session.saveOrUpdate(saveKart);
			logger.info("KdvTipKart = "+saveKart+" silindi.");

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		tx.rollback();
		session.close();
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
	public List<KdvTipKart> getAllRows() {
		logger.info("KdvTipKart dataları çekildi.");

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			List query = session.createQuery("SELECT a from KdvTipKart a", KdvTipKart.class).list();

			return query;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@Override
	public String toString() {
		return String.valueOf(getOrani());
	}

	@Override
	public void updateKod(Object eskiDegisen, Object yeniDegisen, BaseMenuFrame frame) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		int result = session.createSQLQuery(
				"Update kdv_tip_kart set kdvtip_kodu='" + yeniDegisen + "'where kdvtip_kodu='" + eskiDegisen + "'")
				.executeUpdate();

		tx.commit();

	}
}
