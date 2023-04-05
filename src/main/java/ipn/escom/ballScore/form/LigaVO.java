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
	
	//getters
	public Long getLiga() {
		return idLiga;
	}
	
	public String getNombre(){	return nombre;}
	
	public String getTelefono() {return telefono;	}
	
	public String getCalle() {	return calle;}
	
	public String getColonia() {return colonia;}
	
	public Long getCodigoPostal() {return codigoPostal;}
	
	public String getDelegacion() {return delegacion;}
	
	public String getestado() {return estado;}
	
	public Date getFechaAlta() {return fechaAlta;}
	
	
	//setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
