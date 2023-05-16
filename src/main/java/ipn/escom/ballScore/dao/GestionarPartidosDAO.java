package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Partido;

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
	 * @return partidos
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartido(){
		Query q = session.createQuery("from Partido");
		return(List<Partido>)q.list();
	}
	
	/**Metodo para consultar partidos por id
	 * @param idPartido del partido
	 * @return partidos
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartidoById(Long idPartido){
		Query q = session.createQuery("from Partido par where par.idPartido = :idPartido");
		q.setParameter("idPartido", idPartido);
		return(List<Partido>)q.list();
	}
	
	/**Metodo para consultar los partidos del equipo local
	 * @param nombreEquipoLocal del equipo local
	 * @return partidos
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartidoByNombreEquipoLocal(String nombreEquipoLocal){
		Query q = session.createQuery("from Partido par where upper(par.equipoTemporadaLocal.equipo.nombre) like :nombreEquipoLocal");
		q.setParameter("nombreEquipoLocal", nombreEquipoLocal.toUpperCase()+"%");
		return(List<Partido>)q.list();
	}
	
	/**Metodo para consultar partidos del equipo visitante
	 * @param nombreEquipoVisitante del equipo visitante
	 * @return partidos
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartidoByNombreEquipoVisitante(String nombreEquipoVisitante){
		Query q = session.createQuery("from Partido par where upper(par.equipoTemporadaVisitante.equipo.nombre) like :nombreEquipoVisitante");
		q.setParameter("nombreEquipoVisitante", nombreEquipoVisitante.toUpperCase()+"%");
		return(List<Partido>)q.list();
	}

	/**Metodo para consultar los partidos por rango de fecha
	 * @param fechaInicio del partido
	 * @param fechaFin del partido
	 * @return partidos
	 */
	@SuppressWarnings("unchecked")
	public List<Partido> selectFromPartidoByFechas(Timestamp fechaInicio, Timestamp fechaFin){
		Query q = session.createQuery("from Partido par where par.fechaAnuncioPartido > :fechaInicio and par.fechaAnuncioPartido < :fechaFin");
		q.setParameter("fechaInicio", fechaInicio);
		q.setParameter("fechaFin", fechaFin);
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
