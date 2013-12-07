package de.srvn.dao.api;

import de.srvn.domain.api.IdOnly;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@SuppressWarnings("unchecked")
@Repository
@Transactional
public abstract class AbstractDao<E extends IdOnly> implements EntityDao<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected Class<E> referenceClass;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager entityManager;

//    @Autowired
//    private SearchContext searchContext;

    @PostConstruct
    public void initReferenceClass() {
        referenceClass = (Class<E>) ((ParameterizedTypeImpl) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        logger.info("setting referenceClass to {}", referenceClass);
    }

    @Override
    public void save(E value) {
        entityManager.persist(value);
    }

    @Override
    public void delete(E value) {
        entityManager.remove(value);
    }

    @Override
    public E findById(Integer id) {
        return entityManager.find(referenceClass, id);
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteriaQuery = entityManager.getCriteriaBuilder()
                .createQuery(referenceClass);

        Root<E> root = criteriaQuery.from(referenceClass);
        List<E> ruderer = entityManager.createQuery(criteriaQuery.select(root)).getResultList();
        return ruderer;
    }

    @Override
    public List<E> search(Map<String, String> parameter) {
        Map<String, String> parameterMap = new HashMap<>();
        for (Map.Entry<String, String> entry : parameter.entrySet()) {
            if (containsField(entry.getKey())) {
                parameterMap.put(entry.getKey(), entry.getValue());
            }
        }
        return executeSearch(parameterMap);
    }

    public E merge(E object) {
        return entityManager.merge(object);
    }

    public List<E> executeSearch(Map<String, String> parameter) {
        QueryBuilder queryBuilder = Search.getFullTextEntityManager(entityManager).getSearchFactory().buildQueryBuilder().forEntity(referenceClass).get();
        // Create a Lucene Full Text Query
        Query query = createQuery(parameter, queryBuilder);
        FullTextQuery fullTextQuery = Search.getFullTextEntityManager(entityManager).createFullTextQuery(query, referenceClass);
        // Run Query and print out results to console
        return fullTextQuery.getResultList();
    }

    protected abstract Query createQuery(Map<String, String> parameter, QueryBuilder queryBuilder);

    private boolean containsField(String fieldname) {
        EntityType<E> entityType = entityManager.getMetamodel().entity(referenceClass);
        boolean result = false;
        try {
            entityType.getDeclaredAttribute(fieldname);
            result = true;
        } catch (Exception e) {
            logger.warn("could not find field {} for class {}", new Object[]{});
        }
        return result;
    }
}