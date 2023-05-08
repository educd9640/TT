package ipn.escom.ballScore.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarJugadorPartidoBI;
import ipn.escom.ballScore.business.GestionarJugadoresBI;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugadorPartidoForm;

public class GestionarJugadorPartidoAction extends BaseAction{
	
	
	private static final Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private GestionarJugadorPartidoForm form;
	private List<String> posiciones;
	
	public String registrarJugadores() {
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoBI bi = new GestionarJugadorPartidoBI();
		
		try {
			if(form.getJugadoresARegistrar()!=null && form.getJugadoresARegistrar()!="")
				bi.registrarJugadoresPartido(form.getIdPartido(), form.getIdEquipo(), form.getIdTemporada(), form.getJugadoresARegistrar().split("_"), "");
		} catch (BussinessException e) {
			logger.error("Error al registrar jugadores del partido", e);
			addActionError("Error al registrar jugadores del partido " +e.getMessage());
		}
		
		return this.consultarJugadoresPartido();
	}
	
	public String consultarJugadoresPartido() {
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoBI bi = new GestionarJugadorPartidoBI();
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		this.posiciones= jugadoresBI.obtenerPosiciones();
		try {
			if(form.getBoletaAlumno()!=null) {
				this.form.setJugadoresPartido(bi.consultarJugadoresPartidoByBoleta(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getBoletaAlumno()));
			}else if(form.getNombrePila()!=null && !form.getNombrePila().equals("")) {
				this.form.setJugadoresPartido(bi.consultarJugadoresPartidoLikeNombrePila(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getNombrePila()));
			}else if(form.getPosicionPrim()!=null && !form.getPosicionPrim().equals("")) {
				this.form.setJugadoresPartido(bi.consultarJugadoresPartidoByPosicionPrim(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getPosicionPrim()));
			}else if(form.getPosicionSec()!= null && !form.getPosicionSec().equals("")){
				this.form.setJugadoresPartido(bi.consultarJugadoresPartidoByPosicionSec(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getPosicionSec()));
			}else {
				this.form.setJugadoresPartido(bi.consultarJugadoresPartido(form.getIdPartido(), form.getIdEquipo(), form.getIdTemporada()));
			}
		} catch (BussinessException e) {
			logger.error("Error al consultar jugadores del partido", e);
			addActionError("Error al consultar jugadores del partido " +e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	public String consultarJugadoresNoInscritos() {
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		this.posiciones= jugadoresBI.obtenerPosiciones();
		GestionarJugadorPartidoBI bi = new GestionarJugadorPartidoBI();
		
		try {
			if(form.getBoletaAlumno()!=null) {
				this.form.setJugadoresEquipoTemp(bi.consultarJugadoresEquipoTempNoInscritosByBoleta(form.getIdEquipo(), form.getIdTemporada(), form.getIdPartido(), form.getBoletaAlumno()));
			}else if(form.getNombrePila()!=null && !form.getNombrePila().equals("")) {
				this.form.setJugadoresEquipoTemp(bi.consultarJugadoresEquipoTempNoInscritosLikeNombrePila(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getNombrePila()));
			}else if(form.getPosicionPrim()!=null && !form.getPosicionPrim().equals("")) {
				this.form.setJugadoresEquipoTemp(bi.consultarJugadoresEquipoTempNoInscritosByPosicionPrim(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getPosicionPrim()));
			}else if(form.getPosicionSec()!= null && !form.getPosicionSec().equals("")){
				this.form.setJugadoresEquipoTemp(bi.consultarJugadoresEquipoTempNoInscritosByPosicionSec(form.getIdPartido(),form.getIdEquipo(), form.getIdTemporada(), form.getPosicionSec()));
			}else {
				this.form.setJugadoresEquipoTemp(bi.consultarJugadoresEquipoTempNoInscritos(form.getIdEquipo(), form.getIdTemporada(), form.getIdPartido()));
			}

		} catch (BussinessException e) {
			logger.error("Error al consultar jugadores del partido", e);
			addActionError("Error al consultar jugadores del partido " +e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	public String presentarRegistroResultados() {
		
		return Action.SUCCESS;
	}
	
	public GestionarJugadorPartidoForm getForm() {
		return form;
	}
	public void setForm(GestionarJugadorPartidoForm form) {
		this.form = form;
	}

	public List<String> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<String> posiciones) {
		this.posiciones = posiciones;
	}
	
	

}
