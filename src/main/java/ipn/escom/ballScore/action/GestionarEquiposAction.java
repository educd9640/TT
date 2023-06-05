package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
	private Long idTemporada;
	private Long equipoL;
	private String accion;
	private Long temporadaElegida;

	private List<Equipo> equiposRegistrados = new ArrayList<Equipo>();
	private List<Equipo> equiposTemporadaRegistrados = new ArrayList<Equipo>();

	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarEquiposAction.registrarEquipo()");
		GestionarEquiposBI equipoBI= new GestionarEquiposBI();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		this.managerActual= (Manager) session.getAttribute("Usuario");
		
		
		try {
			if(idTemporada != null && equipoForm!=null && equipoForm.getIdEquipo()!=null) {
				this.equiposTemporadaRegistrados.add(equipoBI.buscarEquipoTemporadaPorId(equipoForm.getIdEquipo(), idTemporada, equipoL));
			}else if(idTemporada != null && equipoForm!=null && equipoForm.getNombre()!=null && !equipoForm.getNombre().equals("")) {
				this.equiposTemporadaRegistrados = equipoBI.buscarEquipoTemporadaPorNombre(equipoForm.getNombre(), idTemporada, equipoL);
			}else {
				this.equiposTemporadaRegistrados = equipoBI.obtenerEquiposTemporadaRegistrados(idTemporada, equipoL);
			}
			
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		
		equipoForm= new GestionarEquiposForm();
		if(temporadaElegida!=null) {	
			try {
				equiposRegistrados= equipoBI.obtenerEquiposRegistrados(temporadaElegida);
			}catch(BussinessException e) {
				addActionError(e.getMessage());
			}
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
		this.setAccion("mostrar");
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar un equipo
	 * @return Action Result
	 */
	public String registroEquipo() {
		logger.info("Inicia metodo GestionarManagersAction.registro()");
		equipoManager = new Equipo();
		GestionarEquiposBI equiposBI= new GestionarEquiposBI();
		GestionarEquiposVO vo = new GestionarEquiposVO();

		try {
			BeanUtils.copyProperties(vo,equipoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			return Action.SUCCESS;
		}
		try {
			equipoManager = equiposBI.registrarEquipo(vo, this.managerActual.getCorreo(),this.operacion);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		equipoForm.setIdManager(equipoManager.getIdEquipo());
		
		if(this.operacion.equals("actualizado")) {
			addActionMessage("Equipo actualizado con exito: nombre nuevo: "+equipoForm.getNombre());
		}else {
			addActionMessage("Equipo registrado con exito: idEquipo: "+equipoManager.getIdEquipo());
		}
		return Action.SUCCESS;
	}
	
	/**Metodo para visualizar la pantalla de consultarEquipo
	 * @return Action Result
	 */
	@SkipValidation
	public String buscarEquipo() {
		logger.info("Inicia metodo GestionarEquiposAction.buscarEquipo()");
		return Action.SUCCESS;
	}
	
	
	/**Metodo controlador para verificar si el manager cuenta con un equipo
	 * @return Action Result
	 */
	@SkipValidation
	public String actualizarEquipo(){
		logger.info("Inicia metodo GestionarEquiposAction.actualizarEquipo()");
		this.setAccion("mostrar");
		GestionarEquiposBI equiposBI= new GestionarEquiposBI();
		String mensaje="";
		try {
			mensaje=equiposBI.buscarEquipo(this.managerActual.getIdManager());
			addActionMessage(mensaje);
		}catch(BussinessException e) {
			addActionError(e.getMessage());
			equipoForm= new GestionarEquiposForm();
			this.setOperacion("actualizado");
			try {
				Equipo team = equiposBI.obtenerEquipo(this.managerActual.getIdManager());
				BeanUtils.copyProperties(equipoForm,team);
			} catch (IllegalAccessException | InvocationTargetException b) {
				logger.error("Error al copiar las propiedades del alumno al form.", b);
			} catch (BussinessException g) {
				logger.error("Error al consultar el equipo", g);
			}
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
	
	
	/**Metodo para presentar pantalla de equipos locales
	 * @return pantalla de equipos locales
	 */
	public String mostrarLocales() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarLocales()");
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de equipos visitantes
	 * @return pantalla de equipos visitantes
	 */
	public String mostrarVisitantes() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarVisitantes()");
		return Action.SUCCESS;
	}

	/**
	 * @return El campo equipoForm
	 */
	public GestionarEquiposForm getEquipoForm() {
		return equipoForm;
	}

	/**
	 * @param equipoForm El campo equipoForm a settear
	 */
	public void setEquipoForm(GestionarEquiposForm equipoForm) {
		this.equipoForm = equipoForm;
	}

	/**
	 * @return El campo managerActual
	 */
	public Manager getManagerActual() {
		return managerActual;
	}

	/**
	 * @param managerActual El campo managerActual a settear
	 */
	public void setManagerActual(Manager managerActual) {
		this.managerActual = managerActual;
	}

	/**
	 * @return El campo equipoManager
	 */
	public Equipo getEquipoManager() {
		return equipoManager;
	}

	/**
	 * @param equipoManager El campo equipoManager a settear
	 */
	public void setEquipoManager(Equipo equipoManager) {
		this.equipoManager = equipoManager;
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
	 * @return El campo idTemporada
	 */
	public Long getIdTemporada() {
		return idTemporada;
	}

	/**
	 * @param idTemporada El campo idTemporada a settear
	 */
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}

	/**
	 * @return El campo equipoL
	 */
	public Long getEquipoL() {
		return equipoL;
	}

	/**
	 * @param equipoL El campo equipoL a settear
	 */
	public void setEquipoL(Long equipoL) {
		this.equipoL = equipoL;
	}

	/**
	 * @return El campo accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion El campo accion a settear
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return El campo temporadaElegida
	 */
	public Long getTemporadaElegida() {
		return temporadaElegida;
	}

	/**
	 * @param temporadaElegida El campo temporadaElegida a settear
	 */
	public void setTemporadaElegida(Long temporadaElegida) {
		this.temporadaElegida = temporadaElegida;
	}

	/**
	 * @return El campo equiposRegistrados
	 */
	public List<Equipo> getEquiposRegistrados() {
		return equiposRegistrados;
	}

	/**
	 * @param equiposRegistrados El campo equiposRegistrados a settear
	 */
	public void setEquiposRegistrados(List<Equipo> equiposRegistrados) {
		this.equiposRegistrados = equiposRegistrados;
	}

	/**
	 * @return El campo equiposTemporadaRegistrados
	 */
	public List<Equipo> getEquiposTemporadaRegistrados() {
		return equiposTemporadaRegistrados;
	}

	/**
	 * @param equiposTemporadaRegistrados El campo equiposTemporadaRegistrados a settear
	 */
	public void setEquiposTemporadaRegistrados(List<Equipo> equiposTemporadaRegistrados) {
		this.equiposTemporadaRegistrados = equiposTemporadaRegistrados;
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


