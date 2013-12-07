package de.srvn.client.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import de.srvn.client.webservice.AsyncWebresource;
import de.srvn.client.webservice.WebserviceClient;
import de.srvn.domain.api.IdOnly;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 19:30
 */
public abstract class AbstractRestDao<T extends IdOnly> implements RestDao<T> {

    private static ExecutorService EXECUTOR_SERVICE;

    @Autowired
    private WebserviceClient webserviceClient;

    private ObjectMapper mapper;
    private Class<T> clazz;
    private CollectionType collectionType;

    @PostConstruct
    public void initExecutorService() {
        EXECUTOR_SERVICE = Executors.newFixedThreadPool(100);
    }

    @PostConstruct
    public void init() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
    }

    @Override
    public AsyncWebresource<T> saveAsync(final T object) {
        Callable<T> callable = new Callable<T>() {
            @Override
            public T call() throws Exception {
                String result = webserviceClient.postResource(getResource(), mapper.writeValueAsString(object));
                return mapper.readValue(result, clazz);
            };
        };
        return new AsyncWebresource<>(EXECUTOR_SERVICE.submit(callable));
    }

    @Override
    public T save(T object) {
        return saveAsync(object).waitTillDone();
    }

    @Override
    public AsyncWebresource<List<T>> loadAllAsync() {
        Callable<List<T>> callable = new Callable<List<T>>() {

            @Override
            public List<T> call() throws Exception {
                String result = webserviceClient.getResource(getResource());
                List<T> resultList =mapper.readValue(result, collectionType);
                return resultList;
            }
        };
        return new AsyncWebresource<>(EXECUTOR_SERVICE.submit(callable));
    }

    @Override
    public List<T> loadAll() {
        return loadAllAsync().waitTillDone();
    }

    @Override
    public AsyncWebresource<T> loadAsync(final Integer id) {
        Callable<T> callable = new Callable<T>() {
            @Override
            public T call() throws Exception {
                String result = webserviceClient.getResource(getResource() + "/" + id);
                return mapper.readValue(result, clazz);
            }
        };
        return new AsyncWebresource<>(EXECUTOR_SERVICE.submit(callable));
    }

    @Override
    public T load(Integer id) {
        return loadAsync(id).waitTillDone();
    }

    protected abstract String getResource();


}
