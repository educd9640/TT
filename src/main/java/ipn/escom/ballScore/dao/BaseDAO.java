package ipn.escom.ballScore.dao;

import org.hibernate.Session;

import ipn.escom.ballScore.util.HibernateUtil;

/**Clase abstracta para la creación de DAOs
 * @author Jose Mauricio
 *
 */
public abstract class BaseDAO {

Session session;
	
	/**
	 * Constructor para la clase DAO que inicia una session con la base de datos
	 */
	public BaseDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	/**Metodo para cerrar la conexion creada en caso de que estuviera abierta
	 * @return true si la conexión esta cerrada
	 */
	public boolean cerrarConexiones() {
		if(this.session.isOpen())
			this.session.close();
		return true;
	}
}
