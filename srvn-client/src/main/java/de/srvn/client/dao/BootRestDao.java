package de.srvn.client.dao;

import de.srvn.domain.Boot;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:42
 */
@Component
public class BootRestDao extends AbstractRestDao<Boot> {
    private static final String RESOURCE = "boot";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
