package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.Alumno;
import ipn.escom.ballScore.entity.Jugador;
import ipn.escom.ballScore.entity.JugadorEquipoTemp;

/**Clase DAO para la gestion de jugadores de los equipos de temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugadorEquipoTempDAO extends BaseDAO{

	/**
	 * Constructor de la clase
	 */
	public GestionarJugadorEquipoTempDAO() {
		super();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTemp(Long idEquipo, Long idTemporada){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @param boletaAlumno del alumno
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTemp(Long idEquipo, Long idTemporada, Long boletaAlumno){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada and jet.jugador.alumno.boletaAlumno = :boletaAlumno");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("boletaAlumno", boletaAlumno);
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @param nombrePila del jugador
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTempLikeNombrePila(Long idEquipo, Long idTemporada, String nombrePila){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada and jet.jugador.alumno.nombrePila like :nombrePila");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @param posicionPrim del jugador
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTempAndPosicionPrim(Long idEquipo, Long idTemporada, String posicionPrim){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada and jet.jugador.posicionPrim = :posicionPrim");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("posicionPrim", posicionPrim);
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para la consulta de jugadores registrados en un equipo de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada del equipo temporada
	 * @param posicionSec del jugador
	 * @return Lista de jugadores registrados
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadorEquipoTempByEquipoTempAndPosicionSec(Long idEquipo, Long idTemporada, String posicionSec){
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idEquipo=:idEquipo and jet.idTemporada=:idTemporada and jet.jugador.posicionSec = :posicionSec");
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("posicionSec", posicionSec);
		return (List<JugadorEquipoTemp>) q.list();
	}
	
	/**Metodo DAO para registrar jugadores de equipos de temporada
	 * @param jugadores lista de jugadores a registrar
	 */
	public void saveJugadores(List<JugadorEquipoTemp> jugadores) {
		for(JugadorEquipoTemp jugador : jugadores) {
				java.util.Date utilDate = new java.util.Date();
				jugador.setFechaAlta(new Date(utilDate.getTime()));
				session.save(jugador);
				session.flush();
				session.clear();
		}
	}
	
	/**Metodo para consultar un jugador de equipo de temporada
	 * @param idJugador del jugador de temporada
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada de la temporada
	 * @return Jugador de temporada
	 */
	public JugadorEquipoTemp selectJugadorEquipoTemp(Long idJugador, Long idEquipo, Long idTemporada) {
		Query q = session.createQuery("from JugadorEquipoTemp jet where jet.idJugador = :idJugador and jet.idEquipo = :idEquipo and jet.idTemporada = :idTemporada");
		q.setParameter("idJugador", idJugador);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (JugadorEquipoTemp) q.uniqueResult();
	}
	
	/**Metodo para insertar o actualizar un jugador de equipo temporada
	 * @param jugadorEquipoTemp Entidad con los datos del jugador de temporada
	 */
	public void saveOrUpdateJugadorEquipoTemp(JugadorEquipoTemp jugadorEquipoTemp) {
		session.save(jugadorEquipoTemp);
		session.flush();
		session.clear();
	}
	
	/**Metodo DAO para consultar los jugadores de un equipo de temporada que no esten registrados en un partido
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param idPartido del partido
	 * @return Lista de jugadores del equipo de temporada no registrados en el partido
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadoresNoRegistradosEnPartido(Long idEquipo, Long idTemporada, Long idPartido) throws SQLException{
		List<JugadorEquipoTemp> jugadoresRegistrados = new ArrayList<JugadorEquipoTemp>();
		try {
			Query q = session.createSQLQuery("SELECT JET.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JET.FECHA_ALTA \n"
					+ "FROM JUGADOR_EQUIPO_TEMP JET \n"
					+ "INNER JOIN JUGADOR JUG ON (JET.ID_JUGADOR = JUG.ID_JUGADOR) \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE JET.ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_PARTIDO WHERE ID_PARTIDO = :idPartido AND ID_EQUIPO = :idEquipo AND ID_TEMPORADA =:idTemporada) "
					+ "AND JET.ID_EQUIPO = :idEquipo AND JET.ID_TEMPORADA=:idTemporada");
			q.setParameter("idPartido", idPartido);
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				JugadorEquipoTemp jugadorEquipoTemp = new JugadorEquipoTemp();
				Jugador jugador = new Jugador();
				Alumno alumno = new Alumno();
				jugadorEquipoTemp.setIdJugador(Long.parseLong(row[0].toString()));
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugadorEquipoTemp.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadorEquipoTemp.setJugador(jugador);
				jugadoresRegistrados.add(jugadorEquipoTemp);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo dao para consultar jugadores de equipo de temporada que no estan en el partido
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada de la temporada
	 * @param idPartido del partido
	 * @param boletaAlumno del alumno
	 * @return lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadoresNoRegistradosEnPartido(Long idEquipo, Long idTemporada, Long idPartido, Long boletaAlumno) throws SQLException{
		List<JugadorEquipoTemp> jugadoresRegistrados = new ArrayList<JugadorEquipoTemp>();
		try {
			Query q = session.createSQLQuery("SELECT JET.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JET.FECHA_ALTA \n"
					+ "FROM JUGADOR_EQUIPO_TEMP JET \n"
					+ "INNER JOIN JUGADOR JUG ON (JET.ID_JUGADOR = JUG.ID_JUGADOR) \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE JET.ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_PARTIDO WHERE ID_PARTIDO = :idPartido AND ID_EQUIPO = :idEquipo AND ID_TEMPORADA =:idTemporada) "
					+ "AND AL.BOLETA_ALUMNO = :boletaAlumno AND JET.ID_EQUIPO = :idEquipo AND JET.ID_TEMPORADA=:idTemporada");
			q.setParameter("idPartido", idPartido);
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("boletaAlumno", boletaAlumno);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				JugadorEquipoTemp jugadorEquipoTemp = new JugadorEquipoTemp();
				Jugador jugador = new Jugador();
				Alumno alumno = new Alumno();
				jugadorEquipoTemp.setIdJugador(Long.parseLong(row[0].toString()));
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugadorEquipoTemp.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadorEquipoTemp.setJugador(jugador);
				jugadoresRegistrados.add(jugadorEquipoTemp);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo dao para consultar jugadores de equipo de temporada que no estan en el partido
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada de la temporada
	 * @param idPartido del partido
	 * @param nombrePila del alumno
	 * @return lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadoresNoRegistradosEnPartidoLikeNombrePila(Long idEquipo, Long idTemporada, Long idPartido, String nombrePila) throws SQLException{
		List<JugadorEquipoTemp> jugadoresRegistrados = new ArrayList<JugadorEquipoTemp>();
		try {
			Query q = session.createSQLQuery("SELECT JET.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JET.FECHA_ALTA \n"
					+ "FROM JUGADOR_EQUIPO_TEMP JET \n"
					+ "INNER JOIN JUGADOR JUG ON (JET.ID_JUGADOR = JUG.ID_JUGADOR) \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE JET.ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_PARTIDO WHERE ID_PARTIDO = :idPartido AND ID_EQUIPO = :idEquipo AND ID_TEMPORADA =:idTemporada) "
					+ "AND AL.NOMBRE_PILA LIKE :nombrePila AND JET.ID_EQUIPO = :idEquipo AND JET.ID_TEMPORADA=:idTemporada");
			q.setParameter("idPartido", idPartido);
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				JugadorEquipoTemp jugadorEquipoTemp = new JugadorEquipoTemp();
				Jugador jugador = new Jugador();
				Alumno alumno = new Alumno();
				jugadorEquipoTemp.setIdJugador(Long.parseLong(row[0].toString()));
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugadorEquipoTemp.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadorEquipoTemp.setJugador(jugador);
				jugadoresRegistrados.add(jugadorEquipoTemp);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo dao para consultar jugadores de equipo de temporada que no estan en el partido
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada de la temporada
	 * @param idPartido del partido
	 * @param posicionPrim del alumno
	 * @return lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadoresNoRegistradosEnPartidoByPosicionPrim(Long idEquipo, Long idTemporada, Long idPartido, String posicionPrim) throws SQLException{
		List<JugadorEquipoTemp> jugadoresRegistrados = new ArrayList<JugadorEquipoTemp>();
		try {
			Query q = session.createSQLQuery("SELECT JET.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JET.FECHA_ALTA \n"
					+ "FROM JUGADOR_EQUIPO_TEMP JET \n"
					+ "INNER JOIN JUGADOR JUG ON (JET.ID_JUGADOR = JUG.ID_JUGADOR) \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE JET.ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_PARTIDO WHERE ID_PARTIDO = :idPartido AND ID_EQUIPO = :idEquipo AND ID_TEMPORADA =:idTemporada) "
					+ "AND JUG.POSICION_PRIM = :posicionPrim AND JET.ID_EQUIPO = :idEquipo AND JET.ID_TEMPORADA=:idTemporada");
			q.setParameter("idPartido", idPartido);
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("posicionPrim", posicionPrim);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				JugadorEquipoTemp jugadorEquipoTemp = new JugadorEquipoTemp();
				Jugador jugador = new Jugador();
				Alumno alumno = new Alumno();
				jugadorEquipoTemp.setIdJugador(Long.parseLong(row[0].toString()));
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugadorEquipoTemp.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadorEquipoTemp.setJugador(jugador);
				jugadoresRegistrados.add(jugadorEquipoTemp);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
	
	/**Metodo dao para consultar jugadores de equipo de temporada que no estan en el partido
	 * @param idEquipo del equipo de temporada
	 * @param idTemporada de la temporada
	 * @param idPartido del partido
	 * @param posicionSec del alumno
	 * @return lista de jugadores
	 * @throws SQLException en caso de error al consultar
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorEquipoTemp> selectJugadoresNoRegistradosEnPartidoByPosicionSec(Long idEquipo, Long idTemporada, Long idPartido, String posicionSec) throws SQLException{
		List<JugadorEquipoTemp> jugadoresRegistrados = new ArrayList<JugadorEquipoTemp>();
		try {
			Query q = session.createSQLQuery("SELECT JET.ID_JUGADOR, AL.BOLETA_ALUMNO, AL.NOMBRE_PILA, AL.APELLIDO_PAT, AL.APELLIDO_MAT, JUG.POSICION_PRIM, JUG.POSICION_SEC, JET.FECHA_ALTA \n"
					+ "FROM JUGADOR_EQUIPO_TEMP JET \n"
					+ "INNER JOIN JUGADOR JUG ON (JET.ID_JUGADOR = JUG.ID_JUGADOR) \n"
					+ "INNER JOIN ALUMNO AL ON (JUG.BOLETA_ALUMNO = AL.BOLETA_ALUMNO) \n"
					+ "WHERE JET.ID_JUGADOR NOT IN (SELECT ID_JUGADOR FROM JUGADOR_PARTIDO WHERE ID_PARTIDO = :idPartido AND ID_EQUIPO = :idEquipo AND ID_TEMPORADA =:idTemporada) "
					+ "AND JUG.POSICION_SEC = :posicionSec AND JET.ID_EQUIPO = :idEquipo AND JET.ID_TEMPORADA=:idTemporada");
			q.setParameter("idPartido", idPartido);
			q.setParameter("idEquipo", idEquipo);
			q.setParameter("idTemporada", idTemporada);
			q.setParameter("posicionSec", posicionSec);
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				JugadorEquipoTemp jugadorEquipoTemp = new JugadorEquipoTemp();
				Jugador jugador = new Jugador();
				Alumno alumno = new Alumno();
				jugadorEquipoTemp.setIdJugador(Long.parseLong(row[0].toString()));
				alumno.setBoletaAlumno(Long.parseLong(row[1].toString()));
				alumno.setNombrePila(row[2].toString());
				alumno.setApellidoMat(row[3].toString());
				alumno.setApellidoPat(row[4].toString());
				jugador.setAlumno(alumno);
				jugador.setPosicionPrim(row[5].toString());
				jugador.setPosicionSec(row[6].toString());
				Timestamp fechaAlta = (Timestamp) row[7];
				jugadorEquipoTemp.setFechaAlta(new Date(fechaAlta.getTime()));
				jugadorEquipoTemp.setJugador(jugador);
				jugadoresRegistrados.add(jugadorEquipoTemp);
			}
		}catch (Exception e) {
			throw new SQLException(e.getMessage(), e.getCause());
		}
		
		return jugadoresRegistrados;
	}
}
