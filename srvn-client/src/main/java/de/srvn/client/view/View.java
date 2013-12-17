package de.srvn.client.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

/**
 * @author Markus Moormann
 * @version 16.12.13 - 22:25
 */
public abstract class View {

    public final static String DEFAULT_ENDING = "view";
    private FXMLLoader fxmlLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() throws IOException {
        final URL resource = getClass().getResource(getFXMLName());
        String bundleName = getBundleName();
        ResourceBundle bundle = getResourceBundle(bundleName);
        fxmlLoader = new FXMLLoader(resource, bundle);
        fxmlLoader.load();
    }

    public Parent getView() {
        Parent parent = this.fxmlLoader.getRoot();
        addCSSIfAvailable(parent);
        return parent;
    }

    /**
     * Scene Builder creates for each FXML document a root container. This
     * method omits the root container (e.g. AnchorPane) and gives you the
     * access to its first child.
     *
     * @return the first child of the AnchorPane
     */
    public Node getViewWithoutRootContainer() {
        final ObservableList<Node> children = getView().getChildrenUnmodifiable();
        if (children.isEmpty()) {
            return null;
        }
        return children.listIterator().next();
    }

    void addCSSIfAvailable(Parent parent) {
        URL uri = getClass().getResource(getStyleSheetName());
        if (uri == null) {
            return;
        }
        String uriToCss = uri.toExternalForm();
        parent.getStylesheets().add(uriToCss);
    }

    String getStyleSheetName() {
        return getConventionalName(".css");
    }

    public Object getPresenter() {
        Object controller = this.fxmlLoader.getController();
        return controller;
    }

    String getConventionalName(String ending) {
        return getConventionalName() + ending;
    }

    String getConventionalName() {
        String clazz = this.getClass().getSimpleName().toLowerCase();
        return stripEnding(clazz);
    }

    String getBundleName() {
        String conventionalName = getConventionalName();
        return this.getClass().getPackage().getName() + "." + conventionalName;
    }

    static String stripEnding(String clazz) {
        if (!clazz.endsWith(DEFAULT_ENDING)) {
            return clazz;
        }
        int viewIndex = clazz.lastIndexOf(DEFAULT_ENDING);
        return clazz.substring(0, viewIndex);
    }

    final String getFXMLName() {
        return getConventionalName(".fxml");
    }

    static ResourceBundle getResourceBundle(String name) {
        try {
            return getBundle(name);
        } catch (MissingResourceException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
