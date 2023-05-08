package ipn.escom.ballScore.form;

import java.sql.Date;
import java.sql.Timestamp;

import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.ResultadosPartido;

/**Form para gestionar partidos
 * @author Eduardo Callejas
 *
 */
public class PartidoForm {
	

	private Long idPartido;
	private Long idTemporada;
	private Long idEquipoLocal;
	private Long idEquipoVisitante;
	private String campo;
	private Timestamp fechaAnuncioPartido;
	private Date fechaAlta;
	
	private ResultadosPartido resultadosPartido;
	private EquipoTemporada equipoTemporada;
	
	
	public Long getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	public Long getIdEquipoLocal() {
		return idEquipoLocal;
	}
	public void setIdEquipoLocal(Long idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}
	public Long getIdEquipoVisitante() {
		return idEquipoVisitante;
	}
	public void setIdEquipoVisitante(Long idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public Timestamp getFechaAnuncioPartido() {
		return fechaAnuncioPartido;
	}
	public void setFechaAnuncioPartido(Timestamp fechaAnuncioPartido) {
		this.fechaAnuncioPartido = fechaAnuncioPartido;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public ResultadosPartido getResultadosPartido() {
		return resultadosPartido;
	}
	public void setResultadosPartido(ResultadosPartido resultadosPartido) {
		this.resultadosPartido = resultadosPartido;
	}
	public Long getIdTemporada() {
		return idTemporada;
	}
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}
	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	}
}