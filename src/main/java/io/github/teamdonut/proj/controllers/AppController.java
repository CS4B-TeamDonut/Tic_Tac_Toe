package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.music.MusicPlayer;
import io.github.teamdonut.proj.common.BoardUI;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.utils.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Central Hub where all classes interact with
 * @author Kord Boniadi
 * @author Utsav Parajuli
 */
public class AppController implements IObserver {
    private final Stage mainStage;
    public BoardUI boardUI;
    public Scene mainScene;
    public Scene boardScene;
    public Scene singlePlayerScene;
    public Scene multiplayerScene;
    public Scene aboutUsScene;

    /**
     * Constructor
     * @param stage mainStage object received from javafx start() method
     * @author Kord Boniadis
     */
    public AppController(Stage stage) {
        Logger.init("io/github/teamdonut/proj/configs/logging.properties");
        this.mainStage = stage;
    }

    /**
     * Initializes starting page for app
     * @throws IOException failure to initialize *.fxml loader files
     * @author Kord Boniadi
     */
    public void startApp() throws IOException {
        MusicPlayer.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("../startPage.fxml"));

        Scene start = new Scene(root);
        start.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
        mainStage.setUserData(this);
        root.requestFocus();
        // set the title of the stage
        mainStage.setTitle("Donut Tic Tac Toe");
        mainStage.setScene(start);
        mainStage.setResizable(false);
        mainStage.show();
        Logger.log("program started..");
    }

    public void createAboutPage(AboutUsController obj) {
        EventManager.register(obj, this);

        //loads fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../aboutUs.fxml"));

        //setting the main stage to the about us page scene
        try {
            aboutUsScene = new Scene(loader.load());
            aboutUsScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(aboutUsScene);
        } catch (IOException e) {
            Logger.log(e);
        }
    }

    public void createSinglePlayerPage(SinglePlayerController obj) {
        EventManager.register(obj, this);

        //loads the fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../singlePlayerPage.fxml"));

        //setting the controller
        loader.setController(obj);
        try {
            singlePlayerScene = new Scene(loader.load());
            singlePlayerScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(singlePlayerScene);
        } catch (IOException e) {
            Logger.log(e);
        }
    }

    public void createBoardPage(GameController obj) {
        boardUI = new BoardUI();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../boardPage.fxml"));
        loader.setController(new BoardPageController(boardUI, obj));
        try {
            boardScene = new Scene(loader.load());
            boardScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(boardScene);
        } catch (IOException e) {
            Logger.log(e);
        }
        EventManager.register(boardUI, obj.getPlayer1());
        EventManager.register(boardUI, obj.getPlayer2());
        EventManager.register(obj, boardUI);
    }
    /**
     * Receives data from a subscribed subject
     * @param eventType object container
     * @author Kord Boniadi
     * @author Utsav Parajuli
     */
    @Override
    public void update(Object eventType) {

        if (eventType instanceof AboutUsController) // checking if event type is an AboutUsController
            createAboutPage((AboutUsController) eventType);
        else if (eventType instanceof SinglePlayerController)   // checking if event type is an SinglePlayerController
            createSinglePlayerPage((SinglePlayerController) eventType);
        else if (eventType instanceof GameController)   // checking if event type is an GameController
            createBoardPage((GameController) eventType);
    }
}
