package ipn.escom.ballScore.business;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import ipn.escom.ballScore.dao.GestionarEscuelasDAO;
import ipn.escom.ballScore.dao.GestionarManagersDAO;
import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.form.GestionarManagersVO;

public class GestionarManagersBI {

	public List<Escuela> obtenerEscuelas() {
		GestionarEscuelasDAO escuelasDao = new GestionarEscuelasDAO();
		List<Escuela> escuelas = escuelasDao.obtenerEscuelasAlta();
		escuelasDao.cerrarConexiones();
		return escuelas;
	}
	
	public Long registrarManager(GestionarManagersVO vo) {
		
		Manager nuevoManager = new Manager();
		Long idManager;
		try {
			BeanUtils.copyProperties(nuevoManager, vo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GestionarManagersDAO managersDao = new GestionarManagersDAO();
		Manager registrado = managersDao.selectManagerByCorreo(vo.getCorreo());
		if(registrado==null) {
			GestionarEscuelasDAO escuelasDao= new GestionarEscuelasDAO();
			Escuela escuela = escuelasDao.selectEscuelaById(vo.getIdEscuela());
			nuevoManager.setEscuela(escuela);
			idManager = managersDao.insertIntoManagers(nuevoManager);
		}
		else
			idManager = -1L;
		
		managersDao.cerrarConexiones();
		return idManager;
	}
}
