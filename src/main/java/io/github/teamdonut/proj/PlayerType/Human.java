package io.github.teamdonut.proj.PlayerType;

import io.github.teamdonut.proj.common.Board;

public class Human implements IPlayerType
{
    /**
     * This method will make a move for the NPC. It will take in the board object and token of the NPC as
     * parameters and will use algorithms depending on the difficulty level of the NPC to make a move and place
     * it's token on the board.
     *
     * @param board : the tic tac toe board
     * @param c     : the token
     */
    @Override
    public void makeMove(Board board, char c) {
        // something should go here
        // get move from player
        // notify event manager
    }
}
