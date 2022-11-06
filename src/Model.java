/**
 * 
 */
public class Model {

    /**
     * 
     */
    private Game game;

    /**
     * 
     */
    private View view;

    /**
     * 
     * @param view
     */
    public Model(View view, Game game) {
        this.view = view;
        this.game = game;
        paint();
    }

    /**
     * 
     */
    public void placeBoard() {
        game.placeBoard();
        paint();
    }

    /**
     * 
     */
    public void placeHand() {
        game.placeHand();
        paint();
    }

    /**
     * 
     */
    public void quit() {
        game.quit();
        paint();
        view.quit();
    }

    /**
     * 
     */
    public void pass() {
        game.pass();
        paint();
    }

    /**
     * 
     */
    public void finish() {
        game.finish();
        paint();
    }

    /**
     * 
     */
    public void reset() {
        game.reset();
        paint();
    }

    /**
     * 
     * @param x
     */
    public void setX(Integer x) {
        game.setX(x);
    }

    /**
     * 
     * @param y
     */
    public void setY(Integer y) {
        game.setY(y);
    }

    /**
     * 
     * @param n
     */
    public void setN(Integer n) {
        game.setN(n);
    }

    /**
     * 
     */
    public void paint() {
        State state = game.getState();
        Board board = state.getBoard();
        Player player = state.getPlayer();
        PlayerHand hand = player.getHand();

        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                view.setBoardLetter(j, i, board.getLetter(j, i));
            }
        }

        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            view.setHandLetter(i, hand.getLetter(i));
        }
    }
}
