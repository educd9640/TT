package ipn.escom.ballScore.form;

import ipn.escom.ballScore.entity.JugadorPartido;

/**Clase VO para estadisticas ofensivas
 * @author Jose Mauricio
 *
 */
public class EstadisticasOfensivasVO {

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

	public Long getAlBat() {
		return alBat;
	}

	public void setAlBat(Long alBat) {
		this.alBat = alBat;
	}

	public Long getAvg() {
		return avg;
	}

	public void setAvg(Long avg) {
		this.avg = avg;
	}

	public Long getCaughtStealing() {
		return caughtStealing;
	}

	public void setCaughtStealing(Long caughtStealing) {
		this.caughtStealing = caughtStealing;
	}

	public Long getDobles() {
		return dobles;
	}

	public void setDobles(Long dobles) {
		this.dobles = dobles;
	}

	public Long getExtraBaseHits() {
		return extraBaseHits;
	}

	public void setExtraBaseHits(Long extraBaseHits) {
		this.extraBaseHits = extraBaseHits;
	}

	public Long getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Long gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Long getGrandslam() {
		return grandslam;
	}

	public void setGrandslam(Long grandslam) {
		this.grandslam = grandslam;
	}

	public Long getGroundIntoDoubleplays() {
		return groundIntoDoubleplays;
	}

	public void setGroundIntoDoubleplays(Long groundIntoDoubleplays) {
		this.groundIntoDoubleplays = groundIntoDoubleplays;
	}

	public Long getGroundoutToAiroutRatio() {
		return groundoutToAiroutRatio;
	}

	public void setGroundoutToAiroutRatio(Long groundoutToAiroutRatio) {
		this.groundoutToAiroutRatio = groundoutToAiroutRatio;
	}

	public Long getHitsByPitch() {
		return hitsByPitch;
	}

	public void setHitsByPitch(Long hitsByPitch) {
		this.hitsByPitch = hitsByPitch;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Long getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(Long homeruns) {
		this.homeruns = homeruns;
	}

	public Long getIntentionalBB() {
		return intentionalBB;
	}

	public void setIntentionalBB(Long intentionalBB) {
		this.intentionalBB = intentionalBB;
	}

	public Long getLeftOnBase() {
		return leftOnBase;
	}

	public void setLeftOnBase(Long leftOnBase) {
		this.leftOnBase = leftOnBase;
	}

	public Long getOnBasePercentage() {
		return onBasePercentage;
	}

	public void setOnBasePercentage(Long onBasePercentage) {
		this.onBasePercentage = onBasePercentage;
	}

	public Long getOnBasePlusSlugging() {
		return onBasePlusSlugging;
	}

	public void setOnBasePlusSlugging(Long onBasePlusSlugging) {
		this.onBasePlusSlugging = onBasePlusSlugging;
	}

	public Long getPlateAppearance() {
		return plateAppearance;
	}

	public void setPlateAppearance(Long plateAppearance) {
		this.plateAppearance = plateAppearance;
	}

	public Long getReachedOnError() {
		return reachedOnError;
	}

	public void setReachedOnError(Long reachedOnError) {
		this.reachedOnError = reachedOnError;
	}

	public Long getCarreras() {
		return carreras;
	}

	public void setCarreras(Long carreras) {
		this.carreras = carreras;
	}

	public Long getCarrerasBateadas() {
		return carrerasBateadas;
	}

	public void setCarrerasBateadas(Long carrerasBateadas) {
		this.carrerasBateadas = carrerasBateadas;
	}

	public Long getHitsSacrificio() {
		return hitsSacrificio;
	}

	public void setHitsSacrificio(Long hitsSacrificio) {
		this.hitsSacrificio = hitsSacrificio;
	}

	public Long getElevadosSacrificio() {
		return elevadosSacrificio;
	}

	public void setElevadosSacrificio(Long elevadosSacrificio) {
		this.elevadosSacrificio = elevadosSacrificio;
	}

	public Long getSencillos() {
		return sencillos;
	}

	public void setSencillos(Long sencillos) {
		this.sencillos = sencillos;
	}

	public Long getSlugger() {
		return slugger;
	}

	public void setSlugger(Long slugger) {
		this.slugger = slugger;
	}

	public Long getBasesRobadas() {
		return basesRobadas;
	}

	public void setBasesRobadas(Long basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	public Long getPorcentajeBasesRobadas() {
		return porcentajeBasesRobadas;
	}

	public void setPorcentajeBasesRobadas(Long porcentajeBasesRobadas) {
		this.porcentajeBasesRobadas = porcentajeBasesRobadas;
	}

	public Long getTotalBases() {
		return totalBases;
	}

	public void setTotalBases(Long totalBases) {
		this.totalBases = totalBases;
	}

	public Long getTriples() {
		return triples;
	}

	public void setTriples(Long triples) {
		this.triples = triples;
	}

	public Long getBasesPorBola() {
		return basesPorBola;
	}

	public void setBasesPorBola(Long basesPorBola) {
		this.basesPorBola = basesPorBola;
	}

	public Long getWalkOff() {
		return walkOff;
	}

	public void setWalkOff(Long walkOff) {
		this.walkOff = walkOff;
	}

	public Long getStrikeouts() {
		return strikeouts;
	}

	public void setStrikeouts(Long strikeouts) {
		this.strikeouts = strikeouts;
	}

	public Long getGroundOuts() {
		return groundOuts;
	}

	public void setGroundOuts(Long groundOuts) {
		this.groundOuts = groundOuts;
	}

	public Long getFlyOuts() {
		return flyOuts;
	}

	public void setFlyOuts(Long flyOuts) {
		this.flyOuts = flyOuts;
	}

	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}

	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
	
}
