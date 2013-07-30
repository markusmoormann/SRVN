package de.srvn.dao;

import de.srvn.domain.Regatta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
@Repository
@Transactional
public class RegattaDao extends AbstractDao<Regatta> {
}
