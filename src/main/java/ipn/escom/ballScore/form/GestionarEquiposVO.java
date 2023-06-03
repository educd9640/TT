package ipn.escom.ballScore.form;

import java.io.Serializable;
import java.sql.Date;


/**VO para gestionar equipos
 * @author Chris
 *
 */
public class GestionarEquiposVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idEquipo;
	private Long idManager;
	private String nombre;
	private Date fechaAlta;
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
	 * @return El campo idManager
	 */
	public Long getIdManager() {
		return idManager;
	}
	/**
	 * @param idManager El campo idManager a settear
	 */
	public void setIdManager(Long idManager) {
		this.idManager = idManager;
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
	
}
