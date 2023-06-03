package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**Entidad de Alumno
 * @author Jose Mauricio
 *
 */
public class Alumno implements Serializable{
	
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
	private Escuela escuela;
	private Date fechaAlta;
	private Date fechaBaja;
	private Set<Jugador> jugador = new HashSet<Jugador>();
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
	 * @return El campo jugador
	 */
	public Set<Jugador> getJugador() {
		return jugador;
	}
	/**
	 * @param jugador El campo jugador a settear
	 */
	public void setJugador(Set<Jugador> jugador) {
		this.jugador = jugador;
	}
	
}
