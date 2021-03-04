package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.ISubject;
import io.github.teamdonut.sounds.EventSounds;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main Screen Controller class
 * @author Grant Goldsworth
 */
public class MainController implements Initializable, ISubject {
    @FXML
    public BorderPane mainMenuPane;

//    @FXML
//    private ImageView aboutButton;      //corner button

    @FXML
    private ImageView aboutUsRect;      //rectangle button

    @FXML
    private ImageView singlePlayerButton;

    @FXML
    private ImageView multiPlayerButton;

    @FXML
    private Scene aboutUsScene;

    private final String theme = "theme_2";

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
     * Is implicitly called when the main screen is being shown, currently does nothing
     * @param url javafx specific
     * @param rb javafx specific
     * @author Kord Boniadi
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        I (Grant) am temporarily omitting this to remove the label text from the launch screen
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

    /**
     * Handles mouse click event on the single player image "button".
     * @author Grant Goldsworth
     */
    public void onSinglePlayerButtonClick(/*MouseEvent mouseEvent*/) {
//        GameController game = new GameController();
//        EventManager.notify(this, game);
        EventSounds.getInstance().playButtonSound2();
        SinglePlayerController name = new SinglePlayerController();
        EventManager.notify(this, name);
        //        Parent root = FXMLLoader.load(getClass().getResource("boardPage.fxml"));
        //        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //        Stage window = (Stage) gameButton.getScene().getWindow();
        //        Scene scene = new Scene(root);
        //        scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
        //        window.setScene(scene);
        //        window.setResizable(false);
        //        window.show();
    }

    /**
     * Handles mouse hover event on the single player image "button", changing
     * the button icon to the hovered icon status.
     * @author Grant Goldsworth
     */
    public void onSinglePlayerButtonHover(/*MouseEvent mouseEvent*/) {
        singlePlayerButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/singleplayer_button_hover.png")));
    }

    /**
     * Handles mouse hover exit event on the single player image "button", changing the
     * button icon to the normal status.
     * @author Grant Goldsworth
     */
    public void onSinglePlayerButtonExit(/*MouseEvent mouseEvent*/) {
        singlePlayerButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/singleplayer_button.png")));
    }

    /**
     * Handles mouse hover exit event on the multiplayer image "button".
     * Currently does nothing as MP is not implemented yet.
     * @author Grant Goldsworth
     */
    public void onMultiPlayerButtonClick(/*MouseEvent mouseEvent*/) {
        EventSounds.getInstance().playButtonSound2();
    }

    /**
     * Handles mouse hover exit event on the multi player image "button", changing the
     * button icon to the hover status.
     * @author Grant Goldsworth
     */
    public void onMultiPlayerButtonHover(/*MouseEvent mouseEvent*/) {
        multiPlayerButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/multiplayer_button_hover.png")));
    }


    /**
     * Handles mouse hover exit event on the multi player image "button", changing the
     * button icon to the normal status.
     * @author Grant Goldsworth
     */
    public void onMultiPlayerButtonExit(/*MouseEvent mouseEvent*/) {
        multiPlayerButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/multiplayer_button.png")));
    }

    /**
     * Handles mouse click event on the about us image "button".
     * @author Utsav Parajuli
     */
    public void onAboutButtonClicked(/*MouseEvent mouseEvent*/) {
        EventSounds.getInstance().playButtonSound2();
        AboutUsController aboutUs = new AboutUsController();
        EventManager.notify(this, aboutUs);
    }

//    /**
//     * Handles mouse hover event on the about us image "button", changing
//     * the button icon to the hovered icon status.
//     * @author Utsav Parajuli
//     */
//    public void onAboutButtonEnter(/*MouseEvent mouseEvent*/) {
//        aboutButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/about_button_square_hover.png")));
//    }
//
//    /**
//     * Handles mouse hover exit event on the about us image "button", changing the
//     * button icon to the normal status.
//     * @author Utsav Parajuli
//     */
//    public void onAboutButtonExit(MouseEvent mouseEvent) {
//        aboutButton.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/about_button_square.png")));
//    }

    /**
     * Handles mouse hover event on the about us image "button", changing
     * the button icon to the hovered icon status.
     * @author Utsav Parajuli
     */
    public void onAboutRectEnter(/*MouseEvent mouseEvent*/) {
        aboutUsRect.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/about_button_hover.png")));

    }

    /**
     * Handles mouse hover exit event on the about us image "button", changing the
     * button icon to the normal status.
     * @author Utsav Parajuli
     */
    public void onAboutRectExit(/*MouseEvent mouseEvent*/) {
        aboutUsRect.setImage(new Image(getClass().getResourceAsStream("../images/" + theme + "/about_button.png")));

    }
}
