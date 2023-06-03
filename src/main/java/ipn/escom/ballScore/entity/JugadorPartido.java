package ipn.escom.ballScore.entity;

import java.io.Serializable;

/**Entidad de JugadorPartido
 * @author Jose Mauricio
 *
 */
public class JugadorPartido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idJugador;
	private Long idPartido;
	private Long idEquipo;
	private Long idTemporada;
	private String rolEquipo;
	
	//private Partido partido;
	private JugadorEquipoTemp jugadorEquipoTemp;

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
	 * @return El campo idPartido
	 */
	public Long getIdPartido() {
		return idPartido;
	}

	/**
	 * @param idPartido El campo idPartido a settear
	 */
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
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
	 * @return El campo rolEquipo
	 */
	public String getRolEquipo() {
		return rolEquipo;
	}

	/**
	 * @param rolEquipo El campo rolEquipo a settear
	 */
	public void setRolEquipo(String rolEquipo) {
		this.rolEquipo = rolEquipo;
	}

	/**
	 * @return El campo jugadorEquipoTemp
	 */
	public JugadorEquipoTemp getJugadorEquipoTemp() {
		return jugadorEquipoTemp;
	}

	/**
	 * @param jugadorEquipoTemp El campo jugadorEquipoTemp a settear
	 */
	public void setJugadorEquipoTemp(JugadorEquipoTemp jugadorEquipoTemp) {
		this.jugadorEquipoTemp = jugadorEquipoTemp;
	}

}
