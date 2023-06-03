package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Clase entidad para Jugador
 * @author Jose Mauricio
 *
 */
public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idJugador;
	private String posicionPrim;
	private String posicionSec;
	private Date fechaAlta;
	private Equipo equipo;
	private Alumno alumno;
	/**
	 * @return El campo idJugador
	 */
	public Long getIdJugador() {
		return idJugador;
	}
	/**
	 * @param idJugador El campo idJugador a settear
	 */
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	/**
	 * @return El campo posicionPrim
	 */
	public String getPosicionPrim() {
		return posicionPrim;
	}
	/**
	 * @param posicionPrim El campo posicionPrim a settear
	 */
	public void setPosicionPrim(String posicionPrim) {
		this.posicionPrim = posicionPrim;
	}
	/**
	 * @return El campo posicionSec
	 */
	public String getPosicionSec() {
		return posicionSec;
	}
	/**
	 * @param posicionSec El campo posicionSec a settear
	 */
	public void setPosicionSec(String posicionSec) {
		this.posicionSec = posicionSec;
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
	 * @return El campo equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}
	/**
	 * @param equipo El campo equipo a settear
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	/**
	 * @return El campo alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}
	/**
	 * @param alumno El campo alumno a settear
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
