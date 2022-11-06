/**
 * 
 */
public class PlayerUser extends Player {

    /**
     * 
     * @param name
     * @param game
     */
    public PlayerUser(String name, Game game) {
        super(name, game);
    }
    
    /**
     * 
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
        chain.addLetter(x, y, letter);
        board.setLetter(x, y, letter);
        super.placeBoard();
    }
    
    /**
     * 
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
