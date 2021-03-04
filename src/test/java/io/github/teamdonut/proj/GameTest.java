package io.github.teamdonut.proj;
import io.github.teamdonut.proj.common.Game;
import io.github.teamdonut.proj.common.Player;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void winner() {
        Game game = new Game();
        char[][] boardArr = new char[3][3];

        boardArr[0][0] = 'X';
        boardArr[0][1] = ' ';
        boardArr[0][2] = ' ';

        boardArr[1][0] = 'X';
        boardArr[1][1] = ' ';
        boardArr[1][2] = ' ';

        boardArr[2][0] = 'X';
        boardArr[2][1] = ' ';
        boardArr[2][2] = ' ';

        if(game.hasWon(boardArr) == 'X' || game.hasWon(boardArr) == 'O') {
            System.out.println("Winner");
        } else {
            System.out.println("Other Scenario");
        }
    }

    @Test
    public void gameEndedScenarios() {
        Game game = new Game();
        char[][] boardArr = new char[3][3];

        boardArr[0][0] = 'X';
        boardArr[0][1] = 'O';
        boardArr[0][2] = 'X';

        boardArr[1][0] = 'O';
        boardArr[1][1] = 'O';
        boardArr[1][2] = 'X';

        boardArr[2][0] = 'X';
        boardArr[2][1] = 'X';
        boardArr[2][2] = ' ';

        if(game.gameOver(boardArr)) {
            System.out.println("Game Over");
        } else {
            System.out.println("Keep Playing");
        }
    }

    @Test
    public void determiningWinner() {
        Game game = new Game();
        char[][] boardArr = new char[3][3];

        boardArr[0][0] = ' ';
        boardArr[0][1] = 'X';
        boardArr[0][2] = ' ';

        boardArr[1][0] = ' ';
        boardArr[1][1] = 'X';
        boardArr[1][2] = ' ';

        boardArr[2][0] = ' ';
        boardArr[2][1] = 'X';
        boardArr[2][2] = ' ';

        if(game.hasWon(boardArr) == 'O') {
            System.out.println("O winner");
        } else if(game.hasWon(boardArr) == 'X') {
            System.out.println("X winner");
        } else {
            System.out.println(game.hasWon(boardArr));
            System.out.println("Continue");
        }
    }

    @Test
    public void whoWon() {
        Game game = new Game();

        Player player1 = new Player("Tim", 'X');
        Player player2 = new Player("Jorge", 'O');

        char[][] boardArr = new char[3][3];

        boardArr[0][0] = 'X';
        boardArr[0][1] = ' ';
        boardArr[0][2] = ' ';

        boardArr[1][0] = 'X';
        boardArr[1][1] = ' ';
        boardArr[1][2] = ' ';

        boardArr[2][0] = 'X';
        boardArr[2][1] = ' ';
        boardArr[2][2] = ' ';

        if(game.hasWon(boardArr) == player1.getPlayerToken()) {
            String name;
            name = player1.getPlayerName();
            System.out.println(name + " is the winner!");
        }

        if(game.hasWon(boardArr) == player2.getPlayerToken()) {
            String name;
            name = player2.getPlayerName();
            System.out.println(name + " is the winner!");
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
        boardArr[2][2] = 'X';

        if (game.isBoardFull(boardArr)) {
            System.out.println("Board is full");
        } else {
            System.out.println("Board is incomplete");
        }
    }
}
