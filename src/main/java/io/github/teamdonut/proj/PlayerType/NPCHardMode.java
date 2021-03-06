package io.github.teamdonut.proj.PlayerType;

import io.github.teamdonut.proj.common.Board;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.utils.DataValidation;

/**
 * Implementation of Homi mode for the tic tac toe AI.
 * This PlayerType uses minimax to calculate the best possible move and
 * will always win or tie the other player.
 * @author Grant Goldsworth
 */

// TODO: flip the x and y to accommodate the x for col and y for row orientation of java fx
// TODO: check the board update tokens
public class NPCHardMode implements IPlayerType
{

    public static final char MAXIMIZER = 'X';
    public static final char MINIMIZER = 'O';

    // arbitrary numbers for evaluation of the board state
    private static final int WIN_VAL = 10;
    private static final int BEST_VAL = 100;

    //constructor
    public NPCHardMode() {
    }


    /**
     * Hard mode or Homi Mode - use minimax algorithm to choose the move for homi mode AI.
     * @param board : the tic tac toe board
     * @param c : the token
     * @author : Grant Goldsworth
     */
    @Override
    public void makeMove(Board board, char c) {
        DataValidation.ensureObjectNotNull("Board", board);
        int moveRow = 0;      // moveRow coordinate of move to make
        int moveCol = 0;      // moveCol coordinate of move to make
        int bestValue = -100; // starting best value of the AI move


        // for each cell
        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 3; col ++) {
                // if the cell is empty
                if(board.getToken(col, row) == board.EMPTY_VALUE) {
                    // simulate the player's move here (or maximizer's move)
                    board.updateToken(col, row, NPCHardMode.MAXIMIZER);

                    // run minimax on this spot and record result
                    int miniMaxResult = NPCHardMode.miniMax(board, 0, false);

                    // undo the move for this iteration
                    board.updateToken(col, row, board.EMPTY_VALUE);

                    // if the current move's value from minimax is better than the bestValue, update
                    // the best value and record location
                    // should end with value 10 and move [2,2]
                    if (bestValue < miniMaxResult) {
                        bestValue = miniMaxResult;
                        moveRow = row;
                        moveCol = col;
                    }
                }
            }
        } // end for each cell in board
        
        EventManager.notify(this, new IPlayerType.BoardMoveInfo(moveCol, moveRow));
    }


    /**
     * The minimax algorithm. Uses recursion to analyze all possible paths forward from the
     * current state of the board, and make the best possible decision in order
     * for the AI to win or achieve a draw.
     * @param board the board with the current state of the game
     * @param depth the current depth of the recursion; used to increase efficiency
     * @param isMaximizer whether or not current call is for the maximizer's turn
     * @return value chosen at current node by AI
     * @author Grant Goldsworth
     */
    public static int miniMax(Board board, int depth, boolean isMaximizer) {

        // TODO implement alpha-beta pruning
        // evaluate the current board to find out if there is a win/loss
        int boardState = evaluate(board);

        // base cases
        // maximizer win        minimizer win
        if (boardState == WIN_VAL || boardState == -WIN_VAL)
            return boardState;

        // the board is full - draw
        if(board.isBoardFull())
            return 0;

        // maximizer's move
        if(isMaximizer) {
            int bestValue = -BEST_VAL;
            // for each child move, analyze possible routes and the state
            // this means traversing all cells in the board and analyzing
            for(int row = 0; row < 3; row ++) {
                for(int col = 0; col < 3; col ++) {
                    // is this cell empty?
                    if(board.getToken(col, row) == board.EMPTY_VALUE) {
                        // make move of maximizer since it's their move
                        board.updateToken(col, row, MAXIMIZER);

                        // with hypothetical move made, analyze game state with recursive call
                        bestValue = Math.max(bestValue, miniMax(board, depth + 1, !isMaximizer));

                        // undo the move
                        board.updateToken(col, row, board.EMPTY_VALUE);
                    }
                }
            } // end for each child
            return bestValue;
        } // end maximizer's move


        // minimizer's move
        else {
            int bestValue = BEST_VAL;
            // for each child move, analyze possible routes and the state
            // this means traversing all cells in the board and analyzing
            for(int row = 0; row < 3; row ++) {
                for(int col = 0; col < 3; col ++) {
                    // is this cell empty?
                    if(board.getToken(col, row) == board.EMPTY_VALUE) {
                        // make move of minimizer since it's their move
                        board.updateToken(col, row, MINIMIZER);

                        // with hypothetical move made, analyze game state with recursive call
                        bestValue = Math.min(bestValue, miniMax(board, depth + 1, isMaximizer));

                        // undo the move
                        board.updateToken(col, row, board.EMPTY_VALUE);
                    }
                }
            } // end for each child
            return bestValue;
        } // end minimizer's move
    }


    /**
     * Returns the numerical win/loss status of the current board.
     * Positive WIN_VAL is returned if the maximizer has won, negative WIN_VAL if
     * the minimizer has won, and 0 if there is a draw or no win/loss.
     * @param board the board with the current state of the game
     * @return 10 if max win, 0 if draw/none, -10 if min win
     * @author Grant Goldsworth
     */
    public static int evaluate(Board board) {
        // check rows for X or O victory
        // check that contents are equal in row, then return +/- 10 based on what character is
        for (int col = 0; col < 3; col++)
        {
            if (board.getToken(col, 0) == board.getToken(col, 1) && board.getToken(col, 0) == board.getToken(col, 2))
            {
                // row is all one token - what token is it?
                if (board.getToken(col, 0) == 'X')
                    return WIN_VAL;
                else
                    return -WIN_VAL;
            }

        }

        // check columns for X or O victory
        for (int col = 0; col < 3; col++)
        {
            if (board.getToken(0, col) == board.getToken(1, col) && board.getToken(0, col) == board.getToken(2, col))
            {
                // col is all one token - what token is it?
                if (board.getToken(0, col) == 'X')
                    return WIN_VAL;
                else
                    return -WIN_VAL;
            }

        }

        // check diagonals for X or O victory
        // diagonal 1
        if (board.getToken(0,0) == board.getToken(1,1) && board.getToken(0,0) == board.getToken(2,2)) {
            if (board.getToken(0,0) == 'X')
                return WIN_VAL;
            else
                return -WIN_VAL;
        }

        // diagonal 2
        if (board.getToken(0,2) == board.getToken(1,1) && board.getToken(0,2) == board.getToken(2,0)) {
            if (board.getToken(0,2) == 'X')
                return WIN_VAL;
            else
                return -WIN_VAL;
        }

        // final case: no win/loss, return 0
        return 0;
    }
}
