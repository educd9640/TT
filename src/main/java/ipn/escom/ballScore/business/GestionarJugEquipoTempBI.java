package ipn.escom.ballScore.business;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarJugadorEquipoTempDAO;
import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.exception.BussinessException;

/**Clase de negocio para gestionar a los jugadore registrados en los equipos de temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugEquipoTempBI {
	
	private static final Logger logger = LogManager.getLogger();
	
	/**Metodo de negocio para la consulta de los equipos de temporada del manager
	 * @param idManager del manager
	 * @return Lista de equipos temporada
	 * @throws BussinessException En caso de error al consultar o no existan equipos
	 */
	public List<EquipoTemporada> consultarEquiposTemporadaDeManager(Long idManager) throws BussinessException{
		GestionarEquipoTemporadaDAO gestionarEquipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		List<EquipoTemporada> equipos;
		try {
			equipos = gestionarEquipoTemporadaDAO.consultarEquipoTemporadaManager(idManager);
			if(equipos == null || equipos.isEmpty())
				throw new BussinessException("No existen equipos registrados en alguna temporada.");
		} catch (Exception e) {
			logger.error("Error al consultar equipos de la temporada", e);
			throw new BussinessException("Error al consultar equipos de la temporada " + e.getCause());
			
		}
		gestionarEquipoTemporadaDAO.cerrarConexiones();
		return equipos;
	}
	
	/**Metodo de negocio para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @return Lista de jugadores registrados en el equipo temporada
	 * @throws BussinessException En caso de error al consultar
	 */
	public List<JugadorEquipoTemp> consultarJugadoresRegistrados(Long idEquipo, Long idTemporada) throws BussinessException{
		GestionarJugadorEquipoTempDAO gestionarJugadorEquipoTempDAO = new GestionarJugadorEquipoTempDAO();
		List<JugadorEquipoTemp> jugadores;
		try {
			jugadores = gestionarJugadorEquipoTempDAO.selectJugadorEquipoTempByEquipoTemp(idEquipo, idTemporada);
		}catch (Exception e) {
			logger.error("Error al consultar jugadores", e);
			throw new BussinessException("Error al consultar jugadores "+e.getCause());
		}finally {
			gestionarJugadorEquipoTempDAO.cerrarConexiones();
		}
		return jugadores;
	}
}