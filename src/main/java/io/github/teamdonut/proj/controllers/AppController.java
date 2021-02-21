package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.BoardUI;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.utils.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Central Hub where all classes interact with
 * @author Kord Boniadi
 */
public class AppController implements IObserver {
    private final Stage mainStage;
    public BoardUI boardUI;
    public Scene mainScene;
    public Scene boardScene;

    /**
     * Constructor
     * @param stage mainStage object received from javafx start() method
     * @author Kord Boniadi
     */
    public AppController(Stage stage) {
        Logger.init("io/github/teamdonut/proj/configs/logging.properties");
        this.mainStage = stage;
    }

    /**
     * Initializes starting page for app
     * @throws IOException failure to initialize *.fxml loader files
     * @author Kord Boniadi
     */
    public void startApp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../startPage.fxml"));

        EventManager.register(MainController.getInstance(), this);

        mainScene = new Scene(root);
        mainScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
        mainStage.setUserData(this);

        // set the title of the stage
        mainStage.setTitle("Donut Tic Tac Toe");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.show();
    }

    /**
     * Receives data from a subscribed subject
     * @param eventType object container
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {
        if (eventType instanceof GameController) {
            Label score = new Label("{running score}");
            score.setId("score");

            GameController game = (GameController) eventType;
            this.boardUI = new BoardUI();
            ImageView view = new ImageView(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png")));
            view.setPreserveRatio(true);
            view.setFitWidth(200);
            view.setFitHeight(100);

            view.setOnMouseClicked(event -> {
                mainStage.setScene(mainScene);
                mainStage.show();
            });

            view.setOnMouseEntered(event -> {
                view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png")));
            });

            view.setOnMouseExited(event -> {
                view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png")));
            });

            VBox centerScene = new VBox(score, this.boardUI);
            centerScene.setSpacing(10);
            centerScene.setAlignment(Pos.TOP_CENTER);
            BorderPane pane = new BorderPane(
                    centerScene,
                    new HBox(view),
                    new Label(game.getPlayer2().getPlayerName()),
                    null,
                    new Label(game.getPlayer1().getPlayerName())
            );
            pane.setId("boardPage");
            pane.setPrefWidth(800);
            pane.setPrefHeight(450);

            EventManager.register(boardUI, game.getPlayer1());
            EventManager.register(boardUI, game.getPlayer2());
            EventManager.register(game, boardUI);
//            EventManager.register(boardUI, this);
            boardScene = new Scene(pane);
            boardScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(boardScene);
        }
    }
}
