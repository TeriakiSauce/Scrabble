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
        game.getState();
    }

    @Test
    public void testQuit() {
        game.quit();
        game.getState();
    }

    @Test
    public void testFinish() {
        game.finish();
        game.getState();
    }

    @Test
    public void testPass() {
        game.pass();
        game.getState();
    }

    @Test
    public void testSetX() {
        game.setX(1);
        assertEquals(game.getX(), new Integer(1));
    }

    @Test
    public void testSetY() {
        game.setY(1);
        assertEquals(game.getY(), new Integer(1));
    }

    @Test
    public void testSetN() {
        game.setN(1);
        assertEquals(game.getN(), new Integer(1));
    }
}