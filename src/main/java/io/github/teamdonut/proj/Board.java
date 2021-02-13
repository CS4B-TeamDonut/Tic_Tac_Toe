package io.github.teamdonut.proj;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    final int BOARD_WIDTH = 3;
    final int BOARD_HEIGHT = 3;
    final char EMPTY_VALUE = ' ';
    private final char[][] board = new char[BOARD_WIDTH][BOARD_HEIGHT];


    public Board() {
        Arrays.stream(board).forEach(str -> Arrays.fill(str, EMPTY_VALUE));
    }

    public char[][] getBoard() { return board; }

    public void updateToken(int x, int y, char c) {
        if ((x > BOARD_WIDTH || y > BOARD_HEIGHT) || ( x < 0 || y < 0))
            throw new IllegalArgumentException(String.format("invalid xy position --> (%d, %d):" +
                    "valid bounds are (%d, %d]", x, y, 0, BOARD_HEIGHT));
        board[x][y] = c;
    }

    public char getToken(int x, int y) {
        if ((x > BOARD_WIDTH || y > BOARD_HEIGHT) || ( x < 0 || y < 0))
            throw new IllegalArgumentException(String.format("invalid xy position --> (%d, %d):" +
                    "valid bounds are (%d, %d]", x, y, 0, BOARD_HEIGHT));
        return board[x][y];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board1 = (Board) o;
        return Objects.equals(BOARD_WIDTH, board1.BOARD_WIDTH) &&
                Objects.equals(BOARD_HEIGHT, board1.BOARD_HEIGHT) &&
                Objects.equals(EMPTY_VALUE, board1.EMPTY_VALUE) &&
                Arrays.deepEquals(getBoard(), board1.getBoard());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(BOARD_WIDTH, BOARD_HEIGHT, EMPTY_VALUE);
        result = 31 * result + Arrays.hashCode(getBoard());
        return result;
    }

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
