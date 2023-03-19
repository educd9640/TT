package ipn.escom.ballScore.dao;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.util.HibernateUtil;

public class GestionarManagersDAO {
	
	Session session;
	
	public GestionarManagersDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public Long insertIntoManagers(Manager entidad) {
		java.util.Date utilDate = new java.util.Date();
		entidad.setFechaAlta(new Date(utilDate.getTime()));
		session.save(entidad);
		session.flush();
		session.clear();
		return entidad.getIdManager();
	}
	
	public Manager selectManagerByCorreo(String correo) {
		Query q = session.createQuery("from Manager m where m.correo=:correo");
		q.setParameter("correo", correo);
		return (Manager) q.uniqueResult();
	}
	
	public boolean cerrarConexiones() {
		if(this.session.isOpen())
			this.session.close();
		return true;
	}

}
