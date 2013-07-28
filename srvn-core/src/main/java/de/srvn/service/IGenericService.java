package de.srvn.service;

import de.srvn.domain.api.IdOnly;
import org.hibernate.CacheMode;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.Iterator;
import java.util.List;

/**
 * Schnittstelle des generischen Service.
 *
 * @author <a href="mailto:graves@id-on.de">Burkhard Graves</a>
 * @version $Id: IGenericService.java 4140 2008-02-21 11:25:06Z graves $
 *
 * @param <T> Typ des generischen Service
 */
public interface IGenericService<T extends IdOnly> {

    /**
     * @see SessionFactory#getStatistics()
     */
    Statistics getStatistics();

    /**
     * Check whether the given object is in the Session cache.
     *
     * @param t the given object
     * @return true iff the given object is in the Session cache
     */
    boolean isInSessionCache(T t);

    /**
     * Remove the given object from the {@link org.hibernate.Session} cache.
     * @param t the persistent instance to evict
     * @throws org.springframework.dao.DataAccessException in case of Hibernate errors
     * @see org.hibernate.Session#evict
     */
    void removeFromSessionCache(T t);

    /**
     * Replaces oldObject by newObject.
     *
     * @param oldObject the old object
     * @param newObject the new object
     */
    void replace(T oldObject, T newObject);

    /**
     * @return new instance of the referenceClass
     */
    T getNewInstance();

    /**
     * @return the singleton (maybe null)
     */
    T getSingleton();

    /**
     * @return the singleton, eventually create one
     */
    T singleton();

    /**
     * Flush all pending saves, updates and deletes to the database.
     * <b>NOTE:</b> Do not use for "normal" CRUD-operations. Should only be used for special purposes, e.g. batch processing.
     */
    void flush();

    /**
     * Remove all objects from the Session cache.
     * <b>NOTE:</b> Do not use for "normal" CRUD-operations. Should only be used for special purposes, e.g. batch processing.
     */
    void clear();

    /**
     * Flush all pending saves, updates and deletes to the database.
     * Afterwards remove all objects from the Session cache.
     * <b>NOTE:</b> Do not use for "normal" CRUD-operations. Should only be used for special purposes, e.g. batch processing.
     */
    void flushAndClear();

    /**
     * Obtain lock level LockMode.NONE upon the given object.
     *
     * @param t the given (detached) object
     */
    void lock(T t);

    /**
     * Obtain lock level LockMode.READ upon the given object.
     *
     * @param t the given (detached) object
     */
    void lockRead(T t);

    /**
     * Return all persistent instances.
     *
     * @return all persistant instances
     */
    List<T> loadAll();

    /**
     * Deletes all persistent instances;
     *
     * @return number of deleted instances;
     */
    int deleteAll();

    /**
     * Return all persistent instances, sorted.
     *
     * @return all persistant instances, sorted.
     */
    List<T> loadAllSorted();

    /**
     * Return iterator over all persistent instances.
     * @return iterator over all persistent instances.
     */
    Iterator<T> getIterator();

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T load(Integer id);

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T load(String id);

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T get(Integer id);

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T get(String id);

    /**
     * Force initialization of a Hibernate proxy.
     *
     * @param t - a proxy for a persistent t
     */
    void initialize(T t);

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T loadInitialized(Integer id);

    /**
     * Return the persistent instance with the given identifier.
     *
     * @param id an identifier of the persistent instance
     * @return the persistant instance
     */
    T loadInitialized(String id);

    /**
     * Persist the given transient instance.
     *
     * @param t the transient instance to persist
     * @return the (generated) identifier
     */
    Integer save(T t);

    /**
     * Save or update the given persistent instance, according to its id
     * (matching the configured "unsaved-value"?).
     *
     * @param t the persistent instance to save or update
     */
    void saveOrUpdate(T t);

    /**
     * Update the given persistent instance.
     *
     * @param t the persistent instance to update
     */
    void update(T t);

    /**
     * Delete the given persistent instance.
     *
     * @param t the persistent instance to delete
     */
    void delete(T t);

    /**
     * Delete the given persistent instance.
     *
     * @param id an identifier of the persistent instance to delete
     */
    void delete(Integer id);

    /**
     * Delete the given persistent instance.
     *
     * @param id an identifier of the persistent instance to delete
     */
    void delete(String id);

    /**
     * Re-read the state of the given persistent instance.
     *
     * @param t the persistent instance to re-read
     */
    void refresh(T t);

    /**
     * @param queryName
     * @param entity
     * @param cacheable
     * @return
     */
    List<T> findByEntity(String queryName, Object entity, boolean cacheable);

    /**
     * @param queryName
     * @param entity
     * @param cacheable
     * @return
     */
    T findUniqueByEntity(String queryName, Object entity, boolean cacheable);

    /**
     * @param queryName
     * @param name
     * @return
     */
    T findUniqueByName(String queryName, String name, boolean cacheable);

    /**
     * @param queryName
     * @param name
     * @return
     */
    List<T> findByName(String queryName, String name, boolean cacheable);

    /**
     * @param queryName
     * @param id
     * @param cacheable
     * @return
     */
    T findUniqueById(String queryName, int id, boolean cacheable);

    /**
     * @param queryName
     * @param id
     * @param cacheable
     * @return
     */
    List<T> findById(String queryName, int id, boolean cacheable);

    /**
     * @param queryName
     * @param cacheable
     * @return
     */
    List<T> findByQuery(String queryName, boolean cacheable);

    /**
     * @param queryName
     * @param cacheable
     * @return
     */
    T findUniqueByQuery(String queryName, boolean cacheable);

    /**
     * @param queryString
     * @param values
     * @return
     */
    int bulkUpdate(String queryString, Object[] values);

    /**
     * @param queryString
     * @param value
     * @return
     */
    int bulkUpdate(String queryString, Object value);

    /**
     * @param queryString
     * @return
     */
    int bulkUpdate(String queryString);

    List<?> executeHql(String hql);

    List<?> executeHql(String hql, int firstResult, int maxResults);

    void setReferenceClass(Class<T> referenceClass);

    Class<T> getReferenceClass();

    /**
     * Sets the cache mode to use for the current session.
     * <p/>
     * Use for bulk data operations which should not get recorded in first level cache.
     *
     * @param cacheMode Cache mode to set.
     * @since 2.0
     */
    void setCacheMode(CacheMode cacheMode);

    /**
     * Index-Felder für Lucene-Suche.
     *
     * @return
     */
    public String[] getIndexedFields();

}


