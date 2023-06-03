package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.util.List;

import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.entity.JugadorPartido;

/**Form para gestionar jugadores del partido
 * @author Jose Mauricio
 *
 */
public class GestionarJugadorPartidoForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idJugador;
	private Long idPartido;
	private Long idEquipo;
	private Long idTemporada;
	private String jugadoresARegistrar;
	
	private List<JugadorPartido> jugadoresPartido;
	private List<JugadorEquipoTemp> jugadoresEquipoTemp;
	
	private Long boletaAlumno;
	private String nombrePila;
	private String posicionPrim;
	private String posicionSec;
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
	 * @return El campo jugadoresPartido
	 */
	public List<JugadorPartido> getJugadoresPartido() {
		return jugadoresPartido;
	}
	/**
	 * @param jugadoresPartido El campo jugadoresPartido a settear
	 */
	public void setJugadoresPartido(List<JugadorPartido> jugadoresPartido) {
		this.jugadoresPartido = jugadoresPartido;
	}
	/**
	 * @return El campo jugadoresEquipoTemp
	 */
	public List<JugadorEquipoTemp> getJugadoresEquipoTemp() {
		return jugadoresEquipoTemp;
	}
	/**
	 * @param jugadoresEquipoTemp El campo jugadoresEquipoTemp a settear
	 */
	public void setJugadoresEquipoTemp(List<JugadorEquipoTemp> jugadoresEquipoTemp) {
		this.jugadoresEquipoTemp = jugadoresEquipoTemp;
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
