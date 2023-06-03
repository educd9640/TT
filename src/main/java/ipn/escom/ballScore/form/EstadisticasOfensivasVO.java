package ipn.escom.ballScore.form;

import java.io.Serializable;

import ipn.escom.ballScore.entity.JugadorPartido;

/**Clase VO para estadisticas ofensivas
 * @author Jose Mauricio
 *
 */
public class EstadisticasOfensivasVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Long alBat=0L;
	private Long avg=0L;
	private Long caughtStealing=0L;
	private Long dobles=0L;
	private Long extraBaseHits=0L;
	private Long gamesPlayed=0L;
	private Long grandslam=0L;
	private Long groundIntoDoubleplays=0L;
	private Long groundoutToAiroutRatio=0L;
	private Long hitsByPitch=0L;
	private Long hits=0L;
	private Long homeruns=0L;
	private Long intentionalBB=0L;
	private Long leftOnBase=0L;
	private Long onBasePercentage=0L;
	private Long onBasePlusSlugging=0L;
	private Long plateAppearance=0L;
	private Long reachedOnError=0L;
	private Long carreras=0L;
	private Long carrerasBateadas=0L;
	private Long hitsSacrificio=0L;
	private Long elevadosSacrificio=0L;
	private Long sencillos=0L;
	private Long slugger=0L;
	private Long basesRobadas=0L;
	private Long porcentajeBasesRobadas=0L;
	private Long totalBases=0L;
	private Long triples=0L;
	private Long basesPorBola=0L;
	private Long walkOff=0L;
	private Long strikeouts=0L;
	private Long groundOuts=0L;
	private Long flyOuts=0L;
	
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
	public Long getAlBat() {
		return alBat;
	}

	/**
	 * @param alBat El campo alBat a settear
	 */
	public void setAlBat(Long alBat) {
		this.alBat = alBat;
	}

	/**
	 * @return El campo avg
	 */
	public Long getAvg() {
		return avg;
	}

	/**
	 * @param avg El campo avg a settear
	 */
	public void setAvg(Long avg) {
		this.avg = avg;
	}

	/**
	 * @return El campo caughtStealing
	 */
	public Long getCaughtStealing() {
		return caughtStealing;
	}

	/**
	 * @param caughtStealing El campo caughtStealing a settear
	 */
	public void setCaughtStealing(Long caughtStealing) {
		this.caughtStealing = caughtStealing;
	}

	/**
	 * @return El campo dobles
	 */
	public Long getDobles() {
		return dobles;
	}

	/**
	 * @param dobles El campo dobles a settear
	 */
	public void setDobles(Long dobles) {
		this.dobles = dobles;
	}

	/**
	 * @return El campo extraBaseHits
	 */
	public Long getExtraBaseHits() {
		return extraBaseHits;
	}

	/**
	 * @param extraBaseHits El campo extraBaseHits a settear
	 */
	public void setExtraBaseHits(Long extraBaseHits) {
		this.extraBaseHits = extraBaseHits;
	}

	/**
	 * @return El campo gamesPlayed
	 */
	public Long getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @param gamesPlayed El campo gamesPlayed a settear
	 */
	public void setGamesPlayed(Long gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * @return El campo grandslam
	 */
	public Long getGrandslam() {
		return grandslam;
	}

	/**
	 * @param grandslam El campo grandslam a settear
	 */
	public void setGrandslam(Long grandslam) {
		this.grandslam = grandslam;
	}

	/**
	 * @return El campo groundIntoDoubleplays
	 */
	public Long getGroundIntoDoubleplays() {
		return groundIntoDoubleplays;
	}

	/**
	 * @param groundIntoDoubleplays El campo groundIntoDoubleplays a settear
	 */
	public void setGroundIntoDoubleplays(Long groundIntoDoubleplays) {
		this.groundIntoDoubleplays = groundIntoDoubleplays;
	}

	/**
	 * @return El campo groundoutToAiroutRatio
	 */
	public Long getGroundoutToAiroutRatio() {
		return groundoutToAiroutRatio;
	}

	/**
	 * @param groundoutToAiroutRatio El campo groundoutToAiroutRatio a settear
	 */
	public void setGroundoutToAiroutRatio(Long groundoutToAiroutRatio) {
		this.groundoutToAiroutRatio = groundoutToAiroutRatio;
	}

	/**
	 * @return El campo hitsByPitch
	 */
	public Long getHitsByPitch() {
		return hitsByPitch;
	}

	/**
	 * @param hitsByPitch El campo hitsByPitch a settear
	 */
	public void setHitsByPitch(Long hitsByPitch) {
		this.hitsByPitch = hitsByPitch;
	}

	/**
	 * @return El campo hits
	 */
	public Long getHits() {
		return hits;
	}

	/**
	 * @param hits El campo hits a settear
	 */
	public void setHits(Long hits) {
		this.hits = hits;
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
	 * @return El campo intentionalBB
	 */
	public Long getIntentionalBB() {
		return intentionalBB;
	}

	/**
	 * @param intentionalBB El campo intentionalBB a settear
	 */
	public void setIntentionalBB(Long intentionalBB) {
		this.intentionalBB = intentionalBB;
	}

	/**
	 * @return El campo leftOnBase
	 */
	public Long getLeftOnBase() {
		return leftOnBase;
	}

	/**
	 * @param leftOnBase El campo leftOnBase a settear
	 */
	public void setLeftOnBase(Long leftOnBase) {
		this.leftOnBase = leftOnBase;
	}

	/**
	 * @return El campo onBasePercentage
	 */
	public Long getOnBasePercentage() {
		return onBasePercentage;
	}

	/**
	 * @param onBasePercentage El campo onBasePercentage a settear
	 */
	public void setOnBasePercentage(Long onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}

	/**
	 * @return El campo onBasePlusSlugging
	 */
	public Long getOnBasePlusSlugging() {
		return onBasePlusSlugging;
	}

	/**
	 * @param onBasePlusSlugging El campo onBasePlusSlugging a settear
	 */
	public void setOnBasePlusSlugging(Long onBasePlusSlugging) {
		this.onBasePlusSlugging = onBasePlusSlugging;
	}

	/**
	 * @return El campo plateAppearance
	 */
	public Long getPlateAppearance() {
		return plateAppearance;
	}

	/**
	 * @param plateAppearance El campo plateAppearance a settear
	 */
	public void setPlateAppearance(Long plateAppearance) {
		this.plateAppearance = plateAppearance;
	}

	/**
	 * @return El campo reachedOnError
	 */
	public Long getReachedOnError() {
		return reachedOnError;
	}

	/**
	 * @param reachedOnError El campo reachedOnError a settear
	 */
	public void setReachedOnError(Long reachedOnError) {
		this.reachedOnError = reachedOnError;
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
	 * @return El campo carrerasBateadas
	 */
	public Long getCarrerasBateadas() {
		return carrerasBateadas;
	}

	/**
	 * @param carrerasBateadas El campo carrerasBateadas a settear
	 */
	public void setCarrerasBateadas(Long carrerasBateadas) {
		this.carrerasBateadas = carrerasBateadas;
	}

	/**
	 * @return El campo hitsSacrificio
	 */
	public Long getHitsSacrificio() {
		return hitsSacrificio;
	}

	/**
	 * @param hitsSacrificio El campo hitsSacrificio a settear
	 */
	public void setHitsSacrificio(Long hitsSacrificio) {
		this.hitsSacrificio = hitsSacrificio;
	}

	/**
	 * @return El campo elevadosSacrificio
	 */
	public Long getElevadosSacrificio() {
		return elevadosSacrificio;
	}

	/**
	 * @param elevadosSacrificio El campo elevadosSacrificio a settear
	 */
	public void setElevadosSacrificio(Long elevadosSacrificio) {
		this.elevadosSacrificio = elevadosSacrificio;
	}

	/**
	 * @return El campo sencillos
	 */
	public Long getSencillos() {
		return sencillos;
	}

	/**
	 * @param sencillos El campo sencillos a settear
	 */
	public void setSencillos(Long sencillos) {
		this.sencillos = sencillos;
	}

	/**
	 * @return El campo slugger
	 */
	public Long getSlugger() {
		return slugger;
	}

	/**
	 * @param slugger El campo slugger a settear
	 */
	public void setSlugger(Long slugger) {
		this.slugger = slugger;
	}

	/**
	 * @return El campo basesRobadas
	 */
	public Long getBasesRobadas() {
		return basesRobadas;
	}

	/**
	 * @param basesRobadas El campo basesRobadas a settear
	 */
	public void setBasesRobadas(Long basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	/**
	 * @return El campo porcentajeBasesRobadas
	 */
	public Long getPorcentajeBasesRobadas() {
		return porcentajeBasesRobadas;
	}

	/**
	 * @param porcentajeBasesRobadas El campo porcentajeBasesRobadas a settear
	 */
	public void setPorcentajeBasesRobadas(Long porcentajeBasesRobadas) {
		this.porcentajeBasesRobadas = porcentajeBasesRobadas;
	}

	/**
	 * @return El campo totalBases
	 */
	public Long getTotalBases() {
		return totalBases;
	}

	/**
	 * @param totalBases El campo totalBases a settear
	 */
	public void setTotalBases(Long totalBases) {
		this.totalBases = totalBases;
	}

	/**
	 * @return El campo triples
	 */
	public Long getTriples() {
		return triples;
	}

	/**
	 * @param triples El campo triples a settear
	 */
	public void setTriples(Long triples) {
		this.triples = triples;
	}

	/**
	 * @return El campo basesPorBola
	 */
	public Long getBasesPorBola() {
		return basesPorBola;
	}

	/**
	 * @param basesPorBola El campo basesPorBola a settear
	 */
	public void setBasesPorBola(Long basesPorBola) {
		this.basesPorBola = basesPorBola;
	}

	/**
	 * @return El campo walkOff
	 */
	public Long getWalkOff() {
		return walkOff;
	}

	/**
	 * @param walkOff El campo walkOff a settear
	 */
	public void setWalkOff(Long walkOff) {
		this.walkOff = walkOff;
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

	/**
	 * @return El campo flyOuts
	 */
	public Long getFlyOuts() {
		return flyOuts;
	}

	/**
	 * @param flyOuts El campo flyOuts a settear
	 */
	public void setFlyOuts(Long flyOuts) {
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
