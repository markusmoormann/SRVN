package de.srvn.client.config;

import de.srvn.client.dao.RudererRestDao;
import de.srvn.domain.Ruderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:27
 */
@Component
public class MainApp {

    @Autowired
    private RudererRestDao rudererRestDao;

    public void run() {
        List<Ruderer> ruderers = rudererRestDao.loadAll();
    }

}
