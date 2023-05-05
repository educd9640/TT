package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarPartidosDAO;
import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.entity.Partido;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.PartidoVO;

/**Clase de negocio para gestionar los partidos
 * @author Eduardo Callejas
 *
 */
public class GestionarPartidosBI {
	private GestionarPartidosDAO partidoDAO;
	private GestionarTemporadasDAO temporadaDAO;
	
	private static final Logger logger = LogManager.getLogger();
	
	
	public Partido crearPartido(PartidoVO partidoVO, String Operacion) throws BussinessException {
		logger.info("Inicia metodo GestionarPartidosBI.crearPartido()");
		temporadaDAO = new GestionarTemporadasDAO();
		partidoDAO = new GestionarPartidosDAO();
		Partido nuevoPartido= new Partido();
		
		try {
			BeanUtils.copyProperties(nuevoPartido, partidoVO);
		}catch(IllegalAccessException | InvocationTargetException e) {
			logger.error(" Error al copiar propiedades del vo a la entidad.", e);
			throw new BussinessException("Error al registrar la Temporada.");
		}
		/////////////////////////////////////////////////////
		
		try {
			
		}
	}

	
	
}












