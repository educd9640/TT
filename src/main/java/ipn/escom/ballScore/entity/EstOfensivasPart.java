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

	public Double getAlBat() {
		return alBat;
	}

	public void setAlBat(Double alBat) {
		this.alBat = alBat;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getCaughtStealing() {
		return caughtStealing;
	}

	public void setCaughtStealing(Double caughtStealing) {
		this.caughtStealing = caughtStealing;
	}

	public Double getDobles() {
		return dobles;
	}

	public void setDobles(Double dobles) {
		this.dobles = dobles;
	}

	public Double getExtraBaseHits() {
		return extraBaseHits;
	}

	public void setExtraBaseHits(Double extraBaseHits) {
		this.extraBaseHits = extraBaseHits;
	}

	public Double getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Double gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Double getGrandslam() {
		return grandslam;
	}

	public void setGrandslam(Double grandslam) {
		this.grandslam = grandslam;
	}

	public Double getGroundIntoDoubleplays() {
		return groundIntoDoubleplays;
	}

	public void setGroundIntoDoubleplays(Double groundIntoDoubleplays) {
		this.groundIntoDoubleplays = groundIntoDoubleplays;
	}

	public Double getGroundoutToAiroutRatio() {
		return groundoutToAiroutRatio;
	}

	public void setGroundoutToAiroutRatio(Double groundoutToAiroutRatio) {
		this.groundoutToAiroutRatio = groundoutToAiroutRatio;
	}

	public Double getHitsByPitch() {
		return hitsByPitch;
	}

	public void setHitsByPitch(Double hitsByPitch) {
		this.hitsByPitch = hitsByPitch;
	}

	public Double getHits() {
		return hits;
	}

	public void setHits(Double hits) {
		this.hits = hits;
	}

	public Double getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(Double homeruns) {
		this.homeruns = homeruns;
	}

	public Double getIntentionalBB() {
		return intentionalBB;
	}

	public void setIntentionalBB(Double intentionalBB) {
		this.intentionalBB = intentionalBB;
	}

	public Double getLeftOnBase() {
		return leftOnBase;
	}

	public void setLeftOnBase(Double leftOnBase) {
		this.leftOnBase = leftOnBase;
	}

	public Double getOnBasePercentage() {
		return onBasePercentage;
	}

	public void setOnBasePercentage(Double onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}

	public Double getOnBasePlusSlugging() {
		return onBasePlusSlugging;
	}

	public void setOnBasePlusSlugging(Double onBasePlusSlugging) {
		this.onBasePlusSlugging = onBasePlusSlugging;
	}

	public Double getPlateAppearance() {
		return plateAppearance;
	}

	public void setPlateAppearance(Double plateAppearance) {
		this.plateAppearance = plateAppearance;
	}

	public Double getReachedOnError() {
		return reachedOnError;
	}

	public void setReachedOnError(Double reachedOnError) {
		this.reachedOnError = reachedOnError;
	}

	public Double getCarreras() {
		return carreras;
	}

	public void setCarreras(Double carreras) {
		this.carreras = carreras;
	}

	public Double getCarrerasBateadas() {
		return carrerasBateadas;
	}

	public void setCarrerasBateadas(Double carrerasBateadas) {
		this.carrerasBateadas = carrerasBateadas;
	}

	public Double getHitsSacrificio() {
		return hitsSacrificio;
	}

	public void setHitsSacrificio(Double hitsSacrificio) {
		this.hitsSacrificio = hitsSacrificio;
	}

	public Double getElevadosSacrificio() {
		return elevadosSacrificio;
	}

	public void setElevadosSacrificio(Double elevadosSacrificio) {
		this.elevadosSacrificio = elevadosSacrificio;
	}

	public Double getSencillos() {
		return sencillos;
	}

	public void setSencillos(Double sencillos) {
		this.sencillos = sencillos;
	}

	public Double getSlugger() {
		return slugger;
	}

	public void setSlugger(Double slugger) {
		this.slugger = slugger;
	}

	public Double getBasesRobadas() {
		return basesRobadas;
	}

	public void setBasesRobadas(Double basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	public Double getPorcentajeBasesRobadas() {
		return porcentajeBasesRobadas;
	}

	public void setPorcentajeBasesRobadas(Double porcentajeBasesRobadas) {
		this.porcentajeBasesRobadas = porcentajeBasesRobadas;
	}

	public Double getTotalBases() {
		return totalBases;
	}

	public void setTotalBases(Double totalBases) {
		this.totalBases = totalBases;
	}

	public Double getTriples() {
		return triples;
	}

	public void setTriples(Double triples) {
		this.triples = triples;
	}

	public Double getBasesPorBola() {
		return basesPorBola;
	}

	public void setBasesPorBola(Double basesPorBola) {
		this.basesPorBola = basesPorBola;
	}

	public Double getWalkOff() {
		return walkOff;
	}

	public void setWalkOff(Double walkOff) {
		this.walkOff = walkOff;
	}

	public Double getStrikeouts() {
		return strikeouts;
	}

	public void setStrikeouts(Double strikeouts) {
		this.strikeouts = strikeouts;
	}

	public Double getGroundOuts() {
		return groundOuts;
	}

	public void setGroundOuts(Double groundOuts) {
		this.groundOuts = groundOuts;
	}

	public Double getFlyOuts() {
		return flyOuts;
	}

	public void setFlyOuts(Double flyOuts) {
		this.flyOuts = flyOuts;
	}

	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}

	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
	
}
