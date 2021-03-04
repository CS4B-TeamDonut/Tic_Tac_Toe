package io.github.teamdonut.proj.common;
import java.util.Arrays;
import java.util.Objects;

/**
 * Game is a data-only class that holds access to the logic of the game
 */
public class Game {

    private Player player1;
    private Player player2;
    private char token;
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
     * @param token token of the player either X or O
     */
    public Game(Player player1, Player player2, char[][] boardArr1, char token) {
        this.player1      = player1;
        this.player2      = player2;
        this.token        = token;
        this.boardArr     = boardArr1;
        Arrays.stream(boardArr).forEach(str -> Arrays.fill(str, EMPTY_VALUE));
    }
    /**
     * Getter that returns the board array.
     * @return token player token
     */
    public char getToken() {return token; }

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
    public char hasWon(char[][] boardArr) {

        for (int i = 0; i < 3; i++) {
            if (boardArr[i][0] == 'X' && boardArr[i][1] == 'X' && boardArr[i][2] == 'X') {
                return 'X';
            }
        }

        for (int i = 0; i < 3; i++) {
            if (boardArr[i][0] == 'O' && boardArr[i][1] == 'O' && boardArr[i][2] == 'O') {
                return 'O';
            }
        }

        for (int j = 0; j < 3; j++) {
            if (boardArr[0][j] == 'X' && boardArr[1][j] == 'X' && boardArr[2][j] == 'X') {
                return 'X';
            }
        }

        for (int j = 0; j < 3; j++) {
            if (boardArr[0][j] == 'O' && boardArr[1][j] == 'O' && boardArr[2][j] == 'O') {
                return 'O';
            }
        }

        if (boardArr[0][0] == 'X' && boardArr[1][1] == 'X' && boardArr[2][2] == 'X') {
            return 'X';
        }

        if (boardArr[0][0] == 'O' && boardArr[1][1] == 'O' && boardArr[2][2] == 'O') {
            return 'O';
        }

        if (boardArr[0][2] == 'X' && boardArr[1][1] == 'X' && boardArr[2][0] == 'X') {
            return 'X';
        }

        if (boardArr[0][2] == 'O' && boardArr[1][1] == 'O' && boardArr[2][0] == 'O') {
            return 'O';
        }
        return 'C';
    }

    /**
     * gameOver checks if the game is over by checking all the scenarios
     * @param boardArr board array
     * @return true or false depending if there is a winner or not
     */
    public boolean gameOver(char[][] boardArr) {
        return isBoardFull(boardArr) || hasWon(boardArr) == 'X' || hasWon(boardArr) == 'O';
    }

    /**
     * whoWon determines the name of the actual winner
     * @param boardArr board array
     * @param player1 first player
     * @param player2 second player
     * @return nothing/string of space, this will have to return a winners name
     */
    public String whoWon(char[][] boardArr, Player player1, Player player2) {

        String returnNothing = " ";
        if(hasWon(boardArr) == player1.getPlayerToken()) {
            String name;
            name = player1.getPlayerName();
            return name;
        }

        if(hasWon(boardArr) == player2.getPlayerToken()) {
            String name;
            name = player2.getPlayerName();
            return name;
        }

        return returnNothing;
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

    /**
     * Checks whether or not a Game object has the same size and state as another Board object.
     * @param o The Board that is being checked for equality
     * @return A boolean representing the equality of two Game objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(player1, game.player1) && Objects.equals(player2, game.player2) && Arrays.equals(boardArr, game.boardArr);
    }

    /**
     * Returns the hash code of the calling Game object.
     * @return An integer representing the hashcode of the calling Board object
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(player1, player2, EMPTY_VALUE);
        result = 31 * result + Arrays.hashCode(boardArr);
        return result;
    }
}