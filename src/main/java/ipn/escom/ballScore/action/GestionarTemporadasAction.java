package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarEquipoTemporadaBI;
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
	private Long equiposeleccionado;
	private String nombreEquipo;
	private String managerequipo;
	private Long temporadaseleccionada;
	private String consultar;
	private String idTexto;
	private boolean opcion;


	private List<Temporada> temporadasRegistradas = new ArrayList<Temporada>();
	private List<Temporada> equipoTemporadasRegistradas = new ArrayList<Temporada>();
	private List<EquipoTemporada> equiposByTemporada = new ArrayList<EquipoTemporada>();
	


	/**Metodo para preparar la pantalla
	 *
	 */
	public void prepare() {
		logger.info("Inicia metodo GestionarTemporadasAction.prepare()");
		GestionarTemporadasBI temporadaBI = new GestionarTemporadasBI();
		try {
			if(idTexto!=null && !idTexto.equals("")) {
				if(opcion) {//idTemporada
					Long aux = Long.parseLong(idTexto);
					this.temporadasRegistradas.add(temporadaBI.buscarTemporadaPorId(aux));
				}else {//idLiga
					this.temporadasRegistradas = temporadaBI.buscarTemporadaPorNombreLiga(idTexto);
				}
			}else {
				this.temporadasRegistradas = temporadaBI.obtenerTemporadasRegistradas();
			}
			
			
			
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		
		
		try {
			if(temporadaF!=null) {
				if(temporadaF.getIdTemporada()!=null) {
					this.equipoTemporadasRegistradas.add(temporadaBI.buscarTemporadaPorId(temporadaF.getIdTemporada()));
				}else if(temporadaF.getLiga().getIdLiga()!=null) {
					this.equipoTemporadasRegistradas = temporadaBI.buscarTemporadaPorIdLiga(temporadaF.getLiga().getIdLiga());
				}else if(temporadaF.getLiga().getNombre()!=null) {
					this.equipoTemporadasRegistradas = temporadaBI.buscarTemporadaPorNombreLiga(temporadaF.getLiga().getNombre());
				}else {
					this.equipoTemporadasRegistradas = temporadaBI.obtenerEquipoTemporadasRegistradas();
				}
			}else {
				this.equipoTemporadasRegistradas = temporadaBI.obtenerEquipoTemporadasRegistradas();
			}
			
			
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
					logger.error("Error al consultar la Temporada", e);
					addActionError("Error al recuperar datos de la Temporada");
				}
			}
		}
		if(consultar!=null && temporadaseleccionada!=null) {
			if(consultar.equals("equipos")) {
				try {
					this.equiposByTemporada = temporadaBI.obtenerEquiposByTemporada(temporadaseleccionada);
				}catch(Exception e) {
					logger.error("Error al copiar las propiedades de la Temporada al form",e);
				}
			}
		}
		
	}
	
	
	/**Metodo para registrar/actualizar Temporadas
	 * @return pantalla de registro de temporadas
	 */
	public String registrarTemporada() {
		logger.info("Inicia metodo GestionarTemporadasAction.registrarTemporada()");
		TemporadaVO temporadaVO = new TemporadaVO();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaI = null;
		Date fechaF = null;
		if(fechaInicial!= null && !fechaInicial.equals("")) {
			try {
				java.util.Date utilDate = dateFormat.parse(fechaInicial);
				fechaI = new java.sql.Date(utilDate.getTime());
			}catch(Exception e) {
				logger.error("Error al copiar la fecha inicial", e);
				addActionError("Error al copiar la fecha inicial");
			}
		}
		
		if(fechaFinal!= null && !fechaFinal.equals("")) {
			try {
				java.util.Date utilDate = dateFormat.parse(fechaFinal);
				fechaF = new java.sql.Date(utilDate.getTime());
			}catch(Exception e) {
				logger.error("Error al copiar la fecha final", e);
				addActionError("Error al copiar la fecha final");
			}
		}
		
		if(fechaI!=null && fechaF!=null) {
			if(fechaI.compareTo(fechaF) < 0) {
				temporadaF.setFechaInicial(fechaI);
				temporadaF.setFechaFinal(fechaF);
			}else {
				addActionError("El rango de fechas no es válido");
			}
		}else if(fechaI!=null || fechaF!=null) {
			temporadaF.setFechaInicial(fechaI);
			temporadaF.setFechaFinal(fechaF);
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
			return Action.SUCCESS;
		}

		addActionMessage("Temporada " + auxTemporada.getIdTemporada() + " " + operacion + " con exito");

		return Action.SUCCESS;
	}
	
	/**Metodo para registrar un equipo en una temporada
	 * @return pantalla de registro de equipo en temporada
	 */
	@SkipValidation
	public String entrarEquipo() {
		logger.info("Inicia metodo GestionarTemporadasAction.entrarEquipo()");
		EquipoTemporada nuevoEquipo= new EquipoTemporada();
		GestionarEquipoTemporadaBI equipotem = new GestionarEquipoTemporadaBI();
		try {
			nuevoEquipo = equipotem.entrarEquipo(temporadaseleccionada, equiposeleccionado);
			addActionMessage("El equipo con id: "+nuevoEquipo.getIdEquipo()+" se ha registrado en la temporada exitosamente");
		} catch (BussinessException e) {
			addActionError(e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	
	/**Metodo para activar/desactivar una temporada
	 * @return pantalla de temporada
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
	 * @return formulario
	 */
	public String mostrarFormulario() {
		logger.info("Inicia metodo GestionarAlumnosAction.mostrarFormulario()");

		return Action.SUCCESS;
	}
	
	/**Metodo para presentar pantalla de registrados
	 * @return pantalla de registrados
	 */
	public String mostrarRegistrados() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarRegistrados()");
		return Action.SUCCESS;
	}


	/**
	 * @return El campo temporadaF
	 */
	public TemporadaForm getTemporadaF() {
		return temporadaF;
	}


	/**
	 * @param temporadaF El campo temporadaF a settear
	 */
	public void setTemporadaF(TemporadaForm temporadaF) {
		this.temporadaF = temporadaF;
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
	 * @return El campo fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}


	/**
	 * @param fechaInicial El campo fechaInicial a settear
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	/**
	 * @return El campo fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}


	/**
	 * @param fechaFinal El campo fechaFinal a settear
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	/**
	 * @return El campo equiposeleccionado
	 */
	public Long getEquiposeleccionado() {
		return equiposeleccionado;
	}


	/**
	 * @param equiposeleccionado El campo equiposeleccionado a settear
	 */
	public void setEquiposeleccionado(Long equiposeleccionado) {
		this.equiposeleccionado = equiposeleccionado;
	}


	/**
	 * @return El campo nombreEquipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}


	/**
	 * @param nombreEquipo El campo nombreEquipo a settear
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	/**
	 * @return El campo managerequipo
	 */
	public String getManagerequipo() {
		return managerequipo;
	}


	/**
	 * @param managerequipo El campo managerequipo a settear
	 */
	public void setManagerequipo(String managerequipo) {
		this.managerequipo = managerequipo;
	}


	/**
	 * @return El campo temporadaseleccionada
	 */
	public Long getTemporadaseleccionada() {
		return temporadaseleccionada;
	}


	/**
	 * @param temporadaseleccionada El campo temporadaseleccionada a settear
	 */
	public void setTemporadaseleccionada(Long temporadaseleccionada) {
		this.temporadaseleccionada = temporadaseleccionada;
	}


	/**
	 * @return El campo consultar
	 */
	public String getConsultar() {
		return consultar;
	}


	/**
	 * @param consultar El campo consultar a settear
	 */
	public void setConsultar(String consultar) {
		this.consultar = consultar;
	}


	/**
	 * @return El campo temporadasRegistradas
	 */
	public List<Temporada> getTemporadasRegistradas() {
		return temporadasRegistradas;
	}


	/**
	 * @param temporadasRegistradas El campo temporadasRegistradas a settear
	 */
	public void setTemporadasRegistradas(List<Temporada> temporadasRegistradas) {
		this.temporadasRegistradas = temporadasRegistradas;
	}


	/**
	 * @return El campo equipoTemporadasRegistradas
	 */
	public List<Temporada> getEquipoTemporadasRegistradas() {
		return equipoTemporadasRegistradas;
	}


	/**
	 * @param equipoTemporadasRegistradas El campo equipoTemporadasRegistradas a settear
	 */
	public void setEquipoTemporadasRegistradas(List<Temporada> equipoTemporadasRegistradas) {
		this.equipoTemporadasRegistradas = equipoTemporadasRegistradas;
	}


	/**
	 * @return El campo equiposByTemporada
	 */
	public List<EquipoTemporada> getEquiposByTemporada() {
		return equiposByTemporada;
	}


	/**
	 * @param equiposByTemporada El campo equiposByTemporada a settear
	 */
	public void setEquiposByTemporada(List<EquipoTemporada> equiposByTemporada) {
		this.equiposByTemporada = equiposByTemporada;
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


	public String getIdTexto() {
		return idTexto;
	}


	public void setIdTexto(String idTexto) {
		this.idTexto = idTexto;
	}


	public boolean isOpcion() {
		return opcion;
	}


	public void setOpcion(boolean opcion) {
		this.opcion = opcion;
	}
	
	
}
