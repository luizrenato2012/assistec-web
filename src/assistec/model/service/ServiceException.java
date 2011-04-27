package assistec.model.service;
/**
 * Exception p/ erros nas operaçoes dos services
 * @author renato
 *
 */
public class ServiceException extends Exception {

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
