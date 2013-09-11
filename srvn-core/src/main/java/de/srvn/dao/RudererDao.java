package de.srvn.dao;

import de.srvn.dao.api.AbstractDao;
import de.srvn.domain.Ruderer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Repository
@Transactional
public class RudererDao extends AbstractDao<Ruderer> {

    @Override
    protected List<Ruderer> executeSearch(Map<String, String> parameter) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
