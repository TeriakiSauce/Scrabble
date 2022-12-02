import java.io.Serializable;

/**
 * Represents a user player. Provides methods for manual placing of letters.
 * @author Jaan
 * @version 1.0
 */
public class PlayerUser extends Player implements Serializable {

    /**
     * Create new player user.
     * @param name The player name.
     * @param game The game.
     */
    public PlayerUser(String name, Game game) {
        super(name, game);
    }
    
    /**
     * Place board action.
     */
    @Override
    public void placeBoard() {
        Integer x = game.getX();
        Integer y = game.getY();
        Integer n = game.getN();
        State state = game.getState();
        LetterChain chain = state.getChain();
        Board board = state.getBoard();

        if (board.hasLetter(x, y) || n == null || x == null || y == null) {
            return;
        }

        Character letter = newHand.getLetter(n);
        newHand.removeLetter(n);
        LetterCell cell = new LetterCell(x, y, letter);
        chain.addLetter(cell);
        board.setLetter(cell);
        super.placeBoard();
    }
    
    /**
     * Place hand action.
     */
    @Override
    public void placeHand() {
        Integer x = game.getX();
        Integer y = game.getY();
        Integer n = game.getN();
        State state = game.getState();
        LetterChain chain = state.getChain();
        Board board = state.getBoard();

        if (!chain.hasLetter(x, y) || n == null || x == null || y == null) {
            return;
        }

        Character letter = board.getLetter(x, y);
        newHand.setLetter(n, letter);
        board.removeLetter(x, y);
        chain.removeLetter(x, y);
        super.placeHand();
    }
}
