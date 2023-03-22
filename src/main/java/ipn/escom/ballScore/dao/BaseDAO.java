package ipn.escom.ballScore.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import ipn.escom.ballScore.util.HibernateUtil;

/**
 * Clase abstracta para la creación de DAOs
 * 
 * @author Jose Mauricio
 *
 */
public abstract class BaseDAO {

	private static final Logger logger = LogManager.getLogger();
	Session session;

	/**
	 * Constructor para la clase DAO que inicia una session con la base de datos
	 */
	public BaseDAO() {
		try {
			this.session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			logger.error("Error al crear la sesión con la base de datos", e);
		}
	}

	/**
	 * Metodo para cerrar la conexion creada en caso de que estuviera abierta
	 * 
	 * @return true si la conexión esta cerrada
	 */
	public boolean cerrarConexiones() {
		if(this.session.isOpen())
			this.session.close();
		return true;
	}
}
