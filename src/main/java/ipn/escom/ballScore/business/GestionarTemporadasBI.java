package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarLigasDAO;
import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.entity.Liga;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.TemporadaVO;

/**Clase de negocio para gestionar las Temporadas
 * @author Eduardo Callejas
 *
 */
public class GestionarTemporadasBI {
	
	private GestionarTemporadasDAO temporadaDAO;
	private GestionarLigasDAO ligaDAO;
	private GestionarEquipoTemporadaDAO equipotempDAO;
	
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
		} finally {
			temporadaDAO.cerrarConexiones();
			ligaDAO.cerrarConexiones();
		}
		return nuevaTemporada;
	}
	
	
	
	/**Metodo para buscar una temporada por su id
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
		}finally {
			temporadaDAO.cerrarConexiones();
		}
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
		}finally {
			temporadaDAO.cerrarConexiones();
		}
		return temporadas;
	}
	
	/**Para la busqueda de equipos por temporada
	 * @param idTemporada de la temporada
	 * @return equipos de temporada
	 * @throws BussinessException en caso de error de negocio
	 */
	public List<EquipoTemporada> obtenerEquiposByTemporada(Long idTemporada)throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.obtenerEquiposByTemporada()");
		List <EquipoTemporada> equipos = new ArrayList<EquipoTemporada>();
		equipotempDAO = new GestionarEquipoTemporadaDAO();
		equipos= equipotempDAO.obtenerEquiposTemporada(idTemporada);
		if (equipos.size()==0) {
			throw new BussinessException ("Error al consultar los equipos");
		}
		equipotempDAO.cerrarConexiones();
		return equipos;
	}
	
	
	
	/**Metodo para obtener las temporadas registradas en equipo_temporada
	 * @return Lista de temporadas
	 * @throws BussinessException Em caso de error
	 */
	public List<Temporada> obtenerEquipoTemporadasRegistradas()throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.obtenerEquipoTemporadasRegistradas()");
		temporadaDAO = new GestionarTemporadasDAO();
		GestionarEquipoTemporadaDAO equipotemporadaDAO = new GestionarEquipoTemporadaDAO();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		List<Long> equipoTemporadas = new ArrayList<Long>();
		try {
			equipoTemporadas = equipotemporadaDAO.obtenerTemporadas();
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas en equipo_temporada", e);
			throw new BussinessException("Error al consultar las temporadas registradas en equipo_temporada.");
		}finally {
			equipotemporadaDAO.cerrarConexiones();
		}
		
		try {
			for(Long temporada: equipoTemporadas) {
				temporadas.add( temporadaDAO.selectTemporadaById(temporada));
			}
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas ", e);
			throw new BussinessException("Error al consultar las temporadas registradas.");
		}finally {
			temporadaDAO.cerrarConexiones();
		}
		
		return temporadas;
	}
	
	/**Metodo para obtener las temporadas registradas en una liga
	 * @param id de la Liga
	 * @return Lista de temporadas
	 * @throws BussinessException en caso de error de negocio
	 */
	public List<Temporada> buscarTemporadaPorIdLiga(Long id) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.buscarTemporadaPorIdLiga()");
		temporadaDAO = new GestionarTemporadasDAO();
		GestionarEquipoTemporadaDAO equipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		List<Long> equipoTemporadas = new ArrayList<Long>();
		try {
			equipoTemporadas = equipoTemporadaDAO.selectTemporadaByIdLiga(id);
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas con ese id de liga", e);
			throw new BussinessException("Error al consultar las temporadas registradas con ese id de liga.");
		}
		
		try {
			for(Long temporada: equipoTemporadas) {
				temporadas.add( temporadaDAO.selectTemporadaById(temporada));
			}
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas", e);
			throw new BussinessException("Error al consultar las temporadas registradas.");
		}finally {
			temporadaDAO.cerrarConexiones();
		}
		
		
		return temporadas;
		
	}
	
	
	/**Metodo para obtener las temporadas registradas en una liga
	 * @param nombre de la liga
	 * @return Lista de temporadas
	 * @throws BussinessException en caso de error de negocio
	 */
	public List<Temporada> buscarTemporadaPorNombreLiga(String nombre) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.buscarTemporadaPorIdLiga()");
		temporadaDAO = new GestionarTemporadasDAO();
		GestionarEquipoTemporadaDAO equipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		List<Long> equipoTemporadas = new ArrayList<Long>();
		try {
			equipoTemporadas = equipoTemporadaDAO.selectTemporadaByNombreLiga(nombre);
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas con ese nombre", e);
			throw new BussinessException("Error al consultar las temporadas registradas nombre.");
		}
		
		try {
			for(Long temporada: equipoTemporadas) {
				temporadas.add( temporadaDAO.selectTemporadaById(temporada));
			}
		}catch(Exception e) {
			logger.error(" Error al consultar las temporadas registradas", e);
			throw new BussinessException("Error al consultar las temporadas registradas.");
		}finally {
			temporadaDAO.cerrarConexiones();
		}
		
		
		return temporadas;
		
	}
	
}
