package ipn.escom.ballScore.entity;

import java.sql.Date;

/**Clase entidad para Jugador
 * @author Jose Mauricio
 *
 */
public class Jugador {

	private Long idJugador;
	private Long idEquipo;
	private String posicionPrim;
	private String posicionSec;
	private Date fechaAlta;
	private Alumno alumno;
	
	public Long getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
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
	
}
