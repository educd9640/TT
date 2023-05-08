package ipn.escom.ballScore.entity;

import java.sql.Date;

/**Entidad de resultados de partido
 * @author Eduardo Callejas
 *
 */
public class ResultadosPartido {
	
	private Long carrerasLocal;
	private Long carrerasVisitante;
	private Long erroresLocal;
	private Long erroresVisitante;
	private Long hitsLocal;
	private Long hitsVisitante;
	private Date fechaPartido;
	
	private Partido partido;

	public Long getCarrerasLocal() {
		return carrerasLocal;
	}

	public void setCarrerasLocal(Long carrerasLocal) {
		this.carrerasLocal = carrerasLocal;
	}

	public Long getCarrerasVisitante() {
		return carrerasVisitante;
	}

	public void setCarrerasVisitante(Long carrerasVisitante) {
		this.carrerasVisitante = carrerasVisitante;
	}

	public Long getErroresLocal() {
		return erroresLocal;
	}

	public void setErroresLocal(Long erroresLocal) {
		this.erroresLocal = erroresLocal;
	}

	public Long getErroresVisitante() {
		return erroresVisitante;
	}

	public void setErroresVisitante(Long erroresVisitante) {
		this.erroresVisitante = erroresVisitante;
	}

	public Long getHitsLocal() {
		return hitsLocal;
	}

	public void setHitsLocal(Long hitsLocal) {
		this.hitsLocal = hitsLocal;
	}

	public Long getHitsVisitante() {
		return hitsVisitante;
	}

	public void setHitsVisitante(Long hitsVisitante) {
		this.hitsVisitante = hitsVisitante;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
}
