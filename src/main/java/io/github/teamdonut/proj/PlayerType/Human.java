package io.github.teamdonut.proj.PlayerType;

import io.github.teamdonut.proj.common.Board;
import io.github.teamdonut.proj.common.BoardUI;
import io.github.teamdonut.proj.common.Token;
import io.github.teamdonut.proj.listener.EventManager;
import io.github.teamdonut.proj.listener.IObserver;

public class Human implements IPlayerType, IObserver {
    /**
     * This method will make a move for the NPC. It will take in the board object and token of the NPC as
     * parameters and will use algorithms depending on the difficulty level of the NPC to make a move and place
     * it's token on the board.
     *
     * @param board : the tic tac toe board
     * @param c     : the token
     */
    @Override
    public void makeMove(Board board, Token c) {
        // something should go here
        // get move from player
        // notify event manager
    }

    /**
     * New info is received through this method. Object decoding is needed
     *
     * @param eventType General Object type
     * @author Kord Boniadi
     */
    @Override
    public void update(Object eventType) {
        if (eventType instanceof BoardUI.UserSelectionData) {
            BoardUI.UserSelectionData temp = (BoardUI.UserSelectionData) eventType;
            EventManager.notify(this, new IPlayerType.BoardMoveInfo(temp.getX(), temp.getY()));
        }
    }
}
