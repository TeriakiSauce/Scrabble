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
        State state = new State();
        state.getBoard().setLetter(0, 0, 'a');
        assertNotEquals(state, new State());
        state.reset();
        assertEquals(state, new State());
    }

    @Test
    public void testStep() {
    }

    @Test
    public void testRevert() {
    }

    @Test
    public void testAddPlayer() {
    }
}