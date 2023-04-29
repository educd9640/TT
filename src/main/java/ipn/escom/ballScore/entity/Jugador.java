package ipn.escom.ballScore.entity;

import java.sql.Date;

/**Clase entidad para Jugador
 * @author Jose Mauricio
 *
 */
public class Jugador {

	private Long idJugador;
	private String posicionPrim;
	private String posicionSec;
	private Date fechaAlta;
	private Equipo equipo;
	private Alumno alumno;
	
	public Long getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	public String getPosicionPrim() {
		return posicionPrim;
	}
	public void setPosicionPrim(String posicionPrim) {
		this.posicionPrim = posicionPrim;
	}
	public String getPosicionSec() {
		return posicionSec;
	}
	public void setPosicionSec(String posicionSec) {
		this.posicionSec = posicionSec;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
