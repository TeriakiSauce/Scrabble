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
        bot = new PlayerBot("bot", game, PlayerBot.DIFFICULTY.HARD);
        PlayerHand hand = new PlayerHand();
        hand.setLetter(0,'a');
        hand.setLetter(1,'b');
        hand.setLetter(2,'c');
        hand.setLetter(3,'d');
        hand.setLetter(4,'e');
        hand.setLetter(5,'f');
        hand.setLetter(6,'g');
        bot.setHand(hand);

        board.setLetter(new BoardCell(7,7,'a'));
        board.setLetter(new BoardCell(7,8,'s'));
        board.setLetter(new BoardCell(7,9,'h'));


        game.getState().step();
        bot.collectBoardWords();
        bot.findHandCombos();
    }


    @Test
    public void testCollectBoardWords() {

        bot.collectBoardWords();
        LinkedList words = (LinkedList) bot.getCurrentWords();
        LetterChain answer1 = new LetterChain(game);
        answer1.addLetter(new BoardCell(7,7,'a'));
        answer1.addLetter(new BoardCell(7,8,'s'));
        answer1.addLetter(new BoardCell(7,9,'h'));
        answer1.setIsVertical(true);

        LetterChain answer2 = new LetterChain(game);
        answer2.addLetter(new BoardCell(7,7,'a'));
        answer2.setIsVertical(false);

        LetterChain answer3 = new LetterChain(game);
        answer3.addLetter(new BoardCell(7,8,'s'));
        answer3.setIsVertical(false);

        LetterChain answer4 = new LetterChain(game);
        answer4.addLetter(new BoardCell(7,9,'h'));
        answer4.setIsVertical(false);

        LinkedList answers = new LinkedList<LetterChain>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        assert(answers.equals(words));
    }

    @Test
    public void testChoosePlay() {

        bot.calculatePossiblePoints();
        LetterChain optimal = new LetterChain(game);
        optimal.addLetter(new BoardCell(8,7,'p', BoardCell.Type.NORMAL));
        optimal.addLetter(new BoardCell(9,7,'e', BoardCell.Type.NORMAL));
        optimal.addLetter(new BoardCell(10,7,'k', BoardCell.Type.NORMAL));
        optimal.addLetter(new BoardCell(11,7,'a', BoardCell.Type.NORMAL));
        optimal.addLetter(new BoardCell(12,7,'n', BoardCell.Type.NORMAL));
        System.out.println(bot.choosePlay());
        assert(bot.choosePlay().equals(optimal));

    }
}