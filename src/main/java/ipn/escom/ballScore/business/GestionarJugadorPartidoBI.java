package ipn.escom.ballScore.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarJugadorEquipoTempDAO;
import ipn.escom.ballScore.dao.GestionarJugadorPartidoDAO;
import ipn.escom.ballScore.entity.JugadorEquipoTemp;
import ipn.escom.ballScore.entity.JugadorPartido;
import ipn.escom.ballScore.exception.BussinessException;

public class GestionarJugadorPartidoBI {
	private static final Logger logger = LogManager.getLogger();
	
	public List<JugadorPartido> consultarJugadorPartidoById(Long idJugador, Long idPartido, Long idEquipo, Long idTemporada) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadorPartidoById()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadorPartido = dao.selectJugadorPartido(idJugador, idPartido, idEquipo, idTemporada);
			return jugadorPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorPartido> consultarJugadoresPartido(Long idPartido, Long idEquipo, Long idTemporada) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadoresPartido = dao.selectJugadoresPartido(idPartido, idEquipo, idTemporada);
			return jugadoresPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorPartido> consultarJugadoresPartidoByBoleta(Long idPartido, Long idEquipo, Long idTemporada, Long boletaAlumno) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadoresPartido = dao.selectJugadoresPartidoByBoleta(idPartido, idEquipo, idTemporada, boletaAlumno);
			return jugadoresPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorPartido> consultarJugadoresPartidoLikeNombrePila(Long idPartido, Long idEquipo, Long idTemporada, String nombrePila) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadoresPartido = dao.selectJugadoresPartidoLikeNombrePila(idPartido, idEquipo, idTemporada, nombrePila);
			return jugadoresPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorPartido> consultarJugadoresPartidoByPosicionPrim(Long idPartido, Long idEquipo, Long idTemporada, String posicionPrim) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadoresPartido = dao.selectJugadoresPartidoByPosicionPrim(idPartido, idEquipo, idTemporada, posicionPrim);
			return jugadoresPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorPartido> consultarJugadoresPartidoByPosicionSec(Long idPartido, Long idEquipo, Long idTemporada, String posicionSec) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			List<JugadorPartido> jugadoresPartido = dao.selectJugadoresPartidoByPosicionSec(idPartido, idEquipo, idTemporada, posicionSec);
			return jugadoresPartido;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorEquipoTemp> consultarJugadoresEquipoTempNoInscritos(Long idEquipo, Long idTemporada, Long idPartido) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorEquipoTempDAO dao = new GestionarJugadorEquipoTempDAO();
		try {
			List<JugadorEquipoTemp> jugadoresEquipoTemp = dao.selectJugadoresNoRegistradosEnPartido(idEquipo, idTemporada, idPartido);
			return jugadoresEquipoTemp;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorEquipoTemp> consultarJugadoresEquipoTempNoInscritosByBoleta(Long idEquipo, Long idTemporada, Long idPartido, Long boletaAlumno) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorEquipoTempDAO dao = new GestionarJugadorEquipoTempDAO();
		try {
			List<JugadorEquipoTemp> jugadoresEquipoTemp = dao.selectJugadoresNoRegistradosEnPartido(idEquipo, idTemporada, idPartido, boletaAlumno);
			return jugadoresEquipoTemp;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorEquipoTemp> consultarJugadoresEquipoTempNoInscritosLikeNombrePila(Long idEquipo, Long idTemporada, Long idPartido, String NombrePila) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorEquipoTempDAO dao = new GestionarJugadorEquipoTempDAO();
		try {
			List<JugadorEquipoTemp> jugadoresEquipoTemp = dao.selectJugadoresNoRegistradosEnPartidoLikeNombrePila(idEquipo, idTemporada, idPartido, NombrePila);
			return jugadoresEquipoTemp;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorEquipoTemp> consultarJugadoresEquipoTempNoInscritosByPosicionPrim(Long idEquipo, Long idTemporada, Long idPartido, String posicionPrim) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorEquipoTempDAO dao = new GestionarJugadorEquipoTempDAO();
		try {
			List<JugadorEquipoTemp> jugadoresEquipoTemp = dao.selectJugadoresNoRegistradosEnPartidoByPosicionPrim(idEquipo, idTemporada, idPartido, posicionPrim);
			return jugadoresEquipoTemp;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public List<JugadorEquipoTemp> consultarJugadoresEquipoTempNoInscritosByPosicionSec(Long idEquipo, Long idTemporada, Long idPartido, String posicionSec) throws BussinessException{
		logger.info("Inicia metodo GestionarJugadorPartidoBI.consultarJugadoresPartido()");
		GestionarJugadorEquipoTempDAO dao = new GestionarJugadorEquipoTempDAO();
		try {
			List<JugadorEquipoTemp> jugadoresEquipoTemp = dao.selectJugadoresNoRegistradosEnPartidoByPosicionSec(idEquipo, idTemporada, idPartido, posicionSec);
			return jugadoresEquipoTemp;
		}catch (Exception e) {
			logger.error("Error al consultar jugador partido", e);
			throw new BussinessException("Error al consultar jugador partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
	
	public void registrarJugadoresPartido(Long idPartido, Long idEquipo, Long idTemporada, String[] idJugadores, String rolEquipo) throws BussinessException {
		logger.info("Inicia metodo GestionarJugadorPartidoBI.registrarJugadoresPartido()");
		List<JugadorPartido> jugadoresPartido = new ArrayList<JugadorPartido>();
		for(String idJugador: idJugadores) {
			JugadorPartido jugador = new JugadorPartido();
			jugador.setIdPartido(idPartido);
			jugador.setIdEquipo(idEquipo);
			jugador.setIdTemporada(idTemporada);
			jugador.setIdJugador(Long.valueOf(idJugador));
			jugadoresPartido.add(jugador);
		}
		GestionarJugadorPartidoDAO dao = new GestionarJugadorPartidoDAO();
		try {
			dao.insertJugadoresPartido(jugadoresPartido);
		}catch (Exception e) {
			logger.error("Error al consultar insertar jugadores partido", e);
			throw new BussinessException("Error al insertar jugadores partido " + e.getMessage());
		}finally {
			dao.cerrarConexiones();
		}
	}
}
