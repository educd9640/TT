package ipn.escom.ballScore.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarEquipoTemporadaBI;
import ipn.escom.ballScore.business.GestionarJugEquipoTempBI;
import ipn.escom.ballScore.business.GestionarJugadoresBI;
import ipn.escom.ballScore.business.GestionarTemporadasBI;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugEquipTempForm;

/**Clase Action para la gestion de jugadores equipo temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugEquipTempAction extends BaseAction{
	
	private static final Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private GestionarJugEquipTempForm form;
	private List<String> posiciones;
	
	/**Metodo para presentar pantalla de registro de jugadores
	 * @return pantalla de registro de jugadores
	 */
	public String presentarRegistroJugadores() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.presentarRegistroJugadores()");
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		GestionarTemporadasBI biTemp = new GestionarTemporadasBI();
		this.posiciones= jugadoresBI.obtenerPosiciones();
		try {
			
			form.setTemporada(biTemp.buscarTemporadaPorId(form.getIdTemporada()));
			
			if(form.getBoletaAlumno()!=null) {
				form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada(), form.getBoletaAlumno()));
			}else if(form.getNombrePila()!=null && !form.getNombrePila().equals("")) {
				form.setJugadoresTemporada(bi.consultarJugadoresRegistradosLikeNombrePila(form.getIdEquipo(), form.getIdTemporada(), form.getNombrePila()));
			}else if(form.getPosicionPrim()!=null && !form.getPosicionPrim().equals("")) {
				form.setJugadoresTemporada(bi.consultarJugadoresRegistradosByPosicionPrim(form.getIdEquipo(), form.getIdTemporada(), form.getPosicionPrim()));
			}else if(form.getPosicionSec()!= null && !form.getPosicionSec().equals("")){
				form.setJugadoresTemporada(bi.consultarJugadoresRegistradosByPosicionSec(form.getIdEquipo(), form.getIdTemporada(), form.getPosicionSec()));
			}else {
				form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada()));
			}
			
			if(form.getJugadoresARegistrar()!=null && !form.getJugadoresARegistrar().equals("")) {
				this.registrarJugadores();
				form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada()));
				form.setJugadoresARegistrar("");
			}
			
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de consulta de temporadas donde el manager tuviera registrados equipos (tabla EQUIPO_TEMPORADA)
	 * @return pantalla de temporadas
	 */
	public String presentarTemporadas() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.presentarTemporadas()");
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		Manager sessionManager = (Manager) session.getAttribute("Usuario");
		if(form==null) {
			form = new GestionarJugEquipTempForm();
		}
		try {
			if(form.getNombreLiga()!=null && !form.getNombreLiga().equals("") && form.getFechaFinalTemporada()!=null && form.getFechaInicialTemporada()!=null) {
				form.setEquiposTemporada(bi.consultarEquiposTemporadaDeManager(sessionManager.getIdManager(), form.getNombreLiga(),new Date(form.getFechaInicialTemporada().getTime()),
						new Date(form.getFechaFinalTemporada().getTime())));
			}else if(form.getFechaFinalTemporada()!=null && form.getFechaInicialTemporada()!=null){
				form.setEquiposTemporada(bi.consultarEquiposTemporadaDeManager(sessionManager.getIdManager(),new Date(form.getFechaInicialTemporada().getTime()),
						new Date(form.getFechaFinalTemporada().getTime())));
			}else if(form.getNombreLiga()!=null && !form.getNombreLiga().equals("")) {
				form.setEquiposTemporada(bi.consultarEquiposTemporadaDeManager(sessionManager.getIdManager(),form.getNombreLiga()));
			}
			form.setEquiposTemporada(bi.consultarEquiposTemporadaDeManager(sessionManager.getIdManager()));
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	/**Metodo action para presentar pantalla modal donde se seleccionan los jugadores a registrar en un equipo
	 * de temporada
	 * @return Pantalla modal
	 */
	public String presentaModalRegistroJugador() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.presentaModalRegistroJugador()");
		GestionarJugadoresBI biJugadores = new GestionarJugadoresBI();
		this.posiciones= biJugadores.obtenerPosiciones();
		try {
			
			if(form.getBoletaAlumno()!=null) {
				form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistradosByBoleta(form.getIdEquipo(),form.getIdTemporada(), form.getBoletaAlumno()));
			}else if(form.getNombrePila()!=null && !form.getNombrePila().equals("")) {
				form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistradosLikeNombrePila(form.getIdEquipo(), form.getIdTemporada(), form.getNombrePila()));
			}else if(form.getPosicionPrim()!=null && !form.getPosicionPrim().equals("")) {
				form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistradosByPosicionPrim(form.getIdEquipo(), form.getIdTemporada(), form.getPosicionPrim()));
			}else if(form.getPosicionSec()!= null && !form.getPosicionSec().equals("")){
				form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistradosByPosicionSec(form.getIdEquipo(), form.getIdTemporada(), form.getPosicionSec()));
			}else {
				form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistrados(form.getIdEquipo(),form.getIdTemporada()));
			}
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	/**Metodo Action para alternar el estado de un jugador
	 * @return pantalla de registro de jugadores
	 */
	public String alternaEstadoJugador() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.alternaEstadoJugador()");
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		
		try {
			bi.alternarEstadoJugador(form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		return this.presentarRegistroJugadores();
	}
	
	/**
	 * Metodo para registrar jugadores
	 */
	public void registrarJugadores() {
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		try {
			bi.registrarJugadores(form.getJugadoresARegistrar().split("_"), form.getIdEquipo(), form.getIdTemporada());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
	}
	
	/**Metodo para alternar estado de un equipo de temporada
	 * @return pantalla de presentar temporadas
	 */
	public String alternarEstadoEquipoTemp() {
		GestionarEquipoTemporadaBI bi = new GestionarEquipoTemporadaBI();
		try {
			bi.alternarEstadoEquipoTemp(form.getIdTemporada(), form.getIdEquipo());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return this.presentarTemporadas();
	}

	/**
	 * @return El campo form
	 */
	public GestionarJugEquipTempForm getForm() {
		return form;
	}

	/**
	 * @param form El campo form a settear
	 */
	public void setForm(GestionarJugEquipTempForm form) {
		this.form = form;
	}

	/**
	 * @return El campo posiciones
	 */
	public List<String> getPosiciones() {
		return posiciones;
	}

	/**
	 * @param posiciones El campo posiciones a settear
	 */
	public void setPosiciones(List<String> posiciones) {
		this.posiciones = posiciones;
	}

	/**
	 * @return El campo logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return El campo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
