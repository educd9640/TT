package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.Jugador;
import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.entity.Temporada;

/**Form para gestion de jugadores de equipos temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugEquipTempForm implements Serializable{

	private static final long serialVersionUID = 1L;
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
	 * @return El campo temporada
	 */
	public Temporada getTemporada() {
		return temporada;
	}
	/**
	 * @param temporada El campo temporada a settear
	 */
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	/**
	 * @return El campo equiposTemporada
	 */
	public List<EquipoTemporada> getEquiposTemporada() {
		return equiposTemporada;
	}
	/**
	 * @param equiposTemporada El campo equiposTemporada a settear
	 */
	public void setEquiposTemporada(List<EquipoTemporada> equiposTemporada) {
		this.equiposTemporada = equiposTemporada;
	}
	/**
	 * @return El campo jugadoresTemporada
	 */
	public List<JugadorEquipoTemp> getJugadoresTemporada() {
		return jugadoresTemporada;
	}
	/**
	 * @param jugadoresTemporada El campo jugadoresTemporada a settear
	 */
	public void setJugadoresTemporada(List<JugadorEquipoTemp> jugadoresTemporada) {
		this.jugadoresTemporada = jugadoresTemporada;
	}
	/**
	 * @return El campo jugadoresEquipo
	 */
	public List<Jugador> getJugadoresEquipo() {
		return jugadoresEquipo;
	}
	/**
	 * @param jugadoresEquipo El campo jugadoresEquipo a settear
	 */
	public void setJugadoresEquipo(List<Jugador> jugadoresEquipo) {
		this.jugadoresEquipo = jugadoresEquipo;
	}
	/**
	 * @return El campo jugadoresARegistrar
	 */
	public String getJugadoresARegistrar() {
		return jugadoresARegistrar;
	}
	/**
	 * @param jugadoresARegistrar El campo jugadoresARegistrar a settear
	 */
	public void setJugadoresARegistrar(String jugadoresARegistrar) {
		this.jugadoresARegistrar = jugadoresARegistrar;
	}
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
	 * @return El campo fechaInicialTemporada
	 */
	public Date getFechaInicialTemporada() {
		return fechaInicialTemporada;
	}
	/**
	 * @param fechaInicialTemporada El campo fechaInicialTemporada a settear
	 */
	public void setFechaInicialTemporada(Date fechaInicialTemporada) {
		this.fechaInicialTemporada = fechaInicialTemporada;
	}
	/**
	 * @return El campo fechaFinalTemporada
	 */
	public Date getFechaFinalTemporada() {
		return fechaFinalTemporada;
	}
	/**
	 * @param fechaFinalTemporada El campo fechaFinalTemporada a settear
	 */
	public void setFechaFinalTemporada(Date fechaFinalTemporada) {
		this.fechaFinalTemporada = fechaFinalTemporada;
	}
	/**
	 * @return El campo nombreLiga
	 */
	public String getNombreLiga() {
		return nombreLiga;
	}
	/**
	 * @param nombreLiga El campo nombreLiga a settear
	 */
	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}
	/**
	 * @return El campo boletaAlumno
	 */
	public Long getBoletaAlumno() {
		return boletaAlumno;
	}
	/**
	 * @param boletaAlumno El campo boletaAlumno a settear
	 */
	public void setBoletaAlumno(Long boletaAlumno) {
		this.boletaAlumno = boletaAlumno;
	}
	/**
	 * @return El campo nombrePila
	 */
	public String getNombrePila() {
		return nombrePila;
	}
	/**
	 * @param nombrePila El campo nombrePila a settear
	 */
	public void setNombrePila(String nombrePila) {
		this.nombrePila = nombrePila;
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

}
