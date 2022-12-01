/**
 * Represents the main component of the game. Combines several components
 * to create the game.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class Game {

    /**
     * The game state.
     */
    private State state;

    /**
     * The word bank.
     */
    private WordBank bank;

    /**
     * The currently selected x position.
     */
    private Integer x;

    /**
     * The currently selected y position. 
     */
    private Integer y;

    /**
     * The currently selected letter.
     */
    private Integer n;

    /**
     * Create new game.
     */
    public Game() {
        state = new State(this);
        bank = new WordBank(Config.WORD_BANK_PATH);
        reset();
    }

    /**
     * Reset the game. Currently creates one player for the main user.
     */
    public void reset() {
        setX(null);
        setY(null);
        setN(null);
        state.reset();
    }

    /**
     * 
     */
    public void fullReset() {
        state.fullReset();
        reset();
    }

    /**
     * Quit the game.
<<<<<<< HEAD
     * @see Model
=======
>>>>>>> jsoulier
     */
    public void quit() {

    }

    /**
     * Invokes the place board action for the current player.
     */
    public void placeBoard() {
        state.getPlayer().placeBoard();
    }

    /**
     * Invokes the place hand action for the current player.
     */
    public void placeHand() {
        state.getPlayer().placeHand();
    }

    /**
     * Finish the turn for the current player. Checks if the score acheived is greater than zero, and
     * that more than 1 letter was placed unless it was the first turn. If this fails, the board and
     * player are reverted to before anything was placed for the turn. Otherwise, the score is added
     * and the next turn is started.
     * @return
     */
    public boolean finish() {
        Integer score = state.getChain().getScore();
        if ((state.getTurn() != 0 && state.getChain().getSize() == 1) || score == 0) {
            state.getPlayer().revert();
            state.revert();
            return false;
        }

        state.getBag().updateHand(state.getPlayer().getHand());
        state.getPlayer().addScore(score);
        state.getPlayer().step();
        state.step();
        return true;
    }

    /**
     * Pass the turn for the current player. Makes sure to revert any placements in case the player
     * attempted to place something.
     */
    public void pass() {
        state.getPlayer().revert();
        state.revert();
        state.step();
    }

    /**
     * Get the state.
     * @return The state.
     */
    public State getState() {
        return state;
    }

    /**
     * Get the word bank.
     * @return The word bank.
     */
    public WordBank getWordBank() {
        return bank;
    }

    /**
     * Get the currently selected x position.
     * @return The currenly selected x position.
     */
    public Integer getX() {
        return x;
    }

    /**
     * Set the currently selected x position.
     * @param x The currently selected x position.
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Get the currently selected y position.
     * @return The currently selected y position.
     */
    public Integer getY() {
        return y;
    }

    /**
     * Set the currently selected y position.
     * @param y Get the currently selected y position.
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Get the currently selected letter.
     * @return The currently selected letter.
     */
    public Integer getN() {
        return n;
    }

    /**
     * Set the currently selected letter.
     * @param n The currently selected letter.
     */
    public void setN(Integer n) {
        this.n = n;
    }
}
