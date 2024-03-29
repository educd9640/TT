package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import ipn.escom.ballScore.entity.Equipo;

/**Clase DAO para gestionar equipos
 * @author Cisneros Christian
 *
 */
public class GestionarEquiposDAO extends BaseDAO {

	/**
	 * Constructor de la clase DAO
	 */
	public GestionarEquiposDAO() {
		super();
	}
	
	/**Metodo para insert un equipo
	 * @param entidad con los datos del equipo
	 * @return la entidad persistida
	 * @throws SQLException En caso de error al persistir la entidad
	 */
	public Equipo insertIntoEquipo(Equipo entidad) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return entidad;
	}
	
	/**Metodo para actualizar un equipo
	 * @param entidad con los datos del equipo
	 * @return la entidad actualizada
	 * @throws SQLException En caso de error al actualizar la entidad
	 */
	public Equipo updateEquipo(Equipo entidad) throws SQLException{
		try 
		{
			session.update(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(),e.getCause());
		}
		
		return entidad;
		
	}
	
	/**Metodo para activar un equipo
	 * @param entidad con los datos del equipo
	 * @return la entidad con la fecha modificada
	 * @throws SQLException En caso de error al activar la entidad
	 */
	
	public Equipo altaEquipo (Equipo entidad) throws SQLException{
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		try 
		{
			session.update(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(),e.getCause());
		}
		
		return entidad;
	}
	
	/**Metodo para desactivar un equipo
	 * @param entidad con los datos del equipo
	 * @return la entidad con la fecha vacia
	 * @throws SQLException En caso de error al desactivar la entidad
	 */
	
	public Equipo bajaEquipo (Equipo entidad) throws SQLException{
		entidad.setFechaAlta(null);
		try 
		{
			session.update(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(),e.getCause());
		}
		
		return entidad;
	}
	
	/**Metodo para buscar un equipo de acuerdo a su manager (id)
	 * @param id del manager
	 * @return la entidad Equipo de acorde al id del manager
	 */
	public Equipo obtenerManager(Long id){
		return (Equipo) session.createQuery("from Equipo where ID_MANAGER = :id").setParameter("id",id).uniqueResult();
	}
	
	/**Metodo para buscar un equipo de acuerdo a su (id)
	 * @param id del equipo
	 * @return la entidad Equipo de acorde al id
	 */
	public Equipo obtenerEquipo(Long id){
		return (Equipo) session.createQuery("from Equipo where ID_EQUIPO = :id").setParameter("id",id).uniqueResult();
	}
	
	/**Metodo para consultar todos los equipos registrados
	 * @return Lista con las entidades de cada equipo registrado
	 */
	@SuppressWarnings("unchecked")
	public List<Equipo> selectFromEquipo(){
		Query q = session.createQuery("from Equipo");
		return (List<Equipo>)q.list();
	}
	
	/**Metodo para consultar un equipos de acorde al id del manager
	 * @param idManager del manager
	 * @return Lista con los equipos cuyo manager tenga dicho id
	 */
	@SuppressWarnings("unchecked")
	public List<Equipo> obtenerEquipoDelManager(Long idManager) {
		Query q = session.createQuery("from Equipo where id_Manager =:idManager");
		q.setParameter("idManager", idManager);
		return(List<Equipo>) q.list();
	}
	
	/**Metodo para obtener un equipo por su id
	 * @param id del equipo
	 * @return La entidad Equipo con sus datos
	 */
	public Equipo selectEquipoById(Long id) {
		return(Equipo) this.session.get(Equipo.class, id);
	}
	
}



