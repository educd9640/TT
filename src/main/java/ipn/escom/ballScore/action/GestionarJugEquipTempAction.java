package ipn.escom.ballScore.action;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

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
	
	/**Metodo para presentar pantalla de registro de jugadores
	 * @return
	 */
	public String presentarRegistroJugadores() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.presentarRegistroJugadores()");
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		GestionarTemporadasBI biTemp = new GestionarTemporadasBI();
		try {
			form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada()));
			form.setTemporada(biTemp.buscarTemporadaPorId(form.getIdTemporada()));
			
			if(form.getJugadoresARegistrar()!=null) {
				this.registrarJugadores();
				form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada()));
			}
			
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de consulta de temporadas donde el manager tuviera registrados equipos (tabla EQUIPO_TEMPORADA)
	 * @return
	 */
	public String presentarTemporadas() {
		logger.info("Inicia metodo GestionarJugEquipTempAction.presentarTemporadas()");
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		Manager sessionManager = (Manager) session.getAttribute("Usuario");
		try {
			form = new GestionarJugEquipTempForm();
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
		try {
			form.setJugadoresEquipo(biJugadores.consultarJugadoresNoRegistrados(form.getIdEquipo(),form.getIdTemporada()));
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
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
	
	//Inician getters y setters

	public GestionarJugEquipTempForm getForm() {
		return form;
	}

	public void setForm(GestionarJugEquipTempForm form) {
		this.form = form;
	}

}
