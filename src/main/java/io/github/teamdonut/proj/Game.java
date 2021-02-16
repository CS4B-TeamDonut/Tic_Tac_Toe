package io.github.teamdonut.proj;
import java.util.Arrays;

/**
 * Game is a data-only class that holds access to the logic of the game
 */
public class Game {

    private Player player1;
    private Player player2;
    private char[][] boardArr;
    private final char EMPTY_VALUE = ' ';

    /**
     * Constructs a Game object without any parameters.
     */
    public Game () {}

    /**
     * Constructs a Game object with set players and board.
     * @param player1 first player
     * @param player2 second player
     * @param boardArr1 board array holding chars
     */
    public Game(Player player1, Player player2, char[][] boardArr1) {
        this.player1      = player1;
        this.player2      = player2;
        this.boardArr     = boardArr1;
        Arrays.stream(boardArr).forEach(str -> Arrays.fill(str, EMPTY_VALUE));
    }

    /**
     * Getter that returns the board array.
     * @return boardArr board array
     */
    public char[][] getBoardArr() {
        return boardArr;
    }

    /**
     * Getter that returns player1.
     * @return player1 first player
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Getter that returns player2.
     * @return player2 second player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Getter that returns the next player.
     * @param currPlayer the current player on the board
     * @return player1 first player or the second player (situation)
     */
    public Player getNextPlayer(Player currPlayer) {
        if (currPlayer == player1) {
            return player2;
        }
        else {
            return player1;
        }
    }

    /**
     * hasWon checks if there is a winning outcome, if there is returns a true
     * @param boardArr board array
     * @return true or false depending if there is a winning scenario
     */
    public boolean hasWon(char[][] boardArr) {
        for (int i = 0; i < 3; i++) {
            if (boardArr[i][0] == 'X' && boardArr[i][1] == 'X' && boardArr[i][2] == 'X') {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (boardArr[i][0] == 'O' && boardArr[i][1] == 'O' && boardArr[i][2] == 'O') {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (boardArr[0][j] == 'X' && boardArr[1][j] == 'X' && boardArr[2][j] == 'X') {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (boardArr[0][j] == 'O' && boardArr[1][j] == 'O' && boardArr[2][j] == 'O') {
                return true;
            }
        }

        if (boardArr[0][0] == 'X' && boardArr[1][1] == 'X' && boardArr[2][2] == 'X') {
            return true;
        }

        if (boardArr[0][0] == 'O' && boardArr[1][1] == 'O' && boardArr[2][2] == 'O') {
            return true;
        }

        if (boardArr[0][2] == 'X' && boardArr[1][1] == 'X' && boardArr[2][0] == 'X') {
            return true;
        }

        if (boardArr[0][2] == 'O' && boardArr[1][1] == 'O' && boardArr[2][0] == 'O') {
            return true;
        }
        return false;
    }

    /**
     * isBoardFull checks if the board is full, if there is an empty space, the board is incomplete
     * @param boardArr board array
     * @return true or false depending if the bard is full or not
     */
    public boolean isBoardFull(char[][] boardArr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardArr[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}