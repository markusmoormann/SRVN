package de.srvn.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 21:01
 */
@Component
public class Application {

    @Value("${srvn.rest.url}")
    private String restUrl;

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }
}
