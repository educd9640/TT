package ipn.escom.ballScore.form;

import java.sql.Date;


/**VO para gestionar las Ligas
 * @author Eduardo Callejas
 *
 */
public class LigaVO{
	
	private Long idLiga;
	private String nombre;
	private String telefono;
	private String calle;
	private String colonia;
	private Long codigoPostal;
	private String delegacion;
	private String estado;
	private Date fechaAlta;
	
	public Long getIdLiga() {
		return idLiga;
	}
	public void setIdLiga(Long idLiga) {
		this.idLiga = idLiga;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public Long getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
