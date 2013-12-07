package de.srvn.client.dao;

import de.srvn.domain.Benutzer;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:05
 */
@Component
public class BenutzerRestDao extends AbstractRestDao<Benutzer> {
    private static final String RESOURCE = "benutzer";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
