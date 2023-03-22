/*
 * interceptor class to verify sessions before
*/
package ipn.escom.ballScore.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**Clase para validar login
 * @author Jose Mauricio
 *
 */
public class ValidaLogin implements Interceptor{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger();

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
        	logger.info("Interceptor : ValidaLogin: \nLa sesión identificada expiró o se intentó ver sin iniciar sesión primero");
        	
            return "expired";   // sesion expirada o no iniciada
        }  
        else{

        	logger.info("Interceptor : ValidaLogin: \nSesión existente identificada y liberando la invocación normal de la Acción");
        	
            return invocation.invoke(); // Continua el flujo normal
            
        }  
	}

}


