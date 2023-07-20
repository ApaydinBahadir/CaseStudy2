package src.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import src.model.KdvTipKart;
import src.model.StokKart;
import src.model.StokTipiKart;

public class HibernateUtil {

	private static SessionFactory builtSessionFactory() {

		ServiceRegistry serviceRegistery = new StandardServiceRegistryBuilder().configure()
				.loadProperties("hibernate.cfg.xml").build();
		SessionFactory sf = new Configuration()

				.configure().addAnnotatedClass(StokKart.class).addAnnotatedClass(KdvTipKart.class)
				.addAnnotatedClass(StokTipiKart.class).buildSessionFactory(serviceRegistery);
		return sf;

	}

	private static SessionFactory sessionFactory = builtSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
