package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;

import ipn.escom.ballScore.entity.Liga;

/**VO para gestionar temporadas
 * @author Eduardo Callejas
 *
 */
public class TemporadaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idTemporada;
	private Long idEquipoCampeon;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaAlta;
	
	private Liga liga;

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
	 * @return El campo idEquipoCampeon
	 */
	public Long getIdEquipoCampeon() {
		return idEquipoCampeon;
	}

	/**
	 * @param idEquipoCampeon El campo idEquipoCampeon a settear
	 */
	public void setIdEquipoCampeon(Long idEquipoCampeon) {
		this.idEquipoCampeon = idEquipoCampeon;
	}

	/**
	 * @return El campo fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial El campo fechaInicial a settear
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return El campo fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal El campo fechaFinal a settear
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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
	 * @return El campo liga
	 */
	public Liga getLiga() {
		return liga;
	}

	/**
	 * @param liga El campo liga a settear
	 */
	public void setLiga(Liga liga) {
		this.liga = liga;
	}

}
