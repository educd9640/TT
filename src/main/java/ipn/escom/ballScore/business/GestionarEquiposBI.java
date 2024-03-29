package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.dao.GestionarManagersDAO;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.EquipoTemporada;
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
	
	private GestionarEquipoTemporadaDAO equipoTemporadaDAO;

	/**
	 * Metodo de negocio para registrar un equipo
	 * 
	 * @param vo Con los datos del Equipo
	 * @param correo correo del manager
	 * @param operacion operacion a realizar
	 * @return Id con el que se registro el equipo
	 * @throws BussinessException En caso de error de negocio
	 */
	public Equipo registrarEquipo(GestionarEquiposVO vo, String correo, String operacion) throws BussinessException {
		logger.info("Inicia metodo GestionarEquiposBI.registrarEquipo()");

		GestionarEquiposDAO equiposDao = new GestionarEquiposDAO();
		GestionarManagersDAO managersDao = new GestionarManagersDAO();
		Equipo nuevoEquipo = new Equipo();
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
		}finally {
			managersDao.cerrarConexiones();
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
				throw new BussinessException(" Error al registrar el equipo. ");
			}
		}finally {
			equiposDao.cerrarConexiones();
		}

		return nuevoEquipo;
	}
	
	/**
	 * Metodo de negocio para verificar si el manager tiene un equipo registrado
	 * @param id_manager con el id del manager
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
	 * @param id con el id del manager
	 * @return String con un mensaje para el usuario
	 * @throws BussinessException En caso de error de negocio
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
	 * @param idManager con el id del manager
	 * @return Equipo entidad del equipo
	 * @throws BussinessException En caso de error de negocio
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
	 * @param equipoEstatus entidad con los datos del equipo
	 * @return String para indicar al usuario si el equipo a sido activado o desctivado
	 * @throws BussinessException En caso de error de negocio
	 */
	public String cambiarEstatus(Equipo equipoEstatus) throws BussinessException {
		GestionarEquiposDAO equipoDao= new GestionarEquiposDAO();
		String mensaje="";
		Date estatus= equipoEstatus.getFechaAlta();
		if(estatus!=null) {
			try {
				equipoDao.bajaEquipo(equipoEstatus);
				mensaje="El equipo se ha desactivado exitosamente";
			} catch (SQLException e) {
				throw new BussinessException("Error al desactivar al equipo");
			}finally {
				equipoDao.cerrarConexiones();
			}
		}else {
			try {
				equipoDao.altaEquipo(equipoEstatus);
				mensaje="El equipo ha sido activado exitosamente";
			} catch (SQLException e) {
				throw new BussinessException("Error al activar el equipo");
			}finally {
				equipoDao.cerrarConexiones();
			}
		}
		
		return mensaje;
	}
	
	/**Metodo para buscar coincidencias
	 * @param equipos lista de equipos
	 * @param temporada temporadas
	 * @return equipos
	 */
	public List<Equipo> buscarCoincidencias(List<Equipo> equipos, List<EquipoTemporada> temporada) {
		Equipo equipo = new Equipo();
		List<Equipo> equiposF= new ArrayList<Equipo>();
		EquipoTemporada equipoTemporada =new EquipoTemporada();
		int registrado=0;
		for(int e=0; e < equipos.size(); e++) {
			equipo= equipos.get(e);
			registrado=0;
			for(int t=0; t < temporada.size(); t++) {
				equipoTemporada = temporada.get(t);
				if(equipo.getIdEquipo()==equipoTemporada.getIdEquipo()) {
					registrado=1;
				}
			}
			if(registrado==0) {
				equiposF.add(equipo);
			}
		}
		return equiposF;
	} 
	
	/**Metodo de negocio para obtener los equipos que aun no estan registrados en una temporada
	 * @param idTemporada de la temporada
	 * @return equipos registrados
	 * @throws BussinessException En caso de error de negocio
	 */
	public List<Equipo> obtenerEquiposRegistrados(Long idTemporada) throws BussinessException{
		logger.info("Inicia metodo GestionarEquiposBI.obtenerEquiposRegistrados()");
		GestionarEquiposDAO equipoDao= new GestionarEquiposDAO();
		List<Equipo> equipos= new ArrayList<Equipo>();
		List<Equipo> equiposFaltantes= new ArrayList<Equipo>();
		List<EquipoTemporada> equipostemp = new ArrayList<EquipoTemporada>();
		try {
			equipos=equipoDao.selectFromEquipo();
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados ", e);
			throw new BussinessException("Error al consultar los equipos registrados.");
		}finally {
			equipoDao.cerrarConexiones();
		}
		GestionarEquipoTemporadaDAO tempequipos = new GestionarEquipoTemporadaDAO();
		equipostemp= tempequipos.obtenerEquiposTemporada(idTemporada);
		tempequipos.cerrarConexiones();
		equiposFaltantes = buscarCoincidencias(equipos,equipostemp);
		return equiposFaltantes;
	}
	
	
	/**Metodo de negocio para obtener los equipos registrados en equipo_temporada
	 * @param idTemporada de la temporada
	 * @param equipoL  id del equipo
	 * @return Lista de equipos
	 * @throws BussinessException En caso de error
	 */
	public List<Equipo> obtenerEquiposTemporadaRegistrados(Long idTemporada, Long equipoL) throws BussinessException{
		logger.info("Inicia metodo GestionarEquiposBI.obtenerEquiposTemporadaRegistrados()");
		GestionarEquiposDAO equipoDAO= new GestionarEquiposDAO();
		equipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		
		List<Equipo> equipos = new ArrayList<Equipo>();
		List<Long> equiposTem = new ArrayList<Long>();
		
		try {
			if(equipoL!=null) {
				equiposTem = equipoTemporadaDAO.obtenerEquipos(idTemporada, equipoL);
			}else {
				equiposTem = equipoTemporadaDAO.obtenerEquipos(idTemporada);
			}
			
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados en equipo_temporada", e);
			throw new BussinessException("Error al consultar los equipos registrados en equipo_temporada.");
		}
		
		try {
			for(Long equipo : equiposTem) {
				equipos.add(equipoDAO.obtenerEquipo(equipo));
			}
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados", e);
			throw new BussinessException("Error al consultar los equipos registrados.");
		}finally {
			equipoDAO.cerrarConexiones();
			equipoTemporadaDAO.cerrarConexiones();
		}
		
		return equipos;
		
	}
	
	/**Metodo para buscar un equipo por su id
	 * @param id del equipo
	 * @return Entidad del equipo con sus datos
	 * @throws BussinessException En caso de no encontrar el Equipo
	 */
	public Equipo buscarEquipoPorId(Long id) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.buscarTemporadaPorId()");
		GestionarEquiposDAO equipoDAO= new GestionarEquiposDAO();
		Equipo equipo = equipoDAO.selectEquipoById(id);
		
		if(equipo == null) {
			throw new BussinessException("Error al obtener la temporada por su id, no se encuentra registrada.");
		}
		equipoDAO.cerrarConexiones();
		return equipo;
		
	}
	
	/**Metodo para buscar un equipo que se encuentre en equipo_temporada  por su id
	 * @param idEquipo del equipo
	 * @param idTemporada de la temporada
	 * @param equipoL del equipo
	 * @return La entidad Equipo si se encuentra
	 * @throws BussinessException En caso de error de negocio
	 */
	public Equipo buscarEquipoTemporadaPorId(Long idEquipo, Long idTemporada, Long equipoL) throws BussinessException {
		logger.info("Inicia metodo GestionarEquiposBI.buscarEquipoTemporadaPorId()");
		GestionarEquiposDAO equipoDAO= new GestionarEquiposDAO();
		equipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		
		EquipoTemporada Aux = new EquipoTemporada();
		Equipo equipo = new Equipo();
		
		try {
			if(equipoL!=null) {
				Aux = equipoTemporadaDAO.selectEquipoTemporadaById(idEquipo, idTemporada, equipoL);				
			}else {

				Aux = equipoTemporadaDAO.selectEquipoTemporadaById(idEquipo, idTemporada);
			}
			
			
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados con ese id", e);
			throw new BussinessException("Error al consultar los equipos registrados con ese id.");
		}
		
		 
		try {
			if(Aux!=null) {
				equipo = equipoDAO.selectEquipoById(idEquipo);
			}
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados", e);
			throw new BussinessException("Error al consultar los equipos registrados.");
		}finally {
			equipoDAO.cerrarConexiones();
			equipoTemporadaDAO.cerrarConexiones();
		}
		
		
		return equipo;
		
	}
	
	/**Metodo para obtener una lista de equipos con el nombre requerido
	 * @param nombre del equipo
	 * @param idTemporada de la temporada
	 * @param equipoL id del equipo local a excluir
	 * @return lista de equipo
	 * @throws BussinessException en caso de error de negocio
	 */
	public List<Equipo> buscarEquipoTemporadaPorNombre(String nombre, Long idTemporada, Long equipoL) throws BussinessException {
		logger.info("Inicia metodo GestionarEquiposBI.buscarEquipoTemporadaPorNombre()");
		GestionarEquiposDAO equipoDAO= new GestionarEquiposDAO();
		equipoTemporadaDAO = new GestionarEquipoTemporadaDAO();
		
		List<Equipo> equipos = new ArrayList<Equipo>();
		List<Long> equiposTem = new ArrayList<Long>();
		try {
			if(equipoL!=null) {
				equiposTem = equipoTemporadaDAO.selectEquipoTemporadaByNombre(nombre, idTemporada, equipoL);
			}else {
				equiposTem = equipoTemporadaDAO.selectEquipoTemporadaByNombre(nombre, idTemporada);
			}
			
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados con ese nombre", e);
			throw new BussinessException("Error al consultar los equipos registrados con ese nombre.");
		}
		try {
			for(Long equipo : equiposTem) {
				equipos.add(equipoDAO.obtenerEquipo(equipo));
			}
		}catch(Exception e) {
			logger.error(" Error al consultar los equipos registrados", e);
			throw new BussinessException("Error al consultar los equipos registrados.");
		}finally {
			equipoDAO.cerrarConexiones();
			equipoTemporadaDAO.cerrarConexiones();
		}
		
		return equipos;
		
	}
	
}
