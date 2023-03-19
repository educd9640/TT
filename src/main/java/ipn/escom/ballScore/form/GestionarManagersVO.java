package ipn.escom.ballScore.form;

import java.sql.Date;

public class GestionarManagersVO {
	private Long idManager;
	private String nombrePila;
	private String apellidoPat;
	private String apellidoMat;
	private String telefono;
	private Long idEscuela;
	private String correo;
	private String contrasenia;
	private Date fechaAlta;
	private Date fechaBaja;

	public Long getIdManager() {
		return idManager;
	}

	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}

	public String getNombrePila() {
		return nombrePila;
	}

	public void setNombrePila(String nombrePila) {
		this.nombrePila = nombrePila;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(Long idEscuela) {
		this.idEscuela = idEscuela;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
}
