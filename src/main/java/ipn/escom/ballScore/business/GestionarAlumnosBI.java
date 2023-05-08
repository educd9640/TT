package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarAlumnosDAO;
import ipn.escom.ballScore.dao.GestionarEscuelasDAO;
import ipn.escom.ballScore.entity.Alumno;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarAlumnosVO;

/**Clase de negocio para gestionar los alumnos
 * @author Jose Mauricio
 *
 */
public class GestionarAlumnosBI {
	
	private static final Logger logger = LogManager.getLogger();
	
	/**Metodo para obtener las escuelas registradas
	 * @return Lista de escuelas sin fecha baja
	 * @throws BussinessException En caso de error de negocio
	 */
	public List<Escuela> obtenerEscuelas() throws BussinessException {
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerEscuelas()");
		
		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		List<Escuela> escuelas = new ArrayList<Escuela>();
		try {
			escuelas = escuelasDao.obtenerEscuelasAlta();
		}catch(Exception e) {
			logger.error(" Error al consultar las escuelas ",e);
			throw new BussinessException("Error al consultar las escuelas");
		}
		escuelasDao.cerrarConexiones();
		return escuelas;
	}
	
	/**Metodo para obtener los semestres
	 * @return Lista de semestres
	 */
	public List<Long> obtenerSemestres(){
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerSemestres()");
		List<Long> semestres = new ArrayList<Long>();
		
		semestres.add(1L);
		semestres.add(2L);
		semestres.add(3L);
		semestres.add(4L);
		semestres.add(5L);
		semestres.add(6L);
		semestres.add(7L);
		semestres.add(8L);
		semestres.add(9L);
		return semestres;
	}
	
