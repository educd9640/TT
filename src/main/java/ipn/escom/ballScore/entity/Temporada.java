package ipn.escom.ballScore.entity;

import java.sql.Date;

/**Entidad de Temporada
 * @author Eduardo Callejas
 *
 */
public class Temporada{
	private Long idTemporada;
	private Long idEquipoCampeon;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaAlta;
	
	private Liga liga;
	private EquipoTemporada equipoTemporada;

	public Long getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
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

	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}

	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	} 
	
	
}