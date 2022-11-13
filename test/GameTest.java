import static org.junit.Assert.*;
import org.junit.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void reset() {
        game.reset();
    }

    @Test
    public void quit() {
        game.quit();
    }

    @Test
    public void placeBoard() {
        game.placeBoard();
    }

    @Test
    public void placeHand() {
        game.placeHand();
    }

    @Test
    public void finish() {
        game.finish();
    }

    @Test
    public void pass() {
        game.pass();
    }

    @Test
    public void getState() {
        game.getState();
    }

    @Test
    public void getX() {
        game.getX();
    }

    @Test
    public void setX() {
        game.setX(1);
    }

    @Test
    public void getY() {
        game.getY();
    }

    @Test
    public void setY() {
        game.setY(1);
    }

    @Test
    public void getN() {
        game.getN();
    }

    @Test
    public void setN() {
        game.setN(1);
    }
}