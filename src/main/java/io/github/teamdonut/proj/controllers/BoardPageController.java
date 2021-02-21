package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.BoardUI;
import io.github.teamdonut.proj.listener.EventManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class should no longer be used
 * @deprecated
 */
@Deprecated
public class BoardPageController implements Initializable {

    @FXML
    private ImageView backButton;

    @FXML
    private BorderPane boardPage;

    private BoardUI board;
    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("images/common/back_arrow_hover_gray.png"));

    public BoardPageController(BoardUI board) {
        this.board = board;
    }

    public void setGameController(AppController game) {
//        this.game = game;
//        this.boardUI = game.boardUI;
//        EventManager.register(boardUI, this.game);
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardPage.setCenter(board);
    }

    public void onBackButtonClick(MouseEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = ((AppController) window.getUserData()).mainScene;
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
        window.setTitle("JavaFX and Gradle");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void onBackButtonEnter() {
        backButton.setImage(backButtonHover);
    }

    public void onBackButtonExit() {
        backButton.setImage(backButtonIdle);
    }
}
