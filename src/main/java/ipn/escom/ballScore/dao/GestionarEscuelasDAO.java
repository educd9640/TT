package ipn.escom.ballScore.dao;

import java.util.List;

import org.hibernate.Query;
import ipn.escom.ballScore.entity.Escuela;

/**Clase DAO para gestionar las escuelas
 * @author Jose Mauricio
 *
 */
public class GestionarEscuelasDAO extends BaseDAO{
	
	/**
	 * Constructor de la clase DAO
	 */
	public GestionarEscuelasDAO() {
		super();
	}
	
	/**Metodo para obtener las escuelas que esten en alta
	 * @return Lista de escuelas en alta
	 */
	@SuppressWarnings("unchecked")
	public List<Escuela> obtenerEscuelasAlta(){
		Query q = session.createQuery("from Escuela e where e.fechaAlta is not null");
		return (List<Escuela> ) q.list();
	}
	
	/**Metodo para obtener una escuela por Id
	 * @param idEscuela de la escuela
	 * @return Entidad escuela con sus datos
	 */
	public Escuela selectEscuelaById(Long idEscuela) {
		Query q = session.createQuery("from Escuela e where e.idEscuela=:idEscuela");
		q.setParameter("idEscuela", idEscuela);
		return (Escuela) q.uniqueResult();
	}
}
