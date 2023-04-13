package ipn.escom.ballScore.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarJugadoresBI;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugadoresForm;

public class GestionarJugadoresAction extends BaseAction implements Preparable{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger();
	private GestionarJugadoresForm jugadoresForm;
	private Escuela escuela;
	private Equipo equipo;
	private List<String> posiciones;
	//private List<Equipo> equiposManager;
	
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
		} catch (BussinessException e) {
			//addActionError(e.getMessage());
		}
		this.posiciones= jugadoresBI.obtenerPosiciones();
    }
	
	/**Metodo para presentar formulario de jugadores
	 * @return
	 */
	public String mostrarFormulario() {
		
		return Action.SUCCESS;
	}
	
	public String registrarJugador() {
		logger.info("Inicia metodo GestionarJugadoresAction.prepare()");
		
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
	
}
