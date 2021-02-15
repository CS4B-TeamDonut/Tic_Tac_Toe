package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main Screen Controller class
 * @author Grant Goldsworth
 */
public class MainController implements Initializable, ISubject {
    @FXML
    public VBox mainMenuPane;

    @FXML
    private ImageView singlePlayerButton;

    @FXML
    private ImageView multiPlayerButton;


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
//        I (Grant) am temporarily ommitting this to remove the label text from the launch screen
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");

        // create single player button graphic
        // obtain input
//        ImageView singleplayerView = new ImageView(new Image(getClass().getResourceAsStream("images/theme_1/singleplayer_button.png")));
//        singleplayerView.setPreserveRatio(true);
//        singleplayerView.setFitHeight(120);
//        singleplayerView.setFitWidth(40);
//        singlePlayerButton.setGraphic(singleplayerView);
//        singlePlayerButton.setPrefSize(120, 40);

    }


    public void onSinglePlayerButtonClick(/*MouseEvent mouseEvent*/) {
        Board board = new Board();
        EventManager.notify(this, board);

        //        Parent root = FXMLLoader.load(getClass().getResource("boardPage.fxml"));
        //        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //        Stage window = (Stage) gameButton.getScene().getWindow();
        //        Scene scene = new Scene(root);
        //        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
        //        window.setScene(scene);
        //        window.setResizable(false);
        //        window.show();
    }

    public void onSinglePlayerButtonHover(/*MouseEvent mouseEvent*/) {
        singlePlayerButton.setImage(new Image(getClass().getResourceAsStream("images/theme_1/singleplayer_button_hover.png")));
    }

    public void onSinglePlayerButtonExit(/*MouseEvent mouseEvent*/) {
        singlePlayerButton.setImage(new Image(getClass().getResourceAsStream("images/theme_1/singleplayer_button.png")));
    }



    public void onMultiPlayerButtonClick(/*MouseEvent mouseEvent*/) {

    }

    public void onMultiPlayerButtonHover(/*MouseEvent mouseEvent*/) {
        multiPlayerButton.setImage(new Image(getClass().getResourceAsStream("images/theme_1/multiplayer_button_hover.png")));
    }

    public void onMultiPlayerButtonExit(/*MouseEvent mouseEvent*/) {
        multiPlayerButton.setImage(new Image(getClass().getResourceAsStream("images/theme_1/multiplayer_button.png")));
    }

}
