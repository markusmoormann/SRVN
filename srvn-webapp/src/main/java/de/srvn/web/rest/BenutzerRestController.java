package de.srvn.web.rest;

import de.srvn.dao.api.EntityDao;
import de.srvn.domain.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Controller
@RequestMapping(value = "benutzer")
public class BenutzerRestController extends AbstractRestController<Benutzer> {

    @Autowired
    private EntityDao<Benutzer> benutzerDao;

    @Override
    protected EntityDao<Benutzer> getEntityDao() {
        return benutzerDao;
    }
}
