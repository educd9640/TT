package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
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
	 * @return Lista de alumnos
	 * @throws BussinessException En caso de error de negocio
	 */
	public List<Alumno> obtenerAlumnosRegistrados() throws BussinessException{
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnosRegistrados()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			alumnos = alumnosDao.selectFromAlumno();
		}catch(Exception e) {
			logger.error(" Error al consultar los alumnos registrados ", e);
			throw new BussinessException("Error al consultar los alumnos registrados.");
		}
		alumnosDao.cerrarConexiones();
		return alumnos;
	}

	/**Metodo para registrar un alumno
	 * @param vo Con los datos del alumno
	 * @return Entidad persistida
	 * @throws BussinessException Si ya existiera un alumno registrado con el numero de boleta
	 */
	public Alumno registrarAlumno(GestionarAlumnosVO vo) throws BussinessException {
		
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
		}
		nuevoAlumno.setEscuela(escuela);

		try {
			if(nuevoAlumno.getBoletaAlumno()==null)
				nuevoAlumno = alumnosDao.insertIntoAlumno(nuevoAlumno);
			else
				nuevoAlumno = alumnosDao.updateAlumno(nuevoAlumno);
		} catch (SQLException e) {
			if(e.getCause().getMessage().contains("ORA-00001")) {
				logger.error(" Error al registrar al alumno, ya existe un alumno registrado", e);
				throw new BussinessException("Ya existe un alumno registrado con ese numero de boleta.");
			}
			else {
				logger.error("Error al realizar insert del alumno",e);
				throw new BussinessException("Error al registrar al alumno.");
			}
		}


		alumnosDao.cerrarConexiones();
		escuelasDao.cerrarConexiones();

		return nuevoAlumno;
	}
	
	public Alumno obtenerAlumnoPorBoleta(Long numeroBoleta) throws BussinessException {
		logger.info("Inicia metodo GestionarAlumnosBI.obtenerAlumnoPorBoleta()");
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		Alumno alumno = alumnosDao.selectAlumnoById(numeroBoleta);
		if(alumno == null) {
			throw new BussinessException("Error al obtener alumno por boleta, no se encuentra registrado.");
		}
		alumnosDao.cerrarConexiones();
		return alumno;
	}
	
}
