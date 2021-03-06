package io.github.teamdonut.proj;

import io.github.teamdonut.proj.common.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void toStringTest() {
        Board board = new Board();
        char token = 'X';
        for (int i = 0; i < board.BOARD_ROWS; i++) {
            for (int j = 0; j < board.BOARD_COLUMNS; j++) {
                board.updateToken(i, j, token);
                token = (token == 'X') ? 'O' : 'X';
            }
        }
        System.out.println(board);
    }

    @Test
    public void equalsTest() {
        Board board1 = new Board();
        Board board2 = new Board();

        assertEquals(board2, board1);

        board2.updateToken(0, 1, 'X');
        assertNotEquals(board1, board2);
    }
}
