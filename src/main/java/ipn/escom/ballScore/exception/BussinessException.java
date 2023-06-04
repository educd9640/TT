package ipn.escom.ballScore.exception;

/**Clase de excepción para las excepciones de negocio
 * @author Jose Mauricio
 *
 */
public class BussinessException extends Exception  {

	private static final long serialVersionUID = 1L;

	/**Constructor de la excepcion
	 * @param message Mensaje de la excepcion
	 */
	public BussinessException(String message) {
		super(message);
	}
}
