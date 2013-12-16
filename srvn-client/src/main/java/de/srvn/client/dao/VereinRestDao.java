package de.srvn.client.dao;

import de.srvn.domain.Verein;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:43
 */
@Component
public class VereinRestDao extends AbstractRestDao<Verein> {
    private static final String RESOURCE = "verein";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
