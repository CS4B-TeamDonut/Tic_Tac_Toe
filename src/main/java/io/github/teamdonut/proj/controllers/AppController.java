package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.MusicPlayer;
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
 */
public class AppController implements IObserver {
    private final Stage mainStage;
    public BoardUI boardUI;
    public Scene mainScene;
    public Scene boardScene;
    public Scene intermediateScene;
    public Scene aboutUsScene;

    /**
     * Constructor
     * @param stage mainStage object received from javafx start() method
     * @author Kord Boniadi
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

//        Parent root = FXMLLoader.load(getClass().getResource("../menuPage.fxml"));
//
//        EventManager.register(MainController.getInstance(), this);
//
//        mainScene = new Scene(root);
//        mainScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
//        mainStage.setUserData(this);
//
//        // set the title of the stage
//        mainStage.setTitle("Donut Tic Tac Toe");
//        mainStage.setScene(mainScene);
//        mainStage.setResizable(false);
//        mainStage.show();
    }

    /**
     * Receives data from a subscribed subject
     * @param eventType object container
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {

        if (eventType instanceof AboutUsController) {
            AboutUsController aboutUs = (AboutUsController) eventType;
            EventManager.register(aboutUs, this);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../aboutUs.fxml"));

            try {
                aboutUsScene = new Scene(loader.load());
                aboutUsScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
                mainStage.setScene(aboutUsScene);
            } catch (IOException e) {
                Logger.log(e);
            }

        }
        //checking if the eventType is an IntermediateController
        if (eventType instanceof IntermediateController) {
            IntermediateController name = (IntermediateController) eventType;
            EventManager.register(name, this);

            //loads the fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../intermediatePage.fxml"));

            //setting the controller
            loader.setController(name);
            try {
                intermediateScene = new Scene(loader.load());
                intermediateScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
                mainStage.setScene(intermediateScene);
            } catch (IOException e) {
                Logger.log(e);
            }
            //setting the title in the screen
//            Label title = new Label("Please Enter Your Name");
//            title.setId("title");

            //getting the properties of back button
//            ImageView view = getImageInfo();
//
//            //text field for the player to enter their name
//            TextField nameEntry = new TextField();
//            nameEntry.setId("nameEntry");
//
//            //when the player presses "ENTER" key after entering their name they
//            //will be directed towards the boardPage
//            nameEntry.setOnKeyPressed(event -> {
//                if(event.getCode() == KeyCode.ENTER) {
//                    update(new GameController(new Player(nameEntry.getText())));
//                }
//            });
//
//            //button for the player to press to enter their name
//            Button entry = new Button("Enter");
//            entry.setId("entry");
//
//            entry.setOnMouseClicked(event -> update(new GameController()));
//
//            //creating a scene to put the arrange the title, name entry field and button
//            VBox centerScene = new VBox(title, nameEntry, entry);
//            centerScene.setSpacing(10);
//            centerScene.setAlignment(Pos.TOP_CENTER);
//
//            //new boarder pane
//            BorderPane pane = new BorderPane(centerScene,
//                                            view,null,
//                                    null,null);
//            pane.setId("intermediatePage");
//            pane.setPrefWidth(800);
//            pane.setPrefHeight(450);
        }
        //if the event type is a GameController
        //keeping track of commit
        if (eventType instanceof GameController) {
            GameController game = (GameController) eventType;
            boardUI = new BoardUI();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../boardPage.fxml"));
            loader.setController(new BoardPageController(boardUI, game));
            try {
                boardScene = new Scene(loader.load());
                boardScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
                mainStage.setScene(boardScene);
            } catch (IOException e) {
                Logger.log(e);
            }
            EventManager.register(boardUI, game.getPlayer1());
            EventManager.register(boardUI, game.getPlayer2());
            EventManager.register(game, boardUI);

//            Label score = new Label("{running score}");
//            score.setId("score");
//
//            GameController game = (GameController) eventType;
//            this.boardUI = new BoardUI();
//            ImageView view = new ImageView(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png")));
//            view.setPreserveRatio(true);
//            view.setFitWidth(200);
//            view.setFitHeight(100);
//
//            view.setOnMouseClicked(event -> {
//                mainStage.setScene(mainScene);
//                mainStage.show();
//            });
//
//            view.setOnMouseEntered(event -> {
//                view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png")));
//            });
//
//            view.setOnMouseExited(event -> {
//                view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png")));
//            });
//
//            VBox centerScene = new VBox(score, this.boardUI);
//            centerScene.setSpacing(10);
//            centerScene.setAlignment(Pos.TOP_CENTER);
//            BorderPane pane = new BorderPane(
//                    centerScene,
//                    new HBox(view),
//                    new Label(game.getPlayer2().getPlayerName()),
//                    null,
//                    new Label(game.getPlayer1().getPlayerName())
//            );
//            pane.setId("boardPage");
//            pane.setPrefWidth(800);
//            pane.setPrefHeight(450);
//
////            EventManager.register(boardUI, this);
//            boardScene = new Scene(pane);
//            boardScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
//            mainStage.setScene(boardScene);
//            EventManager.register(boardUI, game.getPlayer1());
//            EventManager.register(boardUI, game.getPlayer2());
//            EventManager.register(game, boardUI);

        }
    }
}
