package de.srvn.client.dao;

import de.srvn.domain.Ruderer;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 20:54
 */
@Component
public class RudererRestDao extends AbstractRestDao<Ruderer> {
    private static final String RESOURCE = "ruderer";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
