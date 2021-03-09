package io.github.teamdonut.proj;
import io.github.teamdonut.proj.common.Player;
import static io.github.teamdonut.proj.common.Token.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    /**
     * Tests the equality of two Player objects
     * @author Joey Campbell
     */
    @Test
    public void equalsTest() {
        Player p1 = new Player("Test", X);
        Player p2 = new Player("Test", X);

        assertEquals(p1, p2);

        p1.setPlayerName("NotTest");

        assertNotEquals(p1, p2);
    }
}
