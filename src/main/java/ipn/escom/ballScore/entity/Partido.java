package ipn.escom.ballScore.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**Entidad de Partido
 * @author Eduardo Callejas
 *
 */
public class Partido {
	
	private Long idPartido;
	private Long idTemporada;
	private Long idEquipoLocal;
	private Long idEquipoVisitante;
	private String campo;
	private Timestamp fechaAnuncioPartido;
	private Date fechaAlta;
	
	private ResultadosPartido resultadosPartido;
	private EquipoTemporada equipoTemporadaLocal;
	private EquipoTemporada equipoTemporadaVisitante;
	
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
	public EquipoTemporada getEquipoTemporadaLocal() {
		return equipoTemporadaLocal;
	}
	public void setEquipoTemporadaLocal(EquipoTemporada equipoTemporadaLocal) {
		this.equipoTemporadaLocal = equipoTemporadaLocal;
	}
	public EquipoTemporada getEquipoTemporadaVisitante() {
		return equipoTemporadaVisitante;
	}
	public void setEquipoTemporadaVisitante(EquipoTemporada equipoTemporadaVisitante) {
		this.equipoTemporadaVisitante = equipoTemporadaVisitante;
	}
	
	
}
