package ipn.escom.ballScore.form;

import java.io.Serializable;

import ipn.escom.ballScore.entity.JugadorPartido;

/**VO para estadisticas defensivas
 * @author Jose Mauricio
 *
 */
public class EstadisticasDefensivasVO implements Serializable{

	private static final long serialVersionUID = 1L;
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
	public Long getAsistencias() {
		return asistencias;
	}

	/**
	 * @param asistencias El campo asistencias a settear
	 */
	public void setAsistencias(Long asistencias) {
		this.asistencias = asistencias;
	}

	/**
	 * @return El campo atrapadasEnRobo
	 */
	public Long getAtrapadasEnRobo() {
		return atrapadasEnRobo;
	}

	/**
	 * @param atrapadasEnRobo El campo atrapadasEnRobo a settear
	 */
	public void setAtrapadasEnRobo(Long atrapadasEnRobo) {
		this.atrapadasEnRobo = atrapadasEnRobo;
	}

	/**
	 * @return El campo dobleplays
	 */
	public Long getDobleplays() {
		return dobleplays;
	}

	/**
	 * @param dobleplays El campo dobleplays a settear
	 */
	public void setDobleplays(Long dobleplays) {
		this.dobleplays = dobleplays;
	}

	/**
	 * @return El campo errores
	 */
	public Long getErrores() {
		return errores;
	}

	/**
	 * @param errores El campo errores a settear
	 */
	public void setErrores(Long errores) {
		this.errores = errores;
	}

	/**
	 * @return El campo fieldingPercentage
	 */
	public Long getFieldingPercentage() {
		return fieldingPercentage;
	}

	/**
	 * @param fieldingPercentage El campo fieldingPercentage a settear
	 */
	public void setFieldingPercentage(Long fieldingPercentage) {
		this.fieldingPercentage = fieldingPercentage;
	}

	/**
	 * @return El campo inningsJugadas
	 */
	public Long getInningsJugadas() {
		return inningsJugadas;
	}

	/**
	 * @param inningsJugadas El campo inningsJugadas a settear
	 */
	public void setInningsJugadas(Long inningsJugadas) {
		this.inningsJugadas = inningsJugadas;
	}

	/**
	 * @return El campo outs
	 */
	public Long getOuts() {
		return outs;
	}

	/**
	 * @param outs El campo outs a settear
	 */
	public void setOuts(Long outs) {
		this.outs = outs;
	}

	/**
	 * @return El campo asistenciaOutField
	 */
	public Long getAsistenciaOutField() {
		return asistenciaOutField;
	}

	/**
	 * @param asistenciaOutField El campo asistenciaOutField a settear
	 */
	public void setAsistenciaOutField(Long asistenciaOutField) {
		this.asistenciaOutField = asistenciaOutField;
	}

	/**
	 * @return El campo passedballs
	 */
	public Long getPassedballs() {
		return passedballs;
	}

	/**
	 * @param passedballs El campo passedballs a settear
	 */
	public void setPassedballs(Long passedballs) {
		this.passedballs = passedballs;
	}

	/**
	 * @return El campo putouts
	 */
	public Long getPutouts() {
		return putouts;
	}

	/**
	 * @param putouts El campo putouts a settear
	 */
	public void setPutouts(Long putouts) {
		this.putouts = putouts;
	}

	/**
	 * @return El campo totalChances
	 */
	public Long getTotalChances() {
		return totalChances;
	}

	/**
	 * @param totalChances El campo totalChances a settear
	 */
	public void setTotalChances(Long totalChances) {
		this.totalChances = totalChances;
	}

	/**
	 * @return El campo triplePlays
	 */
	public Long getTriplePlays() {
		return triplePlays;
	}

	/**
	 * @param triplePlays El campo triplePlays a settear
	 */
	public void setTriplePlays(Long triplePlays) {
		this.triplePlays = triplePlays;
	}

	/**
	 * @return El campo robos
	 */
	public Long getRobos() {
		return robos;
	}

	/**
	 * @param robos El campo robos a settear
	 */
	public void setRobos(Long robos) {
		this.robos = robos;
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
