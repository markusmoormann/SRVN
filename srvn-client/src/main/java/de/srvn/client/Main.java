package de.srvn.client;

import de.srvn.client.config.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:27
 */
public class Main extends Application {

    private static final SpringFxmlLoader loader = new SpringFxmlLoader();

    public static void main(String[] args) {
        launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) loader.load("/de/srvn/client/view/main/main.fxml");
        Scene scene = new Scene(root, 768, 480);
        stage. setMaximized(true);
        stage.setScene(scene);
        stage.setTitle("Regatta");
        stage.show();
    }
}
