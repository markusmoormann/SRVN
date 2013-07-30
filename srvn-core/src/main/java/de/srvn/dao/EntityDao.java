package de.srvn.dao;

import de.srvn.domain.api.IdOnly;

import java.util.List;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public interface EntityDao<E extends IdOnly> {

    void save(E value);
    void update(E value);
    void saveOrUpdate(E value);

    E findById(Integer id);
    List<E> findAll();
    List<E> findAllSorted(String sortField, SortOrder sortOrder);
}
