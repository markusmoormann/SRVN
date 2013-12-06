package de.srvn.dao;

import de.srvn.dao.api.AbstractDao;
import de.srvn.domain.Regatta;
import org.apache.lucene.search.Query;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Repository
@Transactional
public class RegattaDao extends AbstractDao<Regatta> {
    @Override
    protected Query createQuery(Map<String, String> parameter, QueryBuilder queryBuilder) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
