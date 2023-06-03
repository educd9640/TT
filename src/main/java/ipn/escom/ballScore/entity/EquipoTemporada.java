package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**Entidad de EquipoTemporada
 * @author Jose Mauricio
 *
 */
public class EquipoTemporada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idEquipo;
	private Long idTemporada;
	private Equipo equipo;
	private Temporada temporada;
	private Date fechaAlta;
	private Set<Partido> partidosLocal = new HashSet<Partido>();
	private Set<Partido> partidosVisitante = new HashSet<Partido>();
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
	 * @return El campo equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}
	/**
	 * @param equipo El campo equipo a settear
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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
	 * @return El campo partidosLocal
	 */
	public Set<Partido> getPartidosLocal() {
		return partidosLocal;
	}
	/**
	 * @param partidosLocal El campo partidosLocal a settear
	 */
	public void setPartidosLocal(Set<Partido> partidosLocal) {
		this.partidosLocal = partidosLocal;
	}
	/**
	 * @return El campo partidosVisitante
	 */
	public Set<Partido> getPartidosVisitante() {
		return partidosVisitante;
	}
	/**
	 * @param partidosVisitante El campo partidosVisitante a settear
	 */
	public void setPartidosVisitante(Set<Partido> partidosVisitante) {
		this.partidosVisitante = partidosVisitante;
	}
	/**
	 * @return El campo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
