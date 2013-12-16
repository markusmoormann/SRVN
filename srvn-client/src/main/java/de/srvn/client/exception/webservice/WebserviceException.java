package de.srvn.client.exception.webservice;

import de.srvn.client.exception.SrvnException;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 14:15
 */
public class WebserviceException extends SrvnException {

    public WebserviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebserviceException(Throwable cause) {
        super(cause);
    }
}
