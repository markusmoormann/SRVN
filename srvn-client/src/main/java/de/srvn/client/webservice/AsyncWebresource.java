package de.srvn.client.webservice;

import de.srvn.client.exception.SrvnException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:21
 */
public class AsyncWebresource<T> {

    private Future<T> future;

    public AsyncWebresource(Future<T> future) {
        this.future = future;
    }

    public T waitTillDone() {
        while (!future.isDone()) {

        }
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new SrvnException(e);
        }
    }
}
