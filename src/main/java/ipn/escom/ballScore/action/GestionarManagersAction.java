package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarManagersBI;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.form.GestionarManagersForm;
import ipn.escom.ballScore.form.GestionarManagersVO;

/**Clase Action para gestionar los managers
 * @author Jose Mauricio
 *
 */
public class GestionarManagersAction extends BaseAction implements Preparable{

	private static final long serialVersionUID = 1L;
	private GestionarManagersForm managerForm;
	private List<Escuela> escuelas = new ArrayList<Escuela>();
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare() throws Exception {
		GestionarManagersBI managersBI = new GestionarManagersBI();
		this.escuelas = managersBI.obtenerEscuelas();
    }
	
	/**Metodo para presentar la pantalla de formulario
	 * @return Action Result
	 */
	public String mostrarFormulario() {
		managerForm = new GestionarManagersForm();
		GestionarManagersBI managersBI = new GestionarManagersBI();
		this.escuelas = managersBI.obtenerEscuelas();
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar un manager
	 * @return Action Result
	 */
	public String registro() {
		GestionarManagersVO vo = new GestionarManagersVO();

		try {
			BeanUtils.copyProperties(vo,managerForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long idManager = new GestionarManagersBI().registrarManager(vo);
		if(idManager!=-1L) {
			managerForm.setIdManager(idManager);
			addActionMessage("Usuario registrado con exito: idManager: "+idManager+" Login: "+managerForm.getCorreo());
		}
		else
			addActionError("Error al registrar: Ya existe un manager registrado con ese correo electronico");
		return Action.SUCCESS;
	}
	
	//Inician Metodos getters y setters

	public GestionarManagersForm getManagerForm() {
		return managerForm;
	}

	public void setManagerForm(GestionarManagersForm managerForm) {
		this.managerForm = managerForm;
	}

	public List<Escuela> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

}
