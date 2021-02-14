package io.github.teamdonut.proj;

import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;
import io.github.teamdonut.proj.listener.ISubject;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * BoardUI class; handles drawing board to screen in javafx
 * @author Kord Bonaidi
 */
public class BoardUI extends GridPane implements ISubject, IObserver {

    /**
     * Container for data to be sent out to IObservers subscribed to this class
     * @see EventManager#notify(ISubject, Object)
     * @author Kord Boniadi
     */
    public static class UserSelectionData {
        private int x;
        private int y;

        /**
         * Constructor
         * @author Kord Boniadi
         */
        public UserSelectionData() {
            this(0, 0);
        }

        /**
         * Constructor
         * @param x value
         * @param y value
         * @author Kord Boniadi
         */
        public UserSelectionData(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * @return x coordinate
         */
        public int getX() {
            return this.x;
        }

        /**
         * @return y coordinate
         */
        public int getY() {
            return this.y;
        }


        /**
         * Indicates whether some other object is "equal to" this one.
         *
         * @param o the reference object with which to compare.
         * @return {@code true} if this object is the same as the obj
         * argument; {@code false} otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserSelectionData)) return false;
            UserSelectionData that = (UserSelectionData) o;
            return getX() == that.getX() && getY() == that.getY();
        }

        /**
         * Returns a hash code value for the object. This method is
         * supported for the benefit of hash tables such as those provided by
         * @return a hash code value
         */
        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }


        /**
         * @return String representation of the object
         */
        @Override
        public String toString() {
            return "UserSelectionData{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private final int GRID_SIZE = 3;
    private Image xImage;
    private Image yImage;
    private Image emptyImage;

    /**
     * Default GUI board constructor
     * Constructs an empty board in javafx
     * @author Kord Boniadi
     */
    public BoardUI() {
        try {
            xImage = new Image(getClass().getResourceAsStream("images/common/X_black.png"));
            yImage = new Image(getClass().getResourceAsStream("images/common/O_black.png"));
            emptyImage = new Image(getClass().getResourceAsStream("images/common/Empty.png"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        boardConstruction();
    }

    /**
     * helper class for BoardUI initialization
     * @see #BoardUI()
     * @author Kord Boniadi
     */
    private void boardConstruction() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Pane clickable = new Pane();
                ImageView token = new ImageView(emptyImage);
                token.setPreserveRatio(true);
                token.setFitHeight(100);
                clickable.getChildren().add(token);
                clickable.setOnMouseClicked(event -> {
                    Object eventType = new UserSelectionData(
                            GridPane.getColumnIndex((Node) event.getSource()),
                            GridPane.getRowIndex((Node) event.getSource())
                    );
                    EventManager.notify(this, eventType);
                });
                this.add(clickable, j, i);
            }
        }
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Clears Board view setting it to original starting state
     * @author Kord Bonaidi
     */
    public void clearBoard() {
        ObservableList<Node> nodes = this.getChildren();
        for (var n : nodes) {
            if (n instanceof Pane) {
                ((ImageView) ((Pane) n).getChildren().get(0)).setImage(emptyImage);
            }
        }
    }

    /**
     * Draws Board image based on Data level board class info
     * @param currState data level board state
     * @author Kord Boniadi
     */
    public void drawBoard(Board currState) {
        ObservableList<Node> nodes = this.getChildren();
        ImageView image;
        for (Node n : nodes) {
            if (n instanceof Pane) {
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
    }

    /**
     * Receives data from a subscribed subject
     * @param eventType object container
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {
        // update boardUI
    }
}
