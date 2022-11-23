import org.junit.Before;
import org.junit.Test;

/**
 * Testing the PlayerBot class which has AI functionality
 */
public class PlayerBotTest {
    private Game game;
    private Board board;
    private PlayerBot bot;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        board = game.getState().getBoard();
        bot = new PlayerBot("bot", game);
        board.setLetter(new LetterCell(7,7,'b'));
        board.setLetter(new LetterCell(7,8,'o'));
        board.setLetter(new LetterCell(7,9,'y'));
        board.setLetter(new LetterCell(6,8,'l'));
        board.setLetter(new LetterCell(8,8,'t'));


        game.getState().step();
        bot.collectBoardWords();
        bot.findHandCombos();
    }


    @Test
    public void testCollectBoardWords() {

        bot.collectBoardWords();

        System.out.println(bot.getCurrentWords());
    }
    @Test
    public void testFindHandCombos() {

        bot.findHandCombos();
        System.out.println(bot.getHandCombos());
    }

    @Test
    public void testCalculatePossiblePoints() {

        bot.calculatePossiblePoints();


        System.out.println(bot.choosePlay());
    }
    @Test
    public void testPlaceBoard() {

        bot.placeBoard();

    }
}