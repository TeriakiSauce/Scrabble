import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Represents the state of the game. Represents all that needs to be saved and loaded.
 * @author Jaan
 * @version 1.0
 */
public class State implements Serializable {

    /**
     * The letter bag.
     */
    private LetterBag bag;

    /**
     * The current letter chain.
     */
    private LetterChain chain;

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
     *
     */
    private String name;

    /**
     * Create a new state.
     * @param game The game
     */
    public State(Game game) {
        bag = new LetterBag();
        chain = new LetterChain(game);
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
        turn = 0;
        player = 0;
        if (players.size() > 0) {
            players.get(0).getHand().clear();
            bag.updateHand(players.get(0).getHand());
        }
    }

    /**
     * 
     */
    public void fullReset() {
        players.clear();
        reset();
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
     *
     */
    public void back() {
        if (player == 0) {
            turn--;
            player = players.size() - 1;
        } else {
            player--;
        }
    }

    /**
     * Step the turn/player forward.
     */
    public void next() {
        player++;
        if (player == players.size()) {
            player = 0;
            turn++;
        }
    }

    public void step() {
        next();
        chain.clear();
        oldBoard = newBoard.makeCopy();
        save();
        saveWithVersion();
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
     * Get the old board
     * @return the old board
     */
    public Board getOldBoard() {
        return oldBoard;
    }

    /**
     * Get the current player.
     * @return The player.
     */
    public Player getPlayer() {
        if (!players.isEmpty()) {
            return players.get(player);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public Integer getPlayerTurn() {
        return player;
    }

    /**
     * Get the players.
     * @return The players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
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
        return oldBoard.equals(state.oldBoard) && newBoard.equals(state.newBoard)
                && players.equals(state.players) && turn.equals(state.turn)
                && player.equals(state.player);
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        chain.setGame(game);
        for (Player player : players) {
            player.setGame(game);
        }
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param game
     * @param path
     * @return
     */
    static State load(Game game, String path) {
        State state = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            state = (State) ois.readObject();
            state.setGame(game);
        } catch (Exception e) {}
        return state;
    }

    /**
     *
     * @return
     */
    private boolean save(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public boolean save() {
        return save(getPath());
    }

    /**
     *
     * @return
     */
    public boolean saveWithVersion() {
        return save(getPathWithVersion());
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return name;
    }

    /**
     * Return a path in the form: <name>_<turn>_<player>
     * e.g. test_3_1 would specify turn 3 for player 1 in game "test"
     * @return The path.
     */
    public String getPathWithVersion() {
        return getPath() + getVersion(turn, player);
    }

    /**
     *
     * @param turn
     * @param player
     * @return
     */
    public static String getVersion(Integer turn, Integer player) {
        return "_" + String.valueOf(turn) + "_" + String.valueOf(player);
    }

    /**
     *
     * @param game
     * @return
     */
    public boolean loadNext(State state, Game game) {
        next();
        State nextState = load(game, getPathWithVersion());
        back();
        if (nextState == null) {
            return false;
        } else {
            game.state = nextState;
            return true;
        }
    }

    /**
     *
     * @param game
     * @return
     */
    public boolean loadPrev(State state, Game game) {
        back();
        State nextState = load(game, getPathWithVersion());
        next();
        if (nextState == null) {
            return false;
        } else {
            game.state = nextState;
            return true;
        }
    }

    /**
     * Returns true if a bot is the current player
     */
    public boolean isBotPlaying(){
        return (players.get(player) instanceof PlayerBot);
    }
}
