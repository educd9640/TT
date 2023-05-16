package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarPartidosBI;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.PartidoForm;
import ipn.escom.ballScore.form.PartidoVO;

/**Clase Acrion para gestionar Partidos
 * @author Eduardo Callejas
 *
 */
public class GestionarPartidosAction extends BaseAction implements Preparable {
	private static final Logger logger = LogManager.getLogger();

	private static final long serialVersionUID = 1L;
	
	private PartidoForm partidoF;
	private String operacion;
	private String fechaAnuncioPartido;
	private String horaAnuncioPartido;
	
	
	private List<Partido> partidosRegistrados = new ArrayList<Partido>();
	
	private List<Partido> partidos;
	private Manager sessionManager;
	/**Metodo para preparar la pantalla
	 *
	 */
	public void prepare() {
		logger.info("Inicia metodo GestionarPartidosAction.prepare()");
		GestionarPartidosBI partidoBI = new GestionarPartidosBI();
		
		/*try {
			this.partidosRegistrados = partidoBI.obtenerPartidosRegistrados();
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}*/
		
		if(partidoF!=null && operacion!=null && partidoF.getIdPartido()!=null) {
			try {
				Partido partido = partidoBI.buscarPartidoPorId(partidoF.getIdPartido());
				BeanUtils.copyProperties(partidoF, partido);
			}catch(IllegalAccessException | InvocationTargetException e) {
				logger.error("Error al copiar las propiedades del Partido al form",e);
				addActionError("Error al recuperar datos del Partido");
			}catch(BussinessException e) {
				logger.error("Error al consultar el Partido");
				addActionError("Error al recuperar datos del Partido");
			}
		}
		
	}
	
	
	
	public String registrarPartido() {
		logger.info("Inicia metodo GestionarPartidosAction.registrarPartido()");
		PartidoVO partidoVO= new PartidoVO();
		String fechaHoraStr;
		

		if(fechaAnuncioPartido!=null && fechaAnuncioPartido.contains("/")) {
			String auxFecha[]=fechaAnuncioPartido.split("/");
			if(auxFecha.length != 0 && auxFecha.length<=3) {
				if(horaAnuncioPartido!=null && horaAnuncioPartido.contains(":")) {
					fechaHoraStr = auxFecha[2] + "-"+ auxFecha[1] + "-" + auxFecha[0] + " " + horaAnuncioPartido + ":00.000";
				}else {
					fechaHoraStr = auxFecha[2] + "-"+ auxFecha[1] + "-" + auxFecha[0] + " 00:00:00.000";
				}
				Timestamp fechaHora = Timestamp.valueOf(fechaHoraStr);
				partidoF.setFechaAnuncioPartido(fechaHora);
			}
		}
		
		
		try {
			BeanUtils.copyProperties(partidoVO, partidoF);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ", e);
			addActionError("Error al crear el partido.");
			partidoF = new PartidoForm();
			return Action.SUCCESS;
		}
		Partido partido = new Partido();
		try {
			partido = new GestionarPartidosBI().crearPartido(partidoVO, operacion);
		}catch(BussinessException e) {
			addActionError(e.getMessage());
		}
		
		addActionMessage("Partido "+ partido.getIdPartido() + " "+ operacion+ " con exito");
		
		return Action.SUCCESS;
	}
	
	
	/**Metodo para activar/desactivar un partido
	 * @return
	 */
	@SkipValidation
	public String estadoPartido() {
		logger.info("Inicia metodo GestionarPartidosAction.estadoPartido()");
		PartidoVO partidoVO = new PartidoVO();
		try {
			BeanUtils.copyProperties(partidoVO, partidoF);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del Form al VO ", e);
			addActionError("Error al activar/desactivar el partido.");
		}
		
		try {
			new GestionarPartidosBI().estadoPartido(partidoVO.getIdPartido());
		}catch(BussinessException e) {
			addActionError("Error al activar/desactivar");
			partidoF = new PartidoForm();
			return Action.SUCCESS;
		}
		
		addActionMessage("Partido "+ partidoVO.getIdPartido() + " activado/desactivado con exito");
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
	
	/**Metodo para consultar los partidos
	 * @return pantalla de partidos registrados
	 */
	@SkipValidation
	public String consultarPartidos() {
		logger.info("Inicia metodo GestionarLigasAction.mostrarRegistrados()");
		GestionarPartidosBI bi = new GestionarPartidosBI();
		try {
			if(this.partidoF!=null &&this.partidoF.getIdPartido()!=null) {
				this.partidos = bi.obtenerPartidosRegistradosByIdPartido(this.partidoF.getIdPartido());
			}else if(this.partidoF!=null &&!super.isNullOrBlank(this.partidoF.getNombreLiga())) {
				this.partidos = bi.obtenerPartidosRegistradosByLiga(this.partidoF.getNombreLiga());
			}else if(this.partidoF!=null &&!super.isNullOrBlank(this.partidoF.getNombreEquipoVisitante())) {
				this.partidos = bi.obtenerPartidosRegistradosByEquipoVisitante(this.partidoF.getNombreEquipoVisitante());
			}else if(this.partidoF!=null &&!super.isNullOrBlank(this.partidoF.getNombreEquipoLocal())) {
				this.partidos = bi.obtenerPartidosRegistradosByEquipoLocal(this.partidoF.getNombreEquipoLocal());
			}else if(this.partidoF!=null &&this.partidoF.getFechaInicialBusqueda()!=null && this.partidoF.getFechaFinalBusqueda()!= null) {
				this.partidos = bi.obtenerPartidosRegistradosByFechas(this.partidoF.getFechaInicialBusqueda(),this.partidoF.getFechaFinalBusqueda());
			}else {
				this.partidos = bi.obtenerPartidosRegistrados();
			}
		} catch (BussinessException e) {
			logger.error("Error al consultar partido ", e);
			addActionError("Error al consultar partido "+e.getMessage());
		}
		return Action.SUCCESS;
	}
	

	public PartidoForm getPartidoF() {
		return partidoF;
	}


	public void setPartidoF(PartidoForm partidoF) {
		this.partidoF = partidoF;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}



	public String getFechaAnuncioPartido() {
		return fechaAnuncioPartido;
	}



	public void setFechaAnuncioPartido(String fechaAnuncioPartido) {
		this.fechaAnuncioPartido = fechaAnuncioPartido;
	}



	public String getHoraAnuncioPartido() {
		return horaAnuncioPartido;
	}



	public void setHoraAnuncioPartido(String horaAnuncioPartido) {
		this.horaAnuncioPartido = horaAnuncioPartido;
	}



	public List<Partido> getPartidosRegistrados() {
		return partidosRegistrados;
	}



	public void setPartidosRegistrados(List<Partido> partidosRegistrados) {
		this.partidosRegistrados = partidosRegistrados;
	}
	public List<Partido> getPartidos() {
		return partidos;
	}



	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}



	public Manager getSessionManager() {
		return sessionManager;
	}



	public void setSessionManager(Manager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
	
}
