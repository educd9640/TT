package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarLigasDAO;
//import ipn.escom.ballScore.dao.GestionarligaDAO;
//import ipn.escom.ballScore.dao.GestionarEscuelasDAO;
import ipn.escom.ballScore.entity.Liga;
//import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.LigaVO;

/**Clase de negocio para gestionar las ligas
 * @author Eduardo Callejas
 *
 */
public class GestionarLigasBI {
	
	@SuppressWarnings("unused")
	private GestionarLigasDAO ligaDAO;

	
	private static final Logger logger = LogManager.getLogger();
	
	
	/**Metodo para crear/acrtualizar una liga
	 * @param ligaVO Con los datos de la liga
	 * @param operacion Indica la operacion a realizar
	 * @return Entidad persistida
	 * @throws BussinessException Si ya existiera la Liga, en el caso de crear
	 */
	public Liga crearLiga(LigaVO ligaVO, String operacion) throws BussinessException {
		logger.info("Inicia metodo GestionarLigasBI.crearLiga()");
		ligaDAO = new GestionarLigasDAO();
		Liga nuevaLiga = new Liga();
		
		try {
			BeanUtils.copyProperties(nuevaLiga, ligaVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad.", e);
			throw new BussinessException("Error al registrar la Liga.");
		}
		
			
		/////////////////////////////////////////////////////
		try {
			if(operacion.equals("registrado"))
				nuevaLiga = ligaDAO.insertIntoLiga(nuevaLiga);
			else
				nuevaLiga = ligaDAO.updateLiga(nuevaLiga);
		} catch (SQLException e) {
			if(e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar la liga, ya existe una liga registrada", e);
				throw new BussinessException("Ya existe una liga registrada con ese id.");
			}
			else {
				logger.error("Error en la operación sql de la liga",e);
				throw new BussinessException("Error al registrar la liga.");
			}
		}
		
		ligaDAO.cerrarConexiones();
		return nuevaLiga;
		
	}
	
	/**Metodo para buscar una Liga por su id
	 * @param id de la Liga
	 * @return Entidad de la Liga con sus datos
	 * @throws BussinessException En caso de no encontrar la Liga
	 */
	public Liga buscarLigaPorId(Long id) throws BussinessException {
		logger.info("Inicia metodo GestionarLigasBI.buscarLigaPorId()");
		ligaDAO = new GestionarLigasDAO();
		Liga liga = ligaDAO.selectLigaById(id);
		if(liga == null) {
			throw new BussinessException("Error al obtener la liga por su id, no se encuentra registrado.");
		}
		ligaDAO.cerrarConexiones();
		return liga;
	}
	
	/**Metodo para eliminar unaliga
	 * @param id de la liga
	 * @throws BussinessException En caso de que no exista la liga
	 */
	public void eliminarLiga(Long id) throws BussinessException {
		logger.info("Inicia metodo GestionarLigasBI.buscarLigaPorId()");
		ligaDAO = new GestionarLigasDAO();
		
		try {
			Liga liga = ligaDAO.selectLigaById(id);
			if(liga == null) {
				logger.error("Error al borrar la liga: liga con id "+id+" no encontrada");
				throw new BussinessException("Error al borrar la liga: liga no encontrada");
			}
			ligaDAO.deleteLiga(liga);				
		}catch (Exception e) {
			logger.error("Error al borrar la liga ",e);
			throw new BussinessException("Error al borrar la liga.");
		}
		
		ligaDAO.cerrarConexiones();
	}
	

}
