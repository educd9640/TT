package ipn.escom.ballScore.dao;

import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.EquipoTemporada;

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
}
