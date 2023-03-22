package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEscuelasDAO;
import ipn.escom.ballScore.dao.GestionarManagersDAO;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarManagersVO;

/**Clase de negocio para gestionar los managers
 * @author Jose Mauricio
 *
 */
public class GestionarManagersBI {
	
	private static final Logger logger = LogManager.getLogger();

	/**Metodo de negocio para obtener las escuelas registradas
	 * @return Lista de escuelas sin fecha baja
	 * @throws BussinessException En caso de error de negocio
	 */
	public List<Escuela> obtenerEscuelas() throws BussinessException {
		logger.info("Inicia metodo GestionarManagersBI.obtenerEscuelas()");
		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		List<Escuela> escuelas;
		try {
			escuelas = escuelasDao.obtenerEscuelasAlta();
		} catch (Exception e) {
			logger.error("Error al obtener las escuelas en alta", e);
			throw new BussinessException("Error al obtener las escuelas en alta");
		}
		escuelasDao.cerrarConexiones();
		return escuelas;
	}
	
	/**Metodo de negocio para registrar un manager
	 * @param vo Con los datos del manager
	 * @return Id con el que se registro el manager (-1 en caso de que ya exista un manager con ese correo registrado)
	 * @throws BussinessException 
	 */
	public Long registrarManager(GestionarManagersVO vo) throws BussinessException {
		logger.info("Inicia metodo GestionarManagersBI.registrarManager()");
		
		GestionarManagersDAO managersDao = new GestionarManagersDAO();
		GestionarEscuelasDAO escuelasDao= new GestionarEscuelasDAO();
		Manager nuevoManager = new Manager();
		Long idManager = 0L;
		
		try {
			BeanUtils.copyProperties(nuevoManager, vo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad", e);
			throw new BussinessException("Error al registrar al manager.");
		}
		
		try {
			Escuela escuela = escuelasDao.selectEscuelaById(vo.getIdEscuela());
			nuevoManager.setEscuela(escuela);
			idManager = managersDao.insertIntoManagers(nuevoManager);
		}catch (SQLException e) {
			if(e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar al alumno, ya existe un alumno registrado", e);
				throw new BussinessException("Ya existe un alumno registrado con ese numero de boleta.");
			}
			else {
				logger.error("Error al realizar insert del alumno",e);
				throw new BussinessException(" Error al registrar al alumno. ");
			}
		}

		escuelasDao.cerrarConexiones();
		managersDao.cerrarConexiones();
		return idManager;
	}
}
