package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.exception.BussinessException;

/**Clase DAO para la gestion de equipos de temporada
 * @author Jose Mauricio
 *
 */
public class GestionarEquipoTemporadaDAO extends BaseDAO{

	/**
	 * Constructor de la clase GestionarEquipoTemporadaDAO
	 */
	public GestionarEquipoTemporadaDAO() {
		super();
	}
	
	/**Metodo DAO para la consulta de equipos de temporada de un manager
	 * @param idManager del manager
	 * @return Lista de equipos de temporada del manager
	 */
	@SuppressWarnings("unchecked")
	public List<EquipoTemporada> consultarEquipoTemporadaManager(Long idManager){
		Query q = session.createQuery("from EquipoTemporada et where et.equipo.manager.idManager = :idManager");
		q.setParameter("idManager", idManager);
		return (List<EquipoTemporada>) q.list();
	}
	
	/**Metodo DAO para la consulta de equipos de temporada de un manager
	 * @param idManager del manager
	 * @param nombreLiga de la liga
	 * @return Lista de equipos de temporada del manager
	 */
	@SuppressWarnings("unchecked")
	public List<EquipoTemporada> consultarEquipoTemporadaManager(Long idManager, String nombreLiga){
		Query q = session.createQuery("from EquipoTemporada et where et.equipo.manager.idManager  = :idManager and lower(et.temporada.liga.nombre) like :nombreLiga");
		q.setParameter("idManager", idManager);
		q.setParameter("nombreLiga", nombreLiga.toLowerCase()+"%");
		return (List<EquipoTemporada>) q.list();
	}
	
	/**Metodo DAO para la consulta de equipos de temporada de un manager
	 * @param idManager del manager
	 * @param fechaInicialTemporada fecha de inicio de la temporada
	 * @param fechaFinalTemporada fecha de fin de temporada
	 * @param nombreLiga de la liga
	 * @return Lista de equipos de temporada del manager
	 */
	@SuppressWarnings("unchecked")
	public List<EquipoTemporada> consultarEquipoTemporadaManager(Long idManager, Date fechaInicialTemporada, Date fechaFinalTemporada){
		Query q = session.createQuery("from EquipoTemporada et where et.equipo.manager.idManager  = :idManager "
				+ "and et.temporada.fechaInicial > :fechaInicialTemporada and et.temporada.fechaFinal < :fechaFinalTemporada");
		q.setParameter("idManager", idManager);
		q.setParameter("fechaInicialTemporada", fechaInicialTemporada);
		q.setParameter("fechaFinalTemporada", fechaFinalTemporada);
		return (List<EquipoTemporada>) q.list();
	}
	
	/**Metodo DAO para la consulta de equipos de temporada de un manager
	 * @param idManager del manager
	 * @param nombreLiga de la liga
	 * @param fechaInicialTemporada fecha de inicio de la temporada
	 * @param fechaFinalTemporada fecha de fin de temporada
	 * @return Lista de equipos de temporada del manager
	 */
	@SuppressWarnings("unchecked")
	public List<EquipoTemporada> consultarEquipoTemporadaManager(Long idManager, String nombreLiga, Date fechaInicialTemporada, Date fechaFinalTemporada){
		Query q = session.createQuery("from EquipoTemporada et where et.equipo.manager.idManager  = :idManager and lower(et.temporada.liga.nombre) like :nombreLiga " 
				+ "and et.temporada.fechaInicial > :fechaInicialTemporada and et.temporada.fechaFinal < :fechaFinalTemporada");
		q.setParameter("idManager", idManager);
		q.setParameter("nombreLiga", nombreLiga.toLowerCase()+"%");
		q.setParameter("fechaInicialTemporada", fechaInicialTemporada);
		q.setParameter("fechaFinalTemporada", fechaFinalTemporada);
		return (List<EquipoTemporada>) q.list();
	}
	
	/**Metodo DAO para la consulta de equipos de una temporada
	 * @param idTemporada de la temporada
	 * @return Lista de equipos de la temporada
	 */
	@SuppressWarnings("unchecked")
	public List<EquipoTemporada> obtenerEquiposTemporada(Long idTemporada) {
		Query q = session.createQuery("from EquipoTemporada where ID_TEMPORADA =:idTemporada");
		q.setParameter("idTemporada", idTemporada);
		return(List<EquipoTemporada>) q.list();
	}
	
	/**
	 * Metodo DAO para registrar un equipo en una temporada
	 * @param entidad del tipo EquipoTemporada
	 * @return entidad EquipoTemporada con el equipo, temporada y fecha de alta ingresados
	 * @throws BussinessException
	 */
	
	public EquipoTemporada registrarEquipo(EquipoTemporada entidad) throws SQLException {
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
	
	/**Metodo para obtener las temporadas en equipo_temporada
	 * @return Lista de los id de las temporadas en Long
	 */
	@SuppressWarnings("unchecked")
	public List<Long> obtenerTemporadas() {
		Query q = session.createQuery("select distinct et.idTemporada from EquipoTemporada et");
		return (List<Long>)q.list();
	}
	
	
	
	/**Metodo para obtener los equipos en equipo_temporada
	 * @return Lista de los id de los equipos en Long
	 */
	@SuppressWarnings("unchecked")
	public List<Long> obtenerEquipos(Long idTemporada){
		Query q = session.createQuery("select distinct et.idEquipo from EquipoTemporada et where et.idTemporada = :idTemporada");
		q.setParameter("idTemporada", idTemporada);
		return (List<Long>)q.list();
	}
	
	/**Metodo DAO para acutalizar un equipo de temporada
	 * @param entidad del equipo de temporada
	 */
	public void updateEquipoTemporada(EquipoTemporada entidad) {
		session.save(entidad);
		session.flush();
		session.clear();
	}
	
	/**Metodo Dao para seleccionar un equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @return el equipo de temporada
	 */
	public EquipoTemporada selectEquipoTemporadaById(Long idEquipo, Long idTemporada) {
		Query q = session.createQuery("from EquipoTemporada et where et.idEquipo = :idEquipo and et.idTemporada = :idTemporada");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (EquipoTemporada) q.uniqueResult();
	}
}
