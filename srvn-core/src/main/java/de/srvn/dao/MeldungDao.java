package de.srvn.dao;

import de.srvn.dao.api.AbstractDao;
import de.srvn.domain.Meldung;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Component
public class MeldungDao extends AbstractDao<Meldung> {
    @Override
    protected List<Meldung> executeSearch(Map<String, String> parameter) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
