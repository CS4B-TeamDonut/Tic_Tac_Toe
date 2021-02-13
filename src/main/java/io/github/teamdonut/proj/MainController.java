package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, ISubject {
    @FXML
    private Label label;

    /*
     *  // By pass the need for this:
     *  FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
     *  Parent root = loader.load();
     *
     *  Controller myController = loader.getController();
     *********************************************************************/
    private static MainController instance;
    public static MainController getInstance() {
        return instance;
    }

    public MainController() {
        instance = this;
    }
    /*end*****************************************************************/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }


    public void onGameButtonClick(ActionEvent actionEvent) throws IOException {
        Board board = new Board();
        EventManager.notify(this, board);

//        Parent root = FXMLLoader.load(getClass().getResource("boardPage.fxml"));
//        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
////        Stage window = (Stage) gameButton.getScene().getWindow();
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
//        window.setScene(scene);
//        window.setResizable(false);
//        window.show();
    }
}
