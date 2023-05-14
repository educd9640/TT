package ipn.escom.ballScore.entity;

import java.io.Serializable;

public class JugadorPartido implements Serializable{
	
	private static final long serialVersionUID = -3821753512999250746L;
	private Long idJugador;
	private Long idPartido;
	private Long idEquipo;
	private Long idTemporada;
	private String rolEquipo;
	
	//private Partido partido;
	private JugadorEquipoTemp jugadorEquipoTemp;

	public Long getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
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

	public JugadorEquipoTemp getJugadorEquipoTemp() {
		return jugadorEquipoTemp;
	}

	public void setJugadorEquipoTemp(JugadorEquipoTemp jugadorEquipoTemp) {
		this.jugadorEquipoTemp = jugadorEquipoTemp;
	}

	public String getRolEquipo() {
		return rolEquipo;
	}

	public void setRolEquipo(String rolEquipo) {
		this.rolEquipo = rolEquipo;
	}
	
}
