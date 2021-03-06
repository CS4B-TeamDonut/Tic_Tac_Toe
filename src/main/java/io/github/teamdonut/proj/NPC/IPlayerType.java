package io.github.teamdonut.proj.NPC;

import io.github.teamdonut.proj.common.Board;
import io.github.teamdonut.proj.listener.ISubject;
import java.util.Objects;

/**
 * @author utsavparajuli
 * @author Grant Goldsworth
 * @version 2.0
 * NPC represents the non computer player which will have several levels of difficulty. The interface has a
 * method to make a move. It will also extend the ISubject interface which is used as a design pattern
 */
public interface IPlayerType extends ISubject {  //need to implement IObserver and ISubject

    /**
     * The class BoardMoveInfo contains the data that should be updated in the game class using IObserver.
     */
     class BoardMoveInfo {
        private final int  x;     //row in board
        private final int  y;     //column in board
        private final char c;     //token to be placed

        /**
         * This constructor will initialize the BoardModeInfo class with the x, y, and c which are row-position
         * in board, column-position in board, and token to be placed in board respectively.
         * @param x : row number
         * @param y : column number
         * @param c : token
         */
        BoardMoveInfo(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        /**
         * This method will return the x-position/row chose by the NPC
         * @return x
         */
        public int getX() {
            return x;
        }

        /**
         * This method will return the y-position/column chose by the NPC
         * @return y
         */
        public int getY() {
            return y;
        }

        /**
         * This method will return the token to be placed in the board
         * @return c
         */
        public char getC() {
            return c;
        }

        /**
         * This method will override the equals method of the object and will check if two instances
         * of the BoardMoveInfo classes are equal
         * @param o : an object
         * @return : a boolean value of true if the objects are equal or else false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BoardMoveInfo that = (BoardMoveInfo) o;

            return  getX() == that.getX() &&
                    getY() == that.getY() &&
                    getC() == that.getC();
        }

        /**
         * Overrides the hashCode method
         * @return : the hashcode of the object
         */
        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getC());
        }

        /**
         * Overrides the toString method which will return the data of the class as a string
         * @return : a string value
         */
        @Override
        public String toString() {
            return "BoardMoveInfo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", c=" + c +
                    '}';
        }
    }

    /**
     * This method will make a move for the NPC. It will take in the board object and token of the NPC as
     * parameters and will use algorithms depending on the difficulty level of the NPC to make a move and place
     * it's token on the board.
     * @param board : the tic tac toe board
     * @param c : the token
     */
    void makeMove(Board board, char c);
}
