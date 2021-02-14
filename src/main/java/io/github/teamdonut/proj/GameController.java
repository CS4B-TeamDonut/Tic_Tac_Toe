package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Central Hub where all classes interact with
 * @author Kord Boniadi
 */
public class GameController implements IObserver {
    private final Stage mainStage;
    public BoardUI boardUI;
    private Board board;
    public Scene mainScene;
    public Scene boardScene;

    /**
     * Constructor
     * @param stage mainStage object received from javafx start() method
     * @author Kord Boniadi
     */
    public GameController(Stage stage) {
        this.mainStage = stage;
    }

    /**
     * Initializes starting page for app
     * @throws IOException failure to initialize *.fxml loader files
     * @author Kord Boniadi
     */
    public void startGame() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));

        EventManager.register(MainController.getInstance(), this);

        mainScene = new Scene(root);
        mainScene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
        mainStage.setUserData(this);

        mainStage.setTitle("JavaFX and Gradle");
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
        if (eventType instanceof Board) {
            this.board = (Board) eventType;
            this.boardUI = new BoardUI();
            ImageView view = new ImageView(new Image(getClass().getResourceAsStream("images/common/back_arrow.png")));
            view.setPreserveRatio(true);
            view.setFitWidth(200);
            view.setFitHeight(100);

            view.setOnMouseClicked(event -> {
                mainStage.setScene(mainScene);
                mainStage.show();
            });

            view.setOnMouseEntered(event -> {
                view.setImage(new Image(getClass().getResourceAsStream("images/common/back_arrow_hover_gray.png")));
            });

            view.setOnMouseExited(event -> {
                view.setImage(new Image(getClass().getResourceAsStream("images/common/back_arrow.png")));
            });

            BorderPane pane = new BorderPane(
                    this.boardUI,
                    new HBox(view),
                    null,
                    null,
                    null
            );
            pane.setId("boardPage");
            pane.setPrefWidth(800);
            pane.setPrefHeight(450);

            EventManager.register(boardUI, this);
            boardScene = new Scene(pane);
            boardScene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
            mainStage.setScene(boardScene);
            mainStage.show();
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource("boardPage.fxml"));
//                boardScene = new Scene(root);
//                boardScene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
//                this.board = (Board) eventType;
//                this.boardUI = new BoardUI();
//                BoardPageController.getInstance().setGameController(this);
//                mainStage.setScene(boardScene);
//                mainStage.show();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        } else if (eventType instanceof BoardUI.UserSelectionData) {
            BoardUI.UserSelectionData temp = (BoardUI.UserSelectionData) eventType;
            this.board.updateToken(temp.getX(), temp.getY(), 'X');
            this.boardUI.drawBoard(this.board);
        }
    }
}
