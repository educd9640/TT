package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;


/**VO para gestionar alumnos
 * @author Jose Mauricio
 *
 */
public class GestionarAlumnosVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long boletaAlumno;
	private String nombrePila;
	private String apellidoPat;
	private String apellidoMat;
	private Long semestre;
	private String curp;
	private Long nss;
	private String telefono;
	private String telEmergencia;
	private String correo;
	private Long idEscuela;
	private Date fechaAlta;
	private Date fechaBaja;
	/**
	 * @return El campo boletaAlumno
	 */
	public Long getBoletaAlumno() {
		return boletaAlumno;
	}
	/**
	 * @param boletaAlumno El campo boletaAlumno a settear
	 */
	public void setBoletaAlumno(Long boletaAlumno) {
		this.boletaAlumno = boletaAlumno;
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
	 * @return El campo semestre
	 */
	public Long getSemestre() {
		return semestre;
	}
	/**
	 * @param semestre El campo semestre a settear
	 */
	public void setSemestre(Long semestre) {
		this.semestre = semestre;
	}
	/**
	 * @return El campo curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp El campo curp a settear
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return El campo nss
	 */
	public Long getNss() {
		return nss;
	}
	/**
	 * @param nss El campo nss a settear
	 */
	public void setNss(Long nss) {
		this.nss = nss;
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
	 * @return El campo telEmergencia
	 */
	public String getTelEmergencia() {
		return telEmergencia;
	}
	/**
	 * @param telEmergencia El campo telEmergencia a settear
	 */
	public void setTelEmergencia(String telEmergencia) {
		this.telEmergencia = telEmergencia;
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
	
}
