/*
 * interceptor class to verify sessions before
*/
package ipn.escom.ballScore.interceptor;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**Clase para validar login
 * @author Jose Mauricio
 *
 */
public class ValidaLogin implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	/**
	 *Metodo interceptador para validar la sesión
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession(false);  
        if(session==null || session.getAttribute("Usuario")==null){  
        	
        	// print de pureba
        	System.out.println("Interceptor : ValidaLogin: \nLa sesión identificada expiró o se intentó ver sin iniciar sesión primero");
        	
            return "expired";   // if no session or expired; send to it
        }  
        else{
        	
        	// print de prueba
        	System.out.println("Interceptor : ValidaLogin: \nSesión existente identificada y liberando la invocación normal de la Acción");
        	
            return invocation.invoke(); // or ; just continue the stack
            
        }  
	}

}


