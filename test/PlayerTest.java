import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    @Before
    public void setUp() throws Exception {
        Game game = new Game();
        player = new Player("test", game);
    }
    /*
    @Test
    public void placeBoard() {
    }

    @Test
    public void placeHand() {
    }
    */

    @Test
    public void TestStep() {
        player.step();
        assertEquals(player.getOldHand(), player.getHand());
    }

    @Test
    public void TestRevert() {
        player.revert();
        assertEquals(player.getHand(), player.getOldHand());
    }

    @Test
    public void TestAddScore() {
        player.addScore(5);
        assertEquals(player.getScore(), new Integer(5));
    }

    @Test
    public void TestGetName() {
        player.getName();
        assertEquals(player.getName(), "test");
    }

}