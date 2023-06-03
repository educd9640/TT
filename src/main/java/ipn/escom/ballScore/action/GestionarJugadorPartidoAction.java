package ipn.escom.ballScore.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarEquipoTemporadaBI;
import ipn.escom.ballScore.business.GestionarJugadorPartidoBI;
import ipn.escom.ballScore.business.GestionarJugadoresBI;
import ipn.escom.ballScore.business.GestionarPartidosBI;
import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugadorPartidoForm;

/**Clase Action para la gestion de jugadores de partido
 * @author Jose Mauricio
 *
 */
public class GestionarJugadorPartidoAction extends BaseAction{
	
	
	private static final Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private GestionarJugadorPartidoForm form;
	private Partido partido;
	private EquipoTemporada equipoTemporada;
	private Long sessionManagerId;
	private List<String> posiciones;
	
	/**Metodo Action para registrar jugadores
	 * @return pantalla para registrar jugadores
	 */
	public String registrarJugadores() {
		logger.info("Inicia metodo GestionarJugadorPartidoAction.registrarJugadores()");
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
	
	/**Metodo Action para consultar los jugadores de un partido
	 * @return Pantalla de jugadores del partido
	 */
	public String consultarJugadoresPartido() {
		logger.info("Inicia metodo GestionarJugadorPartidoAction.consultarJugadoresPartido()");
		GestionarJugadorPartidoBI bi = new GestionarJugadorPartidoBI();
		GestionarPartidosBI biPartido = new GestionarPartidosBI();
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		GestionarEquipoTemporadaBI equipoBI = new GestionarEquipoTemporadaBI();
		this.posiciones= jugadoresBI.obtenerPosiciones();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		sessionManagerId = ((Manager) session.getAttribute("Usuario")).getIdManager();
		try {
			this.partido = biPartido.obtenerPartidosRegistradosByIdPartido(form.getIdPartido()).get(0);
			this.equipoTemporada = equipoBI.consultarEquipoTemporada(form.getIdEquipo(), form.getIdTemporada());
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
	
	/**Metodo Action para consultar los jugadores no inscritos en un partido
	 * @return pantalla de jugadores no inscritos en el partido
	 */
	public String consultarJugadoresNoInscritos() {
		logger.info("Inicia metodo GestionarJugadorPartidoAction.consultarJugadoresNoInscritos()");
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

	/**
	 * @return El campo form
	 */
	public GestionarJugadorPartidoForm getForm() {
		return form;
	}

	/**
	 * @param form El campo form a settear
	 */
	public void setForm(GestionarJugadorPartidoForm form) {
		this.form = form;
	}

	/**
	 * @return El campo partido
	 */
	public Partido getPartido() {
		return partido;
	}

	/**
	 * @param partido El campo partido a settear
	 */
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	/**
	 * @return El campo equipoTemporada
	 */
	public EquipoTemporada getEquipoTemporada() {
		return equipoTemporada;
	}

	/**
	 * @param equipoTemporada El campo equipoTemporada a settear
	 */
	public void setEquipoTemporada(EquipoTemporada equipoTemporada) {
		this.equipoTemporada = equipoTemporada;
	}

	/**
	 * @return El campo sessionManagerId
	 */
	public Long getSessionManagerId() {
		return sessionManagerId;
	}

	/**
	 * @param sessionManagerId El campo sessionManagerId a settear
	 */
	public void setSessionManagerId(Long sessionManagerId) {
		this.sessionManagerId = sessionManagerId;
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
