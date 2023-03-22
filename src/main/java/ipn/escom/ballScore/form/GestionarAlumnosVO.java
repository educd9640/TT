package ipn.escom.ballScore.form;

import java.sql.Date;


/**VO para gestionar alumnos
 * @author Jose Mauricio
 *
 */
public class GestionarAlumnosVO {
	
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
	
	public Long getBoletaAlumno() {
		return boletaAlumno;
	}
	public void setBoletaAlumno(Long boletaAlumno) {
		this.boletaAlumno = boletaAlumno;
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
	public Long getSemestre() {
		return semestre;
	}
	public void setSemestre(Long semestre) {
		this.semestre = semestre;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Long getNss() {
		return nss;
	}
	public void setNss(Long nss) {
		this.nss = nss;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelEmergencia() {
		return telEmergencia;
	}
	public void setTelEmergencia(String telEmergencia) {
		this.telEmergencia = telEmergencia;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getIdEscuela() {
		return idEscuela;
	}
	public void setIdEscuela(Long idEscuela) {
		this.idEscuela = idEscuela;
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
