/*
 * Classe Base para todas las Actions. 
 * 
 * Posee un sistema de persistencia de acciones para compartir objetos entre sí
 * y mantener persistencia de información fuera de la base de datos.
 * 
*/
package ipn.escom.ballScore.action;

import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import ipn.escom.ballScore.business.LoginBI;

import com.opensymphony.xwork2.ActionSupport;

/**Clase abastracta para la creación de clases Actions
 * @author Jose Mauricio
 *
 */
public abstract class BaseAction extends ActionSupport implements SessionAware{

	// Clase LoginBI para authenticar sesion activa
	@Inject
	private LoginBI loginService;
	
	/**
	 *  Serializada
	 */
	private static final long serialVersionUID = 1L;

	static {
	}

	/**
	 * SessionMap, información de la session
	 */
	private SessionMap<String,Object> sessionMap;
	
	
	/* Metodo para settear en session
	*/
	@SuppressWarnings("rawtypes")
	@Override
	public void setSession(Map<String, Object> session) {
	    sessionMap = (SessionMap) session; 
	}
	
	/**Metodo para obtener datos de la session
	 * @return Session
	 */
	@SuppressWarnings("rawtypes")
	public SessionMap getSessionMap(){
		return this.sessionMap;
	}

	/**Metodo para obtener el servicio de login
	 * @return LoginBI para autenticar
	 */
	public LoginBI getLoginService() {
		return loginService;
	}

	/**Metodo para settear el servicio de login
	 * @param loginService
	 */
	public void setLoginService(LoginBI loginService) {
		this.loginService = loginService;
	}

	
	
	
}
