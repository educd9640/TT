package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Alumno;
import ipn.escom.ballScore.entity.Jugador;

/**Clase DAO para las consultas de jugadores
 * @author Jose Mauricio
 *
 */
public class GestionarJugadoresDAO extends BaseDAO{
	
	/**
	 * Constructor de la clase DAO
	 */
	public GestionarJugadoresDAO() {
		super();
	}
	
	/**Metodo para insertar jugador
	 * @param jugador entidad jugador
	 * @return Entidad persistida
	 * @throws SQLException en caso de error al insertar
	 */
	public Jugador insertIntoJugador(Jugador jugador) throws SQLException {
		java.util.Date utilDate = new java.util.Date();
		jugador.setFechaAlta(new Date(utilDate.getTime()));
		try {
			session.save(jugador);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugador;
	}
	
	/**Metodo para actualizar un jugador
	 * @param jugador Jugador con nuevos datos
	 * @return Entidad persistida
	 * @throws SQLException en caso de error al actualizar
	 */
	public Jugador updateJugador(Jugador jugador) throws SQLException {
		try {
			session.update(jugador);
			session.flush();
			session.clear();
		}catch(Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugador;
	}
	
	/**Metodo para buscar un jugado por boleta
	 * @param boletaAlumno del jugador
	 * @return Lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadorByBoleta(Long boletaAlumno) throws SQLException {
		List<Jugador> resultado;
		Query q = session.createQuery("from Jugador where boleta_alumno = :boletaAlumno");
		q.setParameter("boletaAlumno", boletaAlumno);
		try {
			resultado = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return resultado;
	}
	
	/**Metodo para buscar un jugado por boleta
	 * @param idEquipo del equipo
	 * @param boletaAlumno del jugador
	 * @return Lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadorByBoleta(Long idEquipo, Long boletaAlumno) throws SQLException {
		List<Jugador> resultado;
		Query q = session.createQuery("from Jugador jug where jug.equipo.idEquipo = :idEquipo and jug.alumno.boletaAlumno = :boletaAlumno");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("boletaAlumno", boletaAlumno);
		try {
			resultado = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return resultado;
	}
	
	/**Metodo para buscar un jugado por nombrePila
	 * @param idEquipo del equipo del jugador
	 * @param nombrePila del jugador
	 * @return Lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadorByEquipoLikeNombrePila(Long idEquipo, String nombrePila) throws SQLException {
		List<Jugador> resultado;
		Query q = session.createQuery("from Jugador jug where jug.equipo.idEquipo = :idEquipo and jug.alumno.nombrePila like :nombrePila");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
		try {
			resultado = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return resultado;
	}
	
	/**Metodo para buscar un jugado por posicionPrim
	 * @param idEquipo del equipo del jugador
	 * @param posicionPrim del jugador
	 * @return Lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadorByPosicionPrim(Long idEquipo, String posicionPrim) throws SQLException {
		List<Jugador> resultado;
		Query q = session.createQuery("from Jugador jug where jug.equipo.idEquipo = :idEquipo and jug.posicionPrim = :posicionPrim");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("posicionPrim", posicionPrim);
		try {
			resultado = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return resultado;
	}
	
	/**Metodo para buscar un jugado por posicionSec
	 * @param idEquipo del equipo del jugador
	 * @param posicionSec del jugador
	 * @return Lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadorByPosicionSec(Long idEquipo, String posicionSec) throws SQLException {
		List<Jugador> resultado;
		Query q = session.createQuery("from Jugador jug where jug.equipo.idEquipo = :idEquipo and jug.posicionSec = :posicionSec");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("posicionSec", posicionSec);
		try {
			resultado = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		return resultado;
	}
	
	/**Metodo para consultar los jugadores registrados en un equipo
	 * @param idEquipo del equipo
	 * @return lista de jugadores registrados
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> selectJugadoresByEquipo(Long idEquipo) throws SQLException{
		List<Jugador> jugadoresRegistrados;
		try {
			Query q = session.createQuery("from Jugador j where j.equipo.idEquipo = :idEquipo");
			q.setParameter("idEquipo", idEquipo);
			jugadoresRegistrados = q.list();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo DAO para ejecutar consulta nativa y obtener los jugadores que no estan registrados en un
	 * equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @return Lista de jugadores que no estan registrados en el equipo de temporada
	 * @throws SQLException En caso de error al consultar
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Jugador> selectJugadoresNoRegistrados(Long idEquipo, Long idTemporada) throws SQLException{
		List<Jugador> jugadoresRegistrados = new ArrayList<Jugador>();
		try {
			Query q = session.createSQLQuery("SELECT JUG.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JUG.FECHA_ALTA \n"
					+ "FROM JUGADOR JUG \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_EQUIPO_TEMP WHERE ID_EQUIPO = :idEquipo AND ID_TEMPORADA = :idTemporada)");
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Jugador jugador = new Jugador();
				jugador.setIdJugador(Long.parseLong(row[0].toString()));
				Alumno alumno = new Alumno();
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugador.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadoresRegistrados.add(jugador);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo DAO para ejecutar consulta nativa y obtener los jugadores que no estan registrados en un
	 * equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param boletaAlumno del alumno
	 * @return Lista de jugadores que no estan registrados en el equipo de temporada
	 * @throws SQLException En caso de error al consultar
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Jugador> selectJugadoresNoRegistrados(Long idEquipo, Long idTemporada, Long boletaAlumno) throws SQLException{
		List<Jugador> jugadoresRegistrados = new ArrayList<Jugador>();
		try {
			Query q = session.createSQLQuery("SELECT JUG.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JUG.FECHA_ALTA \n"
					+ "FROM JUGADOR JUG \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_EQUIPO_TEMP WHERE ID_EQUIPO = :idEquipo AND ID_TEMPORADA = :idTemporada) "
					+ "AND AL.BOLETA_ALUMNO = :boletaAlumno");
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("boletaAlumno", boletaAlumno);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Jugador jugador = new Jugador();
				jugador.setIdJugador(Long.parseLong(row[0].toString()));
				Alumno alumno = new Alumno();
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugador.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadoresRegistrados.add(jugador);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo DAO para ejecutar consulta nativa y obtener los jugadores que no estan registrados en un
	 * equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param nombrePila del alumno
	 * @return Lista de jugadores que no estan registrados en el equipo de temporada
	 * @throws SQLException En caso de error al consultar
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Jugador> selectJugadoresNoRegistradosLikeNombrePila(Long idEquipo, Long idTemporada, String nombrePila) throws SQLException{
		List<Jugador> jugadoresRegistrados = new ArrayList<Jugador>();
		try {
			Query q = session.createSQLQuery("SELECT JUG.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JUG.FECHA_ALTA \n"
					+ "FROM JUGADOR JUG \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_EQUIPO_TEMP WHERE ID_EQUIPO = :idEquipo AND ID_TEMPORADA = :idTemporada) "
					+ "AND AL.NOMBRE_PILA LIKE :nombrePila");
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Jugador jugador = new Jugador();
				jugador.setIdJugador(Long.parseLong(row[0].toString()));
				Alumno alumno = new Alumno();
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugador.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadoresRegistrados.add(jugador);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo DAO para ejecutar consulta nativa y obtener los jugadores que no estan registrados en un
	 * equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param posicionPrim del jugador
	 * @return Lista de jugadores que no estan registrados en el equipo de temporada
	 * @throws SQLException En caso de error al consultar
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Jugador> selectJugadoresNoRegistradosByPosicionPrim(Long idEquipo, Long idTemporada, String posicionPrim) throws SQLException{
		List<Jugador> jugadoresRegistrados = new ArrayList<Jugador>();
		try {
			Query q = session.createSQLQuery("SELECT JUG.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JUG.FECHA_ALTA \n"
					+ "FROM JUGADOR JUG \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_EQUIPO_TEMP WHERE ID_EQUIPO = :idEquipo AND ID_TEMPORADA = :idTemporada) "
					+ "AND JUG.POSICION_PRIM = :posicionPrim");
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("posicionPrim", posicionPrim);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Jugador jugador = new Jugador();
				jugador.setIdJugador(Long.parseLong(row[0].toString()));
				Alumno alumno = new Alumno();
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugador.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadoresRegistrados.add(jugador);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo DAO para ejecutar consulta nativa y obtener los jugadores que no estan registrados en un
	 * equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param posicionSec del jugador
	 * @return Lista de jugadores que no estan registrados en el equipo de temporada
	 * @throws SQLException En caso de error al consultar
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Jugador> selectJugadoresNoRegistradosByPosicionSec(Long idEquipo, Long idTemporada, String posicionSec) throws SQLException{
		List<Jugador> jugadoresRegistrados = new ArrayList<Jugador>();
		try {
			Query q = session.createSQLQuery("SELECT JUG.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JUG.FECHA_ALTA \n"
					+ "FROM JUGADOR JUG \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_EQUIPO_TEMP WHERE ID_EQUIPO = :idEquipo AND ID_TEMPORADA = :idTemporada) "
					+ "AND JUG.POSICION_SEC = :posicionSec");
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("posicionSec", posicionSec);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Jugador jugador = new Jugador();
				jugador.setIdJugador(Long.parseLong(row[0].toString()));
				Alumno alumno = new Alumno();
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugador.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadoresRegistrados.add(jugador);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo para consultar un jugador por id
	 * @param idJugador del jugador
	 * @return jugador consultado
	 * @throws SQLException en caso de error al consultar
	 */
	public Jugador selectJugadorById(Long idJugador) throws SQLException {
		Jugador jugador;
		try {
			Query q = session.createQuery("from Jugador j where j.idJugador = :idJugador");
			q.setParameter("idJugador", idJugador);
			jugador = (Jugador) q.uniqueResult();
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugador;
	}

}
