import java.util.ArrayList;

/**
 * 
 */
public class State {

    /**
     * 
     */
    private LetterBag bag;

    /**
     * 
     */
    private LetterChain chain;

    /**
     * 
     */
    private WordBank bank;

    /**
     * 
     */
    private Board oldBoard;

    /**
     * 
     */
    private Board newBoard;

    /**
     * 
     */
    private ArrayList<Player> players;

    /**
     * 
     */
    private Integer turn;

    /**
     * 
     */
    private Integer player;

    /**
     * 
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
     * 
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
     * 
     * @param player
     */
    public void addPlayer(Player player) {
        assert(turn == 0);
        players.add(player);
    }

    /**
     * 
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
     * 
     */
    public void revert() {
        newBoard = oldBoard.makeCopy();
        chain.clear();
    }

    /**
     * 
     * @return
     */
    public LetterBag getBag() {
        return bag;
    }

    /**
     *
     * @return
     */
    public WordBank getWordBank() {
        return bank;
    }
    
    /**
     * 
     * @return
     */
    public LetterChain getChain() {
        return chain;
    }

    /**
     * 
     * @return
     */
    public Board getBoard() {
        return newBoard;
    }

    /**
     * 
     * @return
     */
    public Player getPlayer() {
        return players.get(player);
    }

    /**
     * 
     * @return
     */
    public Integer getTurn() {
        return turn;
    }
}
