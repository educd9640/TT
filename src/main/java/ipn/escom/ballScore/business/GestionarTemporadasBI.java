package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.entity.Liga;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.TemporadaVO;

/**Clase de negocio para gestionar las Temporadas
 * @author Eduardo Callejas
 *
 */
public class GestionarTemporadasBI {
	
	private GestionarTemporadasDAO temporadaDAO;
	
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
		Temporada nuevaTemporada=new Temporada();
		try {
			BeanUtils.copyProperties(nuevaTemporada, temporadaVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad.", e);
			throw new BussinessException("Error al registrar la Temporada.");
		}
		
		/////////////////////////////////////////////////////
		try {
			if(operacion.equals("registrado"))
				nuevaTemporada = temporadaDAO.insertIntoTemporada(nuevaTemporada);
			else
				nuevaTemporada = temporadaDAO.updateTemporada(nuevaTemporada);
		} catch (SQLException e) {
			logger.error("Error aqui",e);
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