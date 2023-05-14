package ipn.escom.ballScore.form;

import java.util.List;

import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.entity.JugadorPartido;

public class GestionarJugadorPartidoForm {
	
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
	public List<JugadorPartido> getJugadoresPartido() {
		return jugadoresPartido;
	}
	public void setJugadoresPartido(List<JugadorPartido> jugadoresPartido) {
		this.jugadoresPartido = jugadoresPartido;
	}
	public List<JugadorEquipoTemp> getJugadoresEquipoTemp() {
		return jugadoresEquipoTemp;
	}
	public void setJugadoresEquipoTemp(List<JugadorEquipoTemp> jugadoresEquipoTemp) {
		this.jugadoresEquipoTemp = jugadoresEquipoTemp;
	}
	public String getJugadoresARegistrar() {
		return jugadoresARegistrar;
	}
	public void setJugadoresARegistrar(String jugadoresARegistrar) {
		this.jugadoresARegistrar = jugadoresARegistrar;
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
