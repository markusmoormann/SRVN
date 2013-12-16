package de.srvn.client.exception.webservice;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 14:16
 */
public class ServerNotAvailableException extends WebserviceException {
    public ServerNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerNotAvailableException(Throwable cause) {
        super(cause);
    }
}
