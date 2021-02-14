package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main Screen Controller class
 * @author Kord Boniadi
 */
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

    /**
     * @return instance of Main screen controller
     */
    public static MainController getInstance() {
        return instance;
    }

    /**
     * Constructor
     */
    public MainController() {
        instance = this;
    }
    /*end*****************************************************************/

    /**
     * Is implicitly called when the main screen is being shown
     * @param url javafx specific
     * @param rb javafx specific
     * @author Kord Boniadi
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }


    /**
     * Event handler that's triggered on "start game" button click
     * @param actionEvent javafx specific
     * @see EventManager#notify(ISubject, Object)
     * @author Kord Boniadi
     */
    public void onGameButtonClick(ActionEvent actionEvent) {
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
