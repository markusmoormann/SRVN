package de.srvn.client.dao;

import de.srvn.domain.Regatta;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:44
 */
@Component
public class RegattaRestDao extends AbstractRestDao<Regatta> {
    private static final String RESOURCE = "regatta";

    @Override
    protected String getResource() {
        return RESOURCE;
    }
}
