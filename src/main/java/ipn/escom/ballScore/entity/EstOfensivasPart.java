package ipn.escom.ballScore.entity;

import java.io.Serializable;

/**Clase de entidad para estadisticas ofensivas
 * @author Jose Mauricio
 *
 */
public class EstOfensivasPart implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Double alBat;
	private Double avg;
	private Double caughtStealing;
	private Double dobles;
	private Double extraBaseHits;
	private Double gamesPlayed;
	private Double grandslam;
	private Double groundIntoDoubleplays;
	private Double groundoutToAiroutRatio;
	private Double hitsByPitch;
	private Double hits;
	private Double homeruns;
	private Double intentionalBB;
	private Double leftOnBase;
	private Double onBasePercentage;
	private Double onBasePlusSlugging;
	private Double plateAppearance;
	private Double reachedOnError;
	private Double carreras;
	private Double carrerasBateadas;
	private Double hitsSacrificio;
	private Double elevadosSacrificio;
	private Double sencillos;
	private Double slugger;
	private Double basesRobadas;
	private Double porcentajeBasesRobadas;
	private Double totalBases;
	private Double triples;
	private Double basesPorBola;
	private Double walkOff;
	private Double strikeouts;
	private Double groundOuts;
	private Double flyOuts;
	
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
	 * @return El campo alBat
	 */
	public Double getAlBat() {
		return alBat;
	}

	/**
	 * @param alBat El campo alBat a settear
	 */
	public void setAlBat(Double alBat) {
		this.alBat = alBat;
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
	 * @return El campo caughtStealing
	 */
	public Double getCaughtStealing() {
		return caughtStealing;
	}

	/**
	 * @param caughtStealing El campo caughtStealing a settear
	 */
	public void setCaughtStealing(Double caughtStealing) {
		this.caughtStealing = caughtStealing;
	}

	/**
	 * @return El campo dobles
	 */
	public Double getDobles() {
		return dobles;
	}

	/**
	 * @param dobles El campo dobles a settear
	 */
	public void setDobles(Double dobles) {
		this.dobles = dobles;
	}

	/**
	 * @return El campo extraBaseHits
	 */
	public Double getExtraBaseHits() {
		return extraBaseHits;
	}

	/**
	 * @param extraBaseHits El campo extraBaseHits a settear
	 */
	public void setExtraBaseHits(Double extraBaseHits) {
		this.extraBaseHits = extraBaseHits;
	}

	/**
	 * @return El campo gamesPlayed
	 */
	public Double getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @param gamesPlayed El campo gamesPlayed a settear
	 */
	public void setGamesPlayed(Double gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * @return El campo grandslam
	 */
	public Double getGrandslam() {
		return grandslam;
	}

	/**
	 * @param grandslam El campo grandslam a settear
	 */
	public void setGrandslam(Double grandslam) {
		this.grandslam = grandslam;
	}

	/**
	 * @return El campo groundIntoDoubleplays
	 */
	public Double getGroundIntoDoubleplays() {
		return groundIntoDoubleplays;
	}

	/**
	 * @param groundIntoDoubleplays El campo groundIntoDoubleplays a settear
	 */
	public void setGroundIntoDoubleplays(Double groundIntoDoubleplays) {
		this.groundIntoDoubleplays = groundIntoDoubleplays;
	}

	/**
	 * @return El campo groundoutToAiroutRatio
	 */
	public Double getGroundoutToAiroutRatio() {
		return groundoutToAiroutRatio;
	}

	/**
	 * @param groundoutToAiroutRatio El campo groundoutToAiroutRatio a settear
	 */
	public void setGroundoutToAiroutRatio(Double groundoutToAiroutRatio) {
		this.groundoutToAiroutRatio = groundoutToAiroutRatio;
	}

	/**
	 * @return El campo hitsByPitch
	 */
	public Double getHitsByPitch() {
		return hitsByPitch;
	}

	/**
	 * @param hitsByPitch El campo hitsByPitch a settear
	 */
	public void setHitsByPitch(Double hitsByPitch) {
		this.hitsByPitch = hitsByPitch;
	}

	/**
	 * @return El campo hits
	 */
	public Double getHits() {
		return hits;
	}

	/**
	 * @param hits El campo hits a settear
	 */
	public void setHits(Double hits) {
		this.hits = hits;
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
	 * @return El campo intentionalBB
	 */
	public Double getIntentionalBB() {
		return intentionalBB;
	}

	/**
	 * @param intentionalBB El campo intentionalBB a settear
	 */
	public void setIntentionalBB(Double intentionalBB) {
		this.intentionalBB = intentionalBB;
	}

	/**
	 * @return El campo leftOnBase
	 */
	public Double getLeftOnBase() {
		return leftOnBase;
	}

	/**
	 * @param leftOnBase El campo leftOnBase a settear
	 */
	public void setLeftOnBase(Double leftOnBase) {
		this.leftOnBase = leftOnBase;
	}

	/**
	 * @return El campo onBasePercentage
	 */
	public Double getOnBasePercentage() {
		return onBasePercentage;
	}

	/**
	 * @param onBasePercentage El campo onBasePercentage a settear
	 */
	public void setOnBasePercentage(Double onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}

	/**
	 * @return El campo onBasePlusSlugging
	 */
	public Double getOnBasePlusSlugging() {
		return onBasePlusSlugging;
	}

	/**
	 * @param onBasePlusSlugging El campo onBasePlusSlugging a settear
	 */
	public void setOnBasePlusSlugging(Double onBasePlusSlugging) {
		this.onBasePlusSlugging = onBasePlusSlugging;
	}

	/**
	 * @return El campo plateAppearance
	 */
	public Double getPlateAppearance() {
		return plateAppearance;
	}

	/**
	 * @param plateAppearance El campo plateAppearance a settear
	 */
	public void setPlateAppearance(Double plateAppearance) {
		this.plateAppearance = plateAppearance;
	}

	/**
	 * @return El campo reachedOnError
	 */
	public Double getReachedOnError() {
		return reachedOnError;
	}

	/**
	 * @param reachedOnError El campo reachedOnError a settear
	 */
	public void setReachedOnError(Double reachedOnError) {
		this.reachedOnError = reachedOnError;
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
	 * @return El campo carrerasBateadas
	 */
	public Double getCarrerasBateadas() {
		return carrerasBateadas;
	}

	/**
	 * @param carrerasBateadas El campo carrerasBateadas a settear
	 */
	public void setCarrerasBateadas(Double carrerasBateadas) {
		this.carrerasBateadas = carrerasBateadas;
	}

	/**
	 * @return El campo hitsSacrificio
	 */
	public Double getHitsSacrificio() {
		return hitsSacrificio;
	}

	/**
	 * @param hitsSacrificio El campo hitsSacrificio a settear
	 */
	public void setHitsSacrificio(Double hitsSacrificio) {
		this.hitsSacrificio = hitsSacrificio;
	}

	/**
	 * @return El campo elevadosSacrificio
	 */
	public Double getElevadosSacrificio() {
		return elevadosSacrificio;
	}

	/**
	 * @param elevadosSacrificio El campo elevadosSacrificio a settear
	 */
	public void setElevadosSacrificio(Double elevadosSacrificio) {
		this.elevadosSacrificio = elevadosSacrificio;
	}

	/**
	 * @return El campo sencillos
	 */
	public Double getSencillos() {
		return sencillos;
	}

	/**
	 * @param sencillos El campo sencillos a settear
	 */
	public void setSencillos(Double sencillos) {
		this.sencillos = sencillos;
	}

	/**
	 * @return El campo slugger
	 */
	public Double getSlugger() {
		return slugger;
	}

	/**
	 * @param slugger El campo slugger a settear
	 */
	public void setSlugger(Double slugger) {
		this.slugger = slugger;
	}

	/**
	 * @return El campo basesRobadas
	 */
	public Double getBasesRobadas() {
		return basesRobadas;
	}

	/**
	 * @param basesRobadas El campo basesRobadas a settear
	 */
	public void setBasesRobadas(Double basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	/**
	 * @return El campo porcentajeBasesRobadas
	 */
	public Double getPorcentajeBasesRobadas() {
		return porcentajeBasesRobadas;
	}

	/**
	 * @param porcentajeBasesRobadas El campo porcentajeBasesRobadas a settear
	 */
	public void setPorcentajeBasesRobadas(Double porcentajeBasesRobadas) {
		this.porcentajeBasesRobadas = porcentajeBasesRobadas;
	}

	/**
	 * @return El campo totalBases
	 */
	public Double getTotalBases() {
		return totalBases;
	}

	/**
	 * @param totalBases El campo totalBases a settear
	 */
	public void setTotalBases(Double totalBases) {
		this.totalBases = totalBases;
	}

	/**
	 * @return El campo triples
	 */
	public Double getTriples() {
		return triples;
	}

	/**
	 * @param triples El campo triples a settear
	 */
	public void setTriples(Double triples) {
		this.triples = triples;
	}

	/**
	 * @return El campo basesPorBola
	 */
	public Double getBasesPorBola() {
		return basesPorBola;
	}

	/**
	 * @param basesPorBola El campo basesPorBola a settear
	 */
	public void setBasesPorBola(Double basesPorBola) {
		this.basesPorBola = basesPorBola;
	}

	/**
	 * @return El campo walkOff
	 */
	public Double getWalkOff() {
		return walkOff;
	}

	/**
	 * @param walkOff El campo walkOff a settear
	 */
	public void setWalkOff(Double walkOff) {
		this.walkOff = walkOff;
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
	 * @return El campo flyOuts
	 */
	public Double getFlyOuts() {
		return flyOuts;
	}

	/**
	 * @param flyOuts El campo flyOuts a settear
	 */
	public void setFlyOuts(Double flyOuts) {
		this.flyOuts = flyOuts;
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
