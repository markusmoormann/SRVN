package de.srvn.client.dao;

import de.srvn.domain.Obmann;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:45
 */
@Component
public class ObmannRestDao extends AbstractRestDao<Obmann> {
    private static final String RESOURCE = "obmann";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
