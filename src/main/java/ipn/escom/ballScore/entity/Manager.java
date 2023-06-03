package ipn.escom.ballScore.entity;

import java.sql.Date;

/**Entidad de Manager
 * @author Jose Mauricio
 *
 */
public class Manager {
	private Long idManager;
	private String nombrePila;
	private String apellidoPat;
	private String apellidoMat;
	private String telefono;
	private String correo;
	private String contrasenia;
	private Date fechaAlta;
	private Date fechaBaja;
	private Escuela escuela;

	/**
	 * @return El campo idManager
	 */
	public Long getIdManager() {
		return idManager;
	}



	/**
	 * @param idManager El campo idManager a settear
	 */
	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}



	/**
	 * @return El campo nombrePila
	 */
	public String getNombrePila() {
		return nombrePila;
	}



	/**
	 * @param nombrePila El campo nombrePila a settear
	 */
	public void setNombrePila(String nombrePila) {
		this.nombrePila = nombrePila;
	}



	/**
	 * @return El campo apellidoPat
	 */
	public String getApellidoPat() {
		return apellidoPat;
	}



	/**
	 * @param apellidoPat El campo apellidoPat a settear
	 */
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}



	/**
	 * @return El campo apellidoMat
	 */
	public String getApellidoMat() {
		return apellidoMat;
	}



	/**
	 * @param apellidoMat El campo apellidoMat a settear
	 */
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
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
	 * @return El campo correo
	 */
	public String getCorreo() {
		return correo;
	}



	/**
	 * @param correo El campo correo a settear
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}



	/**
	 * @return El campo contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}



	/**
	 * @param contrasenia El campo contrasenia a settear
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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
	 * @return El campo fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}



	/**
	 * @param fechaBaja El campo fechaBaja a settear
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}



	/**
	 * @return El campo escuela
	 */
	public Escuela getEscuela() {
		return escuela;
	}



	/**
	 * @param escuela El campo escuela a settear
	 */
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}



	@Override
	public String toString() {
		return "[Manager: id = " + idManager + " ; nombre = " + nombrePila + " " + apellidoPat + " " + apellidoPat
				+ " ; login = " + correo + "]";
	}
}
