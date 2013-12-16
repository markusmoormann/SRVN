package de.srvn.client.webservice;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Markus Moormann
 * @version 16.12.13 - 20:15
 */
@Component
public class WebserviceExecutor {

    private ExecutorService executorService;

    @PostConstruct
    public void initExecutorService() {
        executorService = Executors.newFixedThreadPool(100);
    }

    @PreDestroy
    public void destroyExecutorSercice() {
        executorService.shutdownNow();
    }

    public <V> AsyncWebresource<V> submit(Callable<V> callable) {
        return new AsyncWebresource<>(executorService.submit(callable));
    }

}
