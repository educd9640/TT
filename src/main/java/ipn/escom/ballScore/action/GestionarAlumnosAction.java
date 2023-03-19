package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

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

	private static final long serialVersionUID = 1L;
	GestionarAlumnosForm alumnoForm;
	private List<Escuela> escuelas = new ArrayList<Escuela>();
	private List<Long> semestres = new ArrayList<Long>();
	private List<Alumno> alumnosRegistrado = new ArrayList<Alumno>();
	
	/**
	 *Metodo para preparar la pantalla
	 */
	@Override
    public void prepare() throws Exception {
		
		GestionarAlumnosBI alumnosBI = new GestionarAlumnosBI();
		
		this.escuelas = alumnosBI.obtenerEscuelas();
		this.semestres = alumnosBI.obtenerSemestres();
		this.alumnosRegistrado = alumnosBI.obtenerAlumnosRegistrados();
    }
	
	/**Metodo para presentar pantalla de formulario
	 * @return
	 */
	public String mostrarFormulario() {
		
		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados
	 * @return
	 */
	public String mostrarRegistrados() {
		
		return Action.SUCCESS;
	}
	
	/**Metodo controlador para registrar alumnos
	 * @return Action Result
	 */
	public String registrarAlumno() {
		GestionarAlumnosVO vo = new GestionarAlumnosVO();
		
		try {
			BeanUtils.copyProperties(vo,alumnoForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			new GestionarAlumnosBI().registrarAlumno(vo);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		addActionMessage("Alumno "+vo.getNombrePila()+" "+vo.getApellidoPat()+" registrado con exito. ");
		
		return Action.SUCCESS;
	}
	
	//Inician metodos getters y setters
	
	public GestionarAlumnosForm getAlumnoForm() {
		return alumnoForm;
	}

	public void setAlumnoForm(GestionarAlumnosForm alumnoForm) {
		this.alumnoForm = alumnoForm;
	}

	public List<Escuela> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

	public List<Long> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Long> semestres) {
		this.semestres = semestres;
	}

	public List<Alumno> getAlumnosRegistrado() {
		return alumnosRegistrado;
	}

	public void setAlumnosRegistrado(List<Alumno> alumnosRegistrado) {
		this.alumnosRegistrado = alumnosRegistrado;
	}
	
}
