package ipn.escom.ballScore.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**Entidad de Alumno
 * @author Jose Mauricio
 *
 */
public class Alumno {
	
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
	private Escuela escuela;
	private Date fechaAlta;
	private Date fechaBaja;
	private Set<Jugador> jugador = new HashSet<Jugador>();
	
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
		this.nombrePila = nombrePila.toUpperCase();
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat.toUpperCase();
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat.toUpperCase();
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
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
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
	public Set<Jugador> getJugador() {
		return jugador;
	}
	public void setJugador(Set<Jugador> jugador) {
		this.jugador = jugador;
	}
	
	
	
}
