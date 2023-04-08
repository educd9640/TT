package ipn.escom.ballScore.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ipn.escom.ballScore.dao.GestionarEquiposDAO;
import ipn.escom.ballScore.entity.Equipo;
import ipn.escom.ballScore.exception.BussinessException;

public class GestionarJugadoresBI {
	
	private static final Logger logger = LogManager.getLogger();
	
	public Equipo obtenerEquipoDelManager(Long idManager) throws BussinessException {
		logger.info("Inicia metodo GestionarJugadoresBI.obtenerEquipoDelManager()");
		GestionarEquiposDAO equipoDAO = new GestionarEquiposDAO();
		List<Equipo> equipo = equipoDAO.obtenerEquipoDelManager(idManager);
		equipoDAO.cerrarConexiones();
		if(equipo.size()>0)
			return equipo.get(0);
		else
			throw new BussinessException("El manager no tiene equipo registrado");
	}
	
	public List<String> obtenerPosiciones(){
		List<String> posiciones = new ArrayList<String>();
		posiciones.add("Pitcher");
		posiciones.add("Catcher");
		posiciones.add("Primera Base");
		posiciones.add("Segunda Base");
		posiciones.add("Tercera Base");
		posiciones.add("Shortstop");
		posiciones.add("Jardin Izquierdo");
		posiciones.add("Jardin Central");
		posiciones.add("Jardin Derecho");
		return posiciones;
	}

}
