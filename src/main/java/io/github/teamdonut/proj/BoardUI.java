package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BoardUI extends BorderPane implements ISubject, IObserver {
    private final int GRID_SIZE = 3;
    private Image xImage;
    private Image yImage;
    private Image backButton;
    private Image emptyImage;


    public BoardUI() {
        try {
            xImage = new Image(getClass().getResourceAsStream(""));
            yImage = new Image(getClass().getResourceAsStream(""));
            backButton = new Image(getClass().getResourceAsStream(""));
            emptyImage = new Image(getClass().getResourceAsStream(""));
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.setCenter(boardConstruction());
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.getChildren().add(new ImageView(backButton));
        this.setTop(hbox);
    }

    private GridPane boardConstruction() {
        GridPane grid = new GridPane();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Pane clickable = new Pane();
                ImageView token = new ImageView(emptyImage);
                clickable.getChildren().add(token);
                clickable.setOnMouseClicked(event -> {
                    // send something
                });
                grid.add(clickable, j, i);
            }
        }
        grid.setGridLinesVisible(true);
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
