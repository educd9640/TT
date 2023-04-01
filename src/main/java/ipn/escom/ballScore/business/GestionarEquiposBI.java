package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.dao.GestionarManagersDAO;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarEquiposVO;

/**
 * Clase de negocio para gestionar los equipos
 * 
 * @author Cisneros Christian
 *
 */
public class GestionarEquiposBI {

	private static final Logger logger = LogManager.getLogger();

	/**
	 * Metodo de negocio para registrar un equipo
	 * 
	 * @param vo Con los datos del Equipo
	 * @return Id con el que se registro el equipo
	 * @throws BussinessException
	 */
	public Equipo registrarEquipo(GestionarEquiposVO vo, String correo, String operacion) throws BussinessException {
		logger.info("Inicia metodo GestionarEquiposBI.registrarEquipo()");

		GestionarEquiposDAO equiposDao = new GestionarEquiposDAO();
		GestionarManagersDAO managersDao = new GestionarManagersDAO();
		Equipo nuevoEquipo = new Equipo();
		Long idEquipo = 0L;
		Manager manager;
		

		try {
			BeanUtils.copyProperties(nuevoEquipo, vo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad", e);
			throw new BussinessException("Error al registrar el equipo.");
		}
		try{
			manager = managersDao.selectManagerByCorreo(correo);
		}catch(Exception e) {
			logger.error("Error al obtener el manager para registrar el equipo", e);
			throw new BussinessException("Error al registrar al alumno. ");
		}
		nuevoEquipo.setManager(manager);
		try 
		{
			if((operacion.equals("actualizado"))) 
			{
				nuevoEquipo=equiposDao.updateEquipo(nuevoEquipo);
			}else {
				nuevoEquipo=equiposDao.insertIntoEquipo(nuevoEquipo);
			}
		}catch (SQLException e) {
			if (e.getCause()!=null&&e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar al equipo, ya existe un equipo registrado", e);
				throw new BussinessException("Ya existe un equipo registrado con ese nombre.");
			} else {
				logger.error("Error al realizar insert del equipo", e);
				throw new BussinessException(" Error al registrar al alumno. ");
			}
		}

		equiposDao.cerrarConexiones();
		managersDao.cerrarConexiones();
		return nuevoEquipo;
	}
	
	/**
	 * Metodo de negocio para verificar si el manager tiene
	 * 
	 * @param Long con el id del manager
	 * @return booleano para indicar si el manager tiene o no un equipo registrado
	 * @throws BussinessException
	 */

	public boolean verificarExistencia(Long id_manager) {
		GestionarEquiposDAO equiposDao = new GestionarEquiposDAO();
		Equipo equipo_resultado = equiposDao.obtenerManager(id_manager);
		
		equiposDao.cerrarConexiones();
		
		if (equipo_resultado.getIdEquipo() == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
