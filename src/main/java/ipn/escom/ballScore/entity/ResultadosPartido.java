package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Entidad de resultados de partido
 * @author Eduardo Callejas
 *
 */
public class ResultadosPartido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long carrerasLocal;
	private Long carrerasVisitante;
	private Long erroresLocal;
	private Long erroresVisitante;
	private Long hitsLocal;
	private Long hitsVisitante;
	private Date fechaPartido;
	
	private Partido partido;

	/**
	 * @return El campo carrerasLocal
	 */
	public Long getCarrerasLocal() {
		return carrerasLocal;
	}

	/**
	 * @param carrerasLocal El campo carrerasLocal a settear
	 */
	public void setCarrerasLocal(Long carrerasLocal) {
		this.carrerasLocal = carrerasLocal;
	}

	/**
	 * @return El campo carrerasVisitante
	 */
	public Long getCarrerasVisitante() {
		return carrerasVisitante;
	}

	/**
	 * @param carrerasVisitante El campo carrerasVisitante a settear
	 */
	public void setCarrerasVisitante(Long carrerasVisitante) {
		this.carrerasVisitante = carrerasVisitante;
	}

	/**
	 * @return El campo erroresLocal
	 */
	public Long getErroresLocal() {
		return erroresLocal;
	}

	/**
	 * @param erroresLocal El campo erroresLocal a settear
	 */
	public void setErroresLocal(Long erroresLocal) {
		this.erroresLocal = erroresLocal;
	}

	/**
	 * @return El campo erroresVisitante
	 */
	public Long getErroresVisitante() {
		return erroresVisitante;
	}

	/**
	 * @param erroresVisitante El campo erroresVisitante a settear
	 */
	public void setErroresVisitante(Long erroresVisitante) {
		this.erroresVisitante = erroresVisitante;
	}

	/**
	 * @return El campo hitsLocal
	 */
	public Long getHitsLocal() {
		return hitsLocal;
	}

	/**
	 * @param hitsLocal El campo hitsLocal a settear
	 */
	public void setHitsLocal(Long hitsLocal) {
		this.hitsLocal = hitsLocal;
	}

	/**
	 * @return El campo hitsVisitante
	 */
	public Long getHitsVisitante() {
		return hitsVisitante;
	}

	/**
	 * @param hitsVisitante El campo hitsVisitante a settear
	 */
	public void setHitsVisitante(Long hitsVisitante) {
		this.hitsVisitante = hitsVisitante;
	}

	/**
	 * @return El campo fechaPartido
	 */
	public Date getFechaPartido() {
		return fechaPartido;
	}

	/**
	 * @param fechaPartido El campo fechaPartido a settear
	 */
	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	/**
	 * @return El campo partido
	 */
	public Partido getPartido() {
		return partido;
	}

	/**
	 * @param partido El campo partido a settear
	 */
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}
