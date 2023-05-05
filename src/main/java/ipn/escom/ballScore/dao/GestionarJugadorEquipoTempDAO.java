package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.JugadorEquipoTemp;

/**Clase DAO para la gestion de jugadores de los equipos de temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugadorEquipoTempDAO extends BaseDAO{

	/**
	 * Constructor de la clase
	 */
	public GestionarJugadorEquipoTempDAO() {
		super();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTemp(Long idEquipo, Long idTemporada){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para registrar jugadores de equipos de temporada
	 * @param jugadores lista de jugadores a registrar
	 */
	public void saveJugadores(List<JugadorEquipoTemp> jugadores) {
		for(JugadorEquipoTemp jugador : jugadores) {
				java.util.Date utilDate = new java.util.Date();
				jugador.setFechaAlta(new Date(utilDate.getTime()));
				session.save(jugador);
				session.flush();
				session.clear();
		}
	}
}
