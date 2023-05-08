package ipn.escom.ballScore.dao;

import java.util.List;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.JugadorPartido;

public class GestionarJugadorPartidoDAO extends BaseDAO{
	
	public GestionarJugadorPartidoDAO() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadorPartido(Long idJugador, Long idPartido, Long idEquipo, Long idTemporada) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idJugador = :idJugador and jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada");
		q.setParameter("idJugador", idJugador);
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (List<JugadorPartido>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadoresPartido(Long idPartido, Long idEquipo, Long idTemporada) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (List<JugadorPartido>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadoresPartidoByBoleta(Long idPartido, Long idEquipo, Long idTemporada, Long boletaAlumno) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada and "
				+ "jugadorEquipoTemp.jugador.alumno.boletaAlumno = :boletaAlumno");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("boletaAlumno", boletaAlumno);
		return (List<JugadorPartido>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadoresPartidoLikeNombrePila(Long idPartido, Long idEquipo, Long idTemporada, String nombrePila) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada and "
				+ "jugadorEquipoTemp.jugador.alumno.nombrePila like :nombrePila");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("nombrePila", nombrePila.toUpperCase()+"%");
		return (List<JugadorPartido>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadoresPartidoByPosicionPrim(Long idPartido, Long idEquipo, Long idTemporada, String posicionPrim) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada and "
				+ "jugadorEquipoTemp.jugador.posicionPrim = :posicionPrim");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("posicionPrim", posicionPrim);
		return (List<JugadorPartido>)q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JugadorPartido> selectJugadoresPartidoByPosicionSec(Long idPartido, Long idEquipo, Long idTemporada, String posicionSec) {
		Query q = session.createQuery("from JugadorPartido jup where jup.idPartido = :idPartido and jup.idEquipo = :idEquipo and jup.idTemporada = :idTemporada and "
				+ "jugadorEquipoTemp.jugador.posicionSec = :posicionSec");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("posicionSec", posicionSec);
		return (List<JugadorPartido>)q.list();
	}
	
	public void insertJugadoresPartido(List<JugadorPartido> jugadoresPartido) {
		for(JugadorPartido jugador : jugadoresPartido) {
			session.save(jugador);
			session.flush();
			session.clear();
		}
	}
}
