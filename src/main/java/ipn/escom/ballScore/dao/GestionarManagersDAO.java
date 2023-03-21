package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;

import org.hibernate.Query;
import ipn.escom.ballScore.entity.Manager;

/**Clase DAO para gestionar los managers
 * @author Jose Mauricio
 *
 */
public class GestionarManagersDAO extends BaseDAO{
	
	/**
	 * Metodo contructor para la clase DAO
	 */
	public GestionarManagersDAO() {
		super();
	}
	
	/**Metodo para insertar un manager
	 * @param entidad con los datos del manager
	 * @return Id con el que se persistio la entidad
	 * @throws SQLException En caso de error al persistir
	 */
	public Long insertIntoManagers(Manager entidad) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(entidad);
			session.flush();
			session.clear();
		} catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return entidad.getIdManager();
	}
	
	/**Metodo para consultar un manager por correo
	 * @param correo del manager
	 * @return Entidad del manager con sus datos
	 */
	public Manager selectManagerByCorreo(String correo) {
		Query q = session.createQuery("from Manager m where m.correo=:correo");
		q.setParameter("correo", correo);
		return (Manager) q.uniqueResult();
	}
	
}
