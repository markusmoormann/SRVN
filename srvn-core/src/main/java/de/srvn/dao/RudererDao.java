package de.srvn.dao;

import de.srvn.dao.api.AbstractDao;
import de.srvn.domain.Ruderer;
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
public class RudererDao extends AbstractDao<Ruderer> {

    @Override
    protected Query createQuery(Map<String, String> parameter, QueryBuilder queryBuilder) {
        return queryBuilder.bool().must(queryBuilder.keyword().onFields("name").matching(parameter.get("name")).createQuery()).createQuery();
    }
}
