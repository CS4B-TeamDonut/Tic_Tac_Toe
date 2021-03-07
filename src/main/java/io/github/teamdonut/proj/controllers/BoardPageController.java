package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.Player;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.sounds.EventSounds;
import io.github.teamdonut.proj.common.BoardUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class handles the game board page UI
 * @author Kord Boniadi
 */
public class BoardPageController implements Initializable, IObserver {

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
        EventManager.register(game, this);
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
        playerNameLeft.setText(game.getPlayer1().getPlayerName());
        playerNameRight.setText(game.getPlayer2().getPlayerName());
        playerNameLeft.setPrefWidth(150);
        playerNameRight.setPrefWidth(150);

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
        EventManager.removeAllObserver(game);
        EventManager.removeAllObserver(game.getPlayer1());
        EventManager.removeAllObserver(game.getPlayer2());
        EventManager.removeAllObserver(board);
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

    /**
     * New info is received through this method. Object decoding is needed
     *
     * @param eventType General Object type
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {
        if (eventType instanceof Player) {
            if (((Player) eventType).getPlayerToken() == game.getPlayer1().getPlayerToken()) {
                playerNameLeft.setBorder(new Border(new BorderStroke(
                        Color.GOLD,
                        BorderStrokeStyle.SOLID,
                        null,
                        BorderStroke.THIN,
                        Insets.EMPTY
                )));
                playerNameRight.setBorder(null);
            } else if (((Player) eventType).getPlayerToken() == game.getPlayer2().getPlayerToken()) {
                playerNameRight.setBorder(new Border(new BorderStroke(
                        Color.GOLD,
                        BorderStrokeStyle.SOLID,
                        null,
                        BorderStroke.THIN,
                        Insets.EMPTY
                )));
                playerNameLeft.setBorder(null);
            }
        }
    }
}
