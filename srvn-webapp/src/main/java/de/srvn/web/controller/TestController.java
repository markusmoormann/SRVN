package de.srvn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * @author Markus Moormann
 * @version 27.07.13 - 22:52
 */
@Component
public class TestController {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @PostConstruct
    public void init() {
        System.out.println("hallo");
    }

}
