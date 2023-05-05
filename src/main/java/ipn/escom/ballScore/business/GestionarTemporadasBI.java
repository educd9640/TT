package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarLigasDAO;
import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.entity.Liga;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.TemporadaVO;
import ipn.escom.ballScore.form.GestionarEquipoTemporadaVO;

/**Clase de negocio para gestionar las Temporadas
 * @author Eduardo Callejas
 *
 */
public class GestionarTemporadasBI {
	
	private GestionarTemporadasDAO temporadaDAO;
	private GestionarEquiposDAO equipoDAO;
	private GestionarEquipoTemporadaDAO equipotemporadaDAO;
	private GestionarLigasDAO ligaDAO;
	
	private static final Logger logger = LogManager.getLogger();
	
	
	
	
	/**Metodo para crear/actualizar una Temporada
	 * @param temporadaVO con los datos de la temporada
	 * @param operacion con la operacion a realizar
	 * @return Entidad persistida
	 * @throws BussinessException Si existiera la Temporada en caso de crear
	 */
	public Temporada crearTemporada(TemporadaVO temporadaVO, String operacion)throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.crearTemporada()");
		temporadaDAO = new GestionarTemporadasDAO();
		ligaDAO = new GestionarLigasDAO();
		Temporada nuevaTemporada=new Temporada();
		try {
			BeanUtils.copyProperties(nuevaTemporada, temporadaVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad.", e);
			throw new BussinessException("Error al registrar la Temporada.");
		}
		
		/////////////////////////////////////////////////////
		try {
			Liga liga = ligaDAO.selectLigaById(temporadaVO.getLiga().getIdLiga());
			nuevaTemporada.setLiga(liga);
			
			if(operacion.equals("registrado"))
				nuevaTemporada = temporadaDAO.insertIntoTemporada(nuevaTemporada);
			else
				nuevaTemporada = temporadaDAO.updateTemporada(nuevaTemporada);
		} catch (SQLException e) {
			
			if(e!=null && e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar la temporada, ya existe una temporada registrada", e);
				throw new BussinessException("Ya existe una temporada registrada con ese id.");
			}
			else {
				logger.error("Error en la operaci�n sql de la temporada",e);
				throw new BussinessException("Error al registrar la temporada.");
			}
		}
		temporadaDAO.cerrarConexiones();
		return nuevaTemporada;
	}
	
	
	
	/**Metodo para busacar una temporada por su id
	 * @param id de la temporada
	 * @return Entidad de la temporada con sus datos
	 * @throws BussinessException En caso de no encontrar la Temporada
	 */
	public Temporada buscarTemporadaPorId(Long id) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.buscarTemporadaPorId()");
		temporadaDAO = new GestionarTemporadasDAO();	
		Temporada temporada = temporadaDAO.selectTemporadaById(id);
		
		if(temporada == null) {
			throw new BussinessException("Error al obtener la temporada por su id, no se encuentra registrada.");
		}
		temporadaDAO.cerrarConexiones();
		return temporada;
		
	}
	
	
	
	
	/**Metodo para activar/desactivar una temporada
	 * @param id de la temporada
	 * @throws BussinessException En caso de error
	 */
	public void estadoTemporada(Long id) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.estadoTemporada()");
		temporadaDAO = new GestionarTemporadasDAO();
		try {
			Temporada temporada = temporadaDAO.selectTemporadaById(id);
			if(temporada == null) {
				logger.error("Error al activar/desactivar la temporada: temporada con id "+id+" no encontrada");
				throw new BussinessException("Error al activar/desactivar la temporada: liga no encontrada");
			}
			temporadaDAO.estadoTemporada(temporada);				
		}catch (Exception e) {
			logger.error("Error al activar/desactivar la temporada ",e);
			throw new BussinessException("Error al activar/desactivar la temporada.");
		}
		temporadaDAO.cerrarConexiones();
	}
	
	/**
	 * Metodo de negocio para registrar un equipo dentro de una temporada
	 * 
	 * @params Long con el id de la temporada donde se regitrara el equipo y Long con el id del equipo a registrar
	 * @return entidad EquipoTemporada con el equipo y temporada registrados
	 * @throws BussinessException
	 */
	public EquipoTemporada entrarEquipo(Long idTemporada, Long idEquipo) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.entrarEquipo()");
		
		equipotemporadaDAO = new GestionarEquipoTemporadaDAO();
		equipoDAO = new GestionarEquiposDAO();
		temporadaDAO = new GestionarTemporadasDAO();
		Equipo equipoEscogido = new Equipo();
		Temporada temporadaElegida= new Temporada();
		EquipoTemporada nuevoequipo = new EquipoTemporada();
		EquipoTemporada equiporegistrado= new EquipoTemporada();
		equipoEscogido = equipoDAO.obtenerEquipo(idEquipo);
		temporadaElegida = temporadaDAO.selectTemporadaById(idTemporada);
		nuevoequipo.setEquipo(equipoEscogido);
		nuevoequipo.setTemporada(temporadaElegida);
		nuevoequipo.setIdEquipo(idEquipo);
		nuevoequipo.setIdTemporada(idTemporada);
		try {
			equiporegistrado=equipotemporadaDAO.registrarEquipo(nuevoequipo);
		} catch (SQLException e) {
			logger.error(" Error al registrar el equipo en la temporada", e);
			throw new BussinessException("Error al registrar el equipo en la temporada.");
		}
		equipoDAO.cerrarConexiones();
		equipotemporadaDAO.cerrarConexiones();
		temporadaDAO.cerrarConexiones();
		return equiporegistrado;
	} 
	
	
	
	
	/**Metodo para obtener las temporadas registradas
	 * @return Lista de temporadas
	 * @throws BussinessException En caso de error del negocio
	 */
	public List<Temporada> obtenerTemporadasRegistradas()throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.obtenerTemporadasRegistradas()");
		temporadaDAO = new GestionarTemporadasDAO();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		try {
			temporadas = temporadaDAO.selectFromTemporada();
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas ", e);
			throw new BussinessException("Error al consultar las temporadas registradas.");
		}
		temporadaDAO.cerrarConexiones();
		return temporadas;
	}
	
}