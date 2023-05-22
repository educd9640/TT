package ipn.escom.ballScore.entity;

import java.io.Serializable;

/**Clase de entidad para estadisticas de pitcher
 * @author Jose Mauricio
 *
 */
public class EstPitcherPart implements Serializable{
	
	private static final long serialVersionUID = 6549468971604292788L;
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
	
	public Long getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	public Long getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public Long getIdTemporada() {
		return idTemporada;
	}
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	public Double getPartidoIniciado() {
		return partidoIniciado;
	}
	public void setPartidoIniciado(Double partidoIniciado) {
		this.partidoIniciado = partidoIniciado;
	}
	public Double getPartidoSalvado() {
		return partidoSalvado;
	}
	public void setPartidoSalvado(Double partidoSalvado) {
		this.partidoSalvado = partidoSalvado;
	}
	public Double getPartidoTerminado() {
		return partidoTerminado;
	}
	public void setPartidoTerminado(Double partidoTerminado) {
		this.partidoTerminado = partidoTerminado;
	}
	public Double getPartidoGanado() {
		return partidoGanado;
	}
	public void setPartidoGanado(Double partidoGanado) {
		this.partidoGanado = partidoGanado;
	}
	public Double getPartidoPerdido() {
		return partidoPerdido;
	}
	public void setPartidoPerdido(Double partidoPerdido) {
		this.partidoPerdido = partidoPerdido;
	}
	public Double getEsOportunidadSalvado() {
		return esOportunidadSalvado;
	}
	public void setEsOportunidadSalvado(Double esOportunidadSalvado) {
		this.esOportunidadSalvado = esOportunidadSalvado;
	}
	public Double getEsShutout() {
		return esShutout;
	}
	public void setEsShutout(Double esShutout) {
		this.esShutout = esShutout;
	}
	public Double getInningsPitcheadas() {
		return inningsPitcheadas;
	}
	public void setInningsPitcheadas(Double inningsPitcheadas) {
		this.inningsPitcheadas = inningsPitcheadas;
	}
	public Double getBasesPorbola() {
		return basesPorbola;
	}
	public void setBasesPorbola(Double basesPorbola) {
		this.basesPorbola = basesPorbola;
	}
	public Double getBasesPorBolaInt() {
		return basesPorBolaInt;
	}
	public void setBasesPorBolaInt(Double basesPorBolaInt) {
		this.basesPorBolaInt = basesPorBolaInt;
	}
	public Double getBasesPorGolpe() {
		return basesPorGolpe;
	}
	public void setBasesPorGolpe(Double basesPorGolpe) {
		this.basesPorGolpe = basesPorGolpe;
	}
	public Double getBalks() {
		return balks;
	}
	public void setBalks(Double balks) {
		this.balks = balks;
	}
	public Double getWildpitchs() {
		return wildpitchs;
	}
	public void setWildpitchs(Double wildpitchs) {
		this.wildpitchs = wildpitchs;
	}
	public Double getHitsPermitidos() {
		return hitsPermitidos;
	}
	public void setHitsPermitidos(Double hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}
	public Double getCarreras() {
		return carreras;
	}
	public void setCarreras(Double carreras) {
		this.carreras = carreras;
	}
	public Double getCarrerasPermitidas() {
		return carrerasPermitidas;
	}
	public void setCarrerasPermitidas(Double carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}
	public Double getHomeruns() {
		return homeruns;
	}
	public void setHomeruns(Double homeruns) {
		this.homeruns = homeruns;
	}
	public Double getStrikeouts() {
		return strikeouts;
	}
	public void setStrikeouts(Double strikeouts) {
		this.strikeouts = strikeouts;
	}
	public Double getFlyouts() {
		return flyouts;
	}
	public void setFlyouts(Double flyouts) {
		this.flyouts = flyouts;
	}
	public Double getGroundOuts() {
		return groundOuts;
	}
	public void setGroundOuts(Double groundOuts) {
		this.groundOuts = groundOuts;
	}
	public Double getKnine() {
		return knine;
	}
	public void setKnine(Double knine) {
		this.knine = knine;
	}
	public Double getBbnine() {
		return bbnine;
	}
	public void setBbnine(Double bbnine) {
		this.bbnine = bbnine;
	}
	public Double getKbb() {
		return kbb;
	}
	public void setKbb(Double kbb) {
		this.kbb = kbb;
	}
	public Double getHrnine() {
		return hrnine;
	}
	public void setHrnine(Double hrnine) {
		this.hrnine = hrnine;
	}
	public Double getKperc() {
		return kperc;
	}
	public void setKperc(Double kperc) {
		this.kperc = kperc;
	}
	public Double getBbperc() {
		return bbperc;
	}
	public void setBbperc(Double bbperc) {
		this.bbperc = bbperc;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}
	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
	
}
