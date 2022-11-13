import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class tests the Game class methods
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testReset() {
        game.reset();
    }

    @Test
    public void testQuit() {
        game.quit();
    }
    /*
    @Test
    public void placeBoard() {
        game.placeBoard();
    }

    @Test
    public void placeHand() {
        game.placeHand();
    }
    */

    @Test
    public void testFinish() {
        game.finish();
    }

    @Test
    public void testPass() {
        game.pass();
    }

    @Test
    public void testState() {
        game.getState();
    }

    @Test
    public void testX() {
        game.setX(1);
        game.getX();
    }

    @Test
    public void testY() {
        game.setY(1);
        game.getY();
    }

    @Test
    public void testN() {
        game.setN(1);
        game.getN();
    }
}