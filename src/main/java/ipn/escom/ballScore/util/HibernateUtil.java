package ipn.escom.ballScore.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ариорх on 27.05.2017.
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static final Logger logger = LogManager.getLogger();

	static {
		try {
			Configuration cfg = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			sessionFactory = cfg.buildSessionFactory(builder.build());
		} catch (Exception e) {
			logger.error("Error al realizar la configuración de Hibernate", e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}