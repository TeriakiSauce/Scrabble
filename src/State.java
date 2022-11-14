import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the state of the game. Represents all that needs to be saved and loaded.
 * @author Jaan
 * @version 1.0
 */
public class State {

    /**
     * The letter bag.
     */
    private LetterBag bag;

    /**
     * The current letter chain.
     */
    private LetterChain chain;

    /**
     * The word bank.
     */
    private WordBank bank;

    /**
     * The old board.
     */
    private Board oldBoard;

    /**
     * The new board.
     */
    private Board newBoard;

    /**
     * The players.
     */
    private ArrayList<Player> players;

    /**
     * The current turn.
     */
    private Integer turn;

    /**
     * The current player.
     */
    private Integer player;

    /**
     * Create a new state.
     */
    public State() {
        bag = new LetterBag();
        chain = new LetterChain(this);
        bank = new WordBank(Config.WORD_BANK_PATH);
        oldBoard = new Board();
        newBoard = new Board();
        players = new ArrayList<>();
        reset();
    }

    /**
     * Resets the state.
     */
    public void reset() {
        bag.reset();
        oldBoard.clear();
        newBoard.clear();
        players.clear();
        turn = 0;
        player = 0;
    }

    /**
     * Add a new player. Can only be done on turn zero.
     * @param player The player.
     */
    public void addPlayer(Player player) {
        assert(turn == 0);
        players.add(player);
    }

    /**
     * Step the turn/player forward.
     */
    public void step() {
        player++;
        if (player == players.size()) {
            player = 0;
            turn++;
        }

        chain.clear();
        oldBoard = newBoard.makeCopy();
    }

    /**
     * Revert the turn.
     */
    public void revert() {
        newBoard = oldBoard.makeCopy();
        chain.clear();
    }

    /**
     * Get the letter bag.
     * @return The letter bag.
     */
    public LetterBag getBag() {
        return bag;
    }

    /**
     * Get the word bank.
     * @return The word bank.
     */
    public WordBank getWordBank() {
        return bank;
    }

    /**
     * Get the letter chain.
     * @return The letter chain.
     */
    public LetterChain getChain() {
        return chain;
    }

    /**
     * Get the board.
     * @return The board.
     */
    public Board getBoard() {
        return newBoard;
    }

    /**
     * Get the current player.
     * @return The player.
     */
    public Player getPlayer() {
        return players.get(player);
    }

    /**
     * Get the current turn.
     * @return The turn.
     */
    public Integer getTurn() {
        return turn;
    }

    /**
     * Compares the state with the specified state.
     * @param o the state to be compared.
     * @return true if states are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return bag.equals(state.bag) && chain.equals(state.chain)
                && oldBoard.equals(state.oldBoard) && newBoard.equals(state.newBoard)
                && players.equals(state.players) && turn.equals(state.turn)
                && player.equals(state.player);
    }

}
