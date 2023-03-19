package ipn.escom.ballScore.action;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.entity.Manager;

public class LoginAction extends BaseAction{

	private String login;

	private String contrasenia;


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

	@SuppressWarnings("unchecked")
	public String login(){
		Manager usuario = getLoginService().doLogin(getLogin(), getContrasenia());

		if (usuario != null) {
			// Crear sesion
			getSessionMap().put("Usuario", usuario);

			return "valid";
		}
		else {
			addActionError("INVALID LOGIN / PASSWORD");
			return "invalid";
		}

	} // end login method

	// método para probar la sesión solamente
	public String sessionTest(){
		
		// eliminar print en producción
		System.out.println("LoginAction : sessionTest: \nPrueba de inicio de sesión/Interceptor que se creó antes al iniciar sesión");
		
		Manager usuarioLogado = (Manager) this.getSessionMap().get("Usuario");
		System.out.println("Usuario logado: "+usuarioLogado);

		return "success";
	}


	// método para cerrar sesión
	public String logout(){
		Manager usuarioLogado = (Manager) this.getSessionMap().get("Usuario");
		
		// eliminar print en producción
		System.out.println("LoginAction : logout: \nEfectuando LOGOUT Usuario : "+usuarioLogado);
		
		this.getSessionMap().remove("Usuario");
		return Action.SUCCESS;

	}


}
