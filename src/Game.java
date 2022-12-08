import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Represents the main component of the game. Combines several components
 * to create the game.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class Game implements Serializable {

    /**
     * The game state.
     */
    public transient State state;

    /**
     * The word bank.
     */
    private transient WordBank bank;

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
     * The blank tile counter.
     */
    private Integer blankCounter;

    /**
     * Create new game.
     */
    public Game() {
        this.blankCounter = 0;
        state = new State(this);
        bank = new WordBank(Config.WORD_BANK_PATH);
        reset();
    }

    /**
     * Increments the blank tile counter
     */
    public void incrementCounter(){
        this.blankCounter++;
    }

    /**
     * Resets the blank tile counter
     */
    public void resetCounter(){
        this.blankCounter = 0;
    }

    /**
     * Gets the blank tile counter
     */
    public Integer getCounter(){
        return this.blankCounter;
    }

    /**
     * Reset the game. Currently creates one player for the main user.
     */
    public void reset() {
        setX(null);
        setY(null);
        setN(null);
        resetCounter();
        state.reset();
    }

    /**
     * 
     */
    public void fullReset() {
        resetCounter();
        state.fullReset();
        reset();
    }

    /**
     * Quit the game.
     */
    public void quit() {
        resetCounter();
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
     * Invokes the set blank tile action for the current player.
     */
    public void setBlankTile(Character letter) {
        state.getPlayer().getHand().setBlankTile(letter);
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

//        removeSavesAfter();
        state.getBag().updateHand(state.getPlayer().getHand());
        state.getPlayer().addScore(score);
        state.getPlayer().step();
        state.step();
        return true;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean create(String name) {
        Path path = Paths.get(name);
        if (Files.exists(path)) {
            return false;
        } else {
            state = new State(this);
            state.setName(name);
            return true;
        }
    }

    /**
     *
     */
    public void save() {
        state.save();
        state.saveWithVersion();

    }

    /**
     *
     */
    private void removeSavesAfter() {

        // TODO:
        // TODO: This needs to be fixed!!!!!
        // TODO:
        
        Integer turn = state.getTurn();
        Integer player = state.getPlayerTurn();
        Integer maxPlayers = state.getPlayers().size();

        while (true) {
            String path = state.getName() + State.getVersion(turn, player);
            Path filePath = Paths.get(path);
            if (Files.exists(filePath)) {
                try {
                    Files.delete(filePath);
                } catch (IOException e) {
                    return;
                }
            } else {
                return;
            }

            if (player >= maxPlayers - 1) {
                turn++;
                player = 0;
            } else {
                player++;
            }
        }
    }

    /**
     *
     * @param name
     */
    public void load(String name) {
        state = State.load(this, name);
    }

    /**
     *
     * @return
     */
    public boolean undo() {
        return state.loadPrev(state, this);
    }

    /**
     *
     * @return
     */
    public boolean redo() {
        return state.loadNext(state, this);
    }

    /**
     * Pass the turn for the current player. Makes sure to revert any placements in case the player
     * attempted to place something.
     */
    public void pass() {
        state.getPlayer().revert();
        state.revert();
//        removeSavesAfter();
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
