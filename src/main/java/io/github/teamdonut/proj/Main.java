package io.github.teamdonut.proj;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new GameController(stage).startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

