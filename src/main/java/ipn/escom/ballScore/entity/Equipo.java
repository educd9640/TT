package ipn.escom.ballScore.entity;

import java.io.Serializable;
import java.sql.Date;

/**Entidad de equipo
 * @author Jose Mauricio
 *
 */
public class Equipo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idEquipo;
	private String nombre;
	private Date fechaAlta;
	private Manager manager;
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
	 * @return El campo nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre El campo nombre a settear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return El campo manager
	 */
	public Manager getManager() {
		return manager;
	}
	/**
	 * @param manager El campo manager a settear
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
}
