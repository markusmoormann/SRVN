package de.srvn.client.webservice;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:20
 */
public interface WebserviceCallback<T> {

    void onSuccess(T object);
    void onFailure(Exception e);

}
