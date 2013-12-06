package de.srvn.client;

import de.srvn.client.dao.RudererRestDao;
import de.srvn.domain.Geschlecht;
import de.srvn.domain.Ruderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 19:57
 */
public class TestApp {

    private static final Logger logger = LoggerFactory.getLogger(TestApp.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RudererRestDao rudererRestDao = (RudererRestDao) context.getBean("rudererRestDao");
        List<Ruderer> ruderers = rudererRestDao.loadAll();
        Ruderer ruderer = rudererRestDao.load(1);
        ruderer.setName("abs");
        Ruderer save = rudererRestDao.save(ruderer);
        Ruderer neu = new Ruderer();
        neu.setGeschlecht(Geschlecht.MAENNLICH);
        neu.setName("hallo");
        neu = rudererRestDao.save(neu);
        System.exit(0);
    }
}