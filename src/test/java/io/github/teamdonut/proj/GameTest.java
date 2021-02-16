package io.github.teamdonut.proj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void winner() {
        Game game = new Game();
        char[][] boardArr = new char[3][3];

        boardArr[0][0] = 'O';
        boardArr[0][1] = ' ';
        boardArr[0][2] = ' ';

        boardArr[1][0] = 'O';
        boardArr[1][1] = ' ';
        boardArr[1][2] = ' ';

        boardArr[2][0] = 'O';
        boardArr[2][1] = ' ';
        boardArr[2][2] = ' ';

        if (game.hasWon(boardArr)) {
            System.out.println("Winner");
        }
    }

    @Test
    public void full() {
        Game game = new Game();
        char[][] boardArr = new char[3][3];

        boardArr[0][0] = 'X';
        boardArr[0][1] = 'X';
        boardArr[0][2] = 'X';

        boardArr[1][0] = 'X';
        boardArr[1][1] = 'X';
        boardArr[1][2] = 'X';

        boardArr[2][0] = 'X';
        boardArr[2][1] = 'X';
        boardArr[2][2] = ' ';

        if (game.isBoardFull(boardArr)) {
            System.out.println("Board is full");
        } else {
            System.out.println("Board is incomplete");
        }
    }
}
