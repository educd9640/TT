package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarManagersBI;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.form.GestionarManagersForm;
import ipn.escom.ballScore.form.GestionarManagersVO;

public class GestionarManagersAction extends BaseAction implements Preparable{

	private GestionarManagersForm managerForm;
	private List<Escuela> escuelas = new ArrayList<Escuela>();
	
	@Override
    public void prepare() throws Exception {
		this.escuelas = new GestionarManagersBI().obtenerEscuelas();
    }
	
	public String mostrarFormulario() {
		managerForm = new GestionarManagersForm();
		this.escuelas = new GestionarManagersBI().obtenerEscuelas();
		
		return "success";
	}
	
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
		return "success";
	}

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
