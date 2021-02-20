package io.github.teamdonut.proj.controllers;

import io.github.teamdonut.proj.common.BoardUI;
import io.github.teamdonut.proj.common.Player;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    /**
     * Constructor
     * @param stage mainStage object received from javafx start() method
     * @author Kord Boniadi
     */
    public AppController(Stage stage) {
        this.mainStage = stage;
    }

    /**
     * Initializes starting page for app
     * @throws IOException failure to initialize *.fxml loader files
     * @author Kord Boniadi
     */
    public void startApp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../startPage.fxml"));

        EventManager.register(MainController.getInstance(), this);

        mainScene = new Scene(root);
        mainScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
        mainStage.setUserData(this);

        // set the title of the stage
        mainStage.setTitle("Donut Tic Tac Toe");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.show();
    }

    /**
     * Receives data from a subscribed subject
     * @param eventType object container
     * @author Kord Boniadi
     * @author Utsav Parajuli
     */
    @Override
    public void update(Object eventType) {
        //checking if the eventType is an IntermediateController
        if (eventType instanceof IntermediateController) {
            //setting the title in the screen
            Label title = new Label("Please Enter Your Name");
            title.setId("title");

            IntermediateController name = (IntermediateController) eventType;

            //getting the properties of back button
            ImageView view = getImageInfo();

            //text field for the player to enter their name
            TextField nameEntry = new TextField();
            nameEntry.setId("nameEntry");

            //when the player presses "ENTER" key after entering their name they
            //will be directed towards the boardPage
            nameEntry.setOnKeyPressed(event -> {
                if(event.getCode() == KeyCode.ENTER) {
                    System.out.println(nameEntry.getText());
                    update(new GameController(new Player(nameEntry.getText())));
                }
            });

            //button for the player to press to enter their name
            Button entry = new Button("Enter");
            entry.setId("entry");

            entry.setOnMouseClicked(event -> update(new GameController()));

            //creating a scene to put the arrange the title, name entry field and button
            VBox centerScene = new VBox(title, nameEntry, entry);
            centerScene.setSpacing(10);
            centerScene.setAlignment(Pos.TOP_CENTER);

            //new boarder pane
            BorderPane pane = new BorderPane(centerScene,
                                            view,null,
                                    null,null);
            pane.setId("intermediatePage");
            pane.setPrefWidth(800);
            pane.setPrefHeight(450);

            intermediateScene = new Scene(pane);
            intermediateScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(intermediateScene);
        }
        //if the event type is a GameController
        if (eventType instanceof GameController) {
            Label score = new Label("{running score}");
            score.setId("score");

            GameController game = (GameController) eventType;
            this.boardUI = new BoardUI();

            ImageView view = getImageInfo();

            VBox centerScene = new VBox(score, this.boardUI);
            centerScene.setSpacing(10);
            centerScene.setAlignment(Pos.TOP_CENTER);
            BorderPane pane = new BorderPane(
                    centerScene,
                    new HBox(view),
                    new Label(game.getPlayer2().getPlayerName()),
                    null,
                    new Label(game.getPlayer1().getPlayerName())
            );
            pane.setId("boardPage");
            pane.setPrefWidth(800);
            pane.setPrefHeight(450);

            EventManager.register(boardUI, game.getPlayer1());
            EventManager.register(boardUI, game.getPlayer2());
            EventManager.register(game, boardUI);
//            EventManager.register(boardUI, this);
            boardScene = new Scene(pane);
            boardScene.getStylesheets().add((getClass().getResource("../styles.css")).toExternalForm());
            mainStage.setScene(boardScene);
        }
    }

    /**
     * This method will return an ImageView object that has the properties of the back
     * button
     * @author Utsav Parajuli
     * @author Kord Boniadi
     * @return view
     */
    private ImageView getImageInfo() {
        ImageView view = new ImageView(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png")));
        view.setPreserveRatio(true);
        view.setFitWidth(200);
        view.setFitHeight(100);

        view.setOnMouseClicked(event -> {
            mainStage.setScene(mainScene);
            mainStage.show();
        });

        view.setOnMouseEntered(event -> view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow_hover.png"))));

        view.setOnMouseExited(event -> view.setImage(new Image(getClass().getResourceAsStream("../images/common/back_arrow.png"))));
        return view;
    }
}
