package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.ResultadosPartido;

/**VO para gestionar partidos
 * @author Eduardo Callejas
 *
 */
public class PartidoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private Long idTemporada;
	private Long idEquipoLocal;
	private Long idEquipoVisitante;
	private String campo;
	private Timestamp fechaAnuncioPartido;
	private Date fechaAlta;
	
	private ResultadosPartido resultadosPartido;
	private EquipoTemporada equipoTemporada;
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
	 * @return El campo idEquipoLocal
	 */
	public Long getIdEquipoLocal() {
		return idEquipoLocal;
	}
	/**
	 * @param idEquipoLocal El campo idEquipoLocal a settear
	 */
	public void setIdEquipoLocal(Long idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}
	/**
	 * @return El campo idEquipoVisitante
	 */
	public Long getIdEquipoVisitante() {
		return idEquipoVisitante;
	}
	/**
	 * @param idEquipoVisitante El campo idEquipoVisitante a settear
	 */
	public void setIdEquipoVisitante(Long idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}
	/**
	 * @return El campo campo
	 */
	public String getCampo() {
		return campo;
	}
	/**
	 * @param campo El campo campo a settear
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}
	/**
	 * @return El campo fechaAnuncioPartido
	 */
	public Timestamp getFechaAnuncioPartido() {
		return fechaAnuncioPartido;
	}
	/**
	 * @param fechaAnuncioPartido El campo fechaAnuncioPartido a settear
	 */
	public void setFechaAnuncioPartido(Timestamp fechaAnuncioPartido) {
		this.fechaAnuncioPartido = fechaAnuncioPartido;
	}
	/**
	 * @return El campo fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta El campo fechaAlta a settear
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return El campo resultadosPartido
	 */
	public ResultadosPartido getResultadosPartido() {
		return resultadosPartido;
	}
	/**
	 * @param resultadosPartido El campo resultadosPartido a settear
	 */
	public void setResultadosPartido(ResultadosPartido resultadosPartido) {
		this.resultadosPartido = resultadosPartido;
	}
	/**
	 * @return El campo equipoTemporada
	 */
	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}
	/**
	 * @param equipoTemporada El campo equipoTemporada a settear
	 */
	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	}
	
}
