package io.github.teamdonut.proj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardPageController implements Initializable {

    Image backButtonIdle = new Image(getClass().getResourceAsStream("images/common/back_arrow.png"));
    Image backButtonHover = new Image(getClass().getResourceAsStream("images/common/back_arrow_hover_gray.png"));

    @FXML
    private ImageView backButton;

    @FXML
    private BorderPane boardPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BoardUI board = new BoardUI();
        boardPage.setCenter(board);
    }

    public void onBackButtonClick(MouseEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
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
