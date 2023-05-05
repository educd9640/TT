package ipn.escom.ballScore.form;

import java.util.List;

import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.Jugador;
import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.entity.Temporada;

/**Clase form para las pantallas de gestion de jugadores de equipos temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugEquipTempForm {

	private Long idTemporada;
	private Long idEquipo;
	private Temporada temporada;
	private List<EquipoTemporada> equiposTemporada;
	private List<JugadorEquipoTemp> jugadoresTemporada;
	private List<Jugador> jugadoresEquipo;
	private String jugadoresARegistrar;

	
	public Long getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public List<EquipoTemporada> getEquiposTemporada() {
		return equiposTemporada;
	}

	public void setEquiposTemporada(List<EquipoTemporada> equiposTemporada) {
		this.equiposTemporada = equiposTemporada;
	}

	public List<JugadorEquipoTemp> getJugadoresTemporada() {
		return jugadoresTemporada;
	}

	public void setJugadoresTemporada(List<JugadorEquipoTemp> jugadoresTemporada) {
		this.jugadoresTemporada = jugadoresTemporada;
	}

	public List<Jugador> getJugadoresEquipo() {
		return jugadoresEquipo;
	}

	public void setJugadoresEquipo(List<Jugador> jugadoresEquipo) {
		this.jugadoresEquipo = jugadoresEquipo;
	}

	public String getJugadoresARegistrar() {
		return jugadoresARegistrar;
	}

	public void setJugadoresARegistrar(String jugadoresARegistrar) {
		this.jugadoresARegistrar = jugadoresARegistrar;
	}
	
	
	
}
