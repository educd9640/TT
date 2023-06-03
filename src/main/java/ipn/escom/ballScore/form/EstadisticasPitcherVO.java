package ipn.escom.ballScore.form;

import java.io.Serializable;

/**VO para estadisticas de pitcher
 * @author Jose Mauricio
 *
 */
public class EstadisticasPitcherVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long partidoIniciado=0L;
	private Long partidoSalvado=0L;
	private Long partidoTerminado=0L;
	private Long partidoGanado=0L;
	private Long partidoPerdido=0L;
	private Long esOportunidadSalvado=0L;
	private Long esShutout=0L;
	private Long inningsPitcheadas=0L;
	private Long basesPorbola=0L;
	private Long basesPorBolaInt=0L;
	private Long basesPorGolpe=0L;
	private Long balks=0L;
	private Long wildpitchs=0L;
	private Long hitsPermitidos=0L;
	private Long carreras=0L;
	private Long carrerasPermitidas=0L;
	private Long homeruns=0L;
	private Long strikeouts=0L;
	private Long flyouts=0L;
	private Long groundOuts=0L;
	/**
	 * @return El campo partidoIniciado
	 */
	public Long getPartidoIniciado() {
		return partidoIniciado;
	}
	/**
	 * @param partidoIniciado El campo partidoIniciado a settear
	 */
	public void setPartidoIniciado(Long partidoIniciado) {
		this.partidoIniciado = partidoIniciado;
	}
	/**
	 * @return El campo partidoSalvado
	 */
	public Long getPartidoSalvado() {
		return partidoSalvado;
	}
	/**
	 * @param partidoSalvado El campo partidoSalvado a settear
	 */
	public void setPartidoSalvado(Long partidoSalvado) {
		this.partidoSalvado = partidoSalvado;
	}
	/**
	 * @return El campo partidoTerminado
	 */
	public Long getPartidoTerminado() {
		return partidoTerminado;
	}
	/**
	 * @param partidoTerminado El campo partidoTerminado a settear
	 */
	public void setPartidoTerminado(Long partidoTerminado) {
		this.partidoTerminado = partidoTerminado;
	}
	/**
	 * @return El campo partidoGanado
	 */
	public Long getPartidoGanado() {
		return partidoGanado;
	}
	/**
	 * @param partidoGanado El campo partidoGanado a settear
	 */
	public void setPartidoGanado(Long partidoGanado) {
		this.partidoGanado = partidoGanado;
	}
	/**
	 * @return El campo partidoPerdido
	 */
	public Long getPartidoPerdido() {
		return partidoPerdido;
	}
	/**
	 * @param partidoPerdido El campo partidoPerdido a settear
	 */
	public void setPartidoPerdido(Long partidoPerdido) {
		this.partidoPerdido = partidoPerdido;
	}
	/**
	 * @return El campo esOportunidadSalvado
	 */
	public Long getEsOportunidadSalvado() {
		return esOportunidadSalvado;
	}
	/**
	 * @param esOportunidadSalvado El campo esOportunidadSalvado a settear
	 */
	public void setEsOportunidadSalvado(Long esOportunidadSalvado) {
		this.esOportunidadSalvado = esOportunidadSalvado;
	}
	/**
	 * @return El campo esShutout
	 */
	public Long getEsShutout() {
		return esShutout;
	}
	/**
	 * @param esShutout El campo esShutout a settear
	 */
	public void setEsShutout(Long esShutout) {
		this.esShutout = esShutout;
	}
	/**
	 * @return El campo inningsPitcheadas
	 */
	public Long getInningsPitcheadas() {
		return inningsPitcheadas;
	}
	/**
	 * @param inningsPitcheadas El campo inningsPitcheadas a settear
	 */
	public void setInningsPitcheadas(Long inningsPitcheadas) {
		this.inningsPitcheadas = inningsPitcheadas;
	}
	/**
	 * @return El campo basesPorbola
	 */
	public Long getBasesPorbola() {
		return basesPorbola;
	}
	/**
	 * @param basesPorbola El campo basesPorbola a settear
	 */
	public void setBasesPorbola(Long basesPorbola) {
		this.basesPorbola = basesPorbola;
	}
	/**
	 * @return El campo basesPorBolaInt
	 */
	public Long getBasesPorBolaInt() {
		return basesPorBolaInt;
	}
	/**
	 * @param basesPorBolaInt El campo basesPorBolaInt a settear
	 */
	public void setBasesPorBolaInt(Long basesPorBolaInt) {
		this.basesPorBolaInt = basesPorBolaInt;
	}
	/**
	 * @return El campo basesPorGolpe
	 */
	public Long getBasesPorGolpe() {
		return basesPorGolpe;
	}
	/**
	 * @param basesPorGolpe El campo basesPorGolpe a settear
	 */
	public void setBasesPorGolpe(Long basesPorGolpe) {
		this.basesPorGolpe = basesPorGolpe;
	}
	/**
	 * @return El campo balks
	 */
	public Long getBalks() {
		return balks;
	}
	/**
	 * @param balks El campo balks a settear
	 */
	public void setBalks(Long balks) {
		this.balks = balks;
	}
	/**
	 * @return El campo wildpitchs
	 */
	public Long getWildpitchs() {
		return wildpitchs;
	}
	/**
	 * @param wildpitchs El campo wildpitchs a settear
	 */
	public void setWildpitchs(Long wildpitchs) {
		this.wildpitchs = wildpitchs;
	}
	/**
	 * @return El campo hitsPermitidos
	 */
	public Long getHitsPermitidos() {
		return hitsPermitidos;
	}
	/**
	 * @param hitsPermitidos El campo hitsPermitidos a settear
	 */
	public void setHitsPermitidos(Long hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}
	/**
	 * @return El campo carreras
	 */
	public Long getCarreras() {
		return carreras;
	}
	/**
	 * @param carreras El campo carreras a settear
	 */
	public void setCarreras(Long carreras) {
		this.carreras = carreras;
	}
	/**
	 * @return El campo carrerasPermitidas
	 */
	public Long getCarrerasPermitidas() {
		return carrerasPermitidas;
	}
	/**
	 * @param carrerasPermitidas El campo carrerasPermitidas a settear
	 */
	public void setCarrerasPermitidas(Long carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}
	/**
	 * @return El campo homeruns
	 */
	public Long getHomeruns() {
		return homeruns;
	}
	/**
	 * @param homeruns El campo homeruns a settear
	 */
	public void setHomeruns(Long homeruns) {
		this.homeruns = homeruns;
	}
	/**
	 * @return El campo strikeouts
	 */
	public Long getStrikeouts() {
		return strikeouts;
	}
	/**
	 * @param strikeouts El campo strikeouts a settear
	 */
	public void setStrikeouts(Long strikeouts) {
		this.strikeouts = strikeouts;
	}
	/**
	 * @return El campo flyouts
	 */
	public Long getFlyouts() {
		return flyouts;
	}
	/**
	 * @param flyouts El campo flyouts a settear
	 */
	public void setFlyouts(Long flyouts) {
		this.flyouts = flyouts;
	}
	/**
	 * @return El campo groundOuts
	 */
	public Long getGroundOuts() {
		return groundOuts;
	}
	/**
	 * @param groundOuts El campo groundOuts a settear
	 */
	public void setGroundOuts(Long groundOuts) {
		this.groundOuts = groundOuts;
	}
	
}
