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

import ipn.escom.ballScore.business.GestionarAlumnosBI;
import ipn.escom.ballScore.entity.Alumno;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarAlumnosForm;
import ipn.escom.ballScore.form.GestionarAlumnosVO;

/**Clase Action para gestionar alumnos
 * @author Jose Mauricio
 *
 */
public class GestionarAlumnosAction extends BaseAction implements Preparable{
	
	private static final Logger logger = LogManager.getLogger();

	private static final long serialVersionUID = 1L;
	private GestionarAlumnosForm alumnoForm;
	private String operacion;
	private List<Escuela> escuelas = new ArrayList<Escuela>();
	private List<Long> semestres = new ArrayList<Long>();
	private List<Alumno> alumnosRegistrado = new ArrayList<Alumno>();
	private boolean soloLibres;
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare(){
		logger.info("Inicia metodo GestionarAlumnosAction.prepare()");
		
		GestionarAlumnosBI alumnosBI = new GestionarAlumnosBI();
		
		try {
			this.escuelas = alumnosBI.obtenerEscuelas();
			if(alumnoForm != null && alumnoForm.getBoletaAlumno()!= null) {
				this.alumnosRegistrado = alumnosBI.obtenerAlumnosRegistradosPorBoleta(alumnoForm.getBoletaAlumno());
			}else if(alumnoForm != null && alumnoForm.getNombrePila()!= null && !alumnoForm.getNombrePila().equals("")) {
				this.alumnosRegistrado = alumnosBI.obtenerAlumnosRegistradosPorNombrePila(alumnoForm.getNombrePila(), soloLibres);
			}else if(alumnoForm != null && alumnoForm.getIdEscuela()!= null && alumnoForm.getIdEscuela()!=-1L) {
				this.alumnosRegistrado = alumnosBI.obtenerAlumnosRegistradosPorEscuela(alumnoForm.getIdEscuela(), soloLibres);
			}else
				this.alumnosRegistrado = alumnosBI.obtenerAlumnosRegistrados(soloLibres);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		this.semestres = alumnosBI.obtenerSemestres();
		
		if(alumnoForm !=null && alumnoForm.getBoletaAlumno()!=null && operacion !=null && operacion.equals("actualizado")) {
				try {
					Alumno alumno = alumnosBI.obtenerAlumnoPorBoleta(alumnoForm.getBoletaAlumno());
					BeanUtils.copyProperties(alumnoForm,alumno);
					alumnoForm.setIdEscuela(alumno.getEscuela().getIdEscuela());
				} catch (IllegalAccessException | InvocationTargetException e) {
					logger.error("Error al copiar las propiedades del alumno al form.", e);
					addActionError("Error al recuperar datos del alumno");
				} catch (BussinessException e) {
					logger.error("Error al consultar al alumno", e);
					addActionError("Error al recuperar datos del alumno");
				}

		}
    }
	
	/**Metodo para presentar pantalla de formulario
	 * @return pantalla de formulario
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarFormulario()");

		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados
	 * @return pantalla de registrados
	 */
	@SkipValidation
	public String mostrarRegistrados() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarRegistrados()");

		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados Libres
	 * @return pantalla de registrados sin equipo
	 */
	@SkipValidation
	public String mostrarRegistradosLibres() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarRegistrados()");

		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar alumnos
	 * @return Action Result
	 */
	public String registrarAlumno() {
		logger.info("Inicia metodo GestionarAlumnosAction.registrarAlumno()");
		
		GestionarAlumnosVO vo = new GestionarAlumnosVO();
		try {
			BeanUtils.copyProperties(vo,alumnoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			alumnoForm = new GestionarAlumnosForm();
			return Action.SUCCESS;
		}
		try {
			new GestionarAlumnosBI().registrarAlumno(vo, operacion);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			return Action.SUCCESS;
		}
		
		addActionMessage("Alumno ["+vo.getNombrePila()+" "+vo.getApellidoPat()+"] "+operacion+" con exito. ");
		alumnoForm = new GestionarAlumnosForm();
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para baja de un alumno
	 * @return Action Result
	 */
	@SkipValidation
	public String bajaAlumno() {
		logger.info("Inicia metodo GestionarAlumnosAction.eliminarAlumno()");
		GestionarAlumnosVO vo = new GestionarAlumnosVO();
		try {
			BeanUtils.copyProperties(vo,alumnoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			alumnoForm = new GestionarAlumnosForm();
			return Action.SUCCESS;
		}
		
		try {
			new GestionarAlumnosBI().bajaAlumno(vo.getBoletaAlumno());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			alumnoForm = new GestionarAlumnosForm();
			return Action.SUCCESS;
		}
		
		addActionMessage("Alumno con boleta: "+vo.getBoletaAlumno()+" dado de baja con exito.");
		this.prepare();
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para activar un alumno
	 * @return Action Result
	 */
	@SkipValidation
	public String altaAlumno() {
		logger.info("Inicia metodo GestionarAlumnosAction.eliminarAlumno()");
		GestionarAlumnosVO vo = new GestionarAlumnosVO();
		try {
			BeanUtils.copyProperties(vo,alumnoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al registrarse.");
			alumnoForm = new GestionarAlumnosForm();
			return Action.SUCCESS;
		}
		
		try {
			new GestionarAlumnosBI().altaAlumno(vo.getBoletaAlumno());
		} catch (BussinessException e) {
			addActionError(e.getMessage());
			alumnoForm = new GestionarAlumnosForm();
			return Action.SUCCESS;
		}
		
		addActionMessage("Alumno con boleta: "+vo.getBoletaAlumno()+" dado de alta con exito.");
		this.prepare();
		return Action.SUCCESS;
	}

	/**
	 * @return El campo alumnoForm
	 */
	public GestionarAlumnosForm getAlumnoForm() {
		return alumnoForm;
	}

	/**
	 * @param alumnoForm El campo alumnoForm a settear
	 */
	public void setAlumnoForm(GestionarAlumnosForm alumnoForm) {
		this.alumnoForm = alumnoForm;
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
	 * @return El campo semestres
	 */
	public List<Long> getSemestres() {
		return semestres;
	}

	/**
	 * @param semestres El campo semestres a settear
	 */
	public void setSemestres(List<Long> semestres) {
		this.semestres = semestres;
	}

	/**
	 * @return El campo alumnosRegistrado
	 */
	public List<Alumno> getAlumnosRegistrado() {
		return alumnosRegistrado;
	}

	/**
	 * @param alumnosRegistrado El campo alumnosRegistrado a settear
	 */
	public void setAlumnosRegistrado(List<Alumno> alumnosRegistrado) {
		this.alumnosRegistrado = alumnosRegistrado;
	}

	/**
	 * @return El campo soloLibres
	 */
	public boolean isSoloLibres() {
		return soloLibres;
	}

	/**
	 * @param soloLibres El campo soloLibres a settear
	 */
	public void setSoloLibres(boolean soloLibres) {
		this.soloLibres = soloLibres;
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
