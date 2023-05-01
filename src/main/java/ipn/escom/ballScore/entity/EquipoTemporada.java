package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

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
	
	
}
