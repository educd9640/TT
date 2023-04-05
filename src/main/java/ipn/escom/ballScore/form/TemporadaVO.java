package ipn.escom.ballScore.form;

import java.sql.Date;

import ipn.escom.ballScore.entity.Liga;

/**VO para gestionar temporadas
 * @author Eduardo Callejas
 *
 */
public class TemporadaVO {
	private long idTemporada;
	private long idLiga;
	private long idEquipoCampeon;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaAlta;
	
	private Liga liga; 
	
	//getters
	public long getIdTemporada() {	return idTemporada;}
	
	public long getIdLiga() {		return idLiga;	}

	public Date getFechaInicial() {		return fechaInicial;	}

	public Date getFechaFinal() {		return fechaFinal;	}

	public long getIdEquipoCampeon ()	{	return idEquipoCampeon;}	
	
	public Date getFechaAlta() {return fechaAlta;}
	
	
	//setters
	public void setIdEquipoCampeon(long idEquipoCampeon) {
		this.idEquipoCampeon = idEquipoCampeon;
	}
	
	public void setIdTemporada(long idTemporada) {
		this.idTemporada = idTemporada;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public void setIdLiga(long idLiga) {
		this.idLiga = idLiga;
	}
	
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
