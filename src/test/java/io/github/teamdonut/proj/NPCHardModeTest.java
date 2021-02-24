package io.github.teamdonut.proj;

import io.github.teamdonut.proj.NPC.NPCHardMode;
import io.github.teamdonut.proj.common.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NPCHardModeTest
{
    @Test
    public void evaluateBoardTest() {
        Board board = new Board();

        // test horizontal win
        board.updateToken(0, 0, 'X');
        board.updateToken(1, 0, 'X');
        board.updateToken(2, 0, 'X');

        // assert that it is a maximizer (X) win on a horizontal row
        assertEquals(NPCHardMode.evaluate(board), 10);

        // test diagonal
        board = new Board();
        board.updateToken(0,0,'X');
        board.updateToken(1,1,'X');
        board.updateToken(2,2,'X');

        // assert that it is a maximizer (X) win on diagonal
        assertEquals(NPCHardMode.evaluate(board), 10);

    }
}
