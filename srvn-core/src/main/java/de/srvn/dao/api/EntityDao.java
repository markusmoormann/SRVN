package de.srvn.dao.api;

import de.srvn.domain.api.IdOnly;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public interface EntityDao<E extends IdOnly> {

    void save(E value);
    void delete(E value);

    E findById(Integer id);
    List<E> findAll();
    List<E> search(Map<String, String> parameter);
}
