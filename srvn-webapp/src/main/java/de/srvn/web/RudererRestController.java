package de.srvn.web;

import de.srvn.dao.EntityDao;
import de.srvn.dao.RudererDao;
import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "/ruderer/*")
public class RudererRestController extends AbstractRestController<Ruderer> {

    @Autowired
    private RudererDao rudererDao;

    @Override
    protected EntityDao getEntityDao() {
        return rudererDao;
    }
}
