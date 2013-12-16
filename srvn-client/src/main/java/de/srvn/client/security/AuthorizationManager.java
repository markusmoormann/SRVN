package de.srvn.client.security;

import de.srvn.client.webservice.WebserviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:48
 */
@Component
public class AuthorizationManager {

    @Autowired
    private WebserviceClient webserviceClient;

    public void authorize(String user, String password) {
        try {
            webserviceClient.getResource("/");
        } catch (Exception e) {

        }
    }

}
