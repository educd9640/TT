package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarPartidosDAO;
import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.PartidoVO;

/**Clase de negocio para gestionar los partidos
 * @author Eduardo Callejas
 *
 */
public class GestionarPartidosBI {
	private GestionarPartidosDAO partidoDAO;
	private GestionarTemporadasDAO temporadaDAO;
	private GestionarEquipoTemporadaDAO equipoTDAO;
	
	private static final Logger logger = LogManager.getLogger();
	
	
	/**Metodo para crear/actualizar un partido
	 * @param partidoVO con los datos del partido
	 * @param operacion con la operacion a realizar
	 * @return Entidad persistida
	 * @throws BussinessException Si existiera el partido en cado de crear
	 */
	public Partido crearPartido(PartidoVO partidoVO, String operacion) throws BussinessException {
		logger.info("Inicia metodo GestionarPartidosBI.crearPartido()");
		temporadaDAO = new GestionarTemporadasDAO();
		partidoDAO = new GestionarPartidosDAO();
		equipoTDAO = new GestionarEquipoTemporadaDAO();
		Partido nuevoPartido= new Partido();
		
		try {
			BeanUtils.copyProperties(nuevoPartido, partidoVO);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad.", e);
			throw new BussinessException("Error al registrar el partido.");
		}
		/////////////////////////////////////////////////////
		Long idTemporada = nuevoPartido.getIdTemporada();
		nuevoPartido.setEquipoTemporadaLocal(equipoTDAO.selectEquipoTemporadaById(nuevoPartido.getIdEquipoLocal(), idTemporada));
		nuevoPartido.setEquipoTemporadaVisitante(equipoTDAO.selectEquipoTemporadaById(nuevoPartido.getIdEquipoVisitante(), idTemporada));
		nuevoPartido.setTemporada(temporadaDAO.selectTemporadaById(idTemporada));
		
		try {
			if(operacion.equals("registrado"))
				nuevoPartido = partidoDAO.insertIntoPartido(nuevoPartido);
			else
				nuevoPartido = partidoDAO.updatePartido(nuevoPartido);
		}catch(SQLException e){
			if(e!=null && e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar el partido, ya existe un partido registrado", e);
				throw new BussinessException("Ya existe un partido registrada con ese id.");
			}
			else {
				logger.error("Error en la operacion sql del partido",e);
				throw new BussinessException("Error al registrar el partido.");
			}
		}finally {
			partidoDAO.cerrarConexiones();
			temporadaDAO.cerrarConexiones();
			equipoTDAO.cerrarConexiones();
		}
		return nuevoPartido;
	}


	/**Metodo para buscar un partido por su id
	 * @param id del partido
	 * @return Entidad del partido con sus datos
	 * @throws BussinessException En caso de no encontrar el partido
	 */
	public Partido buscarPartidoPorId(Long id) throws BussinessException {
		logger.info("Inicia metodo GestionarPartidosBI.buscarPartidoPorId()");
		partidoDAO = new GestionarPartidosDAO();
		Partido partido = partidoDAO.selectPartidoById(id);
		
		if(partido == null) {
			throw new BussinessException("Error al obtener el partido por su id, no se encuentra registrado.");
		}
		partidoDAO.cerrarConexiones();
		return partido;
	}
	
	
	/**Metodo para activar/deactivar un partido 
	 * @param id del partido
	 * @throws BussinessException En caso de error
	 */
	public void estadoPartido(Long id) throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.estadoPartido()");
		partidoDAO = new GestionarPartidosDAO();
		try {
			Partido partido = partidoDAO.selectPartidoById(id);
			if(partido == null) {
				logger.error("Error al activar/desactivar el partido: partido con id "+id+" no encontrado");
				throw new BussinessException("Error al activar/desactivar el partido: partido no encontrado");
			}
			partidoDAO.estadoPartido(partido);
		}catch(Exception e) {
			logger.error("Error al activar/desactivar el partido ",e);
			throw new BussinessException("Error al activar/desactivar el partido.");
		}
		partidoDAO.cerrarConexiones();
	}
	
	
	
	/**Metodo para obtener los partidos registrados
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistrados()throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartido();
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
	/**Metodo para obtener los partidos registrados
	 * @param idPartido del partido
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistradosByIdPartido(Long idPartido)throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartidoById(idPartido);
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
	/**Metodo para obtener los partidos registrados
	 * @param nombreLiga de la liga
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistradosByLiga(String nombreLiga)throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartidoLikeLiga(nombreLiga);
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
	/**Metodo para obtener los partidos registrados
	 * @param nombreEquipoLocal del equipo local
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistradosByEquipoLocal(String nombreEquipoLocal)throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartidoByNombreEquipoLocal(nombreEquipoLocal);
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
	/**Metodo para obtener los partidos registrados
	 * @param nombreEquipoVisitante del equipo visitante
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistradosByEquipoVisitante(String nombreEquipoVisitante)throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartidoByNombreEquipoVisitante(nombreEquipoVisitante);
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
	/**Metodo para obtener los partidos registrados
	 * @param fechaInicial para rango de busqueda
	 * @param fechaFinal para rango de busqueda
	 * @return Lista de partidos
	 * @throws BussinessException En caso de error
	 */
	public List<Partido> obtenerPartidosRegistradosByFechas(Timestamp fechaInicial, Timestamp fechaFinal)throws BussinessException{
		logger.info("Inicia metodo GestionarPartidosBI.obtenerPartidosRegistrados()");
		partidoDAO = new GestionarPartidosDAO();
		List<Partido> partidos = new ArrayList<Partido>();
		try {
			partidos = partidoDAO.selectFromPartidoByFechas(fechaInicial,fechaFinal);
		}catch(Exception e) {
			logger.error(" Error al consultar los partidos registrados ", e);
			throw new BussinessException("Error al consultar los partidos registrados.");
		}finally {
			partidoDAO.cerrarConexiones();
		}
		return partidos;
	}
	
}












