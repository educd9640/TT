package ipn.escom.ballScore.dao;

import org.hibernate.Query;

import ipn.escom.ballScore.form.EstadisticasDefensivasVO;
import ipn.escom.ballScore.form.EstadisticasPitcherVO;

/**Clase DAO para la gestion de estadisticas
 * @author Jose Mauricio
 *
 */
public class GestionarEstadisticasDAO extends BaseDAO{

	/**Metodo DAO para llamada a sp para registrar estadisticas de pitcher
	 * @param idPartido del partido
	 * @param idJugador del jugador del partido
	 * @param idEquipo del equipo del partido
	 * @param idTemporada del partido
	 * @param estVo con estadisticas del pitcher
	 */
	public void registrarEstadisticasPitcher(Long idPartido, Long idJugador, Long idEquipo, Long idTemporada, EstadisticasPitcherVO estVo) {
		Query q = session.createSQLQuery("CALL SP_REGISTRAR_EST_PITCHER_PART ("
				+ ":idPartido,"
				+ ":idJugador,"
				+ ":idEquipo,"
				+ ":idTemporada,"
				+ ":partidoIniciado,"
				+ ":partidoSalvado,"
				+ ":partidoTerminado,"
				+ ":partidoGanado,"
				+ ":partidoPerdido,"
				+ ":esOportunidadSalvado,"
				+ ":esShoutout,"
				+ ":inningsPitcheadas,"
				+ ":basesPorbola,"
				+ ":basesPorGolpe,"
				+ ":hitsPermitidos,"
				+ ":carreras,"
				+ ":carrerasPermitidas,"
				+ ":homeruns,"
				+ ":basesPorBolaInt,"
				+ ":wildpitchs,"
				+ ":balks,"
				+ ":strikeouts,"
				+ ":flyouts,"
				+ ":groundOuts)");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idJugador", idJugador);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("partidoIniciado", estVo.getPartidoIniciado()!=null? estVo.getPartidoIniciado() : 0);
		q.setParameter("partidoSalvado", estVo.getPartidoSalvado()!=null? estVo.getPartidoSalvado() : 0);
		q.setParameter("partidoTerminado", estVo.getPartidoTerminado()!=null? estVo.getPartidoTerminado() : 0);
		q.setParameter("partidoGanado", estVo.getPartidoGanado()!=null? estVo.getPartidoGanado() : 0);
		q.setParameter("partidoPerdido", estVo.getPartidoPerdido()!=null? estVo.getPartidoPerdido() : 0);
		q.setParameter("esOportunidadSalvado", estVo.getEsOportunidadSalvado()!=null? estVo.getEsOportunidadSalvado() : 0);
		q.setParameter("esShoutout", estVo.getEsShutout()!=null? estVo.getEsShutout() : 0);
		q.setParameter("inningsPitcheadas", estVo.getInningsPitcheadas());
		q.setParameter("basesPorbola", estVo.getBasesPorbola());
		q.setParameter("basesPorGolpe", estVo.getBasesPorGolpe());
		q.setParameter("hitsPermitidos", estVo.getHitsPermitidos());
		q.setParameter("carreras", estVo.getCarreras());
		q.setParameter("carrerasPermitidas", estVo.getCarrerasPermitidas());
		q.setParameter("homeruns", estVo.getHomeruns());
		q.setParameter("basesPorBolaInt", estVo.getBasesPorBolaInt());
		q.setParameter("wildpitchs", estVo.getWildpitchs());
		q.setParameter("balks", estVo.getBalks());
		q.setParameter("strikeouts", estVo.getStrikeouts());
		q.setParameter("flyouts", estVo.getFlyouts());
		q.setParameter("groundOuts", estVo.getGroundOuts());
		q.executeUpdate();
	}
	
	/**Metodo DAO para llamada a sp para registrar estadisticas defensivas
	 * @param idPartido del partido
	 * @param idJugador del jugador del partido
	 * @param idEquipo del equipo del partido
	 * @param idTemporada del partido
	 * @param estVo con estadisticas
	 */
	public void registrarEstadisticasDefensivas(Long idPartido, Long idJugador, Long idEquipo, Long idTemporada, EstadisticasDefensivasVO estVo) {
		Query q = session.createSQLQuery("CALL SP_REGISTRAR_EST_DEFENSIVAS_PART ("
				+ ":idPartido,"
				+ ":idJugador,"
				+ ":idEquipo,"
				+ ":idTemporada,"
				+ ":asistencias,"
				+ ":atrapadasEnRobo,"
				+ ":robos,"
				+ ":dobleplays,"
				+ ":errores,"
				+ ":inningsJugadas,"
				+ ":outs,"
				+ ":asistenciaOutField,"
				+ ":passedballs,"
				+ ":putouts,"
				+ ":triplePlays)");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idJugador", idJugador);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("asistencias", estVo.getAsistencias());
		q.setParameter("atrapadasEnRobo", estVo.getAtrapadasEnRobo());
		q.setParameter("robos", estVo.getRobos());
		q.setParameter("dobleplays", estVo.getDobleplays());
		q.setParameter("errores", estVo.getErrores());
		q.setParameter("inningsJugadas", estVo.getInningsJugadas());
		q.setParameter("outs", estVo.getOuts());
		q.setParameter("asistenciaOutField", estVo.getAsistenciaOutField());
		q.setParameter("passedballs", estVo.getPassedballs());
		q.setParameter("putouts", estVo.getPutouts());
		q.setParameter("triplePlays", estVo.getTriplePlays());
		q.executeUpdate();
	}
}
