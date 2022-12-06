import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Tests the LetterChain class, more specifically the getScore method
 * @author Andrew
 * @version 1.0
 */
public class LetterChainTest {
    private Game game;
    private LetterChain chain;
    private State state;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        chain = new LetterChain(game);
        state = game.getState();
    }

    @Test
    public void testClear() {
        BoardCell cell1 = new BoardCell(7,7,'h');
        chain.addLetter(cell1);
        BoardCell cell2 = new BoardCell(8,7,'e');
        chain.addLetter(cell2);
        BoardCell cell3 = new BoardCell(9,7,'y');
        chain.addLetter(cell3);
        chain.clear();
        assertEquals(0, (int) chain.getSize());
    }

    @Test
    public void testAddLetter() {
        BoardCell cell1 = new BoardCell(7,7,'h');
        chain.addLetter(cell1);

        assertEquals(true, chain.hasLetter(7,7));
    }

    @Test
    public void testRemoveLetter() {
        BoardCell cell1 = new BoardCell(7,7,'h');
        chain.addLetter(cell1);
        chain.removeLetter(7,7);

        assertEquals(false, chain.hasLetter(7,7));
    }

    @Test
    public void testHasLetter() {
        BoardCell cell1 = new BoardCell(7,7,'h');
        chain.addLetter(cell1);

        assertEquals(true, chain.hasLetter(7,7));
    }

    @Test
    public void testGetScore() {
        // Testing a basic word being placed
        BoardCell cell1 = new BoardCell(7,7,'h');
        chain.addLetter(cell1);
        state.getBoard().setLetter(cell1);
        BoardCell cell2 = new BoardCell(8,7,'e');
        chain.addLetter(cell2);
        state.getBoard().setLetter(cell2);
        BoardCell cell3 = new BoardCell(9,7,'y');
        chain.addLetter(cell3);
        state.getBoard().setLetter(cell3);
        assertEquals(9 , (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word being placed through an existing word
        BoardCell cell4 = new BoardCell(8,6,'b');
        chain.addLetter(cell4);
        state.getBoard().setLetter(cell4);
        BoardCell cell5 = new BoardCell(8,8,'t');
        chain.addLetter(cell5);
        state.getBoard().setLetter(cell5);
        BoardCell cell6 = new BoardCell(8,9,'a');
        chain.addLetter(cell6);
        state.getBoard().setLetter(cell6);
        assertEquals(6, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word connecting to another word in a different direction
        BoardCell cell7 = new BoardCell(9,8,'a');
        chain.addLetter(cell7);
        state.getBoard().setLetter(cell7);
        assertEquals(7, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word that extends another one
        BoardCell cell8 = new BoardCell(6,7,'t');
        chain.addLetter(cell8);
        state.getBoard().setLetter(cell8);
        assertEquals(10, (int) chain.getScore());
        chain.clear();
        state.step();

        //Testing a word that is disconnected being invalid
        BoardCell cell9 = new BoardCell(12,10,'h');
        chain.addLetter(cell9);
        state.getBoard().setLetter(cell9);
        BoardCell cell10 = new BoardCell(12,11,'e');
        chain.addLetter(cell10);
        state.getBoard().setLetter(cell10);
        BoardCell cell11 = new BoardCell(12,12,'y');
        chain.addLetter(cell11);
        state.getBoard().setLetter(cell11);
        assertEquals(0 , (int) chain.getScore());
    }

    @Test
    public void testGetScorePremium() {
        System.out.println(chain.getScore());
        System.out.println(chain);
        BoardCell cell12 = new BoardCell(7,7,'h', BoardCell.Type.BLUE);
        BoardCell cell13 = new BoardCell(8,7,'e');
        BoardCell cell14 = new BoardCell(9,7,'y');
        chain.addLetter(cell12);
        state.getBoard().setLetter(cell12);
        chain.addLetter(cell13);
        state.getBoard().setLetter(cell13);
        chain.addLetter(cell14);
        state.getBoard().setLetter(cell14);
        System.out.println(chain.getScore()*chain.getMultiplier(cell12.getType()));
        System.out.println(chain);

    }

}
