package de.srvn.dao;

import de.srvn.domain.api.IdOnly;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.List;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDao<E extends IdOnly> implements EntityDao<E> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private Class<E> referenceClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    public void initReferenceClass() {
        referenceClass = (Class<E>) ((ParameterizedTypeImpl)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        logger.info("setting referenceClass to {}", referenceClass);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria createCriteria() {
        return getCurrentSession().createCriteria(referenceClass);
    }

    @Override
    public void save(E value) {
        getCurrentSession().save(value);
    }

    @Override
    public void update(E value) {
        getCurrentSession().update(value);
    }

    @Override
    public void saveOrUpdate(E value) {
        getCurrentSession().saveOrUpdate(value);
    }

    @Override
    public E findById(Integer id) {
        return (E) createCriteria()
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<E> findAll() {
        return createCriteria().list();
    }

    @Override
    public List<E> findAllSorted(String sortField, SortOrder sortOrder) {
        return createCriteria()
                .addOrder(sortOrder == SortOrder.ASC ? Order.asc(sortField) : Order.desc(sortField))
                .list();
    }
}
