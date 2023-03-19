package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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
	
	/**Metodo para obtener las escuelas registradas
	 * @return Lista de escuelas sin fecha baja
	 */
	public List<Escuela> obtenerEscuelas() {
		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		List<Escuela> escuelas = escuelasDao.obtenerEscuelasAlta();
		escuelasDao.cerrarConexiones();
		return escuelas;
	}
	
	/**Metodo para obtener los semestres
	 * @return Lista de semestres
	 */
	public List<Long> obtenerSemestres(){
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
	 */
	public List<Alumno> obtenerAlumnosRegistrados(){
		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();
		List<Alumno> alumnos = alumnosDao.selectFromAlumno();
		alumnosDao.cerrarConexiones();
		return alumnos;
	}

	/**Metodo para registrar un alumno
	 * @param vo Con los datos del alumno
	 * @return Entidad persistida
	 * @throws BussinessException Si ya existiera un alumno registrado con el numero de boleta
	 */
	public Alumno registrarAlumno(GestionarAlumnosVO vo) throws BussinessException {

		Alumno nuevoAlumno = new Alumno();
		try {
			BeanUtils.copyProperties(nuevoAlumno, vo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GestionarAlumnosDAO alumnosDao = new GestionarAlumnosDAO();

		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		Escuela escuela = escuelasDao.selectEscuelaById(vo.getIdEscuela());
		nuevoAlumno.setEscuela(escuela);

		try {
			nuevoAlumno = alumnosDao.insertIntoAlumno(nuevoAlumno);
		} catch (SQLException e) {
			if(e.getCause().getMessage().contains("ORA-00001"))
				throw new BussinessException("Ya existe un alumno registrado con ese numero de boleta");
			else
				e.printStackTrace();
		}


		alumnosDao.cerrarConexiones();
		escuelasDao.cerrarConexiones();

		return nuevoAlumno;
	}

}
