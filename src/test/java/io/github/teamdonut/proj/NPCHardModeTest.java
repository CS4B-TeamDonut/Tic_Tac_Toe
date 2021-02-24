package io.github.teamdonut.proj;

import io.github.teamdonut.proj.NPC.NPCHardMode;
import io.github.teamdonut.proj.common.Board;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the hard mode AI. Tests the evaluation methods as well as
 * the actual AI itself with a few different scenarios. 
 * @author Grant Goldsworth
 */
public class NPCHardModeTest
{
    /**
     * Test the evaluation method for the Homi-Mode AI.
     * The evaluate method is designed to return 10/0/-10
     * based on a max/draw/min win.
     * @author Grant Goldsworth
     * @see NPCHardMode#evaluate(Board) 
     */
    @Test
    public void evaluateBoardTest() {
        Board board = new Board();

        // test row win
        board.updateToken(0, 0, 'X');
        board.updateToken(0, 1, 'X');
        board.updateToken(0, 2, 'X');

        // assert that it is a maximizer (X) win on a horizontal row
        assertEquals(10, NPCHardMode.evaluate(board));


        // test column win
        board = new Board();
        board.updateToken(0, 1, 'O');
        board.updateToken(1, 1, 'O');
        board.updateToken(2, 1, 'O');

        // assert that it is a minimizer (X) win on a horizontal row
        assertEquals(-10, NPCHardMode.evaluate(board));


        // test diagonal
        board = new Board();
        board.updateToken(0,0,'X');
        board.updateToken(1,1,'X');
        board.updateToken(2,2,'X');

        // assert that it is a maximizer (X) win on diagonal
        assertEquals(10, NPCHardMode.evaluate(board));


        // test other diagonal
        board = new Board();
        board.updateToken(0,2,'O');
        board.updateToken(1,1,'O');
        board.updateToken(0,2,'O');

        // assert that it is a minimizer (X) win on diagonal
        assertEquals(-10, NPCHardMode.evaluate(board));

    }

    /**
     * Test the minimax algorithm with a few different scenarios. 
     * @author Grant Goldsworth
     * @see NPCHardMode#miniMax(Board, int, boolean) 
     */
    @Test
    public void miniMaxAlgoTest() {
        // give a scenario
        // run minimax
        // ensure that it returns correct numerical choice

    }

    @Test
    public void fullBoardTest() {
        Board board = new Board();

        // fill board with tokens
        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++)
                board.updateToken(i, j, i % 2 == 0 ? 'X' : 'O');

        // assert that method returns that it is a full board
        assertTrue(NPCHardMode.isFullBoard(board));

        // create non-full board
        board = new Board();
        board.updateToken(0, 2, 'X');

        // assert that method returns that it is not a full board
        assertFalse(NPCHardMode.isFullBoard(board));



    }
}
