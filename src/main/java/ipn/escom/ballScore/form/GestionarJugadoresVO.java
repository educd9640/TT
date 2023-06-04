package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;

import ipn.escom.ballScore.entity.Alumno;

/**VO para la gestion de jugadores
 * @author Jose Mauricio
 *
 */
public class GestionarJugadoresVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idJugador;
	private Long idEquipo;
	private String posicionPrim;
	private String posicionSec;
	private Date fechaAlta;
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
	 * @return El campo idEquipo
	 */
	public Long getIdEquipo() {
		return idEquipo;
	}
	/**
	 * @param idEquipo El campo idEquipo a settear
	 */
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
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
