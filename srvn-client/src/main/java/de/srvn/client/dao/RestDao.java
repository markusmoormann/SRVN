package de.srvn.client.dao;

import de.srvn.client.webservice.AsyncWebresource;
import de.srvn.domain.api.IdOnly;

import java.util.List;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:04
 */
public interface RestDao<T extends IdOnly> {

    AsyncWebresource<T> saveAsync(T object);
    T save(T object);

    AsyncWebresource<List<T>> loadAllAsync();
    List<T> loadAll();

    AsyncWebresource<T> loadAsync(Integer id);
    T load(Integer id);
}
