package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "/ruderer")
public class RudererRestController extends AbstractRestController<Ruderer> {

    @Autowired
    private EntityDao<Ruderer> rudererDao;

    @Override
    protected EntityDao<Ruderer> getEntityDao() {
        return rudererDao;
    }
}
