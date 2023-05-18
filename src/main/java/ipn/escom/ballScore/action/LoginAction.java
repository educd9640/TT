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
			logger.error("Error al iniciar sesión con el usuario: "+getLogin());
			addActionError("Usuario o contraseña invalidos");
			return "invalid";
		}

	}


	/**Metodo para testear session
	 * @return En consola muestra el estado de la session
	 */
	public String sessionTest(){
		
		logger.info("LoginAction : sessionTest: \nPrueba de inicio de sesión/Interceptor que se creó antes al iniciar sesión");
		
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
	
	//Inician metodos getters y setters
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


}
