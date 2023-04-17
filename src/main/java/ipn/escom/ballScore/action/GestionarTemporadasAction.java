package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarTemporadasBI;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.TemporadaForm;
import ipn.escom.ballScore.form.TemporadaVO;

/**Clase Action para gestionar Temporadas
 * @author Eduardo Callejas
 *
 */
public class GestionarTemporadasAction extends BaseAction implements Preparable {
	private static final Logger logger = LogManager.getLogger();

	private static final long serialVersionUID = 1L;
	
	private TemporadaForm temporadaF;
	private String operacion;
	@SuppressWarnings("unused")
	private List<Temporada> temporadasRegistradas = new ArrayList<Temporada>();
	
	
	
	/**Metodo para preparar la pantalla
	 *
	 */
	public void prepare() {
		logger.info("Inicia metodo GestionarTemporadasAction.prepare()");
		GestionarTemporadasBI temporadaBI = new GestionarTemporadasBI();
		try {
			this.temporadasRegistradas = temporadaBI.obtenerTemporadasRegistradas();
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
	}
	
	
	/**Metodo para registrar/actualizar Temporadas
	 * @return
	 */
	public String registrarTemporada() {
		logger.info("Inicia metodo GestionarTemporadasAction.registrarTemporada()");
		
		TemporadaVO temporadaVO = new TemporadaVO();
		try {
			BeanUtils.copyProperties(temporadaVO, temporadaF);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al crear la temporada.");
			temporadaF = new TemporadaForm();
			return Action.SUCCESS;
		}
		
		try {
			new GestionarTemporadasBI().crearTemporada(temporadaVO, operacion);
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		
		addActionMessage("Temporada "+temporadaVO.getIdTemporada()+ " "+ operacion + " con exito");
		
		return Action.SUCCESS;
	}
	
	
	
	public String estadoTemporada() {
		logger.info("Inicia metodo GestionarTemporadasAction.estadoTemporada()");
		TemporadaVO temporadaVO = new TemporadaVO();
		try {
			BeanUtils.copyProperties(temporadaVO, temporadaF);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ",e);
			addActionError("Error al crear la temporada.");
		}
		
		try {
			new GestionarTemporadasBI().estadoTemporada(temporadaVO.getIdTemporada());
		}catch(BussinessException e) {
			addActionError("Error al registrarse");
			temporadaF = new TemporadaForm();
			return Action.SUCCESS;
		}
		
		addActionMessage("Temporada "+ temporadaVO.getIdTemporada() + " activada/desactivada con exito");
		this.prepare();
		return Action.SUCCESS;
	}
	
	
	/**Metodo para presentar pantalla de formulario
	 * @return
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarFormulario()");

		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados
	 * @return
	 */
	public String mostrarRegistrados() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarRegistrados()");
		return Action.SUCCESS;
	}


	public TemporadaForm getTemporadaF() {
		return temporadaF;
	}


	public void setTemporadaF(TemporadaForm temporadaF) {
		this.temporadaF = temporadaF;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public List<Temporada> getTemporadasRegistradas() {
		return temporadasRegistradas;
	}


	public void setTemporadasRegistradas(List<Temporada> temporadasRegistradas) {
		this.temporadasRegistradas = temporadasRegistradas;
	}
	
	
}
