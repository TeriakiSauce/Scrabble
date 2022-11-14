/**
 * Represents a player type. Can be either a user or a bot.
 * @author Jaan
 * @version 1.0
 */
public class Player {

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
    protected Game game;

    /**
     * Create new player.
     * @param name The player name.
     * @param game The game.
     */
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        oldHand = new PlayerHand();
        newHand = new PlayerHand();
        score = 0;
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
     * Revert player hand.
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
     * Get the hand.
     * @return The hand.
     */
    public PlayerHand getHand() {
        return newHand;
    }
}