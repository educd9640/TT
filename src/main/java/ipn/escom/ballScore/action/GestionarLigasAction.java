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
import ipn.escom.ballScore.entity.Liga;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.LigaForm;
import ipn.escom.ballScore.form.LigaVO;

/**Clase Action para gestionar Ligas
 * @author Eduardo Callejas
 *
 */
public class GestionarLigasAction extends BaseAction implements Preparable {
	
	
	private static final Logger logger = LogManager.getLogger();

	private static final long serialVersionUID = 1L;
	
	private LigaForm ligaF;
	private String operacion;
	private List<Liga> ligasRegistradas = new ArrayList<Liga>();
	
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
	public void prepare() {
		logger.info("Inicia metodo GestionarLigasAction.prepare()");
		GestionarLigasBI ligaBI = new GestionarLigasBI();
		try {
			this.ligasRegistradas = ligaBI.obtenerLigasRegistradas() ;
		} catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		
		if(ligaF!=null && operacion!=null && ligaF.getIdLiga()!=null) {
			if(operacion.equals("actualizado")) {
				try {
					Liga liga = ligaBI.buscarLigaPorId(ligaF.getIdLiga());
					BeanUtils.copyProperties(ligaF, liga);
				}catch(IllegalAccessException | InvocationTargetException e){
					logger.error("Error al copiar las propiedades de la liga al form",e);
					addActionError("Error al recuperar datos de la Liga");
				}catch(BussinessException e){
					logger.error("Error al consultar la Liga");
					addActionError("Error al recuperar datos de la Liga");
				}
			}
		}
		
	}
	
	
	
	
	/**Metodo controlador para registrar ligas
	 * @return Action Result
	 */
	public String registrarLiga() {
		
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
		
		try {
			new GestionarLigasBI().crearLiga(ligaVO, operacion);
		}catch(BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
	
		
		addActionMessage("Liga " + ligaVO.getNombre() +" "+ operacion + " con exito");
		
		return Action.SUCCESS;
	}
	
	
	
	/**Metodo controlador para activar/desactivar una liga
	 * @return Action Result
	 */
	@SkipValidation
	public String estadoLiga() {
		logger.info("Inicia metodo GestionarAlumnosAction.estadoLiga()");
		LigaVO ligaVO = new LigaVO();
		try {
			BeanUtils.copyProperties(ligaVO, ligaF);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			ligaF = new LigaForm();
			return Action.SUCCESS;
		}
		
		try {
			new GestionarLigasBI().estadoLiga(ligaVO.getIdLiga());
		}catch(BussinessException e) {
			addActionError("Error al registrarse.");
			ligaF = new LigaForm();
			return Action.SUCCESS;
		}
		
		addActionMessage("Liga " + ligaVO.getIdLiga() +" activada/desactivada con exito");
		this.prepare();
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de formulario
	 * @return pantalla de formulario
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarFormulario()");

		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados
	 * @return pantalla de ligas registradas
	 */
	public String mostrarRegistrados() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarRegistrados()");
		return Action.SUCCESS;
	}

	/**
	 * @return El campo ligaF
	 */
	public LigaForm getLigaF() {
		return ligaF;
	}

	/**
	 * @param ligaF El campo ligaF a settear
	 */
	public void setLigaF(LigaForm ligaF) {
		this.ligaF = ligaF;
	}

	/**
	 * @return El campo operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion El campo operacion a settear
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return El campo ligasRegistradas
	 */
	public List<Liga> getLigasRegistradas() {
		return ligasRegistradas;
	}

	/**
	 * @param ligasRegistradas El campo ligasRegistradas a settear
	 */
	public void setLigasRegistradas(List<Liga> ligasRegistradas) {
		this.ligasRegistradas = ligasRegistradas;
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
