package de.srvn.controller.rest;

import de.srvn.domain.Ruderer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:19
 */
@Controller
public class RudererController extends AbstractRestController<Ruderer> {

    @RequestMapping
    public String test() {
        logger.info("hallo");
        return "/index.jsp";
    }

}