	/**Metodo para obtener los alumnos registrados
	 * @param soloLibres indica si consultar solo alumnos sin equipo
	 * @return Lista de alumnos
	 * @throws BussinessException En caso de error de negocio
	 */
	public List<Alumno> obtenerAlumnosRegistrados(boolean soloLibres) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnosRegistrados()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			alumnos = alumnosDao.selectFromAlumno(soloLibres);
		}catch(Exception e) {
			logger.error(" Error al consultar los alumnos registrados ", e);
			throw new BussinessException("Error al consultar los alumnos registrados.");
		}
		alumnosDao.cerrarConexiones();
		return alumnos;
	}
	

	/**Metodo para obtener los alumnos por boleta
	 * @param boletaAlumno del alumno
	 * @return Lista con un alumno o vacia en caso de no encontrar
	 * @throws BussinessException En caso de error al consultar
	 */
	public List<Alumno> obtenerAlumnosRegistradosPorBoleta(Long boletaAlumno) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnosRegistrados()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			alumnos.add(alumnosDao.selectAlumnoById(boletaAlumno));
		}catch(Exception e) {
			logger.error(" Error al consultar los alumnos registrados ", e);
			throw new BussinessException("Error al consultar los alumnos registrados.");
		}finally {
			alumnosDao.cerrarConexiones();
		}
		return alumnos;
	}
	
	/**Metodo para obtener alumnos por nombrePila
	 * @param nombrePila del alumno
	 * @param soloLibres indica si solo mostrar alumnos sin equipo
	 * @return Lista de alumnos donde nombre pila sea como nombrePila%
	 * @throws BussinessException en caso de error al consultar
	 */
	public List<Alumno> obtenerAlumnosRegistradosPorNombrePila(String nombrePila, boolean soloLibres) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnosRegistrados()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			alumnos = alumnosDao.selectFromAlumnoLikeNombrePila(nombrePila, soloLibres);
		}catch(Exception e) {
			logger.error(" Error al consultar los alumnos registrados ", e);
			throw new BussinessException("Error al consultar los alumnos registrados.");
		}finally {
			alumnosDao.cerrarConexiones();
		}
		return alumnos;
	}
	

	/**Metodo de negocio para obtener los alumnos registrados en una escuela
	 * @param idEscuela de la escuela
	 * @param soloLibres indica si mostrar solo alumnos sin equipo
	 * @return Lista de alumnos
	 * @throws BussinessException En caso de error al consultar
	 */
	public List<Alumno> obtenerAlumnosRegistradosPorEscuela(Long idEscuela, boolean soloLibres) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnosRegistrados()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			alumnos = alumnosDao.selectFromAlumnoByEscuela(idEscuela, soloLibres);
		}catch(Exception e) {
			logger.error(" Error al consultar los alumnos registrados ", e);
			throw new BussinessException("Error al consultar los alumnos registrados.");
		}finally {
			alumnosDao.cerrarConexiones();
		}
		return alumnos;
	}

	/**Metodo para registrar/actualizar un alumno
	 * @param vo Con los datos del alumno
	 * @param operacion Indicia la operaci�n a realizar (registrado ó actualizado)
	 * @return Entidad persistida
	 * @throws BussinessException Si ya existiera un alumno registrado con el numero de boleta (en el caso de registro)
	 */
	public Alumno registrarAlumno(GestionarAlumnosVO vo, String operacion) throws BussinessException {
		
		logger.info("Inicia metodo GestionarAlumnosBI.registrarAlumno()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		Escuela escuela;
		Alumno nuevoAlumno = new Alumno();
		
		try {
			BeanUtils.copyProperties(nuevoAlumno, vo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad", e);
			throw new BussinessException("Error al registrar al alumno.");
		}

		try{
			escuela = escuelasDao.selectEscuelaById(vo.getIdEscuela());
		}catch(Exception e) {
			logger.error("Error al obtener la escuela para registrar al alumno", e);
			throw new BussinessException("Error al registrar al alumno. ");
		}finally {
			escuelasDao.cerrarConexiones();
		}
		nuevoAlumno.setEscuela(escuela);

		try {
			if(operacion.equals("registrado"))
				nuevoAlumno = alumnosDao.insertIntoAlumno(nuevoAlumno);
			else
				nuevoAlumno = alumnosDao.updateAlumno(nuevoAlumno);
		} catch (SQLException e) {
			if(e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar al alumno, ya existe un alumno registrado", e);
				throw new BussinessException("Ya existe un alumno registrado con ese numero de boleta.");
			}
			else {
				logger.error("Error en la operación sql del alumno",e);
				throw new BussinessException("Error al registrar al alumno.");
			}
		}finally {
			alumnosDao.cerrarConexiones();
		}

		return nuevoAlumno;
	}
	
	/**Metodo para obtener un alumno por boleta
	 * @param numeroBoleta del alumno
	 * @return Entidad de alumno con sus datos
	 * @throws BussinessException En caso de no encontrar alumno
	 */
	public Alumno obtenerAlumnoPorBoleta(Long numeroBoleta) throws BussinessException {
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnoPorBoleta()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		Alumno alumno = alumnosDao.selectAlumnoById(numeroBoleta);
		if(alumno == null) {
			alumnosDao.cerrarConexiones();
			throw new BussinessException("Error al obtener alumno por boleta, no se encuentra registrado.");
		}
		alumnosDao.cerrarConexiones();
		return alumno;
	}
	
	/**Metodo para eliminar un alumno
	 * @param numeroBoleta del alumno
	 * @throws BussinessException si no existiera el alumno
	 */
	public void bajaAlumno(Long numeroBoleta) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.eliminarAlumno()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		try {
			Alumno alumno = alumnosDao.selectAlumnoById(numeroBoleta);
			if(alumno==null) {
				logger.error("Error al borrar al alumno: alumno con boleta "+numeroBoleta+" no encontrado");
				throw new BussinessException("Error al borrar al alumno: alumno no encontrado");
			}
			alumno.setFechaAlta(null);
			java.util.Date utilDate = new java.util.Date();
			alumno.setFechaBaja(new Date(utilDate.getTime()));
			alumnosDao.updateAlumno(alumno);
			//alumnosDao.deleteAlumno(alumno);				
		}catch (Exception e) {
			logger.error("Error al borrar al alumno ",e);
			throw new BussinessException("Error al borrar al alumno.");
		}finally {
			alumnosDao.cerrarConexiones();
		}
		
	}
	
	/**Metodo para eliminar un alumno
	 * @param numeroBoleta del alumno
	 * @throws BussinessException si no existiera el alumno
	 */
	public void altaAlumno(Long numeroBoleta) throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.eliminarAlumno()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		try {
			Alumno alumno = alumnosDao.selectAlumnoById(numeroBoleta);
			if(alumno==null) {
				logger.error("Error al borrar al alumno: alumno con boleta "+numeroBoleta+" no encontrado");
				throw new BussinessException("Error al borrar al alumno: alumno no encontrado");
			}
			java.util.Date utilDate = new java.util.Date();
			alumno.setFechaAlta(new Date(utilDate.getTime()));
			alumno.setFechaBaja(null);
			alumnosDao.updateAlumno(alumno);
			//alumnosDao.deleteAlumno(alumno);				
		}catch (Exception e) {
			logger.error("Error al borrar al alumno ",e);
			throw new BussinessException("Error al borrar al alumno.");
		}finally {
			alumnosDao.cerrarConexiones();
		}
		
	}
	
}
