package ipn.escom.ballScore.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarEstadisticasBI;
import ipn.escom.ballScore.entity.EstDefensivasPart;
import ipn.escom.ballScore.entity.EstOfensivasPart;
import ipn.escom.ballScore.entity.EstPitcherPart;
import ipn.escom.ballScore.form.EstadisticasDefensivasVO;
import ipn.escom.ballScore.form.EstadisticasOfensivasVO;
import ipn.escom.ballScore.form.EstadisticasPitcherVO;
import ipn.escom.ballScore.form.GestionarEstadisticasForm;
import ipn.escom.ballScore.form.GestionarEstadisticasVO;

/**Clase Action para la gestion de estadisticas
 * @author Jose Mauricio
 *
 */
public class GestionarEstadisticasAction extends BaseAction{
	
	static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger();
	private GestionarEstadisticasForm form;
	
	/**Metodo Action para registrar estadisticas del pitcher
	 * @return Pantalla para registro
	 */
	public String registrarEstadisticasPitcher() {
		logger.info("Inicia metodo GestionarEstadisticasAction.registrarEstadisticasPitcher()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		GestionarEstadisticasVO vo = new GestionarEstadisticasVO();
		
		try {
			BeanUtils.copyProperties(vo, form);
			bi.registrarEstadisticasPitcher(vo);
		} catch (Exception e) {
			logger.error("Error al registrar estadisticas : "+e.getMessage(), e);
			addActionError("Error al registrar estadisticas : "+e.getMessage());
		}
		
		addActionMessage("Estadisticas pitcher registradas");
		
		return this.presentarRegistroResultados();
	}
	
	/**Metodo Action para registrar estadisticas defensivas
	 * @return Pantalla para registro
	 */
	public String registrarEstadisticasDefensivas() {
		logger.info("Inicia metodo GestionarEstadisticasAction.registrarEstadisticasDefensivas()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		GestionarEstadisticasVO vo = new GestionarEstadisticasVO();
		
		try {
			BeanUtils.copyProperties(vo, form);
			bi.registrarEstadisticasDefensivas(vo);
		} catch (Exception e) {
			logger.error("Error al registrar estadisticas : "+e.getMessage(), e);
			addActionError("Error al registrar estadisticas : "+e.getMessage());
		}
		
		addActionMessage("Estadisticas defensivas registradas");
		
		return this.presentarRegistroResultados();
	}
	
	/**Metodo Action para registrar estadisticas ofensivas
	 * @return Pantalla para registro
	 */
	public String registrarEstadisticasOfensivas() {
		logger.info("Inicia metodo GestionarEstadisticasAction.registrarEstadisticasOfensivas()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		GestionarEstadisticasVO vo = new GestionarEstadisticasVO();
		
		try {
			BeanUtils.copyProperties(vo, form);
			bi.registrarEstadisticasOfensivas(vo);
		} catch (Exception e) {
			logger.error("Error al registrar estadisticas : "+e.getMessage(), e);
			addActionError("Error al registrar estadisticas : "+e.getMessage());
		}
		
		addActionMessage("Estadisticas ofensivas registradas");
		
		return this.presentarRegistroResultados();
	}
	
	/**Metodo Action para presentar pantalla de registro
	 * @return pantalla para registro
	 */
	public String presentarRegistroResultados() {
		logger.info("Inicia metodo GestionarEstadisticasAction.presentarRegistroResultados()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		try {
			EstPitcherPart estPitcher = bi.consultarEstadisticasJugadorPitcher(form.getIdPartido(), form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada());
			EstOfensivasPart estOfensivas = bi.consultarEstadisticasJugadorOfensivas(form.getIdPartido(), form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada());
			EstDefensivasPart estDefensivas = bi.consultarEstadisticasJugadorDefensivas(form.getIdPartido(), form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada());
			EstadisticasPitcherVO voPitcher = new EstadisticasPitcherVO();
			EstadisticasOfensivasVO voOfensivas = new EstadisticasOfensivasVO();
			EstadisticasDefensivasVO voDefensivas = new EstadisticasDefensivasVO();
			
			if(estPitcher!=null)
				BeanUtils.copyProperties(voPitcher, estPitcher);
			if(estOfensivas!=null)
				BeanUtils.copyProperties(voOfensivas, estOfensivas);
			if(estDefensivas!=null)
				BeanUtils.copyProperties(voDefensivas, estDefensivas);
			form.setEstadisticasPitcherVO(voPitcher);
			form.setEstadisticasOfensivasVO(voOfensivas);
			form.setEstadisticasDefensivasVO(voDefensivas);
		} catch (Exception e) {
			logger.error("Error al consultar estadisticas : "+e.getMessage(), e);
			addActionError("Error al consultar estadisticas : "+e.getMessage());
		}
		return Action.SUCCESS;
	}

	/**Metodo para consultar estadisticas de partido
	 * @return pantalla con estadisticas del partido
	 */
	public String consultarEstadisticasPartido() {
		logger.info("Inicia metodo GestionarEstadisticasAction.consultarEstadisticasPartido()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		try {
			form.setEstadisticasPitcher(bi.consultarEstadisticasPitcherEquipoPartido(form.getIdPartido(), form.getIdEquipo(), form.getIdTemporada()));
			form.setEstadisticasDefensivas(bi.consultarEstadisticasDefensivasEquipoPartido(form.getIdPartido(), form.getIdEquipo(), form.getIdTemporada()));
			form.setEstadisticasOfensivas(bi.consultarEstadisticasOfensivasEquipoPartido(form.getIdPartido(), form.getIdEquipo(), form.getIdTemporada()));
		} catch (Exception e) {
			logger.error("Error al consultar estadisticas : "+e.getMessage(), e);
			addActionError("Error al consultar estadisticas : "+e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	/**Metodo Action para consultar las estadisticas de temporada
	 * @return Pantalla de estadisticas de temporada
	 */
	public String consultarEstadisticasTemporada() {
		logger.info("Inicia metodo GestionarEstadisticasAction.consultarEstadisticasTemporada()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		try {
			form.setEstadisticasPitcher(bi.consultarEstadisticasPitcherJugadorTemp(form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada()));
			form.setEstadisticasDefensivas(bi.consultarEstadisticasDefensivasTemp(form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada()));
			form.setEstadisticasOfensivas(bi.consultarEstadisticasOfensivasTemp(form.getIdJugador(), form.getIdEquipo(), form.getIdTemporada()));
		} catch (Exception e) {
			logger.error("Error al consultar estadisticas : "+e.getMessage(), e);
			addActionError("Error al consultar estadisticas : "+e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	public GestionarEstadisticasForm getForm() {
		return form;
	}

	public void setForm(GestionarEstadisticasForm form) {
		this.form = form;
	}
	

}
