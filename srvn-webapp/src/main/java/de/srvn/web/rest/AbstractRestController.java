package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.api.IdOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public abstract class AbstractRestController<E extends IdOnly> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public E add(@RequestBody E value) {
        getEntityDao().save(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public E update(@RequestBody E value) {
        getEntityDao().save(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<E> get() {
        return getEntityDao().findAll();
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public E getSingle(@PathVariable Integer id) {
        return getEntityDao().findById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "search",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<E> search(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            parameterMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return getEntityDao().search(parameterMap);
    }

//    @RequestMapping(value = "bla", method = RequestMethod.GET)
//    @ResponseBody
//    public String hallo(@Context SearchContext searchContext) {
//        logger.info("hallo");
//        return "hallo";
//    }

//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    @ResponseBody
//    public String test(@Context SearchContext searchContext) {
//        logger.info("test");
//        return "test";
//    }

    protected abstract EntityDao<E> getEntityDao();
}
