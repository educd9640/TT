package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.entity.Temporada;

/**Clase DAO para gestrionar partidos
 * @author Eduardo Callejas
 *
 */
public class GestionarPartidosDAO extends BaseDAO{
	
	public GestionarPartidosDAO() {
		super();
	}
	
	/**Metodo para insertar un partido
	 * @param partido
	 * @return la entidad persistida
	 * @throws SQLException
	 */
	public Partido insertIntoPartido(Partido partido) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		partido.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(partido);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return partido;
	}
	
	
	/**Metodo para consultar todos los partidos registrados
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartido(){
		Query q = session.createQuery("from Partido");
		return(List<Partido>)q.list();
	}
	
	
	/**Metodo para actualizar un partido
	 * @param partido
	 * @return la entidad persistida
	 * @throws SQLException en caso de error
	 */
	public Partido updatePartido(Partido partido) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		partido.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.update(partido);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return partido;
	}
	
	
	/**Metodo para obtener un partido por su id
	 * @param id del partido
	 * @return
	 */
	public Partido selectPartidoById(Long id) {
		return(Partido) this.session.get(Partido.class, id);
	}
	
	
	/**Metodo para activar/desactivar un partido
	 * @param partido
	 * @throws SQLException en caso de error
	 */
	public void estadoPartido(Partido partido) throws SQLException {
		if(partido.getFechaAlta()!=null) {
			partido.setFechaAlta(null);
		}else {
			java.util.Date utilDate = new java.util.Date();
			partido.setFechaAlta(new Date(utilDate.getTime()));
		}
		try {
			session.update(partido);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
	}
	

}
