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
	private Double asistencias=0D;
	private Double atrapadasEnRobo=0D;
	private Double dobleplays=0D;
	private Double errores=0D;
	private Double fieldingPercentage=0D;
	private Double inningsJugadas=0D;
	private Double outs=0D;
	private Double asistenciaOutField=0D;
	private Double passedballs=0D;
	private Double putouts=0D;
	private Double totalChances=0D;
	private Double triplePlays=0D;
	private Double robos=0D;
	
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

	public Double getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Double asistencias) {
		this.asistencias = asistencias;
	}

	public Double getAtrapadasEnRobo() {
		return atrapadasEnRobo;
	}

	public void setAtrapadasEnRobo(Double atrapadasEnRobo) {
		this.atrapadasEnRobo = atrapadasEnRobo;
	}

	public Double getDobleplays() {
		return dobleplays;
	}

	public void setDobleplays(Double dobleplays) {
		this.dobleplays = dobleplays;
	}

	public Double getErrores() {
		return errores;
	}

	public void setErrores(Double errores) {
		this.errores = errores;
	}

	public Double getFieldingPercentage() {
		return fieldingPercentage;
	}

	public void setFieldingPercentage(Double fieldingPercentage) {
		this.fieldingPercentage = fieldingPercentage;
	}

	public Double getInningsJugadas() {
		return inningsJugadas;
	}

	public void setInningsJugadas(Double inningsJugadas) {
		this.inningsJugadas = inningsJugadas;
	}

	public Double getOuts() {
		return outs;
	}

	public void setOuts(Double outs) {
		this.outs = outs;
	}

	public Double getAsistenciaOutField() {
		return asistenciaOutField;
	}

	public void setAsistenciaOutField(Double asistenciaOutField) {
		this.asistenciaOutField = asistenciaOutField;
	}

	public Double getPassedballs() {
		return passedballs;
	}

	public void setPassedballs(Double passedballs) {
		this.passedballs = passedballs;
	}

	public Double getPutouts() {
		return putouts;
	}

	public void setPutouts(Double putouts) {
		this.putouts = putouts;
	}

	public Double getTotalChances() {
		return totalChances;
	}

	public void setTotalChances(Double totalChances) {
		this.totalChances = totalChances;
	}

	public Double getTriplePlays() {
		return triplePlays;
	}

	public void setTriplePlays(Double triplePlays) {
		this.triplePlays = triplePlays;
	}

	public Double getRobos() {
		return robos;
	}

	public void setRobos(Double robos) {
		this.robos = robos;
	}

	public JugadorPartido getJugadorPartido() {
		return jugadorPartido;
	}

	public void setJugadorPartido(JugadorPartido jugadorPartido) {
		this.jugadorPartido = jugadorPartido;
	}
		
}
