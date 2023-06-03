package ipn.escom.ballScore.entity;

import java.io.Serializable;

/**Clase de entidad para estadisticas de pitcher
 * @author Jose Mauricio
 *
 */
public class EstPitcherPart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Double partidoIniciado;
	private Double partidoSalvado;
	private Double partidoTerminado;
	private Double partidoGanado;
	private Double partidoPerdido;
	private Double esOportunidadSalvado;
	private Double esShutout;
	private Double inningsPitcheadas;
	private Double basesPorbola;
	private Double basesPorBolaInt;
	private Double basesPorGolpe;
	private Double balks;
	private Double wildpitchs;
	private Double hitsPermitidos;
	private Double carreras;
	private Double carrerasPermitidas;
	private Double homeruns;
	private Double strikeouts;
	private Double flyouts;
	private Double groundOuts;
	private Double knine;
	private Double bbnine;
	private Double kbb;
	private Double hrnine;
	private Double kperc;
	private Double bbperc;
	private Double avg;
	private JugadorPartido jugadorPartido;
	/**
	 * @return El campo idPartido
	 */
	public Long getIdPartido() {
		return idPartido;
	}
	/**
	 * @param idPartido El campo idPartido a settear
	 */
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	/**
	 * @return El campo idJugador
	 */
	public Long getIdJugador() {
		return idJugador;
	}
	/**
	 * @param idJugador El campo idJugador a settear
	 */
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	/**
	 * @return El campo idEquipo
	 */
	public Long getIdEquipo() {
		return idEquipo;
	}
	/**
	 * @param idEquipo El campo idEquipo a settear
	 */
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	/**
	 * @return El campo idTemporada
	 */
	public Long getIdTemporada() {
		return idTemporada;
	}
	/**
	 * @param idTemporada El campo idTemporada a settear
	 */
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	/**
	 * @return El campo partidoIniciado
	 */
	public Double getPartidoIniciado() {
		return partidoIniciado;
	}
	/**
	 * @param partidoIniciado El campo partidoIniciado a settear
	 */
	public void setPartidoIniciado(Double partidoIniciado) {
		this.partidoIniciado = partidoIniciado;
	}
	/**
	 * @return El campo partidoSalvado
	 */
	public Double getPartidoSalvado() {
		return partidoSalvado;
	}
	/**
	 * @param partidoSalvado El campo partidoSalvado a settear
	 */
	public void setPartidoSalvado(Double partidoSalvado) {
		this.partidoSalvado = partidoSalvado;
	}
	/**
	 * @return El campo partidoTerminado
	 */
	public Double getPartidoTerminado() {
		return partidoTerminado;
	}
	/**
	 * @param partidoTerminado El campo partidoTerminado a settear
	 */
	public void setPartidoTerminado(Double partidoTerminado) {
		this.partidoTerminado = partidoTerminado;
	}
	/**
	 * @return El campo partidoGanado
	 */
	public Double getPartidoGanado() {
		return partidoGanado;
	}
	/**
	 * @param partidoGanado El campo partidoGanado a settear
	 */
	public void setPartidoGanado(Double partidoGanado) {
		this.partidoGanado = partidoGanado;
	}
	/**
	 * @return El campo partidoPerdido
	 */
	public Double getPartidoPerdido() {
		return partidoPerdido;
	}
	/**
	 * @param partidoPerdido El campo partidoPerdido a settear
	 */
	public void setPartidoPerdido(Double partidoPerdido) {
		this.partidoPerdido = partidoPerdido;
	}
	/**
	 * @return El campo esOportunidadSalvado
	 */
	public Double getEsOportunidadSalvado() {
		return esOportunidadSalvado;
	}
	/**
	 * @param esOportunidadSalvado El campo esOportunidadSalvado a settear
	 */
	public void setEsOportunidadSalvado(Double esOportunidadSalvado) {
		this.esOportunidadSalvado = esOportunidadSalvado;
	}
	/**
	 * @return El campo esShutout
	 */
	public Double getEsShutout() {
		return esShutout;
	}
	/**
	 * @param esShutout El campo esShutout a settear
	 */
	public void setEsShutout(Double esShutout) {
		this.esShutout = esShutout;
	}
	/**
	 * @return El campo inningsPitcheadas
	 */
	public Double getInningsPitcheadas() {
		return inningsPitcheadas;
	}
	/**
	 * @param inningsPitcheadas El campo inningsPitcheadas a settear
	 */
	public void setInningsPitcheadas(Double inningsPitcheadas) {
		this.inningsPitcheadas = inningsPitcheadas;
	}
	/**
	 * @return El campo basesPorbola
	 */
	public Double getBasesPorbola() {
		return basesPorbola;
	}
	/**
	 * @param basesPorbola El campo basesPorbola a settear
	 */
	public void setBasesPorbola(Double basesPorbola) {
		this.basesPorbola = basesPorbola;
	}
	/**
	 * @return El campo basesPorBolaInt
	 */
	public Double getBasesPorBolaInt() {
		return basesPorBolaInt;
	}
	/**
	 * @param basesPorBolaInt El campo basesPorBolaInt a settear
	 */
	public void setBasesPorBolaInt(Double basesPorBolaInt) {
		this.basesPorBolaInt = basesPorBolaInt;
	}
	/**
	 * @return El campo basesPorGolpe
	 */
	public Double getBasesPorGolpe() {
		return basesPorGolpe;
	}
	/**
	 * @param basesPorGolpe El campo basesPorGolpe a settear
	 */
	public void setBasesPorGolpe(Double basesPorGolpe) {
		this.basesPorGolpe = basesPorGolpe;
	}
	/**
	 * @return El campo balks
	 */
	public Double getBalks() {
		return balks;
	}
	/**
	 * @param balks El campo balks a settear
	 */
	public void setBalks(Double balks) {
		this.balks = balks;
	}
	/**
	 * @return El campo wildpitchs
	 */
	public Double getWildpitchs() {
		return wildpitchs;
	}
	/**
	 * @param wildpitchs El campo wildpitchs a settear
	 */
	public void setWildpitchs(Double wildpitchs) {
		this.wildpitchs = wildpitchs;
	}
	/**
	 * @return El campo hitsPermitidos
	 */
	public Double getHitsPermitidos() {
		return hitsPermitidos;
	}
	/**
	 * @param hitsPermitidos El campo hitsPermitidos a settear
	 */
	public void setHitsPermitidos(Double hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}
	/**
	 * @return El campo carreras
	 */
	public Double getCarreras() {
		return carreras;
	}
	/**
	 * @param carreras El campo carreras a settear
	 */
	public void setCarreras(Double carreras) {
		this.carreras = carreras;
	}
	/**
	 * @return El campo carrerasPermitidas
	 */
	public Double getCarrerasPermitidas() {
		return carrerasPermitidas;
	}
	/**
	 * @param carrerasPermitidas El campo carrerasPermitidas a settear
	 */
	public void setCarrerasPermitidas(Double carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}
	/**
	 * @return El campo homeruns
	 */
	public Double getHomeruns() {
		return homeruns;
	}
	/**
	 * @param homeruns El campo homeruns a settear
	 */
	public void setHomeruns(Double homeruns) {
		this.homeruns = homeruns;
	}
	/**
	 * @return El campo strikeouts
	 */
	public Double getStrikeouts() {
		return strikeouts;
	}
	/**
	 * @param strikeouts El campo strikeouts a settear
	 */
	public void setStrikeouts(Double strikeouts) {
		this.strikeouts = strikeouts;
	}
	/**
	 * @return El campo flyouts
	 */
	public Double getFlyouts() {
		return flyouts;
	}
	/**
	 * @param flyouts El campo flyouts a settear
	 */
	public void setFlyouts(Double flyouts) {
		this.flyouts = flyouts;
	}
	/**
	 * @return El campo groundOuts
	 */
	public Double getGroundOuts() {
		return groundOuts;
	}
	/**
	 * @param groundOuts El campo groundOuts a settear
	 */
	public void setGroundOuts(Double groundOuts) {
		this.groundOuts = groundOuts;
	}
	/**
	 * @return El campo knine
	 */
	public Double getKnine() {
		return knine;
	}
	/**
	 * @param knine El campo knine a settear
	 */
	public void setKnine(Double knine) {
		this.knine = knine;
	}
	/**
	 * @return El campo bbnine
	 */
	public Double getBbnine() {
		return bbnine;
	}
	/**
	 * @param bbnine El campo bbnine a settear
	 */
	public void setBbnine(Double bbnine) {
		this.bbnine = bbnine;
	}
	/**
	 * @return El campo kbb
	 */
	public Double getKbb() {
		return kbb;
	}
	/**
	 * @param kbb El campo kbb a settear
	 */
	public void setKbb(Double kbb) {
		this.kbb = kbb;
	}
	/**
	 * @return El campo hrnine
	 */
	public Double getHrnine() {
		return hrnine;
	}
	/**
	 * @param hrnine El campo hrnine a settear
	 */
	public void setHrnine(Double hrnine) {
		this.hrnine = hrnine;
	}
	/**
	 * @return El campo kperc
	 */
	public Double getKperc() {
		return kperc;
	}
	/**
	 * @param kperc El campo kperc a settear
	 */
	public void setKperc(Double kperc) {
		this.kperc = kperc;
	}
	/**
	 * @return El campo bbperc
	 */
	public Double getBbperc() {
		return bbperc;
	}
	/**
	 * @param bbperc El campo bbperc a settear
	 */
	public void setBbperc(Double bbperc) {
		this.bbperc = bbperc;
	}
	/**
	 * @return El campo avg
	 */
	public Double getAvg() {
		return avg;
	}
	/**
	 * @param avg El campo avg a settear
	 */
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	/**
	 * @return El campo jugadorPartido
	 */
	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}
	/**
	 * @param jugadorPartido El campo jugadorPartido a settear
	 */
	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
	
}
