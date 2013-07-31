package de.srvn.web.controller.rest;

import de.srvn.dao.EntityDao;
import de.srvn.dao.RudererDao;
import de.srvn.domain.Geschlecht;
import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:19
 */
@Controller
public class RudererController {

    @Autowired
    private RudererDao rudererDao;

    @PostConstruct
    public void init() {
//        logger.info("ruderer controller Initialized");
    }

//    @RequestMapping(produces = MediaType.TEXT_PLAIN)
    @RequestMapping
    public void test() {
        Ruderer ruderer = new Ruderer();
        ruderer.setGeschlecht(Geschlecht.MÄNNLICH);
        ruderer.setJahrgang(85);
        ruderer.setName("Markus Moormann");
        rudererDao.save(ruderer);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Ruderer get(Integer id) {
        return (Ruderer) getEntityDao().findById(id);
    }
//    @Override
    protected EntityDao getEntityDao() {
        return rudererDao;
    }
}
