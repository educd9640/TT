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

public abstract class BaseAction extends ActionSupport implements SessionAware{

	// I put here my services bean classes and inject with CDI 
	@Inject
	private LoginBI loginService;
	
	/**
	 *  Serializada
	 */
	private static final long serialVersionUID = 1L;

	static { // LOAD BLOCK
	} // LOAD BLOCK 

	private SessionMap<String,Object> sessionMap;
	
	
	/* method to get sessions
	*/
	@Override
	public void setSession(Map<String, Object> session) {
	    sessionMap = (SessionMap) session; 
	}
	
	public SessionMap getSessionMap(){
		return this.sessionMap;
	}

	public LoginBI getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginBI loginService) {
		this.loginService = loginService;
	}

	
	
	
}
