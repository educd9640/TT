package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarManagersBI;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarManagersForm;
import ipn.escom.ballScore.form.GestionarManagersVO;

/**Clase Action para gestionar los managers
 * @author Jose Mauricio
 *
 */
public class GestionarManagersAction extends BaseAction implements Preparable{

	private static final Logger logger = LogManager.getLogger();
	
	private static final long serialVersionUID = 1L;
	private GestionarManagersForm managerForm;
	private List<Escuela> escuelas = new ArrayList<Escuela>();
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarManagersAction.registrarAlumno()");
		GestionarManagersBI managersBI = new GestionarManagersBI();
		try {
			this.escuelas = managersBI.obtenerEscuelas();
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
    }
	
	/**Metodo para presentar la pantalla de formulario
	 * @return Action Result
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarManagersAction.mostrarFormulario()");
		managerForm = new GestionarManagersForm();
		GestionarManagersBI managersBI = new GestionarManagersBI();
		try {
			this.escuelas = managersBI.obtenerEscuelas();
		} catch (BussinessException e) {
			addActionError("Error al obtener las escuelas en alta");
		}
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar un manager
	 * @return Action Result
	 */
	public String registro() {
		logger.info("Inicia metodo GestionarManagersAction.registro()");
		GestionarManagersVO vo = new GestionarManagersVO();

		try {
			BeanUtils.copyProperties(vo,managerForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			return Action.SUCCESS;
		}
		Long idManager;
		try {
			idManager = new GestionarManagersBI().registrarManager(vo);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		managerForm.setIdManager(idManager);
		addActionMessage("Usuario registrado con exito: idManager: "+idManager+" Login: "+managerForm.getCorreo());
		
		return Action.SUCCESS;
	}

	/**
	 * @return El campo managerForm
	 */
	public GestionarManagersForm getManagerForm() {
		return managerForm;
	}

	/**
	 * @param managerForm El campo managerForm a settear
	 */
	public void setManagerForm(GestionarManagersForm managerForm) {
		this.managerForm = managerForm;
	}

	/**
	 * @return El campo escuelas
	 */
	public List<Escuela> getEscuelas() {
		return escuelas;
	}

	/**
	 * @param escuelas El campo escuelas a settear
	 */
	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
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
