import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the State class methods
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class StateTest {

    Game game;
    State state;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        state = game.getState();
    }

    @Test
    public void testReset() {

    }

    @Test
    public void testAddPlayer() {
        state.addPlayer(new Player("sample", new Game()));
        assertEquals(state.getPlayer().getName(), "sample");
    }
}