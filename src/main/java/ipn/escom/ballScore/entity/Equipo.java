package ipn.escom.ballScore.entity;

import java.sql.Date;

public class Equipo {
	
	private Long idEquipo;
	private String nombre;
	private Date fechaAlta;
	private Manager manager;
	
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
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
