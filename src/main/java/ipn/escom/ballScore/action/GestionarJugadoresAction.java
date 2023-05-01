package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarJugadoresBI;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.entity.Jugador;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugadoresForm;
import ipn.escom.ballScore.form.GestionarJugadoresVO;

public class GestionarJugadoresAction extends BaseAction implements Preparable{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger();
	private GestionarJugadoresForm jugadoresForm;
	private Escuela escuela;
	private Equipo equipo;
	private List<String> posiciones;
	private List<Jugador> jugadoresRegistrados;
	private String operacion;
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarJugadoresAction.prepare()");
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		Manager sessionManager = (Manager) session.getAttribute("Usuario");
		this.escuela = sessionManager.getEscuela();
		try {
			this.equipo = jugadoresBI.obtenerEquipoDelManager(sessionManager.getIdManager());
			if(operacion!=null && operacion.equals("actualizado")) {
				Jugador jugador = jugadoresBI.consultarJugador(jugadoresForm.getIdJugador());
				jugadoresForm.setAlumno(jugador.getAlumno());
				jugadoresForm.setPosicionPrim(jugador.getPosicionPrim());
				jugadoresForm.setPosicionSec(jugador.getPosicionSec());
			}
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		this.posiciones= jugadoresBI.obtenerPosiciones();
    }
	
	/**Metodo para presentar formulario de jugadores
	 * @return
	 */
	public String mostrarFormulario() {
		
		return Action.SUCCESS;
	}
	
	/**Metodo para registar a un jugador
	 * @return pantalla de registro
	 */
	public String registrarJugador() {
		logger.info("Inicia metodo GestionarJugadoresAction.prepare()");
		GestionarJugadoresVO vo = new GestionarJugadoresVO();
		Long idJugador;
		try {
			BeanUtils.copyProperties(vo,jugadoresForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrar jugador.");
			jugadoresForm = new GestionarJugadoresForm();
			return Action.SUCCESS;
		}
		
		try {
			if(vo.getIdJugador()==null)
				idJugador = new GestionarJugadoresBI().registrarJugador(vo, equipo);
			else
				idJugador = new GestionarJugadoresBI().actualizarJugador(vo);
				
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		
		if(vo.getIdJugador()!=null)
			addActionMessage("Jugador registrado con exito: "+ idJugador);
		else
			addActionMessage("Jugador modificado con exito: "+ idJugador);
		return Action.SUCCESS;
	}
	
	/**Metodo para consultar jugadores
	 * @return pantalla de consulta
	 */
	@SkipValidation
	public String consultarJugadores() {
		logger.info("Inicia metodo GestionarJugadoresAction.consultarJugadores()");
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		Manager sessionManager = (Manager) session.getAttribute("Usuario");
		GestionarJugadoresBI jugadoresBI = new GestionarJugadoresBI();
		this.escuela = sessionManager.getEscuela();
		try {
			this.equipo = jugadoresBI.obtenerEquipoDelManager(sessionManager.getIdManager());
			this.jugadoresRegistrados = jugadoresBI.consultarJugadoresEquipo(equipo.getIdEquipo());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	/**Metodo para alternar estado del jugador
	 * @return pantalla de consulta
	 */
	@SkipValidation
	public String alternarEstadoJugador() {
		logger.info("Inicia metodo GestionarJugadoresAction.alternarEstadoJugador()");
		try {
			new GestionarJugadoresBI().actualizarEstadoJugador(jugadoresForm.getIdJugador());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		this.prepare();
		this.consultarJugadores();
		return Action.SUCCESS;
	}
	
	//Inician getters y setters
	
	public GestionarJugadoresForm getJugadoresForm() {
		return jugadoresForm;
	}

	public void setJugadoresForm(GestionarJugadoresForm jugadoresForm) {
		this.jugadoresForm = jugadoresForm;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<String> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<String> posiciones) {
		this.posiciones = posiciones;
	}

	public List<Jugador> getJugadoresRegistrados() {
		return jugadoresRegistrados;
	}

	public void setJugadoresRegistrados(List<Jugador> jugadoresRegistrados) {
		this.jugadoresRegistrados = jugadoresRegistrados;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
}
