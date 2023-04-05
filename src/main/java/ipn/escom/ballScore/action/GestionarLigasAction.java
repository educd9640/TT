package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarLigasBI;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.LigaForm;
import ipn.escom.ballScore.form.LigaVO;

public class GestionarLigasAction extends BaseAction implements Preparable {
	
	
	private static final Logger logger = LogManager.getLogger();

	private static final long serialVersionUID = 1L;
	
	private LigaForm ligaF;
	private String operacion;
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Inicia metodo GestionarLigasAction.prepare()");
		
		GestionarLigasBI ligaBI = new GestionarLigasBI();
	}
	
	
	
	
	public String crearLiga() {
		
		logger.info("Inicia metodo GestionarLigasAction.crearLiga()");
		
		LigaVO ligaVO = new LigaVO();
		try {
			BeanUtils.copyProperties(ligaVO, ligaF);
		}catch(IllegalAccessException | InvocationTargetException e){
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al crear liga.");
			ligaF = new LigaForm();
			return Action.SUCCESS;
		}
		if(ligaF != null  && operacion!=null) {
			try {
				new GestionarLigasBI().crearLiga(ligaVO, operacion);
			}catch(BussinessException e) {
				addActionError(e.getMessage());
				return Action.SUCCESS;
			}
		}
		
		addActionMessage("Liga " + ligaVO.getNombre() +" "+ operacion + " con exito");
		
		return Action.SUCCESS;
	}
	
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarFormulario()");

		return Action.SUCCESS;
	}


	
	
	
	public LigaForm getLigaF() {
		return ligaF;
	}

	public String getOperacion() {
		return operacion;
	}
	
	
	
	public void setLigaF(LigaForm ligaF) {
		this.ligaF = ligaF;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	

}
