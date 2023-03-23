package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import ipn.escom.ballScore.entity.Alumno;

/**Clase DAO para gestionar alumnos
 * @author Jose Mauricio
 *
 */
public class GestionarAlumnosDAO extends BaseDAO {

	/**
	 * Constructor de la clase DAO
	 */
	public GestionarAlumnosDAO() {
		super();
	}
	
	/**Metodo para insertar un alumno
	 * @param entidad con los datos del alumno
	 * @return la entidad persistida
	 * @throws SQLException En caso de error al persistir la entidad
	 */
	public Alumno insertIntoAlumno(Alumno entidad) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return entidad;
	}
	
	/**Metodo para consultar todos los alumnos registrados
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Alumno> selectFromAlumno(){
		Query q = session.createQuery("from Alumno");
		return (List<Alumno>)q.list();
	}
	
	/**Metodo para obtener un alumno por boleta
	 * @param numeroBoleta del alumno
	 * @return La entidad alumno con sus datos
	 */
	public Alumno selectAlumnoById(Long numeroBoleta) {
		return (Alumno) this.session.get(Alumno.class, numeroBoleta);
	}
	
	public Alumno updateAlumno(Alumno entidad) throws SQLException {
		try {
			session.update(entidad);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return entidad;
	}
	
}



