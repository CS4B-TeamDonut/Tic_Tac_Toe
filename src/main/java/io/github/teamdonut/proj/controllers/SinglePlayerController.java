package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.Player;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import io.github.teamdonut.proj.utils.Logger;
import io.github.teamdonut.proj.utils.RestrictiveTextField;
import io.github.teamdonut.sounds.EventSounds;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Intermediate Screen controller class where the player can enter their name
 * @author Utsav Parajuli
 * @version 0.3
 */
public class SinglePlayerController implements Initializable, ISubject {

    @FXML
    public Label title;

    @FXML
    public RestrictiveTextField nameEntry;

    @FXML
    public ImageView startButton;

    @FXML
    private ImageView backButton;

    @FXML
    private BorderPane intermediatePage;

    @FXML
    private Label difficultyLevelTitle;

    @FXML
    private Label tokenSelectorTitle;

    @FXML
    private RadioButton tokenX;

    @FXML
    private RadioButton tokenO;

    @FXML
    private RadioButton easyMode;

    @FXML
    private RadioButton hardMode;

    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"));

    private final Image startButtonIdle = new Image(getClass().getResourceAsStream("../images/theme_2/start_button.png"));
    private final Image startButtonHover = new Image(getClass().getResourceAsStream("../images/theme_2/start_button_hover.png"));

//    private static SinglePlayerController instance;     //instance of the controller

    /**
     * This method will return the instance of the controller
     *
     * @return this
     * @author Utsav Parajuli
     */
//    public static SinglePlayerController getInstance() {
//        return instance;
//    }

    /**
     * Constructor
     *
     * @author Utsav Parajuli
     */
//    public SinglePlayerController() {
//        instance = this;
//    }


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     * @author Utsav Parajuli
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setting the name entry title
        title.setText("Please Enter Your Name");
        title.setAlignment(Pos.TOP_CENTER);

        //name entry box
        nameEntry.setAlignment(Pos.CENTER);

        //TODO: Setting the number of characters the player can use as a name; Here I put
        //      4 so when you go to enter you can't enter anymore after 4 characters
        nameEntry.setMaxLength(5);

        //start button
        startButton.setId("startButton");

        //difficulty level option
        difficultyLevelTitle.setText("Difficulty: ");
        ToggleGroup difficultyGroup = new ToggleGroup();
        easyMode.setText("Easy");
        hardMode.setText("Hard");
        easyMode.setToggleGroup(difficultyGroup);
        easyMode.setSelected(true);
        hardMode.setToggleGroup(difficultyGroup);

        //token selector option
        tokenSelectorTitle.setText("    Token: ");
        ToggleGroup tokenGroup = new ToggleGroup();
        tokenX.setText("X");
        tokenO.setText("O");
        tokenX.setToggleGroup(tokenGroup);
        tokenX.setSelected(true);
        tokenO.setToggleGroup(tokenGroup);
    }

    /**
     * When the name of the user is entered and all the options are chosen this method will start the game
     *
     * @param keyEvent : press of a key
     * @author Utsav Parajuli
     */
    public void onNameEntered(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            startGame();
        }
    }

    /**
     * This method will start the game when the start button is clicked
     *
     * @param actionEvent : mouse click
     */
    public void onStartButtonClick(MouseEvent actionEvent) {
        EventSounds.getInstance().playButtonSound2();
        startGame();
    }

    /**
     * Helper method that will check the options entered by the user and assign the correct token to both the
     * player and NPC. Will also check the difficulty level. Then will instantiate a game object and notify the observers
     *
     * @author : Utsav Parajuli
     */
    private void startGame() {
        char userToken;
        char cpuToken;
        String cpuLevel;
        String userName;

        if (nameEntry.getText().isEmpty()) {
            userName = "Guest";
        }
        else {
            userName = nameEntry.getText();
        }

        if (tokenO.isSelected()) {
            userToken = 'O';
            cpuToken = 'X';
        } else {
            userToken = 'X';
            cpuToken = 'O';
        }

        if (easyMode.isSelected()) {
            cpuLevel = "Rook";
        } else {
            cpuLevel = "Pro";
        }

        GameController game = new GameController(
                new Player(userName, userToken),
                new Player(cpuLevel, cpuToken));

//        EventManager.notify(SinglePlayerController.getInstance(), game);
        EventManager.notify(this, game);
    }

    /**
     * Event handler for back button
     *
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