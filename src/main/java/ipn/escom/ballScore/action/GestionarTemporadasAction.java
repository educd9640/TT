package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarTemporadasBI;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.entity.EquipoTemporada;
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
	private String fechaInicial;
	private String fechaFinal;
	private Long equipo_seleccionado;
	private String nombre_equipo_seleccionado;
	private String manager_equipo_seleccionado;
	private Long temporada_seleccionada;
	


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
		if(temporadaF!=null && operacion!=null && temporadaF.getIdTemporada()!=null) {
			if(operacion.equals("actualizado")) {
				try {
					Temporada temporada = temporadaBI.buscarTemporadaPorId(temporadaF.getIdTemporada());
					BeanUtils.copyProperties(temporadaF, temporada);
				}catch(IllegalAccessException | InvocationTargetException e) {
					logger.error("Error al copiar las propiedades de la Temporada al form",e);
					addActionError("Error al recuperar datos de la Temporada");
				}catch(BussinessException e) {
					logger.error("Error al consultar la Temporada");
					addActionError("Error al recuperar datos de la Temporada");
				}
			}
		}
		
	}
	
	
	/**Metodo para registrar/actualizar Temporadas
	 * @return
	 */
	public String registrarTemporada() {
		logger.info("Inicia metodo GestionarTemporadasAction.registrarTemporada()");

		TemporadaVO temporadaVO = new TemporadaVO();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if (fechaInicial != null) {
			try {
				java.util.Date utilDate = dateFormat.parse(fechaInicial);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				temporadaF.setFechaInicial(sqlDate);
			} catch (Exception e) {
				logger.error("Error al copiar la fecha inicial", e);
				addActionError("Error al copiar la fecha inicial");
			}
		}

		if (fechaFinal != null) {
			try {
				java.util.Date utilDate = dateFormat.parse(fechaFinal);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				temporadaF.setFechaFinal(sqlDate);
			} catch (Exception e) {
				logger.error("Error al copiar la fecha final", e);
				addActionError("Error al copiar la fecha final");
			}
		}

		try {
			BeanUtils.copyProperties(temporadaVO, temporadaF);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ", e);
			addActionError("Error al crear la temporada.");
			temporadaF = new TemporadaForm();
			return Action.SUCCESS;
		}
		Temporada auxTemporada = new Temporada();
		try {
			auxTemporada = new GestionarTemporadasBI().crearTemporada(temporadaVO, operacion);
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}

		addActionMessage("Temporada " + auxTemporada.getIdTemporada() + " " + operacion + " con exito");

		return Action.SUCCESS;
	}
	
	/**Metodo para registrar un equipo en una temporada
	 * @return
	 */
	@SkipValidation
	public String entrarEquipo() {
		logger.info("Inicia metodo GestionarTemporadasAction.entrarEquipo()");
		EquipoTemporada nuevoEquipo= new EquipoTemporada();
		GestionarTemporadasBI equipotem = new GestionarTemporadasBI();
		try {
			nuevoEquipo = equipotem.entrarEquipo(temporada_seleccionada, equipo_seleccionado);
			addActionMessage("El equipo con id: "+nuevoEquipo.getIdEquipo()+" se ha registrado en la temporada exitosamente");
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	
	/**Metodo para activar/desactivar una temporada
	 * @return
	 */
	@SkipValidation
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


	public String getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public String getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public Long getEquipo_seleccionado() {
		return equipo_seleccionado;
	}


	public void setEquipo_seleccionado(Long equipo_seleccionado) {
		this.equipo_seleccionado = equipo_seleccionado;
	}


	public Long getTemporada_seleccionada() {
		return temporada_seleccionada;
	}


	public void setTemporada_seleccionada(Long temporada_seleccionada) {
		this.temporada_seleccionada = temporada_seleccionada;
	}

	public String getNombre_equipo_seleccionado() {
		return nombre_equipo_seleccionado;
	}


	public void setNombre_equipo_seleccionado(String nombre_equipo_seleccionado) {
		this.nombre_equipo_seleccionado = nombre_equipo_seleccionado;
	}


	public String getManager_equipo_seleccionado() {
		return manager_equipo_seleccionado;
	}


	public void setManager_equipo_seleccionado(String manager_equipo_seleccionado) {
		this.manager_equipo_seleccionado = manager_equipo_seleccionado;
	}
	
}
