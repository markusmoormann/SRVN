package de.srvn.web.controller.rest;

import de.srvn.dao.EntityDao;
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
@SuppressWarnings("unchecked")
@RequestMapping(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
public abstract class AbstractRestController<E extends IdOnly> implements RestController<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.POST)
    public E add(E value) {
        getEntityDao().save(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public E update(E value) {
        getEntityDao().saveOrUpdate(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.GET)
    public E get(Integer id) {
        return (E) getEntityDao().findById(id);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<E> getAll() {
//        return getEntityDao().findAll();
//    }

    protected abstract EntityDao getEntityDao();
}
