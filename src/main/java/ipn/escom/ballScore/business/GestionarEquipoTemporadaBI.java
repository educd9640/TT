package ipn.escom.ballScore.business;

import java.sql.Date;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquipoTemporadaDAO;
import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.dao.GestionarTemporadasDAO;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.entity.EquipoTemporada;
import ipn.escom.ballScore.entity.Temporada;
import ipn.escom.ballScore.exception.BussinessException;

/**Clase de negocio para la gestion de equipos de temporada
 * @author Jose Mauricio
 *
 */
public class GestionarEquipoTemporadaBI {
	private static final Logger logger = LogManager.getLogger();
	private GestionarTemporadasDAO temporadaDAO;
	private GestionarEquiposDAO equipoDAO;
	private GestionarEquipoTemporadaDAO equipotemporadaDAO;
	
	/**
	 * Metodo de negocio para registrar un equipo dentro de una temporada
	 * @param idTemporada con el id de la temporada donde se regitrara el equipo y Long con el id del equipo a registrar
	 * @param idEquipo EquipoTemporada con el equipo y temporada registrados
	 * @return Equipo de temporada persistido
	 * @throws BussinessException En caso de error de negocio
	 */
	public EquipoTemporada entrarEquipo(Long idTemporada, Long idEquipo) throws BussinessException{
		logger.info("Inicia metodo GestionarTemporadasBI.entrarEquipo()");
		
		equipotemporadaDAO = new GestionarEquipoTemporadaDAO();
		equipoDAO = new GestionarEquiposDAO();
		temporadaDAO = new GestionarTemporadasDAO();
		Equipo equipoEscogido = new Equipo();
		Temporada temporadaElegida= new Temporada();
		EquipoTemporada nuevoequipo = new EquipoTemporada();
		EquipoTemporada equiporegistrado= new EquipoTemporada();
		equipoEscogido = equipoDAO.obtenerEquipo(idEquipo);
		temporadaElegida = temporadaDAO.selectTemporadaById(idTemporada);
		nuevoequipo.setEquipo(equipoEscogido);
		nuevoequipo.setTemporada(temporadaElegida);
		nuevoequipo.setIdEquipo(idEquipo);
		nuevoequipo.setIdTemporada(idTemporada);
		try {
			equiporegistrado=equipotemporadaDAO.registrarEquipo(nuevoequipo);
		} catch (SQLException e) {
			logger.error(" Error al registrar el equipo en la temporada", e);
			throw new BussinessException("Error al registrar el equipo en la temporada.");
		}finally {
			equipoDAO.cerrarConexiones();
			equipotemporadaDAO.cerrarConexiones();
			temporadaDAO.cerrarConexiones();
		}
		return equiporegistrado;
	} 
	
	/**Metodo de negocio para alternar el estado de un equipo de temporada
	 * @param idTemporada del equipo de temporada
	 * @param idEquipo del equipo de temporada
	 * @throws BussinessException en caso de error al alternar
	 */
	public void alternarEstadoEquipoTemp(Long idTemporada, Long idEquipo) throws BussinessException {
		equipotemporadaDAO = new GestionarEquipoTemporadaDAO();
		try {
			EquipoTemporada equipoTemporada = equipotemporadaDAO.selectEquipoTemporadaById(idEquipo, idTemporada);
			if(equipoTemporada.getFechaAlta()!=null) {
				equipoTemporada.setFechaAlta(null);
			}else {
				java.util.Date utilDate = new java.util.Date();
				equipoTemporada.setFechaAlta(new Date(utilDate.getTime()));
			}
			equipotemporadaDAO.updateEquipoTemporada(equipoTemporada);
		}catch (Exception e) {
			logger.error("Error al alternar estado", e);
			throw new BussinessException("Error al alternar estado del equipo." +e.getMessage());
		}finally {
			equipotemporadaDAO.cerrarConexiones();
		}
	}
	
	/**Metodo para consultar los equipos de temporada
	 * @param idEquipo del equipo temporada
	 * @param idTemporada de la temporada
	 * @return equipo de temporada
	 * @throws BussinessException en caso de error al consultar
	 */
	public EquipoTemporada consultarEquipoTemporada(Long idEquipo, Long idTemporada) throws BussinessException {
		equipotemporadaDAO = new GestionarEquipoTemporadaDAO();
		try {
			return equipotemporadaDAO.selectEquipoTemporadaById(idEquipo, idTemporada);
		}catch (Exception e) {
			logger.error("Error al consultar equipo", e);
			throw new BussinessException("Error al consultar equipo." +e.getMessage());
		}finally {
			equipotemporadaDAO.cerrarConexiones();
		}
	}
}
