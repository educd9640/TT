package ipn.escom.ballScore.dao;

import org.hibernate.Query;

import ipn.escom.ballScore.entity.EstPitcherPart;
import ipn.escom.ballScore.form.EstadisticasDefensivasVO;
import ipn.escom.ballScore.form.EstadisticasOfensivasVO;
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
		q.setParameter("partidoIniciado", estVo.getPartidoIniciado());
		q.setParameter("partidoSalvado", estVo.getPartidoSalvado());
		q.setParameter("partidoTerminado", estVo.getPartidoTerminado());
		q.setParameter("partidoGanado", estVo.getPartidoGanado());
		q.setParameter("partidoPerdido", estVo.getPartidoPerdido());
		q.setParameter("esOportunidadSalvado", estVo.getEsOportunidadSalvado());
		q.setParameter("esShoutout", estVo.getEsShutout());
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
	
	public void registrarEstadisticasOfensivas(Long idPartido, Long idJugador, Long idEquipo, Long idTemporada, EstadisticasOfensivasVO estVo) {
		Query q = session.createSQLQuery("CALL SP_REGISTRAR_EST_OFENSIVAS_PART ("
				+ ":idPartido,"
				+ ":idJugador,"
				+ ":idEquipo,"
				+ ":idTemporada,"
				+ ":turnosAlBat,"
				+ ":sencillos,"
				+ ":dobles,"
				+ ":triples,"
				+ ":homeruns,"
				+ ":grandslam,"
				+ ":esWalkOff,"
				+ ":carreras,"
				+ ":carrerasBateadas,"
				+ ":basesRobadas,"
				+ ":atrapadoEnRobo,"
				+ ":groundOuts,"
				+ ":flyOuts,"
				+ ":groundDoublePlay,"
				+ ":hitByPitch,"
				+ ":walksIntencionales,"
				+ ":dejadoEnBase,"
				+ ":aparicionesAlPlato,"
				+ ":safeEnError,"
				+ ":toqueSacrificio,"
				+ ":elevadoSacrificio,"
				+ ":basesPorBola,"
				+ ":strikeOuts)");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idJugador", idJugador);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		q.setParameter("turnosAlBat", estVo.getTurnosAlBat());
		q.setParameter("sencillos", estVo.getSencillos());
		q.setParameter("dobles", estVo.getDobles());
		q.setParameter("triples", estVo.getTriples());
		q.setParameter("homeruns", estVo.getHomeruns());
		q.setParameter("grandslam", estVo.getGrandslam());
		q.setParameter("esWalkOff", estVo.getEsWalkOff()!=null ? estVo.getEsWalkOff() : 0);
		q.setParameter("carreras", estVo.getCarreras());
		q.setParameter("carrerasBateadas", estVo.getCarrerasBateadas());
		q.setParameter("basesRobadas", estVo.getBasesRobadas());
		q.setParameter("atrapadoEnRobo", estVo.getAtrapadoEnRobo());
		q.setParameter("groundOuts", estVo.getGroundOuts());
		q.setParameter("flyOuts", estVo.getFlyOuts());
		q.setParameter("groundDoublePlay", estVo.getGroundDoublePlay());
		q.setParameter("hitByPitch", estVo.getHitByPitch());
		q.setParameter("walksIntencionales", estVo.getWalksIntencionales());
		q.setParameter("dejadoEnBase", estVo.getDejadoEnBase());
		q.setParameter("aparicionesAlPlato", estVo.getAparicionesAlPlato());
		q.setParameter("safeEnError", estVo.getSafeEnError());
		q.setParameter("toqueSacrificio", estVo.getToqueSacrificio());
		q.setParameter("elevadoSacrificio", estVo.getElevadoSacrificio());
		q.setParameter("basesPorBola", estVo.getBasesPorBola());
		q.setParameter("strikeOuts", estVo.getStrikeOuts());
		q.executeUpdate();
	}
	
	public EstPitcherPart selectEstPitcherPartById(Long idPartido, Long idJugador, Long idEquipo, Long idTemporada) {
		Query q = session.createQuery("from EstPitcherPart estPitcher where estPitcher.idPartido = :idPartido and estPitcher.idJugador = :idJugador and "
				+ "estPitcher.idEquipo = :idEquipo and estPitcher.idTemporada = :idTemporada");
		q.setParameter("idPartido", idPartido);
		q.setParameter("idJugador", idJugador);
		q.setParameter("idEquipo", idEquipo);
		q.setParameter("idTemporada", idTemporada);
		return (EstPitcherPart) q.uniqueResult();
	}
}
