package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.*;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarEquiposBI;
import ipn.escom.ballScore.entity.Equipo;
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
	private Manager managerActual;
	private Equipo equipoManager;
	private String operacion;
	private List<Equipo> equiposRegistrados = new ArrayList<Equipo>();
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarEquiposAction.registrarEquipo()");
		GestionarEquiposBI equipoBI= new GestionarEquiposBI();
		equipoForm= new GestionarEquiposForm();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		this.managerActual= (Manager) session.getAttribute("Usuario");
		try {
			equiposRegistrados= equipoBI.obtenerEquiposRegistrados();
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		if(operacion !=null && operacion.equals("actualizado")) {
			try {
				Equipo team = equipoBI.obtenerEquipo(this.managerActual.getIdManager());
				BeanUtils.copyProperties(equipoForm,team);
			} catch (IllegalAccessException | InvocationTargetException e) {
				logger.error("Error al copiar las propiedades del alumno al form.", e);
			} catch (BussinessException e) {
				logger.error("Error al consultar el equipo", e);
			}
		}
		
	
    }
	
	/**Metodo para presentar la pantalla de formulario
	 * @return Action Result
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarEquipoAction.mostrarFormulario()");
		equipoForm = new GestionarEquiposForm();
		return Action.SUCCESS;
	}
	
	/**Metodo para redirigir a la pantalla de editar Equipo
	 * @return Action Result
	 */
	
	public String editarEquipo() {
		logger.info("Inicia metodo GestionarEquipoAction.editarEquipo()");
		return Action.SUCCESS;
	}
	
	/**Metodo para redirigir a la pantalla de 
	 * @return Action Result
	 */
	
	public String registrarEquipo() {
		logger.info("Inicia metodo GestionarEquiposAction.registrarEquipo");
		equipoForm= new GestionarEquiposForm();
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar un equipo
	 * @return Action Result
	 */
	public String registroEquipo() {
		logger.info("Inicia metodo GestionarManagersAction.registro()");
		GestionarEquiposBI equiposBI= new GestionarEquiposBI();
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
			equipoManager = equiposBI.registrarEquipo(vo, this.managerActual.getCorreo(),this.operacion);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		equipoForm.setIdManager(equipoManager.getIdEquipo());
		addActionMessage("Equipo registrado con exito: idEquipo: "+equipoForm.getIdEquipo());
		
		return Action.SUCCESS;
	}
	
	/**Metodo para visualizar la pantalla de consultarEquipo
	 * @return Action Result
	 */
	@SkipValidation
	public String buscarEquipo() {
		logger.info("Inicia metodo GestionarEquiposAction.actualizarEquipo()");
		return Action.SUCCESS;
	}
	
	
	/**Metodo controlador para verificar si el manager cuenta con un equipo
	 * @return Action Result
	 */
	@SkipValidation
	public String actualizarEquipo(){
		logger.info("Inicia metodo GestionarEquiposAction.actualizarEquipo()");
		equipoForm= new GestionarEquiposForm();
		GestionarEquiposBI equiposBI= new GestionarEquiposBI();
		String mensaje="";
		try {
			mensaje=equiposBI.buscarEquipo(this.managerActual.getIdManager());
			addActionMessage(mensaje);
		}catch(BussinessException e) {
			addActionError(e.getMessage());
			this.setOperacion("actualizado");
		}
		return Action.SUCCESS;
	}
	
	
	/**Metodo controlador para activar o desactivar un equipo
	 * @return Action Result
	 */
	@SkipValidation
	public String modificarEstatus() {
		logger.info("Inicia metodo GestionarEquiposAction.modificarEstatus()");
		GestionarEquiposBI equipoBI= new GestionarEquiposBI();
		Equipo equipoActual = new Equipo();
		String mensaje="";
		try {
			equipoActual=equipoBI.obtenerEquipo(this.managerActual.getIdManager());
				try{
					mensaje=equipoBI.cambiarEstatus(equipoActual);
					addActionMessage(mensaje);
				}catch(BussinessException e) {
					addActionError(e.getMessage());
				}
		}catch(BussinessException e) {
			addActionError(""+e.getMessage()+", por el momento esta opcion no esta disponible.");
			return Action.INPUT;
		}
		
		return Action.SUCCESS;
	}
	
	//Inician Metodos getters y setters

	public GestionarEquiposForm getEquipoForm() {
		return equipoForm;
	}

	public void setEquipoForm(GestionarEquiposForm equipoForm) {
		this.equipoForm = equipoForm;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
}


