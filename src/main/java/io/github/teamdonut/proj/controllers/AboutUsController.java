package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.ISubject;
import io.github.teamdonut.proj.utils.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutUsController implements Initializable, ISubject {

    @FXML
    public Label aboutUsTitle;

    @FXML
    public ImageView backButton;

    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"));
    public BorderPane aboutUsPage;

    @FXML
    public Hyperlink githubLink;

    @FXML
    public Label contributors;

    @FXML
    public Label info;


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
        aboutUsTitle.setText("TEAM DONUT CS4B");

        info.setText("""
                Welcome to our Tic Tac Toe Board Game. You will
                be able to play local multiplayer with your friends,
                as well as battle against a computer A.I. in two 
                difficulty modes. We will be adding new features
                soon. Stay tuned.
                            Have fun and happy playing!!""");

        githubLink.setText("GitHub Repository");
        githubLink.setOnAction(event -> {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/kboniadi/Tic_Tac_Toe"));
                } catch (IOException | URISyntaxException e) {
                    Logger.log(e);
                }
            }
        });

        contributors.setText("""
                             Kord Boniadi, Brandon Nguyen, Grant Goldsworth, Joey Campbell, Utsav Parajuli
                                                            Copyright 2021 © Donut""");


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

