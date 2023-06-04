package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Entidad de Liga
 * @author Eduardo Callejas
 *
 */
public class Liga implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idLiga;
	private String nombre;
	private String telefono;
	private String calle;
	private String colonia;
	private Long codigoPostal;
	private String delegacion;
	private String estado;
	private Date fechaAlta;
	/**
	 * @return El campo idLiga
	 */
	public Long getIdLiga() {
		return idLiga;
	}
	/**
	 * @param idLiga El campo idLiga a settear
	 */
	public void setIdLiga(Long idLiga) {
		this.idLiga = idLiga;
	}
	/**
	 * @return El campo nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre El campo nombre a settear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return El campo telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono El campo telefono a settear
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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