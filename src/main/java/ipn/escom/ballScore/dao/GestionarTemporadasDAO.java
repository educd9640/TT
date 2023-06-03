package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import ipn.escom.ballScore.entity.Temporada;

/**Clase DAO para gestionar ligas
 * @author Eduardo Callejas
 *
 */
public class GestionarTemporadasDAO extends BaseDAO{
	
	
	/**
	 * Constructor de la clase DAO
	 */
	public GestionarTemporadasDAO() {
		super();
	}
	
	
	/**Metodo para insertar una temporada
	 * @param temporada temporada a persistir
	 * @return la entidad persistida
	 * @throws SQLException en caso de error al persistir
	 */
	public Temporada insertIntoTemporada(Temporada temporada)throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		temporada.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(temporada);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return temporada;
	}
	
	
	/**Metodo para consultar todas las temporadas registradas
	 * @return lista de temporadas
	 */
	@SuppressWarnings("unchecked")
	public List<Temporada> selectFromTemporada(){
		Query q = session.createQuery("from Temporada");
		return (List<Temporada>)q.list();
	}
	
	
	
	
	/**Metodo para actualizar una temporada
	 * @param temporada a actualizar
	 * @return la entidad persistida
	 * @throws SQLException en caso de error
	 */
	public Temporada updateTemporada(Temporada temporada) throws SQLException{
		java.util.Date utilDate = new java.util.Date();
		temporada.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.update(temporada);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return temporada;
	}
	
	
	/**Metodo para obtener una temporada por su id
	 * @param id de la temporada
	 * @return La entidad Temporada con sus datos
	 */
	public Temporada selectTemporadaById(Long id) {
		return(Temporada) this.session.get(Temporada.class, id);
	}
	
	
	
	
	/**Metodo para activar/desactivar una Temporada
	 * @param temporada temporada en cuestion
	 * @throws SQLException en caso de error
	 */
	public void estadoTemporada(Temporada temporada) throws SQLException{
		if(temporada.getFechaAlta()!=null) {
			temporada.setFechaAlta(null);
		}else {
			java.util.Date utilDate = new java.util.Date();
			temporada.setFechaAlta(new Date(utilDate.getTime()));
		}
		try {
			session.update(temporada);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
	}
}
