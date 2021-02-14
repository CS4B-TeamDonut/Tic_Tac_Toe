package io.github.teamdonut.proj;

import io.github.teamdonut.proj.NPC.NPCEasyMode;
import org.junit.jupiter.api.Test;

public class NPCEasyModeTest {

    /**
     * Testing when the board is full and there aren't any spots for the token to be placed
     */
    @Test
    public void boardFullTest() {
        Board board = new Board();

        //filling up the board
        for(int i = 0; i < board.BOARD_WIDTH; i++) {
            for(int j = 0; j < board.BOARD_HEIGHT; j++) {
                board.updateToken(i,j,'X');
            }
        }

        NPCEasyMode easyMode = new NPCEasyMode();

        easyMode.makeMove(board, 'O');
    }

}
