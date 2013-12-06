package de.srvn.dao;

import de.srvn.dao.api.AbstractDao;
import de.srvn.domain.Meldung;
import org.apache.lucene.search.Query;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Component
public class MeldungDao extends AbstractDao<Meldung> {
    @Override
    protected Query createQuery(Map<String, String> parameter, QueryBuilder queryBuilder) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}