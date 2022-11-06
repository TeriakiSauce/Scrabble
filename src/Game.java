/**
 * 
 */
public class Game {

    /**
     * 
     */
    private State state;

    /**
     * 
     */
    private Integer x;

    /**
     * 
     */
    private Integer y;

    /**
     * 
     */
    private Integer n;

    /**
     * 
     */
    public Game() {
        state = new State();
        reset();
    }

    /**
     * 
     */
    public void reset() {
        state.reset();

        PlayerUser player = new PlayerUser("Player 1", this);
        state.addPlayer(player);
        state.getBag().updateHand(player.getHand());
        player.step();
    }

    /**
     * 
     */
    public void quit() {

    }

    /**
     * 
     */
    public void placeBoard() {
        state.getPlayer().placeBoard();
    }

    /**
     * 
     */
    public void placeHand() {
        state.getPlayer().placeHand();
    }

    /**
     * 
     */
    public void finish() {
        Integer score = state.getChain().getScore();
        if ((state.getTurn() == 0 && state.getChain().getSize() == 1) || score == 0) {
            state.getPlayer().revert();
            state.revert();
            return;
        }

        state.getBag().updateHand(state.getPlayer().getHand());
        state.getPlayer().addScore(score);
        state.getPlayer().step();
        state.step();
    }

    /**
     * 
     */
    public void pass() {
        state.getPlayer().revert();
        state.revert();
        state.step();
    }

    /**
     * 
     * @return
     */
    public State getState() {
        return state;
    }

    /**
     * 
     * @return
     */
    public Integer getX() {
        return x;
    }

    /**
     * 
     * @param x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * 
     * @return
     */
    public Integer getY() {
        return y;
    }

    /**
     * 
     * @param y
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * 
     * @return
     */
    public Integer getN() {
        return n;
    }

    /**
     * 
     * @param n
     */
    public void setN(Integer n) {
        this.n = n;
    }
}
