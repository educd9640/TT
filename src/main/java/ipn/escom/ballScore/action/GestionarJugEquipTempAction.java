package ipn.escom.ballScore.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarJugEquipoTempBI;
import ipn.escom.ballScore.business.GestionarTemporadasBI;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarJugEquipTempForm;

/**Clase Action para la gestion de jugadores equipo temporada
 * @author Jose Mauricio
 *
 */
public class GestionarJugEquipTempAction extends BaseAction{
	

	private static final long serialVersionUID = 1L;
	private GestionarJugEquipTempForm form;
	
	/**Metodo para presentar pantalla de registro de jugadores
	 * @return
	 */
	public String presentarRegistroJugadores() {
		GestionarJugEquipoTempBI bi = new GestionarJugEquipoTempBI();
		GestionarTemporadasBI biTemp = new GestionarTemporadasBI();
		try {
			form.setJugadoresTemporada(bi.consultarJugadoresRegistrados(form.getIdEquipo(), form.getIdTemporada()));
			form.setTemporada(biTemp.buscarTemporadaPorId(form.getIdTemporada()));
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de consulta de temporadas donde el manager tuviera registrados equipos (tabla EQUIPO_TEMPORADA)
	 * @return
	 */
	public String presentarTemporadas() {
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
	
	//Inician getters y setters

	public GestionarJugEquipTempForm getForm() {
		return form;
	}

	public void setForm(GestionarJugEquipTempForm form) {
		this.form = form;
	}

}
