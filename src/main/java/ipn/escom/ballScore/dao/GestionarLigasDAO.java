package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Liga;

/**Clase DAO para gestionar ligas
 * @author Eduardo Callejas
 *
 */
public class GestionarLigasDAO extends BaseDAO{

	/**
	 * Constructor de la clase DAO
	 */
	public GestionarLigasDAO() {
		super();
	}
	
	/**Metodo para insertar una liga
	 * @param entidad con los datos de la liga(LigaVO)
	 * @return la entidad persistida
	 * @throws SQLException en caso de error
	 */
	public Liga insertIntoLiga(Liga liga) throws SQLException{
		java.util.Date utilDate = new java.util.Date();
		liga.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(liga);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return liga;
	}
	
	
	/**Metodo para actualizar una liga
	 * @param ligaVO
	 * @throws SQLException en caso de error
	 */
	public Liga updateLiga(Liga liga) throws SQLException {
		try {
			session.update(liga);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return liga;
	}
	
	
	
	
	/**Metodo para eliminar una liga
	 * @param ligaVO liga en cuestión
	 * @throws SQLException en caso de error
	 */
	public void deleteLiga(Liga liga) throws SQLException {
		try {
			session.delete(liga);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
	}
	
	
	
	/**Metodo para consultar todas las ligas registradas
	 * @return Lista de ligas registradas
	 */
	@SuppressWarnings("unchecked")
	public List<Liga> selectLiga () {
		Query q = session.createQuery("from Liga");
		return (List<Liga>)q.list();
	}
	
	/**Metodo para obtener una liga por su id
	 * @param id de la Liga
	 * @return La entidad Liga con sus datos
	 */
	public Liga selectLigaById(Long id) {
		return(Liga) this.session.get(Liga.class, id);
	}
}
