package de.srvn.controller.rest;

import de.srvn.domain.api.IdOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:15
 */
public class AbstractRestController<E extends IdOnly> implements RestController<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public E add(E value) {
        return value;
    }

}
