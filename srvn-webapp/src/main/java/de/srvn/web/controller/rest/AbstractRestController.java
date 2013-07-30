package de.srvn.web.controller.rest;

import de.srvn.domain.api.IdOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:15
 */
@RequestMapping(produces = MediaType.APPLICATION_JSON)
public class AbstractRestController<E extends IdOnly> implements RestController<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.POST)
    public E add(E value) {
        return value;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public E update(E value) {
        return value;
    }

    @RequestMapping(method = RequestMethod.GET)
    public E get(E value) {
        return value;
    }
}
