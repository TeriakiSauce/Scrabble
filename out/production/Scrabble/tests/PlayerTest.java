import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * This class tests the Player class methods
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class PlayerTest {

    Player player;

    @Before
    public void setUp() throws Exception {
        Game game = new Game();
        player = new Player("test", game);
    }

    @Test
    public void TestStep() {
        PlayerHand hand = new PlayerHand();
        hand.setLetter(0, 'a');
        hand.setLetter(1, 'b');
        player.setHand(hand);
        assertNotEquals(player.getOldHand().getLetter(0), player.getHand().getLetter(0));
        player.step();
        assertEquals(player.getOldHand().getLetter(0), player.getHand().getLetter(0));
    }

    @Test
    public void TestRevert() {
        PlayerHand hand = new PlayerHand();
        hand.setLetter(0, 'a');
        hand.setLetter(1, 'b');
        player.setHand(hand);
        player.step();
        PlayerHand hand2 = new PlayerHand();
        player.setHand(hand2);
        assertNotEquals(player.getOldHand(), player.getHand());
        player.revert();
        assertEquals(player.getHand(), player.getOldHand());
    }

    @Test
    public void TestAddScore() {
        player.addScore(5);
        player.addScore(7);
        player.addScore(2);
        player.addScore(4);
        assertEquals(player.getScore(), new Integer(18));
    }

    @Test
    public void TestGetName() {
        assertEquals(player.getName(), "test");
    }

}