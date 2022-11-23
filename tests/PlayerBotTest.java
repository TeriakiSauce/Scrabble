import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        board.setLetter(new LetterCell(7,7,'a'));
        board.setLetter(new LetterCell(7,8,'s'));
        board.setLetter(new LetterCell(7,9,'h'));


        game.getState().step();
        bot.collectBoardWords();
        bot.findHandCombos();
    }


    @Test
    public void testCollectBoardWords() {

        bot.collectBoardWords();
        LinkedList words = (LinkedList) bot.getCurrentWords();
        LetterChain answer1 = new LetterChain(game.getState());
        answer1.addLetter(new LetterCell(7,7,'a'));
        answer1.addLetter(new LetterCell(7,8,'s'));
        answer1.addLetter(new LetterCell(7,9,'h'));
        answer1.setIsVertical(true);

        LetterChain answer2 = new LetterChain(game.getState());
        answer2.addLetter(new LetterCell(7,7,'a'));
        answer2.setIsVertical(false);

        LetterChain answer3 = new LetterChain(game.getState());
        answer3.addLetter(new LetterCell(7,8,'s'));
        answer3.setIsVertical(false);

        LetterChain answer4 = new LetterChain(game.getState());
        answer4.addLetter(new LetterCell(7,9,'h'));
        answer4.setIsVertical(false);

        LinkedList answers = new LinkedList<LetterChain>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        assert(answers.equals(words));
    }
    @Test
    public void testFindHandCombos() {

        bot.findHandCombos();
        List strings = new ArrayList<>();
        strings.add("c");
        strings.add("b");
        strings.add("bc");
        strings.add("cb");
        strings.add("a");
        strings.add("ac");
        strings.add("ca");
        strings.add("ab");
        strings.add("ba");
        strings.add("abc");
        strings.add("acb");
        strings.add("bac");
        strings.add("bca");
        strings.add("cab");
        strings.add("cba");

        assert(bot.getHandCombos().equals(strings));


    }

    @Test
    public void testChoosePlay() {

        bot.calculatePossiblePoints();
        LetterChain optimal = new LetterChain(game.getState());
        optimal.addLetter(new LetterCell(6,9,'c'));
        optimal.addLetter(new LetterCell(8,9,'a'));
        assert(bot.choosePlay().equals(optimal));

    }

}