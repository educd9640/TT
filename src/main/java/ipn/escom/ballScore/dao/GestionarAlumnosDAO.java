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
	
	/**Metodo para actualizar un alumno
	 * @param entidad del alumno
	 * @return Entidad persistida
	 * @throws SQLException En caso de error al persistir la entidad
	 */
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
	
	/**Metodo para consultar todos los alumnos registrados
	 * @param soloLibres si es true, solo muestra alumnos que no tienen equipo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Alumno> selectFromAlumno(boolean soloLibres){
		Query q ;
		if(!soloLibres)
			q = session.createQuery("from Alumno al");
		else
			q = session.createQuery("from Alumno al where al.boletaAlumno not in (select jug.alumno.boletaAlumno from Jugador jug)");
		return (List<Alumno>)q.list();
	}
	
	
	/**Metodo para consultar los alumnos por nombre pila
	 * @param nombrePila del alumno
	 * @param soloLibres si es true, solo muestra alumnos que no tienen equipo
	 * @return Lista de alumnos donde el nombre pila comienze por el indiciado
	 */
	@SuppressWarnings("unchecked")
	public List<Alumno> selectFromAlumnoLikeNombrePila(String nombrePila, boolean soloLibres){
		Query q;
		if(!soloLibres)
			q = session.createQuery("from Alumno al where al.nombrePila like :nombrePila");
		else
			q = session.createQuery("from Alumno al where al.nombrePila like :nombrePila and al.boletaAlumno not in (select jug.alumno.boletaAlumno from Jugador jug)");
		q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
		return (List<Alumno>) q.list();
	}
	
	/**Metodo para consultar alumnos registrados en una escuela
	 * @param idEscuela de la escuela
	 * @param soloLibres si es true, solo muestra alumnos que no tienen equipo
	 * @return lista de alumnos registrados en la escuela
	 */
	@SuppressWarnings("unchecked")
	public List<Alumno> selectFromAlumnoByEscuela(Long idEscuela, boolean soloLibres){
		Query q;
		if(!soloLibres)
			q = session.createQuery("from Alumno al where al.escuela.idEscuela = :idEscuela");
		else
			q = session.createQuery("from Alumno al where al.escuela.idEscuela = :idEscuela and al.boletaAlumno not in (select jug.alumno.boletaAlumno from Jugador jug)");
		q.setParameter("idEscuela", idEscuela);
		return (List<Alumno>) q.list();
	}
	
	/**Metodo para obtener un alumno por boleta
	 * @param numeroBoleta del alumno
	 * @return La entidad alumno con sus datos
	 */
	public Alumno selectAlumnoById(Long numeroBoleta) {
		return (Alumno) this.session.get(Alumno.class, numeroBoleta);
	}
	
}



