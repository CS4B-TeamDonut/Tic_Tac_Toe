package io.github.teamdonut.proj;

import io.github.teamdonut.proj.NPC.NPCEasyMode;
import io.github.teamdonut.proj.common.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing for NPC Easy Mode
 */
public class NPCEasyModeTest {

    /**
     * Testing when the board only has one spot left for the token to be placed
     *
     * @author : Utsav Parajuli
     */
    @Test
    public void boardLastSpotTest() {
        Board board = new Board();

        //filling up the board
        for (int i = 0; i < board.BOARD_WIDTH; i++) {
            for (int j = 0; j < board.BOARD_HEIGHT; j++) {
                board.updateToken(i, j, 'X');
            }
        }

        board.updateToken(2, 2, ' ');

        NPCEasyMode easyMode = new NPCEasyMode();

        easyMode.makeMove(board, 'O');
    }

    /**
     * Testing when the board is full and not full
     */
    @Test
    public void fullBoardTest() {
        Board board = new Board();

        // fill board with tokens
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.updateToken(i, j, i % 2 == 0 ? 'X' : 'O');

        // assert that method returns that it is a full board
        assertTrue(NPCEasyMode.isFullBoard(board));

        // create non-full board
        board = new Board();
        board.updateToken(0, 2, 'X');

        // assert that method returns that it is not a full board
        assertFalse(NPCEasyMode.isFullBoard(board));
    }
}
