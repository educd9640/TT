package ipn.escom.ballScore.form;

import java.util.Date;
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
	private Long idJugador;
	private Date fechaInicialTemporada;
	private Date fechaFinalTemporada;
	private String nombreLiga;
	private Long boletaAlumno;
	private String nombrePila;
	private String posicionPrim;
	private String posicionSec;

	
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

	public Long getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}

	public Date getFechaInicialTemporada() {
		return fechaInicialTemporada;
	}

	public void setFechaInicialTemporada(Date fechaInicialTemporada) {
		this.fechaInicialTemporada = fechaInicialTemporada;
	}

	public Date getFechaFinalTemporada() {
		return fechaFinalTemporada;
	}

	public void setFechaFinalTemporada(Date fechaFinalTemporada) {
		this.fechaFinalTemporada = fechaFinalTemporada;
	}

	public String getNombreLiga() {
		return nombreLiga;
	}

	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	public Long getBoletaAlumno() {
		return boletaAlumno;
	}

	public void setBoletaAlumno(Long boletaAlumno) {
		this.boletaAlumno = boletaAlumno;
	}

	public String getNombrePila() {
		return nombrePila;
	}

	public void setNombrePila(String nombrePila) {
		this.nombrePila = nombrePila;
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
	
	
	
	
	
}
