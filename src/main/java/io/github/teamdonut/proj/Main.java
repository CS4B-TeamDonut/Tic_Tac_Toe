package io.github.teamdonut.proj;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new GameController(stage).startGame();
    }

    public static void main(String[] args) {
        Board test = new Board();

        test.updatePosition(0, 1, 'X');

        System.out.println(test);

        test.clearBoard();

        System.out.println(test);

        launch(args);
    }
}

