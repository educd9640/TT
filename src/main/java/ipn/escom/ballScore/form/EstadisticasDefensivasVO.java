package ipn.escom.ballScore.form;

import ipn.escom.ballScore.entity.JugadorPartido;

/**Clase VO para estadisticas defensivas
 * @author Jose Mauricio
 *
 */
public class EstadisticasDefensivasVO {
	
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Long asistencias=0L;
	private Long atrapadasEnRobo=0L;
	private Long dobleplays=0L;
	private Long errores=0L;
	private Long fieldingPercentage=0L;
	private Long inningsJugadas=0L;
	private Long outs=0L;
	private Long asistenciaOutField=0L;
	private Long passedballs=0L;
	private Long putouts=0L;
	private Long totalChances=0L;
	private Long triplePlays=0L;
	private Long robos=0L;
	
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

	public Long getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Long asistencias) {
		this.asistencias = asistencias;
	}

	public Long getAtrapadasEnRobo() {
		return atrapadasEnRobo;
	}

	public void setAtrapadasEnRobo(Long atrapadasEnRobo) {
		this.atrapadasEnRobo = atrapadasEnRobo;
	}

	public Long getDobleplays() {
		return dobleplays;
	}

	public void setDobleplays(Long dobleplays) {
		this.dobleplays = dobleplays;
	}

	public Long getErrores() {
		return errores;
	}

	public void setErrores(Long errores) {
		this.errores = errores;
	}

	public Long getFieldingPercentage() {
		return fieldingPercentage;
	}

	public void setFieldingPercentage(Long fieldingPercentage) {
		this.fieldingPercentage = fieldingPercentage;
	}

	public Long getInningsJugadas() {
		return inningsJugadas;
	}

	public void setInningsJugadas(Long inningsJugadas) {
		this.inningsJugadas = inningsJugadas;
	}

	public Long getOuts() {
		return outs;
	}

	public void setOuts(Long outs) {
		this.outs = outs;
	}

	public Long getAsistenciaOutField() {
		return asistenciaOutField;
	}

	public void setAsistenciaOutField(Long asistenciaOutField) {
		this.asistenciaOutField = asistenciaOutField;
	}

	public Long getPassedballs() {
		return passedballs;
	}

	public void setPassedballs(Long passedballs) {
		this.passedballs = passedballs;
	}

	public Long getPutouts() {
		return putouts;
	}

	public void setPutouts(Long putouts) {
		this.putouts = putouts;
	}

	public Long getTotalChances() {
		return totalChances;
	}

	public void setTotalChances(Long totalChances) {
		this.totalChances = totalChances;
	}

	public Long getTriplePlays() {
		return triplePlays;
	}

	public void setTriplePlays(Long triplePlays) {
		this.triplePlays = triplePlays;
	}

	public Long getRobos() {
		return robos;
	}

	public void setRobos(Long robos) {
		this.robos = robos;
	}

	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}

	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
		
}
