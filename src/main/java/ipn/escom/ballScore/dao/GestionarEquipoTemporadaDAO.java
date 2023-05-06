package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.EquipoTemporada;
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
	
	/**Metodo DAO para la consulta de equipos de una temporada
	 * @param idManager de la temporada
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
}
