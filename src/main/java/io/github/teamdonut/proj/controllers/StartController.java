package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.sounds.EventSounds;
import io.github.teamdonut.proj.listener.EventManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Start page controller class
 * @author Kord Boniadi
 */
public class StartController implements Initializable {
    @FXML
    public Pane startPage;

    @FXML
    private Label startKey;


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     * @author Kord Boniadi
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startKey.setText("Press (Z) to begin");
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> startKey.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> startKey.setVisible(true))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Key press event handler
     * @param keyEvent  keyboard detection event
     * @throws IOException  fxml detection exception
     * @author Kord Boniadi
     */
    public void onKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.Z)) {
            EventSounds.getInstance().playButtonSound4();
            Stage window = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));

            EventManager.register(MainController.getInstance(), (AppController) window.getUserData());

            Scene mainScene = new Scene(root);
            mainScene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());

            ((AppController) window.getUserData()).mainScene = mainScene;

            // set the title of the stage
            window.setTitle("Donut Tic Tac Toe");
            window.setScene(mainScene);
            window.setResizable(false);
        }
    }
}
