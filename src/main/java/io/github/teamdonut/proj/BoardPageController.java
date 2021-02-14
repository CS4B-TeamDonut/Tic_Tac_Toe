package io.github.teamdonut.proj;

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
public class BoardPageController implements Initializable {

    private BoardUI boardUI;
    private GameController game;
    private final Image backButtonIdle = new Image(getClass().getResourceAsStream("images/common/back_arrow.png"));
    private final Image backButtonHover = new Image(getClass().getResourceAsStream("images/common/back_arrow_hover_gray.png"));

    private static BoardPageController instance;
    public static BoardPageController getInstance() {
        return instance;
    }

    public BoardPageController() {
        instance = this;
    }

    public void setGameController(GameController game) {
        this.game = game;
        this.boardUI = game.boardUI;
        EventManager.register(boardUI, this.game);
    }

    @FXML
    private ImageView backButton;

    @FXML
    private BorderPane boardPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        boardUI = new BoardUI();
        boardPage.setCenter(this.boardUI);
    }

    public void onBackButtonClick(MouseEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = ((GameController) window.getUserData()).mainScene;
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
