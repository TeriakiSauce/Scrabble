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
        hand.setLetter(1, 'b');
        hand.setLetter(2, 'c');
        hand.setLetter(3, 'd');
        hand.setLetter(4, 'e');
    }

    @Test
    public void testSetLetter() {
        assertFalse(hand.hasLetter(0));
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
        PlayerHand copy = hand.makeCopy();
        assertEquals(hand.getLetter(0), copy.getLetter(0));
        assertEquals(hand.getLetter(1), copy.getLetter(1));
        assertEquals(hand.getLetter(2), copy.getLetter(2));
        assertEquals(hand.getLetter(3), copy.getLetter(3));
        assertEquals(hand.getLetter(4), copy.getLetter(4));
    }
}