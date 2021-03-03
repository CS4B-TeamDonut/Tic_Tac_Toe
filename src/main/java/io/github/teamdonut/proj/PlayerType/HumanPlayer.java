package io.github.teamdonut.proj.PlayerType;
import io.github.teamdonut.proj.common.Board;

/**
 * Concrete implementation of the IPlayerType interface to model
 * a human player in the tic tac toe game environment.
 * <p> This class simply handles the player's movement information
 * and passes it to the event manager. </p>
 * @author Grant Goldsworth
 */
public class HumanPlayer implements IPlayerType
{

    /**
     * Handle the human player's move, notifying the event handler
     * with the new information.
     * @param board : the tic tac toe board
     * @param c : the token
     * @author Grant Goldsworth
     */
    @Override
    public void makeMove(Board board, char c)
    {
        // TODO: need to get move and notify event manager
    }
}
