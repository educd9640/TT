package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**Clase entidad para la tabla EQUIPO_TEMPORADA
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
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Temporada getTemporada() {
		return temporada;
	}
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Set<Partido> getPartidosLocal() {
		return partidosLocal;
	}
	public void setPartidosLocal(Set<Partido> partidosLocal) {
		this.partidosLocal = partidosLocal;
	}
	public Set<Partido> getPartidosVisitante() {
		return partidosVisitante;
	}
	public void setPartidosVisitante(Set<Partido> partidosVisitante) {
		this.partidosVisitante = partidosVisitante;
	}
	
}
