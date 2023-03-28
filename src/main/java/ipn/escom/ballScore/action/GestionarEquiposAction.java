package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarEquiposBI;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarEquiposForm;
import ipn.escom.ballScore.form.GestionarEquiposVO;
import ipn.escom.ballScore.form.GestionarManagersForm;

/**Clase Action para gestionar los equipos
 * @author Cisneros Christian
 *
 */
public class GestionarEquiposAction extends BaseAction implements Preparable{

	private static final Logger logger = LogManager.getLogger();
	
	private static final long serialVersionUID = 1L;
	private GestionarEquiposForm equipoForm;
	public long idLiderEquipo;
	public String correo_manager;
	public GestionarEquiposBI equiposBI;
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarEquiposAction.registrarEquipo()");
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		Manager sessionManager= (Manager) session.getAttribute("Usuario");
		this.idLiderEquipo=sessionManager.getIdManager();
		this.correo_manager=sessionManager.getCorreo();
		this.equiposBI = new GestionarEquiposBI();
	
    }
	
	/**Metodo para presentar la pantalla de formulario
	 * @return Action Result
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarEquipoAction.mostrarFormulario()");
		equipoForm = new GestionarEquiposForm();
		return Action.SUCCESS;
	}
	
	public String editarEquipo() {
		logger.info("Inicia metodo GestionarEquipoAction.editarEquipo()");
		return Action.SUCCESS;
	}
	
	public String registrarEquipo() {
		logger.info("Inicia metodo GestionarEquiposAction.registrarEquipo");
		boolean comprobacion= this.equiposBI.verificarExistencia(this.idLiderEquipo);
		if(comprobacion) {
			equipoForm = new GestionarEquiposForm();
			return Action.INPUT;
		}else {
			return Action.SUCCESS;
		}
	}
	
	/**Metodo controlador para registrar un equipo
	 * @return Action Result
	 */
	public String registro() {
		logger.info("Inicia metodo GestionarManagersAction.registro()");
		GestionarEquiposVO vo = new GestionarEquiposVO();

		try {
			BeanUtils.copyProperties(vo,equipoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			return Action.SUCCESS;
		}
		Long idEquipo;
		try {
			idEquipo = this.equiposBI.registrarEquipo(vo, correo_manager);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		equipoForm.setIdManager(idEquipo);
		addActionMessage("Usuario registrado con exito: idManager: "+idEquipo);
		
		return Action.SUCCESS;
	}
	
	//Inician Metodos getters y setters

	public GestionarEquiposForm getManagerForm() {
		return equipoForm;
	}

	public void setEquipoForm(GestionarEquiposForm equipoForm) {
		this.equipoForm = equipoForm;
	}
}


