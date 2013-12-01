package de.srvn.client;

import de.srvn.client.dao.RudererRestDao;
import de.srvn.domain.Ruderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Markus Moormann
 * @version 18.11.13 - 19:57
 */
public class TestApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RudererRestDao rudererRestDao = (RudererRestDao) context.getBean("rudererRestDao");
        List<Ruderer> ruderers = rudererRestDao.loadAll();
        Ruderer ruderer = rudererRestDao.load(1);
        System.exit(0);
    }
}
