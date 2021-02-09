package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardUI extends BorderPane implements ISubject, IObserver {
    private final int GRID_SIZE = 3;
    private Image xImage;
    private Image yImage;
    private Image backButtonIdle;
    private Image backButtonHover;
    private Image emptyImage;


    public BoardUI() {
        try {
            xImage = new Image(getClass().getResourceAsStream("images/common/X_black.png"));
            yImage = new Image(getClass().getResourceAsStream("images/common/O_black.png"));
            backButtonIdle = new Image(getClass().getResourceAsStream("images/common/back_arrow.png"));
            backButtonHover = new Image(getClass().getResourceAsStream("images/common/back_arrow_hover_gray.png"));
            emptyImage = new Image(getClass().getResourceAsStream("images/common/Empty.png"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        ImageView backButton = new ImageView(backButtonIdle);
        backButton.setPreserveRatio(true);
        backButton.setFitHeight(100);
        hbox.getChildren().add(backButton);
        this.setTop(hbox);
        this.setCenter(boardConstruction());
        this.setId("gamePage");

        backButton.setOnMouseEntered(event -> {
            backButton.setImage(backButtonHover);
        });
        backButton.setOnMouseExited(event -> {
            backButton.setImage(backButtonIdle);
        });
        backButton.setOnMouseClicked(event -> {
            Stage window = (Stage) backButton.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm());
                window.setTitle("JavaFX and Gradle");
                window.setScene(scene);
                window.setWidth(1920);
                window.setHeight(1080);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private GridPane boardConstruction() {
        GridPane grid = new GridPane();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Pane clickable = new Pane();
                ImageView token = new ImageView(xImage);
                token.setPreserveRatio(true);
                token.setFitHeight(200);
                clickable.getChildren().add(token);
                clickable.setOnMouseClicked(event -> {
                    // send something
                });
                grid.add(clickable, j, i);
            }
        }
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        return grid;
    }

    public void clearBoard() {
        GridPane board = (GridPane) this.getCenter();
        ObservableList<Node> nodes = board.getChildren();
        for (var n : nodes) {
            if (n instanceof Pane) {
                ((ImageView) ((Pane) n).getChildren().get(0)).setImage(emptyImage);
            }
        }
    }

    public void drawBoard(Board currState) {
        GridPane guiBoard = (GridPane) this.getChildren();
        ObservableList<Node> nodes = guiBoard.getChildren();
        ImageView image;
        for (var n : nodes) {
            image = (ImageView) ((Pane) n).getChildren().get(0);
            int x = GridPane.getColumnIndex(n);
            int y = GridPane.getRowIndex(n);

            switch (currState.getToken(x, y)) {
                case 'X' -> image.setImage(xImage);
                case 'O' -> image.setImage(yImage);
                case ' ' -> image.setImage(emptyImage);
                default -> throw new RuntimeException("Board contained an invalid value");
            }
        }
    }

    @Override
    public void update(Object eventType) {
        // update boardUI
    }
}
