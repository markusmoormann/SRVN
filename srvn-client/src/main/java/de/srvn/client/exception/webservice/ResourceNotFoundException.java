package de.srvn.client.exception.webservice;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 14:15
 */
public class ResourceNotFoundException extends WebserviceException {

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
