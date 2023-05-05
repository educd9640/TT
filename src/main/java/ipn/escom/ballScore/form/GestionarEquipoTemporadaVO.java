package ipn.escom.ballScore.form;

import java.sql.Date;

import ipn.escom.ballScore.entity.Liga;

/**Form para gestionar las Temporadas
 * @author Cisneros Christian
 *
 */
public class GestionarEquipoTemporadaVO {
	private Long idTemporada;
	private Long idEquipo;
	private Date fechaAlta;
	
	private Liga liga;

	public Long getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	
	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
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
