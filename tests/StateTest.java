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
        state.step();
        System.out.println(state.getTurn());
        assertNotEquals(state, new State());
        state.reset();
        assertEquals(state, new State());
    }

    @Test
    public void testStep() {
    }

    @Test
    public void testRevert() {
        State state2 = new State();
        state2.step();
        state.step();
        System.out.println(state.getTurn());
        assertEquals(state, state2);
        state.revert();
        System.out.println(state.getTurn());
        assertNotEquals(state, state2);
    }

    @Test
    public void testAddPlayer() {
    }
}