package ipn.escom.ballScore.business;


import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;

import ipn.escom.ballScore.entity.Manager;
import ipn.escom.ballScore.util.HibernateUtil;

@Stateless(mappedName = "LoginService")
public class LoginBI {

	/** Metodo para loggear
	 * @param login correo electronico
	 * @param pass contraseña
	 * @return usuario Manager si existiera
	 */
	public Manager doLogin(String login, String pass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Manager m where m.correo =:correo and m.contrasenia=:contrasenia and m.fechaBaja is null");
		q.setParameter("correo", login);
		q.setParameter("contrasenia", pass);
		Manager manager = (Manager) q.uniqueResult();
		session.close();
		//Usuario usuario = ensureHelper().getUsuario(login, pass);
		if (manager == null) {return null;}
		else {
			return manager;
		}
	}
}
