package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;

import ipn.escom.ballScore.entity.Liga;

/**Form para gestionar las Temporadas
 * @author Cisneros Christian
 *
 */
public class GestionarEquipoTemporadaForm implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idTemporada;
	private Long idEquipo;
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
