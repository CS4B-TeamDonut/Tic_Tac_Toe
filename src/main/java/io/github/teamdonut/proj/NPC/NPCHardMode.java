package io.github.teamdonut.proj.NPC;

import io.github.teamdonut.proj.common.Board;
import io.github.teamdonut.proj.utils.DataValidation;

public class NPCHardMode implements NPC{

    //constructor
    public NPCHardMode() {
    }

    /**
     * Hard mode or Homi Mode - use minimax algorithm to choose the move for homi mode AI.
     * @param board : the tic tac toe board
     * @param c : the token
     * @author: Grant Goldsworth
     */
    @Override
    public void makeMove(Board board, char c) {
        DataValidation.ensureObjectNotNull("Board", board);
        int x;  // x coordinate of move to make
        int y;  // y coordinate of move to make
        char[][] localBoard = board.getUnderlyingBoard(); // get the actual board data

        // call recursive minimax algorithm function
    }

    /**
     * The minimax algorithm. Uses recursion to analyze all possible paths forward from the
     * current state of the board, and make the best possible decision in order
     * for the AI to win or achieve a draw.
     * @param board the board with the current state of the game
     * @param depth the current depth of the recusion; used to increase efficiency
     * @param isMaximizer whether or not current call is for the maximizer's turn
     * @return value chosen at current node by AI
     */
    private int miniMax(Board board, int depth, boolean isMaximizer) {
        return 1;
    };

    /**
     * Returns whether or not the game is over - if all cells on board have been occupied
     * @param board
     * @return
     */
    private boolean isTerminal(Board board) {
        return false;
    }
}
