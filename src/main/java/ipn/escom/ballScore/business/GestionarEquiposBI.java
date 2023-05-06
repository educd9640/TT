package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
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
				logger.info("Hola");
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
	 * Metodo de negocio para verificar si el manager tiene un equipo registrado
	 * 
	 * @param Long con el id del manager
	 * @return booleano para indicar si el manager tiene o no un equipo registrado
	 */

	public boolean verificarExistencia(Long id_manager) {
		GestionarEquiposDAO equiposDao = new GestionarEquiposDAO();
		Equipo equipo_resultado = equiposDao.obtenerManager(id_manager);
		
		equiposDao.cerrarConexiones();
		
		if (equipo_resultado == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Metodo de negocio para buscar si el manager cuenta con un equipo y regresar un mensaje al usuario
	 * 
	 * @param Long con el id del manager
	 * @return String con un mensaje para el usuario
	 * @throws BussinessException
	 */
	
	public String buscarEquipo(Long id) throws BussinessException {
		logger.info("Inicia metodo GestionarEquiposBI.buscarEquipo()");
		boolean estatus = this.verificarExistencia(id);
		String mensaje="";
		if(estatus==true) {
			mensaje="El manager con id: "+id+" ya cuenta con un equipo";
			throw new BussinessException("No se tiene permitido registrar otro equipo, en cambio puede guardar los cambios que desee realizar");
		}else {
			mensaje="Bienvenido al registro de equipo";	
		}
		
		return mensaje;
	}
	
	/**
	 * Metodo de negocio para recuperar un equipo de acuerdo al id del manager
	 * 
	 * @param Long con el id del manager
	 * @return Equipo entidad del equipo
	 * @throws BussinessException
	 */
	
	public Equipo obtenerEquipo(Long idManager) throws BussinessException {
		GestionarEquiposDAO equipoDao= new GestionarEquiposDAO();
		Equipo equipoManager= equipoDao.obtenerManager(idManager);
		if(equipoManager==null) {
			throw new BussinessException("El manager no cuenta con un equipo registrado");
		}
		equipoDao.cerrarConexiones();
		return equipoManager;
	}
	
	/**
	 * Metodo de negocio para activar o desactivar un equipo de acuerdo a su estado actual, el cual se basa de acuerdo a su fecha de subida
	 * 
	 * @param Equipo entidad con los datos del equipo
	 * @return String para indicar al usuario si el equipo a sido activado o desctivado
	 * @throws BussinessException
	 */
	
	public String cambiarEstatus(Equipo equipoEstatus) throws BussinessException {
		GestionarEquiposDAO equipoDao= new GestionarEquiposDAO();
		String mensaje="";
		Equipo equipoActualizado= new Equipo();
		Date estatus= equipoEstatus.getFechaAlta();
		if(estatus!=null) {
			try {
				equipoActualizado=equipoDao.bajaEquipo(equipoEstatus);
				mensaje="El equipo se ha desactivado exitosamente";
			} catch (SQLException e) {
				throw new BussinessException("Error al desactivar al equipo");
			}
		}else {
			try {
				equipoActualizado=equipoDao.altaEquipo(equipoEstatus);
				mensaje="El equipo ha sido activado exitosamente";
			} catch (SQLException e) {
				throw new BussinessException("Error al activar el equipo");
			}
		}
		
		equipoDao.cerrarConexiones();
		
		return mensaje;
	}
	
	/**Metodo de negocio para obtener los equipos registrados
	 * @return
	 * @throws BussinessException
	 */
	public List<Equipo> obtenerEquiposRegistrados() throws BussinessException{
		logger.info("Inicia metodo GestionarEquiposBI.obtenerEquiposRegistrados()");
		GestionarEquiposDAO equipoDao= new GestionarEquiposDAO();
		List<Equipo> equipos= new ArrayList<Equipo>();
		try {
			equipos=equipoDao.selectFromEquipo();
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados ", e);
			throw new BussinessException("Error al consultar los equipos registrados.");
		}
		equipoDao.cerrarConexiones();
		return equipos;
	}
	
}
