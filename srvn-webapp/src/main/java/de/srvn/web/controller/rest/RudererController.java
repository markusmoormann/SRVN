package de.srvn.web.controller.rest;

import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:19
 */
@Controller
public class RudererController extends AbstractRestController<Ruderer> {

    @Autowired
    @Qualifier("mySessionFactory")
    private LocalSessionFactoryBean localSessionFactoryBean;

    @PostConstruct
    public void init() {
        logger.info("ruderer controller Initialized");
    }

    @RequestMapping(produces = MediaType.TEXT_PLAIN)
    public String test() {
        logger.info("hallo");
        System.out.println("jallo");
        return "/index.jsp";
    }

}
