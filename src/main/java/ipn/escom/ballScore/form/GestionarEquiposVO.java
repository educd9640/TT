package ipn.escom.ballScore.form;

import java.sql.Date;


/**VO para gestionar equipos
 * @author Chris
 *
 */
public class GestionarEquiposVO {
	
	private Long idEquipo;
	private Long idManager;
	private String nombre;
	private Date fechaAlta;
	
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public Long getIdManager() {
		return idManager;
	}
	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
