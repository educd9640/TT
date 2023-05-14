package ipn.escom.ballScore.action;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.GestionarEstadisticasBI;
import ipn.escom.ballScore.exception.BussinessException;
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
		logger.info("Inicia metodo GestionarEstadisticasAction.registrarEstadisticasAction()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		GestionarEstadisticasVO vo = new GestionarEstadisticasVO();
		
		try {
			BeanUtils.copyProperties(vo, form);
			bi.registrarEstadisticasPitcher(vo);
		} catch (BussinessException | IllegalAccessException | InvocationTargetException e) {
			logger.error("Error al registrar estadisticas : "+e.getMessage(), e);
			addActionError("Error al registrar estadisticas : "+e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	/**Metodo Action para registrar estadisticas defensivas
	 * @return Pantalla para registro
	 */
	public String registrarEstadisticasDefensivas() {
		logger.info("Inicia metodo GestionarEstadisticasAction.registrarEstadisticasAction()");
		GestionarEstadisticasBI bi = new GestionarEstadisticasBI();
		GestionarEstadisticasVO vo = new GestionarEstadisticasVO();
		
		try {
			BeanUtils.copyProperties(vo, form);
			bi.registrarEstadisticasDefensivas(vo);
		} catch (BussinessException | IllegalAccessException | InvocationTargetException e) {
			logger.error("Error al registrar estadisticas : "+e.getMessage(), e);
			addActionError("Error al registrar estadisticas : "+e.getMessage());
		}
		
		return Action.SUCCESS;
	}
	
	/**Metodo Action para presentar pantalla de registro
	 * @return pantalla para registro
	 */
	public String presentarRegistroResultados() {
		
		return Action.SUCCESS;
	}

	public GestionarEstadisticasForm getForm() {
		return form;
	}

	public void setForm(GestionarEstadisticasForm form) {
		this.form = form;
	}
	
	
}
