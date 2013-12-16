package de.srvn.client;

import de.srvn.client.config.AppConfig;
import de.srvn.client.config.MainApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:27
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MainApp mainApp = context.getBean(MainApp.class);
        mainApp.run();

        context.close();
    }

}
