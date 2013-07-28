package de.srvn.service;

import de.srvn.domain.api.IdOnly;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Auf Hibernate basierende Implementierung des generischen Service. * * @author <a href="mailto:graves@id-on.de">Burkhard Graves</a> * @version $Id: GenericService.java 4140 2008-02-21 11:25:06Z graves $ * * @param <T> Typ des generischen Service
 */
@Repository
@Transactional
public class GenericService<T extends IdOnly> implements IGenericService<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericService.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> referenceClass;
    private int fuzzyLimit = 3;
    private boolean indexed;
    private String[] indexedFields;
    private String[] indexedFieldsInverse;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Class<T> getReferenceClass() {
        return referenceClass;
    }

    @Override
    @Required
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setReferenceClass(final Class<T> referenceClass) {
        this.referenceClass = referenceClass;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String[] getIndexedFields() {
        return indexedFields;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public String[] getIndexedFieldsInverse() {
        return this.indexedFieldsInverse;
    }

//    /**
//     * TODO ins Interface? * @param sort the sort to set
//     */
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void setSort(final Sort sort) {
//        this.sort = sort;
//    }

    /**
     * @param fuzzyLimit the fuzzyLimit to set
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setFuzzyLimit(final int fuzzyLimit) {
        this.fuzzyLimit = fuzzyLimit;
    }

    /**
     * @see SessionFactory#getCurrentSession()
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected PersistentClass getPersistentClass() {
        return getPersistentClass(referenceClass);
    }

    protected PersistentClass getPersistentClass(Class<T> referenceClass) {
        return sessionFactoryBean.getConfiguration().getClassMapping(sessionFactory.getClassMetadata(referenceClass).getEntityName());
    }

    @Override
    public Statistics getStatistics() {
        return sessionFactory.getStatistics();
    }

    /**
     * Erzeugung einer Criteria. * * @return Criteria
     */
    protected Criteria createCriteria() {
        return getCurrentSession().createCriteria(referenceClass);
    }

    /**
     * Erzeugung einer Criteria mit Berücksichtigung einer hinterlegten Sortierung. * * @return Criteria
     */
    protected Criteria createSortCriteria() {
//        final SortOrderEntry[] sortOrderEntry = sortOrderRegistry.getEntry(referenceClass);
        final Criteria criteria = createCriteria();
//        for (final SortOrderEntry soe : sortOrderEntry) {
//            criteria.addOrder(soe.isAsc() ? Order.asc(soe.getName()) : Order.desc(soe.getName()));
//        }
        criteria.setCacheable(true);
        SessionFactoryUtils.applyTransactionTimeout(criteria, sessionFactory);
        return criteria;
    }

    /**
     * TODO * @return
     */
    protected String createSortHql() {
        StringBuilder sb = new StringBuilder();
        sb.append("from ").append(getPersistentClass().getNodeName());
        appendOrderBy(sb);
        return sb.toString();
    }

    protected void appendOrderBy(StringBuilder sb) {
//        final SortOrderEntry[] sortOrderEntry = sortOrderRegistry.getEntry(referenceClass);
//        for (int i = 0, j = sortOrderEntry.length; i < j; ++i) {
//            SortOrderEntry soe = sortOrderEntry[i];
//            sb.append((i == 0) ? " order by " : ", ").append(soe.getName());
//            if (!soe.isAsc()) {
//                sb.append(" DESC");
//            }
//        }
    }

    protected String getFrom() {
        return "from ".concat(getPersistentClass().getNodeName());
    }

    protected Query applyUsualStuff(Query query) {
        return applyUsualStuff(query, true, true);
    }

    protected Query applyUsualStuff(Query query, boolean transactionTimeOut, boolean cacheable) {
        if (transactionTimeOut) {
            SessionFactoryUtils.applyTransactionTimeout(query, sessionFactory);
        }
        if (cacheable) {
            query.setCacheable(true);
        }
        return query;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isInSessionCache(final T t) {
        return getCurrentSession().contains(t);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeFromSessionCache(final T t) {
        getCurrentSession().evict(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T getSingleton() {
        final Query query = createQuery(getFrom());
        return (T) query.uniqueResult();
    }

    @Override
    public synchronized T singleton() {
        T t = getSingleton();
        if (t == null) {
            save(t = getNewInstance());
        }
        return t;
    }

    @Override
    public void flushAndClear() {
        final Session currentSession = getCurrentSession();
        currentSession.flush();
        currentSession.clear();
    }

    @Override
    @Transactional(readOnly = true)
    public void lock(final T t) {
        getCurrentSession().buildLockRequest(LockOptions.NONE).lock(t);
    }

    /**
     * Obtain lock level LockMode.READ upon the given object. * * @param t the given (detached) object
     */
    @Override
    @Transactional(readOnly = true)
    public void lockRead(final T t) {
        getCurrentSession().buildLockRequest(LockOptions.READ).lock(t);
    }

    @Override
    public int deleteAll() {
        return createQuery("delete ".concat(getPersistentClass().getNodeName())).executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> loadAll() {
        Query query = createQuery(getFrom());
        return applyUsualStuff(query).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> loadAllSorted() {
        Query query = createQuery(createSortHql());
        return applyUsualStuff(query).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T load(final Integer id) {
        return (T) getCurrentSession().load(referenceClass, id);
    }

    @Override
    @Transactional(readOnly = true)
    public T load(final String id) {
        return load(Integer.valueOf(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T get(final Integer id) {
        return (T) getCurrentSession().get(referenceClass, id);
    }

    @Override
    @Transactional(readOnly = true)
    public T get(final String id) {
        return get(Integer.valueOf(id));
    }

    @Override
    @Transactional(readOnly = true)
    public void initialize(final T t) {
        Hibernate.initialize(t);
    }

    @Override
    @Transactional(readOnly = true)
    public T loadInitialized(final Integer id) {
        final T t = load(id);
        initialize(t);
        return t;
    }

    @Override
    @Transactional(readOnly = true)
    public T loadInitialized(final String id) {
        return loadInitialized(Integer.valueOf(id));
    }

    /**
     * Persist the given transient instance. * * @param t the transient instance to persist * @return the (generated) identifier
     */
    @Override
    public Integer save(final T t) {
        return (Integer) getCurrentSession().save(onBeforeSave(t));
    }

    /**
     * Save or update the given persistent instance, according to its id * (matching the configured "unsaved-value"?). * * @param t the persistent instance to save or update
     */
    @Override
    public void saveOrUpdate(final T t) {
        getCurrentSession().saveOrUpdate(onBeforeSaveOrUpdate(t));
    }

    /**
     * Update the given persistent instance. * * @param t the persistent instance to update
     */
    @Override
    public void update(final T t) {
        getCurrentSession().update(onBeforeUpdate(t));
    }

    /**
     * Delete the given persistent instance. * * @param t the persistent instance to delete
     */
    @Override
    public void delete(final T t) {
        getCurrentSession().delete(onBeforeDelete(t));
    }

    @SuppressWarnings("unchecked")
    protected T onBeforeDelete(final T t) {
        return (T) t.onBeforeDelete();
    }

    @SuppressWarnings("unchecked")
    protected T onBeforeSave(final T t) {
        return (T) t.onBeforeSave();
    }

    @SuppressWarnings("unchecked")
    protected T onBeforeUpdate(final T t) {
        return (T) t.onBeforeUpdate();
    }

    @SuppressWarnings("unchecked")
    protected T onBeforeSaveOrUpdate(final T t) {
        return (T) t.onBeforeSaveOrUpdate();
    }

    @Override
    public void delete(final Integer id) {
        delete(load(id));
    }

    @Override
    public void delete(final String id) {
        delete(load(id));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public T getNewInstance() {
        return BeanUtils.instantiateClass(referenceClass);
    }

    @Override
    public void replace(final T oldObject, final T newObject) {
        final Session currentSession = getCurrentSession();
        currentSession.evict(oldObject);
        currentSession.update(newObject);
    }

    @Override
    public void refresh(final T t) {
        getCurrentSession().refresh(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Iterator<T> getIterator() {
        final Query query = createQuery(getFrom());
        return query.iterate();
    }

    protected Query createQuery(final String queryString) {
        return getCurrentSession().createQuery(queryString);
    }

    @Override
    public void clear() {
        getCurrentSession().clear();
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public void setCacheMode(final CacheMode cacheMode) {
        getCurrentSession().setCacheMode(cacheMode);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findByQuery(final String queryName, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        return applyUsualStuff(query).list();
    }

    protected Query getNamedQuery(final String queryName) {
        return getCurrentSession().getNamedQuery(queryName);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T findUniqueByQuery(final String queryName, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        return (T) applyUsualStuff(query).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findById(final String queryName, final int id, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setInteger(0, id);
        return applyUsualStuff(query).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findByName(final String queryName, final String name, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setString(0, name);
        return applyUsualStuff(query).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findByEntity(final String queryName, final Object entity, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setEntity(0, entity);
        return applyUsualStuff(query).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T findUniqueByEntity(final String queryName, final Object entity, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setEntity(0, entity);
        return (T) applyUsualStuff(query).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T findUniqueById(final String queryName, final int id, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setInteger(0, id);
        return (T) applyUsualStuff(query).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T findUniqueByName(final String queryName, final String name, final boolean cacheable) {
        final Query query = getNamedQuery(queryName);
        query.setString(0, name);
        return (T) applyUsualStuff(query).uniqueResult();
    }

    @Override
    public int bulkUpdate(final String queryString, final Object[] values) {
        final Query query = getCurrentSession().createQuery(queryString);
        if (values != null) {
            for (int i = values.length; --i >= 0; ) {
                query.setParameter(i, values[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public int bulkUpdate(final String queryString, final Object value) {
        return bulkUpdate(queryString, new Object[]{value});
    }

    @Override
    public int bulkUpdate(final String queryString) {
        return bulkUpdate(queryString, null);
    }

    @Override
    public List<?> executeHql(String hql) {
        return executeHql(hql, -1, -1);
    }

    @Override
    public List<?> executeHql(String hql, int firstResult, int maxResults) {
        Query query = createQuery(hql);
        if (firstResult >= 0) {
            query.setFirstResult(firstResult);
        }
        if (maxResults >= 0) {
            query.setMaxResults(maxResults);
        }
        return query.list();
    }
}