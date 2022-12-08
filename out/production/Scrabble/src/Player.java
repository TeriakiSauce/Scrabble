import java.util.Objects;
import java.io.Serializable;

/**
 * Represents a player type. Can be either a user or a bot.
 * @author Jaan
 * @version 1.0
 */
public class Player implements Serializable {

    /**
     * The old hand.
     */
    protected PlayerHand oldHand;

    /**
     * The new hand.
     */
    protected PlayerHand newHand;

    /**
     * The player name.
     */
    private String name;

    /**
     * The player score.
     */
    private Integer score;

    /**
     * The game.
     */
    protected transient Game game;

    /**
     * Creates a new player.
     * @param name of the player.
     * @param game that is played.
     */
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        oldHand = new PlayerHand();
        newHand = new PlayerHand();
        score = 0;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Place board action.
     */
    public void placeBoard() {
        game.setX(null);
        game.setY(null);
        game.setN(null);
    }

    /**
     * Place hand action.
     */
    public void placeHand() {
        game.setX(null);
        game.setY(null);
        game.setN(null);
    }

    /**
     * Step player hand forward.
     */
    public void step() {
        oldHand = newHand.makeCopy();
    }

    /**
     * Reverts player hand.
     */
    public void revert() {
        newHand = oldHand.makeCopy();
    }

    /**
     * Add to player score.
     * @param score The added score.
     */
    public void addScore(Integer score) {
        this.score += score;
    }

    /**
     * Get the player name.
     * @return The player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the score.
     * @return The score.
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets the hand.
     * @param hand to be set.
     */
    public void setHand(PlayerHand hand) {
        newHand = hand;
    }

    /**
     * Returns the current hand.
     * @return the current hand.
     */
    public PlayerHand getHand() {
        return newHand;
    }

    /**
     * Returns the old hand.
     * @return the old hand.
     */
    public PlayerHand getOldHand() {
        return oldHand;
    }

    /**
     * Compares the player with the specified player.
     * @param o the player to be compared.
     * @return true if player are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(oldHand, player.oldHand) && Objects.equals(newHand, player.newHand) && Objects.equals(name, player.name) && Objects.equals(score, player.score) && Objects.equals(game, player.game);
    }

}
