package de.srvn.client.view.menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import org.springframework.stereotype.Component;

/**
 * @author Markus Moormann
 * @version 17.12.13 - 20:33
 */
@Component
public class MenuView {

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void test(ActionEvent actionEvent) {
    }
}
