package io.github.teamdonut.proj;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Button gameButton;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }


    public void onGameButtonClick(ActionEvent actionEvent) {
        BoardUI board = new BoardUI();

        Stage window = (Stage) gameButton.getScene().getWindow();
        Scene scene = new Scene(board);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/io/github/teamdonut/proj/styles.css")).toExternalForm());
        window.setScene(scene);
        window.setResizable(true);
        window.setHeight(1080);
        window.setWidth(1920);
        window.show();
    }
}
