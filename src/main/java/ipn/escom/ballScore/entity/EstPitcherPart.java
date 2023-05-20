package ipn.escom.ballScore.entity;

import java.io.Serializable;

public class EstPitcherPart implements Serializable{
	
	private static final long serialVersionUID = 6549468971604292788L;
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Long partidoIniciado;
	private Long partidoSalvado;
	private Long partidoTerminado;
	private Long partidoGanado;
	private Long partidoPerdido;
	private Long esOportunidadSalvado;
	private Long esShutout;
	private Long inningsPitcheadas;
	private Long basesPorbola;
	private Long basesPorBolaInt;
	private Long basesPorGolpe;
	private Long balks;
	private Long wildpitchs;
	private Long hitsPermitidos;
	private Long carreras;
	private Long carrerasPermitidas;
	private Long homeruns;
	private Long strikeouts;
	private Long flyouts;
	private Long groundOuts;
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
	public Long getPartidoIniciado() {
		return partidoIniciado;
	}
	public void setPartidoIniciado(Long partidoIniciado) {
		this.partidoIniciado = partidoIniciado;
	}
	public Long getPartidoSalvado() {
		return partidoSalvado;
	}
	public void setPartidoSalvado(Long partidoSalvado) {
		this.partidoSalvado = partidoSalvado;
	}
	public Long getPartidoTerminado() {
		return partidoTerminado;
	}
	public void setPartidoTerminado(Long partidoTerminado) {
		this.partidoTerminado = partidoTerminado;
	}
	public Long getPartidoGanado() {
		return partidoGanado;
	}
	public void setPartidoGanado(Long partidoGanado) {
		this.partidoGanado = partidoGanado;
	}
	public Long getPartidoPerdido() {
		return partidoPerdido;
	}
	public void setPartidoPerdido(Long partidoPerdido) {
		this.partidoPerdido = partidoPerdido;
	}
	public Long getEsOportunidadSalvado() {
		return esOportunidadSalvado;
	}
	public void setEsOportunidadSalvado(Long esOportunidadSalvado) {
		this.esOportunidadSalvado = esOportunidadSalvado;
	}
	public Long getEsShutout() {
		return esShutout;
	}
	public void setEsShutout(Long esShutout) {
		this.esShutout = esShutout;
	}
	public Long getInningsPitcheadas() {
		return inningsPitcheadas;
	}
	public void setInningsPitcheadas(Long inningsPitcheadas) {
		this.inningsPitcheadas = inningsPitcheadas;
	}
	public Long getBasesPorbola() {
		return basesPorbola;
	}
	public void setBasesPorbola(Long basesPorbola) {
		this.basesPorbola = basesPorbola;
	}
	public Long getBasesPorBolaInt() {
		return basesPorBolaInt;
	}
	public void setBasesPorBolaInt(Long basesPorBolaInt) {
		this.basesPorBolaInt = basesPorBolaInt;
	}
	public Long getBasesPorGolpe() {
		return basesPorGolpe;
	}
	public void setBasesPorGolpe(Long basesPorGolpe) {
		this.basesPorGolpe = basesPorGolpe;
	}
	public Long getBalks() {
		return balks;
	}
	public void setBalks(Long balks) {
		this.balks = balks;
	}
	public Long getWildpitchs() {
		return wildpitchs;
	}
	public void setWildpitchs(Long wildpitchs) {
		this.wildpitchs = wildpitchs;
	}
	public Long getHitsPermitidos() {
		return hitsPermitidos;
	}
	public void setHitsPermitidos(Long hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}
	public Long getCarreras() {
		return carreras;
	}
	public void setCarreras(Long carreras) {
		this.carreras = carreras;
	}
	public Long getCarrerasPermitidas() {
		return carrerasPermitidas;
	}
	public void setCarrerasPermitidas(Long carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}
	public Long getHomeruns() {
		return homeruns;
	}
	public void setHomeruns(Long homeruns) {
		this.homeruns = homeruns;
	}
	public Long getStrikeouts() {
		return strikeouts;
	}
	public void setStrikeouts(Long strikeouts) {
		this.strikeouts = strikeouts;
	}
	public Long getFlyouts() {
		return flyouts;
	}
	public void setFlyouts(Long flyouts) {
		this.flyouts = flyouts;
	}
	public Long getGroundOuts() {
		return groundOuts;
	}
	public void setGroundOuts(Long groundOuts) {
		this.groundOuts = groundOuts;
	}
	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}
	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
	
	
}
