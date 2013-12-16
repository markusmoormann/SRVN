package de.srvn.client.exception.webservice;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 14:16
 */
public class AuthorizationException extends WebserviceException {
    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }
}
