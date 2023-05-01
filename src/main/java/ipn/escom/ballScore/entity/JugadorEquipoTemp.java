package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Clase entidad para la tabla JUGADOR_EQUIPO_TEMP
 * @author Jose Mauricio
 *
 */
public class JugadorEquipoTemp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idJugador;
	private Long idEquipo;
	private Long idTemporada;
	private Date fechaAlta;
	
	private Jugador jugador;
	private EquipoTemporada equipoTemporada;
	
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
	public Long getIdTemporada() {
		return idTemporada;
	}
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}
	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	}
	
	
	
	
}
