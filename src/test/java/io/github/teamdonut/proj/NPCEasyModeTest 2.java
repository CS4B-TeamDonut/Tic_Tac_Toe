package io.github.teamdonut.proj;

import io.github.teamdonut.proj.NPC.NPCEasyMode;
import io.github.teamdonut.proj.common.Board;
import org.junit.jupiter.api.Test;

public class NPCEasyModeTest {

    /**
     * Testing when the board only has one spot left for the token to be placed
     */
    @Test
    public void boardLastSpotTest() {
        Board board = new Board();

        //filling up the board
        for(int i = 0; i < board.BOARD_WIDTH; i++) {
            for(int j = 0; j < board.BOARD_HEIGHT; j++) {
                board.updateToken(i,j,'X');
            }
        }

        board.updateToken(2,2,' ');

        NPCEasyMode easyMode = new NPCEasyMode();

        easyMode.makeMove(board, 'O');
    }
}