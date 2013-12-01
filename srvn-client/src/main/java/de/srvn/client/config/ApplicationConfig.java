package de.srvn.client.config;

import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 21:01
 */
@Component
public class ApplicationConfig {

    private String restUrl;

    public String getRestUrl() {
//        return restUrl;
        return "http://localhost:8080/rest/";
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }
}
