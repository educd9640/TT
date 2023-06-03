package ipn.escom.ballScore.entity;

import java.io.Serializable;

/**Clase de entidad para estadisticas defensivas
 * @author Jose Mauricio
 *
 */
public class EstDefensivasPart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Double asistencias;
	private Double caughtStealingPerc;
	private Double dobleplays;
	private Double errores;
	private Double fieldingPercentage;
	private Double inningsJugadas;
	private Double outs;
	private Double asistenciaOutField;
	private Double passedballs;
	private Double putouts;
	private Double totalChances;
	private Double triplePlays;
	
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
	 * @return El campo asistencias
	 */
	public Double getAsistencias() {
		return asistencias;
	}

	/**
	 * @param asistencias El campo asistencias a settear
	 */
	public void setAsistencias(Double asistencias) {
		this.asistencias = asistencias;
	}

	/**
	 * @return El campo caughtStealingPerc
	 */
	public Double getCaughtStealingPerc() {
		return caughtStealingPerc;
	}

	/**
	 * @param caughtStealingPerc El campo caughtStealingPerc a settear
	 */
	public void setCaughtStealingPerc(Double caughtStealingPerc) {
		this.caughtStealingPerc = caughtStealingPerc;
	}

	/**
	 * @return El campo dobleplays
	 */
	public Double getDobleplays() {
		return dobleplays;
	}

	/**
	 * @param dobleplays El campo dobleplays a settear
	 */
	public void setDobleplays(Double dobleplays) {
		this.dobleplays = dobleplays;
	}

	/**
	 * @return El campo errores
	 */
	public Double getErrores() {
		return errores;
	}

	/**
	 * @param errores El campo errores a settear
	 */
	public void setErrores(Double errores) {
		this.errores = errores;
	}

	/**
	 * @return El campo fieldingPercentage
	 */
	public Double getFieldingPercentage() {
		return fieldingPercentage;
	}

	/**
	 * @param fieldingPercentage El campo fieldingPercentage a settear
	 */
	public void setFieldingPercentage(Double fieldingPercentage) {
		this.fieldingPercentage = fieldingPercentage;
	}

	/**
	 * @return El campo inningsJugadas
	 */
	public Double getInningsJugadas() {
		return inningsJugadas;
	}

	/**
	 * @param inningsJugadas El campo inningsJugadas a settear
	 */
	public void setInningsJugadas(Double inningsJugadas) {
		this.inningsJugadas = inningsJugadas;
	}

	/**
	 * @return El campo outs
	 */
	public Double getOuts() {
		return outs;
	}

	/**
	 * @param outs El campo outs a settear
	 */
	public void setOuts(Double outs) {
		this.outs = outs;
	}

	/**
	 * @return El campo asistenciaOutField
	 */
	public Double getAsistenciaOutField() {
		return asistenciaOutField;
	}

	/**
	 * @param asistenciaOutField El campo asistenciaOutField a settear
	 */
	public void setAsistenciaOutField(Double asistenciaOutField) {
		this.asistenciaOutField = asistenciaOutField;
	}

	/**
	 * @return El campo passedballs
	 */
	public Double getPassedballs() {
		return passedballs;
	}

	/**
	 * @param passedballs El campo passedballs a settear
	 */
	public void setPassedballs(Double passedballs) {
		this.passedballs = passedballs;
	}

	/**
	 * @return El campo putouts
	 */
	public Double getPutouts() {
		return putouts;
	}

	/**
	 * @param putouts El campo putouts a settear
	 */
	public void setPutouts(Double putouts) {
		this.putouts = putouts;
	}

	/**
	 * @return El campo totalChances
	 */
	public Double getTotalChances() {
		return totalChances;
	}

	/**
	 * @param totalChances El campo totalChances a settear
	 */
	public void setTotalChances(Double totalChances) {
		this.totalChances = totalChances;
	}

	/**
	 * @return El campo triplePlays
	 */
	public Double getTriplePlays() {
		return triplePlays;
	}

	/**
	 * @param triplePlays El campo triplePlays a settear
	 */
	public void setTriplePlays(Double triplePlays) {
		this.triplePlays = triplePlays;
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
