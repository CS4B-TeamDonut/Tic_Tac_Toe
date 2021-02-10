package io.github.teamdonut.proj;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new GameController(stage).startGame();
    }

    public static void main(String[] args) {

        Board test1 = new Board();
        Board test2 = new Board();
        test1.updatePosition(1, 0, 'X');
        test1.updatePosition(1,0,'O');
        System.out.println(test1);
        launch(args);
    }
}

