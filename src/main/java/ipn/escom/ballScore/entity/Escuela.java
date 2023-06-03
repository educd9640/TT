package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Entidad de Escuela
 * @author Jose Mauricio
 *
 */
public class Escuela implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idEscuela;
	private String nombreEscuela;
	private String nombreCortoEscuela;
	private String calle;
	private String colonia;
	private Long codigoPostal;
	private String delegacion;
	private String estado;
	private Date fechaAlta;
	
	/**
	 * @return El campo idEscuela
	 */
	public Long getIdEscuela() {
		return idEscuela;
	}
	/**
	 * @param idEscuela El campo idEscuela a settear
	 */
	public void setIdEscuela(Long idEscuela) {
		this.idEscuela = idEscuela;
	}
	/**
	 * @return El campo nombreEscuela
	 */
	public String getNombreEscuela() {
		return nombreEscuela;
	}
	/**
	 * @param nombreEscuela El campo nombreEscuela a settear
	 */
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}
	/**
	 * @return El campo nombreCortoEscuela
	 */
	public String getNombreCortoEscuela() {
		return nombreCortoEscuela;
	}
	/**
	 * @param nombreCortoEscuela El campo nombreCortoEscuela a settear
	 */
	public void setNombreCortoEscuela(String nombreCortoEscuela) {
		this.nombreCortoEscuela = nombreCortoEscuela;
	}
	/**
	 * @return El campo calle
	 */
	public String getCalle() {
		return calle;
	}
	/**
	 * @param calle El campo calle a settear
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * @return El campo colonia
	 */
	public String getColonia() {
		return colonia;
	}
	/**
	 * @param colonia El campo colonia a settear
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	/**
	 * @return El campo codigoPostal
	 */
	public Long getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param codigoPostal El campo codigoPostal a settear
	 */
	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return El campo delegacion
	 */
	public String getDelegacion() {
		return delegacion;
	}
	/**
	 * @param delegacion El campo delegacion a settear
	 */
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	/**
	 * @return El campo estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado El campo estado a settear
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
	
}
