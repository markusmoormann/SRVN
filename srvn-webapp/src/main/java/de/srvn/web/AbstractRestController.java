package de.srvn.web;

import de.srvn.dao.EntityDao;
import de.srvn.domain.api.IdOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public abstract class AbstractRestController<E extends IdOnly> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public E add(@RequestBody E value) {
        getEntityDao().save(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public E update(@RequestBody E value) {
        getEntityDao().saveOrUpdate(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.GET)
    public E get(Integer id) {
        return (E) getEntityDao().findById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<E> getAll() {
        return getEntityDao().findAll();
    }

    protected abstract EntityDao getEntityDao();
}
