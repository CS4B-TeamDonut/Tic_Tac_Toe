package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.ISubject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView backButton;

    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"));

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
        title.setText("Multiplayer Mode");
        title.setAlignment(Pos.TOP_CENTER);

        player1Name.setAlignment(Pos.TOP_CENTER);
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
}
