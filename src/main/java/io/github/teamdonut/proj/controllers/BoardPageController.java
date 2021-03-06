package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.sounds.EventSounds;
import io.github.teamdonut.proj.common.BoardUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class handles the game board page UI
 * @author Kord Boniadi
 */
public class BoardPageController implements Initializable {

    @FXML
    private Label scoreLabel;

    @FXML
    private Label playerNameLeft;

    @FXML
    private Label playerNameRight;

    @FXML
    private ImageView backButton;

    @FXML
    private BorderPane boardPage;

    private final BoardUI board;
    private final GameController game;
    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"));

    /**
     * Constructor
     * @param board instance of boardUI
     * @param game instance of gameController
     * @author Kord Boniadi
     */
    public BoardPageController(BoardUI board, GameController game) {
        this.board = board;
        this.game = game;
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     * @author Kord Boniadi
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreLabel.setText("score");
        playerNameLeft.setText(game.getPlayer1().getPlayerName());
        playerNameRight.setText(game.getPlayer2().getPlayerName());
        ((VBox) boardPage.getCenter()).getChildren().add(board);
        BorderPane.setAlignment(playerNameLeft, Pos.TOP_CENTER);
        BorderPane.setAlignment(playerNameRight, Pos.TOP_CENTER);
    }

    /**
     * Event handler for back button
     * @param actionEvent mouse event
     * @author Kord Boniadi
     */
    public void onBackButtonClick(MouseEvent actionEvent) {
        EventSounds.getInstance().playButtonSound1();
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Donut Tic Tac Toe");
        window.setScene(((AppController) window.getUserData()).mainScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Event handler for back button hover effect
     * @author Kord Boniadi
     */
    public void onBackButtonEnter() {
        backButton.setImage(backButtonHover);
    }

    /**
     * Event handler for back button idle effect
     * @author Kord Boniadi
     */
    public void onBackButtonExit() {
        backButton.setImage(backButtonIdle);
    }

}
