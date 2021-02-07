package io.github.teamdonut.proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/io.github.teamdonut.proj/scene.fxml")));
        BoardUI test = new BoardUI();
        Scene scene = new Scene(test);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/io.github.teamdonut.proj/styles.css")).toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

