import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Tests the LetterChain class, more specifically the getScore method
 * @author Andrew
 * @version 1.0
 */
public class LetterChainTest {
    private State state;
    private LetterChain chain;

    @Before
    public void setUp() throws Exception {
        state = new State();
        chain = new LetterChain(state);
    }

    @Test
    public void testClear() {
        LetterCell cell1 = new LetterCell(7,7,'h');
        chain.addLetter(cell1);
        LetterCell cell2 = new LetterCell(8,7,'e');
        chain.addLetter(cell2);
        LetterCell cell3 = new LetterCell(9,7,'y');
        chain.addLetter(cell3);
        chain.clear();
        assertEquals(0, (int) chain.getSize());
    }

    @Test
    public void testAddLetter() {
        LetterCell cell1 = new LetterCell(7,7,'h');
        chain.addLetter(cell1);

        assertEquals(true, chain.hasLetter(7,7));
    }

    @Test
    public void testRemoveLetter() {
        LetterCell cell1 = new LetterCell(7,7,'h');
        chain.addLetter(cell1);
        chain.removeLetter(7,7);

        assertEquals(false, chain.hasLetter(7,7));
    }

    @Test
    public void testHasLetter() {
        LetterCell cell1 = new LetterCell(7,7,'h');
        chain.addLetter(cell1);

        assertEquals(true, chain.hasLetter(7,7));
    }

    @Test
    public void testGetScore() {
        // Testing a basic word being placed
        LetterCell cell1 = new LetterCell(7,7,'h');
        chain.addLetter(cell1);
        state.getBoard().setLetter(cell1);
        LetterCell cell2 = new LetterCell(8,7,'e');
        chain.addLetter(cell2);
        state.getBoard().setLetter(cell2);
        LetterCell cell3 = new LetterCell(9,7,'y');
        chain.addLetter(cell3);
        state.getBoard().setLetter(cell3);
        assertEquals(9 , (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word being placed through an existing word
        LetterCell cell4 = new LetterCell(8,6,'b');
        chain.addLetter(cell4);
        state.getBoard().setLetter(cell4);
        LetterCell cell5 = new LetterCell(8,8,'t');
        chain.addLetter(cell5);
        state.getBoard().setLetter(cell5);
        LetterCell cell6 = new LetterCell(8,9,'a');
        chain.addLetter(cell6);
        state.getBoard().setLetter(cell6);
        assertEquals(6, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word connecting to another word in a different direction
        LetterCell cell7 = new LetterCell(9,8,'a');
        chain.addLetter(cell7);
        state.getBoard().setLetter(cell7);
        assertEquals(7, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word that extends another one
        LetterCell cell8 = new LetterCell(6,7,'t');
        chain.addLetter(cell8);
        state.getBoard().setLetter(cell8);
        assertEquals(10, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word that is disconnected being invalid
        LetterCell cell9 = new LetterCell(12,10,'h');
        chain.addLetter(cell9);
        state.getBoard().setLetter(cell9);
        LetterCell cell10 = new LetterCell(12,11,'e');
        chain.addLetter(cell10);
        state.getBoard().setLetter(cell10);
        LetterCell cell11 = new LetterCell(12,12,'y');
        chain.addLetter(cell11);
        state.getBoard().setLetter(cell11);
        assertEquals(0 , (int) chain.getScore());
    }
}
