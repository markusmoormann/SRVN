package de.srvn.web.controller.rest;

import de.srvn.dao.EntityDao;
import de.srvn.dao.VereinDao;
import de.srvn.domain.Verein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping("/verein")
public class VereinController extends AbstractRestController<Verein> {

    @Autowired
    private VereinDao vereinDao;

    @Override
    protected EntityDao getEntityDao() {
        return vereinDao;
    }
}
