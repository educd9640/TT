package ipn.escom.ballScore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ipn.escom.ballScore.entity.Escuela;
import ipn.escom.ballScore.util.HibernateUtil;

public class GestionarEscuelasDAO {
	
	Session session;
	
	public GestionarEscuelasDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Escuela> obtenerEscuelasAlta(){
		Query q = session.createQuery("from Escuela e where e.fechaAlta is not null");
		return (List<Escuela> ) q.list();
	}
	
	public Escuela selectEscuelaById(Long idEscuela) {
		Query q = session.createQuery("from Escuela e where e.idEscuela=:idEscuela");
		q.setParameter("idEscuela", idEscuela);
		return (Escuela) q.uniqueResult();
	}
	
	public boolean cerrarConexiones() {
		if(this.session.isOpen())
			this.session.close();
		return true;
	}
}
