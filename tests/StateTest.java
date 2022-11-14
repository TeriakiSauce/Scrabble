import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the State class methods
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class StateTest {

    State state;

    @Before
    public void setUp() throws Exception {
        state = new State();
    }

    @Test
    public void testReset() {
        state.getBoard().setLetter(new LetterCell(0, 0, 'a'));
        state.step();
        assertNotEquals(state, new State());
        state.reset();
        assertEquals(state, new State());
    }

    @Test //To be tested better
    public void testStep() {
        state.step();
        assertEquals(state.getTurn(), new Integer(0));

    }

    @Test
    public void testRevert() {
        State state2 = new State();
        state2.getBoard().setLetter(new LetterCell(0, 0, 'a'));
        state2.step();

        state.getBoard().setLetter(new LetterCell(0, 0, 'a'));
        state.step();
        state.getBoard().setLetter(new LetterCell(0, 1, 'b'));
        state.step();
        assertNotEquals(state, state2);

        state.revert();
        assertNotEquals(state, state2);
    }

    @Test
    public void testAddPlayer() {
        state.addPlayer(new Player("test", new Game()));
        assertEquals(state.getPlayer().getName(), "test");
    }
}