package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.Verein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "/verein")
public class VereinRestController extends AbstractRestController<Verein> {

    @Autowired
    private EntityDao<Verein> vereinDao;

    @Override
    protected EntityDao<Verein> getEntityDao() {
        return vereinDao;
    }
}
