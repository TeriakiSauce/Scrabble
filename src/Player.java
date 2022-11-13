import java.util.Objects;

/**
 * 
 */
public class Player {

    /**
     * 
     */
    protected PlayerHand oldHand;

    /**
     * 
     */
    protected PlayerHand newHand;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer score;

    /**
     * 
     */
    protected Game game;

    /**
     * 
     * @param name
     * @param game
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
     */
    public void placeBoard() {
        game.setX(null);
        game.setY(null);
        game.setN(null);
    }

    /**
     * 
     */
    public void placeHand() {
        game.setX(null);
        game.setY(null);
        game.setN(null);
    }

    /**
     * 
     */
    public void step() {
        oldHand = newHand.makeCopy();
    }

    /**
     * 
     */
    public void revert() {
        newHand = oldHand.makeCopy();
    }

    /**
     * 
     * @param score
     */
    public void addScore(Integer score) {
        this.score += score;
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
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * @return
     */
    public PlayerHand getHand() {
        return newHand;
    }

    /**
     *
     * @return
     */
    public PlayerHand getOldHand() {
        return oldHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(oldHand, player.oldHand) && Objects.equals(newHand, player.newHand) && Objects.equals(name, player.name) && Objects.equals(score, player.score) && Objects.equals(game, player.game);
    }

}
