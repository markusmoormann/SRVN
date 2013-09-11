package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.Obmann;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "obmann")
public class ObmannRestService extends AbstractRestController<Obmann> {

    @Autowired
    private EntityDao<Obmann> obmannDao;

    @Override
    protected EntityDao<Obmann> getEntityDao() {
        return obmannDao;
    }
}
