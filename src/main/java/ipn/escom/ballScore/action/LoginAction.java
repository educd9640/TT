package ipn.escom.ballScore.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.entity.Manager;

/**Clase Action para logins
 * @author Jose Mauricio
 *
 */
public class LoginAction extends BaseAction{

	private static final Logger logger = LogManager.getLogger();
	
	private static final long serialVersionUID = 1L;

	private String login;

	private String contrasenia;

	/**Metodo para logear
	 * @return Valid si el loggin fue exitoso, invalid en caso contrario
	 */
	@SuppressWarnings("unchecked")
	public String login(){
		Manager usuario;
		try {
			usuario = getLoginService().doLogin(getLogin().trim(), getContrasenia());
		}catch(Exception e) {
			logger.error("Error al obtener el login ", e);
			addActionError("Error al obtener el login");
			return "invalid";
		}

		if (usuario != null) {
			// Crear sesion
			getSessionMap().put("Usuario", usuario);

			return "valid";
		}
		else {
			logger.error("Error al iniciar sesi�n con el usuario: "+getLogin());
			addActionError("Usuario o contrase�a inv�lidos");
			return "invalid";
		}

	}


	/**Metodo para testear session
	 * @return En consola muestra el estado de la session
	 */
	public String sessionTest(){
		
		logger.info("LoginAction : sessionTest: \nPrueba de inicio de sesi�n/Interceptor que se crea antes al iniciar sesi�n");
		
		Manager usuarioLogado = (Manager) this.getSessionMap().get("Usuario");
		logger.info("Usuario logeado: "+usuarioLogado);

		return "success";
	}

	
	/**Metodo para logout
	 * @return Action Success
	 */
	public String logout(){
		Manager usuarioLogado = (Manager) this.getSessionMap().get("Usuario");
		
		logger.info("LoginAction : logout: \nEfectuando LOGOUT Usuario : "+usuarioLogado);
		
		this.getSessionMap().remove("Usuario");
		return Action.SUCCESS;

	}


	/**
	 * @return El campo login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login El campo login a settear
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return El campo contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}


	/**
	 * @param contrasenia El campo contrasenia a settear
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	/**
	 * @return El campo logger
	 */
	public static Logger getLogger() {
		return logger;
	}


	/**
	 * @return El campo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
