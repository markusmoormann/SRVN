package de.srvn.web.controller.rest;

import de.srvn.dao.EntityDao;
import de.srvn.dao.RudererDao;
import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Markus Moormann
 * @version 28.07.13 - 18:19
 */
@Controller
@RequestMapping("/ruderer")
public class RudererController extends AbstractRestController<Ruderer> {

    @Autowired
    private RudererDao rudererDao;

////    @RequestMapping(method = RequestMethod.POST)
//    public Ruderer add(Ruderer value) {
//        getEntityDao().save(value);
//        return value;
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public Ruderer update(Ruderer value) {
//        getEntityDao().saveOrUpdate(value);
//        return value;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public Ruderer get(Integer id) {
//        return (Ruderer) getEntityDao().findById(id);
//    }
//
//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    public List<Ruderer> getAll() {
//        return getEntityDao().findAll();
//    }

    @Override
    protected EntityDao getEntityDao() {
        return rudererDao;
    }
}
