package de.srvn.client.exception;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:19
 */
public class SrvnException extends RuntimeException {

    public SrvnException(String message, Throwable cause) {
        super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public SrvnException(Throwable cause) {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
