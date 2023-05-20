package ipn.escom.ballScore.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEstadisticasDAO;
import ipn.escom.ballScore.entity.EstPitcherPart;
import ipn.escom.ballScore.exception.BussinessException;
import ipn.escom.ballScore.form.GestionarEstadisticasVO;

/**Clase de negocio para gestion de estadisticas
 * @author Jose Mauricio
 *
 */
public class GestionarEstadisticasBI {
	private static final Logger logger = LogManager.getLogger();
	
	/**Metodo de negocio para registrar estadisticas
	 * @param estadisticas vo con estadisticas
	 * @throws BussinessException en caso de error al registrar
	 */
	public void registrarEstadisticasPitcher(GestionarEstadisticasVO estadisticas) throws BussinessException {
		logger.info("Inicia metodo GestionarRegistroEstadisticasBI.registrarEstadisticasPitcher()");
		GestionarEstadisticasDAO dao = new GestionarEstadisticasDAO();
		try {
			if(estadisticas.getEstadisticasPitcherVO()!=null) {
				dao.registrarEstadisticasPitcher(estadisticas.getIdPartido(), estadisticas.getIdJugador(), estadisticas.getIdEquipo(), estadisticas.getIdTemporada(), estadisticas.getEstadisticasPitcherVO());
			}
		}catch (Exception e) {
			logger.error("Error al registrar estadisticas: "+e.getMessage(), e);
			throw new BussinessException("Error al registrar estadisticas: "+e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	/**Metodo de negocio para registrar estadisticas
	 * @param estadisticas vo con estadisticas
	 * @throws BussinessException en caso de error al registrar
	 */
	public void registrarEstadisticasDefensivas(GestionarEstadisticasVO estadisticas) throws BussinessException {
		logger.info("Inicia metodo GestionarRegistroEstadisticasBI.registrarEstadisticasDefensivas()");
		GestionarEstadisticasDAO dao = new GestionarEstadisticasDAO();
		try {
			if(estadisticas.getEstadisticasDefensivasVO()!=null) {
				dao.registrarEstadisticasDefensivas(estadisticas.getIdPartido(), estadisticas.getIdJugador(), estadisticas.getIdEquipo(), estadisticas.getIdTemporada(), estadisticas.getEstadisticasDefensivasVO());
			}
		}catch (Exception e) {
			logger.error("Error al registrar estadisticas: "+e.getMessage(), e);
			throw new BussinessException("Error al registrar estadisticas: "+e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	/**Metodo de negocio para registrar estadisticas
	 * @param estadisticas vo con estadisticas
	 * @throws BussinessException en caso de error al registrar
	 */
	public void registrarEstadisticasOfensivas(GestionarEstadisticasVO estadisticas) throws BussinessException {
		logger.info("Inicia metodo GestionarRegistroEstadisticasBI.registrarEstadisticasOfensivas()");
		GestionarEstadisticasDAO dao = new GestionarEstadisticasDAO();
		try {
			if(estadisticas.getEstadisticasOfensivasVO()!=null) {
				dao.registrarEstadisticasOfensivas(estadisticas.getIdPartido(), estadisticas.getIdJugador(), estadisticas.getIdEquipo(), estadisticas.getIdTemporada(), estadisticas.getEstadisticasOfensivasVO());
			}
		}catch (Exception e) {
			logger.error("Error al registrar estadisticas: "+e.getMessage(), e);
			throw new BussinessException("Error al registrar estadisticas: "+e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public EstPitcherPart consultarEstadisticasJugador(Long idPartido, Long idJugador, Long idEquipo, Long idTemporada) throws BussinessException {
		logger.info("Inicia metodo GestionarRegistroEstadisticasBI.consultarEstadisticasJugador()");
		GestionarEstadisticasDAO dao = new GestionarEstadisticasDAO();
		try {
			return dao.selectEstPitcherPartById(idPartido, idJugador, idEquipo, idTemporada);
		}catch (Exception e) {
			logger.error("Error al consultar estadisticas: "+e.getMessage(), e);
			throw new BussinessException("Error al consultar estadisticas: "+e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
}
