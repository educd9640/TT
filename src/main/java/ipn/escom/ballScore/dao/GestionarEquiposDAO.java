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
	
	/**Metodo para buscar un equipo de acuerdo a su manager (id)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Equipo obtenerManager(Long id){
		return (Equipo) session.createQuery("from Equipo where ID_MANAGER = :id").setParameter("id",id).uniqueResult();
	}
	
}



