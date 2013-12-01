package de.srvn.client.security;

import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:29
 */
@Component
public class SecurityContext {

    private String username = "markus";
    private String password = "test";


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
