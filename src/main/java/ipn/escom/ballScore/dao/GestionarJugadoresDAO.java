package ipn.escom.ballScore.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

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
