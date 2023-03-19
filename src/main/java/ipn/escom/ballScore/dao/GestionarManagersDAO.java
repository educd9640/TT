package ipn.escom.ballScore.dao;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;

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
	 */
	public Long insertIntoManagers(Manager entidad) {
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		session.save(entidad);
		session.flush();
		session.clear();
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
