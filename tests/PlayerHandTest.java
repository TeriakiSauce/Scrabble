import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the PlayerHand class methods
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class PlayerHandTest {

    PlayerHand hand;

    @Before
    public void setUp() throws Exception {
        hand = new PlayerHand();
    }

    @Test
    public void testSetLetter() {
        assertFalse(hand.hasLetter(1));
        hand.setLetter(0, 'a');
        assertTrue(hand.hasLetter(0));
        char letter = hand.getLetter(0);
        assertEquals(letter, 'a');
    }

    @Test
    public void testRemoveLetter() {
        hand.setLetter(0, 'a');
        assertTrue(hand.hasLetter(0));
        hand.removeLetter(0);
        assertFalse(hand.hasLetter(0));
    }

    @Test
    public void testMakeCopy() {
        hand.setLetter(0, 'a');
        hand.setLetter(1, 'b');
        PlayerHand copy = hand.makeCopy();
        assertEquals(hand, copy);
    }
}