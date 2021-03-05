package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.Player;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import io.github.teamdonut.proj.utils.RestrictiveTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MultiplayerController implements Initializable, ISubject {

    @FXML
    public Label title;

    @FXML
    public Label player1Name;

    @FXML
    public RestrictiveTextField nameEntryMP1;

    @FXML
    public RestrictiveTextField nameEntryMP2;

//    @FXML
//    public TextField nameEntryMP1;
//
//    @FXML
//    public TextField nameEntryMP2;

    @FXML
    public ImageView startButton;

    @FXML
    private ImageView backButton;

    @FXML
    public RadioButton tokenXP1;

    @FXML
    public RadioButton tokenOP1;

    @FXML
    public RadioButton tokenXP2;

    @FXML
    public RadioButton tokenOP2;

    private char tokenP1;
    private char tokenP2;

    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"));
    private final Image startButtonIdle = new Image(getClass().getResourceAsStream("../images/theme_2/start_button.png"));
    private final Image startButtonHover = new Image(getClass().getResourceAsStream("../images/theme_2/start_button_hover.png"));
    private static MultiplayerController instance;     //instance of the controller

    /**
     * This method will return the instance of the controller
     *
     * @return this (a MultiplayerController object)
     * @author Joey Campbell
     */
    public static MultiplayerController getInstance() {
        return instance;
    }

    /**
     * Constructs a MultiplayerController object by instantiating its own static instance
     *
     * @author Joey Campbell
     */
    public MultiplayerController() {
        instance = this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ToggleGroup tokenGroup1 = new ToggleGroup();
        ToggleGroup tokenGroup2 = new ToggleGroup();

        tokenXP1.setToggleGroup(tokenGroup1);
        tokenOP1.setToggleGroup(tokenGroup1);
        tokenXP1.setSelected(true);

        tokenXP2.setToggleGroup(tokenGroup2);
        tokenOP2.setToggleGroup(tokenGroup2);
        tokenOP2.setSelected(true);

        tokenP1 = 'X';
        tokenP2 = 'O';

        nameEntryMP1.setMaxLength(5);
        nameEntryMP2.setMaxLength(5);

    }

    public void onNameEntered(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            startGame();
        }
    }

    public void onToggleClick1 (MouseEvent actionEvent) {
        if (tokenXP1.isSelected()) {
            tokenOP2.setSelected(true);
            tokenP1 = 'X';
            tokenP2 = 'O';
        }
        else {
            tokenXP2.setSelected(true);
            tokenP1 = 'O';
            tokenP2 = 'X';
        }
    }

    public void onToggleClick2 (MouseEvent actionEvent) {
        if (tokenXP2.isSelected()) {
            tokenOP1.setSelected(true);
            tokenP2 = 'X';
            tokenP1 = 'O';
        }
        else {
            tokenXP1.setSelected(true);
            tokenP2 = 'O';
            tokenP1 = 'X';
        }
    }

    public void onStartButtonClick(MouseEvent actionEvent) {
        startGame();
    }

    private void startGame() {
        String player1Name;
        String player2Name;


        if (nameEntryMP1.getText().isEmpty()) {
            player1Name = "P1";
        }
        else {
            player1Name = "P1: " + nameEntryMP1.getText();
        }

        if (nameEntryMP2.getText().isEmpty()) {
            player2Name = "P2";
        }
        else {
            player2Name = "P2: " + nameEntryMP2.getText();
        }
        System.out.println(tokenP1 + "  " + tokenP2);
        GameController game = new GameController(
                new Player(player1Name, tokenP1),
                new Player(player2Name, tokenP2));

        EventManager.notify(MultiplayerController.getInstance(), game);
    }

    /**
     * Event handler for back button
     *
     * @param actionEvent mouse event
     * @author Kord Boniadi
     */
    public void onBackButtonClick(MouseEvent actionEvent) {
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Donut Tic Tac Toe");
        window.setScene(((AppController) window.getUserData()).mainScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Event handler for back button hover effect
     *
     * @author Kord Boniadi
     */
    public void onBackButtonEnter() {
        backButton.setImage(backButtonHover);
    }

    /**
     * Event handler for back button idle effect
     *
     * @author Kord Boniadi
     */
    public void onBackButtonExit() {
        backButton.setImage(backButtonIdle);
    }

    /**
     * Event handler for start button hover effect
     *
     * @author Utsav Parajuli
     */
    public void onStartButtonEnter() {
        startButton.setImage(startButtonHover);
    }

    /**
     * Event handler for start button idle effect
     *
     * @author Utsav Parajuli
     */
    public void onStartButtonExit() {
        startButton.setImage(startButtonIdle);
    }
}
