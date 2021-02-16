package io.github.teamdonut.proj.common;

import java.util.Arrays;
import java.util.Objects;

/**
 * Board is a data-only class that holds a 2-dimensional array representing the current
 * state of a tic tac toe match.
 */
public class Board {
    public final int BOARD_WIDTH = 3;
    public final int BOARD_HEIGHT = 3;
    private final char EMPTY_VALUE = ' ';
    private final char[][] board = new char[BOARD_WIDTH][BOARD_HEIGHT];

    /**
     * Constructs a Board object by setting all values of char [][]board to EMPTY_VALUE.
     */
    public Board() {
        Arrays.stream(board).forEach(str -> Arrays.fill(str, EMPTY_VALUE));
    }

    /**
     * Gets the current char[][] board of a Board object.
     * @return the char[][] board of a Board object
     */
    public char[][] getBoard() { return board; }

    /**
     * After checking to make sure the passed in position is within the board,
     * the method updates a token of char[][] board.
     * @param x the x-value for the token in the array [0, 1, 2]
     * @param y the y-value for the token in the array [0, 1, 2]
     * @param c the token for the array ['X', 'O']
     */
    public void updateToken(int x, int y, char c) {
        if ((x > BOARD_WIDTH || y > BOARD_HEIGHT) || ( x < 0 || y < 0))
            throw new IllegalArgumentException(String.format("invalid xy position --> (%d, %d):" +
                    "valid bounds are (%d, %d]", x, y, 0, BOARD_HEIGHT));
        board[x][y] = c;
    }

    /**
     * Returns the token of a specific position in char[][] board.
     * @param x the x-value for the token in the array [0, 1, 2]
     * @param y the y-value for the token in the array [0, 1, 2]
     * @return The token ['X', 'O', ' '] of a specific position in char[][] board.
     */
    public char getToken(int x, int y) {
        if ((x > BOARD_WIDTH || y > BOARD_HEIGHT) || ( x < 0 || y < 0))
            throw new IllegalArgumentException(String.format("invalid xy position --> (%d, %d):" +
                    "valid bounds are (%d, %d]", x, y, 0, BOARD_HEIGHT));
        return board[x][y];
    }

    /**
     * Sets all values within char[][] board to EMPTY_VALUE.
     */
    public void clearBoard() {
        for (char[] row: board) Arrays.fill(row, EMPTY_VALUE);
    }

    /**
     * Checks whether or not a Board object has the same size and state as another Board object.
     * @param o The Board that is being checked for equality
     * @return A boolean representing the equality of two Board objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board1 = (Board) o;
        return Objects.equals(BOARD_WIDTH, board1.BOARD_WIDTH) &&
                Objects.equals(BOARD_HEIGHT, board1.BOARD_HEIGHT) &&
                Objects.equals(EMPTY_VALUE, board1.EMPTY_VALUE) &&
                // Uses deepEquals to check nested arrays
                Arrays.deepEquals(getBoard(), board1.getBoard());
    }

    /**
     * Returns the hash code of the calling Board object.
     * @return An integer representing the hashcode of the calling Board object
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(BOARD_WIDTH, BOARD_HEIGHT, EMPTY_VALUE);
        result = 31 * result + Arrays.hashCode(getBoard());
        return result;
    }

    /**
     * Returns a string containing status of a Board object.
     * @return A string containing the status of a Board object
     */
    @Override
    public String toString() {
        // TODO: may need to be StringBuffer for thread safety?
        char delim = '|';
        StringBuilder buf = new StringBuilder();
        int i = 0;
        for (var a : board) {
            for (var b : a) {
                buf.append(b);
                if (i < 2)
                    buf.append(delim);
                i++;
            }
            buf.append('\n');
            i = 0;
        }
        return buf.toString();
    }
}
