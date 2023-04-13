package ipn.escom.ballScore.form;

import java.sql.Date;

import ipn.escom.ballScore.entity.Liga;

/**Form para gestionar las Temporadas
 * @author Eduardo Callejas
 *
 */
public class TemporadaForm {
	
	private Long idTemporada;
	private Long idLiga;
	private Long idEquipoCampeon;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaAlta;
	
	private Liga liga;

	public Long getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}

	public Long getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(Long idLiga) {
		this.idLiga = idLiga;
	}

	public Long getIdEquipoCampeon() {
		return idEquipoCampeon;
	}

	public void setIdEquipoCampeon(Long idEquipoCampeon) {
		this.idEquipoCampeon = idEquipoCampeon;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	} 
}
