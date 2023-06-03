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
	 * @return El campo idTemporada
	 */
	public Long getIdTemporada() {
		return idTemporada;
	}
	/**
	 * @param idTemporada El campo idTemporada a settear
	 */
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
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
	 * @return El campo jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}
	/**
	 * @param jugador El campo jugador a settear
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	/**
	 * @return El campo equipoTemporada
	 */
	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}
	/**
	 * @param equipoTemporada El campo equipoTemporada a settear
	 */
	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	}
	
}
