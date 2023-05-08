package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ipn.escom.ballScore.business.GestionarPartidosBI;
import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.PartidoForm;
import ipn.escom.ballScore.form.PartidoVO;
import ipn.escom.ballScore.form.TemporadaForm;

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
	
	
	/**Metodo para preparar la pantalla
	 *
	 */
	public void prepare() {
		logger.info("Inicia metodo GestionarPartidosAction.prepare()");
		GestionarPartidosBI partidoBI = new GestionarPartidosBI();
		
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
		

		if(fechaAnuncioPartido!=null) {
			String auxFecha[]=fechaAnuncioPartido.split("/");
			if(horaAnuncioPartido!=null) {
				fechaHoraStr = auxFecha[2] + "-"+ auxFecha[1] + "-" + auxFecha[0] + " " + horaAnuncioPartido + ":00.000";
			}else {
				fechaHoraStr = auxFecha[2] + "-"+ auxFecha[1] + "-" + auxFecha[0] + " 00:00:00.000";
			}
			
			Timestamp fechaHora = Timestamp.valueOf(fechaHoraStr);
			partidoF.setFechaAnuncioPartido(fechaHora);
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
}
