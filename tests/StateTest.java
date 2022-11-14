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
        LetterChain chain = new LetterChain(state);
        LetterChain chain2 = new LetterChain(state);
        assertEquals(chain, chain2);
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