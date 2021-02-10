package io.github.teamdonut.proj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }


    public void onGameButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("boardPage.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        Stage window = (Stage) gameButton.getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
        window.setScene(scene);
        window.setResizable(true);
        window.show();
    }
}
