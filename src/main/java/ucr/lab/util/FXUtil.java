package ucr.lab.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FXUtil {
    public static void loadPage(String className, String page, AnchorPane ap) {
        try {
            Class<?> cl = Class.forName(className);
            FXMLLoader fxmlLoader = new FXMLLoader(cl.getResource(page));
            AnchorPane root = fxmlLoader.load(); // o Parent root = ...
            ap.getChildren().setAll(root); // Esto reemplaza el contenido del AnchorPane
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Alert informationDialog(String title) {
        Alert myalert = new Alert(Alert.AlertType.NONE);
        myalert.setAlertType(Alert.AlertType.INFORMATION);
        myalert.setTitle(title);
        myalert.setHeaderText(null);
        return myalert;
    }
}
