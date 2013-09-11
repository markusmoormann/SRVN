package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.Regatta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "/regatta")
public class RegattaRestController extends AbstractRestController<Regatta> {

    @Autowired
    private EntityDao<Regatta> regattaDao;

    @Override
    protected EntityDao<Regatta> getEntityDao() {
        return regattaDao;
    }
}
