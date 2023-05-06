package ipn.escom.ballScore.business;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarAlumnosDAO;
import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.dao.GestionarJugadoresDAO;
import ipn.escom.ballScore.entity.Alumno;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.Jugador;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugadoresVO;

public class GestionarJugadoresBI {
	
	private static final Logger logger = LogManager.getLogger();
	
	/**Metodo para obtener el equipo del manager
	 * @param idManager del manager
	 * @return equipo del manager
	 * @throws BussinessException en caso de error al consultar
	 */
	public Equipo obtenerEquipoDelManager(Long idManager) throws BussinessException {
		logger.info("Inicia metodo GestionarJugadoresBI.obtenerEquipoDelManager()");
		GestionarEquiposDAO equipoDAO = new GestionarEquiposDAO();
		List<Equipo> equipo = equipoDAO.obtenerEquipoDelManager(idManager);
		equipoDAO.cerrarConexiones();
		if(equipo.size()>0)
			return equipo.get(0);
		else
			throw new BussinessException("El manager no tiene equipo registrado");
	}
	
	/**Metodo para obtener lista de posiciones
	 * @return
	 */
	public List<String> obtenerPosiciones(){
		List<String> posiciones = new ArrayList<String>();
		posiciones.add("Pitcher");
		posiciones.add("Catcher");
		posiciones.add("Primera Base");
		posiciones.add("Segunda Base");
		posiciones.add("Tercera Base");
		posiciones.add("Shortstop");
		posiciones.add("Jardin Izquierdo");
		posiciones.add("Jardin Central");
		posiciones.add("Jardin Derecho");
		return posiciones;
	}
	
	/**Metodo para registrar jugador
	 * @param vo con datos del jguador
	 * @param equipo del jugador
	 * @return id del jugador
	 * @throws BussinessException en caso de error al registrar
	 */
	public Long registrarJugador(GestionarJugadoresVO vo, Equipo equipo) throws BussinessException {
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		Jugador jugador = new Jugador();
		Alumno alumno = alumnosDao.selectAlumnoById(vo.getAlumno().getBoletaAlumno());
		jugador.setAlumno(alumno);
		jugador.setEquipo(equipo);
		jugador.setPosicionPrim(vo.getPosicionPrim());
		jugador.setPosicionSec(vo.getPosicionSec());
		try {
			if(jugadoresDao.selectJugadorByBoleta(vo.getAlumno().getBoletaAlumno()).isEmpty())
				jugador = jugadoresDao.insertIntoJugador(jugador);
			else
				throw new BussinessException("Este jugador ya esta registrado en un equipo");
		} catch (SQLException e) {
			if(e.getCause()!= null && e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar al jugador, ya existe un jugador registrado", e);
				throw new BussinessException("Ya existe un jugador registrado.");
			}
			else {
				logger.error("Error en la operación sql del jugador",e);
				throw new BussinessException("Error al registrar al jugador.");
			}
		}
		alumnosDao.cerrarConexiones();
		jugadoresDao.cerrarConexiones();
		
 		return jugador.getIdJugador();
	}
	
	/**Metodo para actualizar al jugador
	 * @param vo con datos del jugador
	 * @return id del jugador
	 * @throws BussinessException en caso de error al actualizar
	 */
	public Long actualizarJugador(GestionarJugadoresVO vo) throws BussinessException {
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		Jugador jugador = null;
		try {
			jugador = jugadoresDao.selectJugadorById(vo.getIdJugador());
			jugador.setPosicionPrim(vo.getPosicionPrim());
			jugador.setPosicionSec(vo.getPosicionSec());
			jugadoresDao.updateJugador(jugador);
		} catch (SQLException e) {
			logger.error("Error en la operación sql del jugador",e);
			throw new BussinessException("Error al actualizar al jugador.");
		}
		jugadoresDao.cerrarConexiones();
		return jugador.getIdJugador();
	}
	
	/**Metodo para consultar los jugadores registrados en un equipo
	 * @param idEquipo del equipo
	 * @return lista de jugadores registrados
	 * @throws BussinessException en caso de error al consultar
	 */
	public List<Jugador> consultarJugadoresEquipo(Long idEquipo) throws BussinessException{
		List<Jugador> jugadoresRegistrados;
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		try {
			jugadoresRegistrados = jugadoresDao.selectJugadoresByEquipo(idEquipo);
		} catch (SQLException e) {
			logger.error("Error al consultar jugadores registrados ", e);
			throw new BussinessException("Error al consultar jugadores registrados "+e.getCause());
		}finally {
			jugadoresDao.cerrarConexiones();
		}
		return jugadoresRegistrados;
	}
	
	/**Metodo para consultar los jugadores que no estan registrados en un equipo de temporada
	 * @param idEquipo del equipo
	 * @param idTemporada de la temporada
	 * @return lista de jugadores no registrados
	 * @throws BussinessException en caso de error al consultar
	 */
	public List<Jugador> consultarJugadoresNoRegistrados(Long idEquipo, Long idTemporada) throws BussinessException{
		List<Jugador> jugadoresNoRegistrados;
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		try {
			jugadoresNoRegistrados = jugadoresDao.selectJugadoresNoRegistrados(idEquipo, idTemporada);
		} catch (SQLException e) {
			logger.error("Error al consultar jugadores registrados ", e);
			throw new BussinessException("Error al consultar jugadores registrados "+e.getCause());
		}finally {
			jugadoresDao.cerrarConexiones();
		}
		return jugadoresNoRegistrados;
	}
	
	/**Metodo para consultar un jugador por id
	 * @param idJugador del jugador
	 * @return Jugador
	 * @throws BussinessException en caso de error al consultar
	 */
	public Jugador consultarJugador(Long idJugador) throws BussinessException {
		Jugador jugador;
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		try {
			jugador = jugadoresDao.selectJugadorById(idJugador);
		} catch (SQLException e) {
			logger.error("Error al consultar jugadores registrados ", e);
			throw new BussinessException("Error al consultar jugador registrado "+e.getCause());
		}
		jugadoresDao.cerrarConexiones();
		return jugador;
		
	}
	
	/**Metodo para alternar el estado de un jugador
	 * @param idJugador del jugador
	 * @throws BussinessException en caso de error al actualizar
	 */
	public void actualizarEstadoJugador(Long idJugador) throws BussinessException {
		GestionarJugadoresDAO jugadoresDao = new  GestionarJugadoresDAO();
		java.util.Date utilDate = new java.util.Date();
		try {
			Jugador jugador = jugadoresDao.selectJugadorById(idJugador);
			if(jugador.getFechaAlta()==null)
				jugador.setFechaAlta(new Date(utilDate.getTime()));
			else 
				jugador.setFechaAlta(null);
			jugadoresDao.updateJugador(jugador);
			
		} catch (SQLException e) {
			logger.error("Error al actualizar jugador ", e);
			throw new BussinessException("Error al actualizar jugador "+e.getCause());
		}
		jugadoresDao.cerrarConexiones();
	}

}
