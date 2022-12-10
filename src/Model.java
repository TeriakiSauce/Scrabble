import java.io.InputStream;
import java.util.ArrayList;

/**
 * Represents the model computing of the model view controller. Receives callbacks from the 
 * controller which it uses to update the view and the game.
 * @author Jaan
 * @version 1.0
 */
public class Model {

    /**
     * The game.
     */
    private Game game;

    /**
     * The view.
     */
    private View view;

    /**
     * 
     */
    private NameGen names;

    /**
     * Create a new model and attach a view and game.
     * @param view The view.
     * @param game The game.
     */
    public Model(View view, Game game) {
        this.view = view;
        this.game = game;
        names = new NameGen();
        view.setStartScreen();
        paint();
    }

    /**
     * Call the game place board action and repaint.
     */
    public void placeBoard() {
        game.placeBoard();
        paint();
    }

    /**
     * Call the game place hand action and repaint.
     */
    public void placeHand() {
        game.placeHand();
        paint();
    }

    /**
     * Increments the blank tile counter
     */
    public void incrementCounter(){
        game.incrementCounter();
    }

    /**
     * Resets the blank tile counter
     */
    public void resetCounter(){
        game.resetCounter();
    }

    /**
     * Gets the blank tile counter
     */
    public Integer getCounter(){
        return game.getCounter();
    }

    /**
     * Call the game set blank tile action and repaint.
     */
    public void setBlankTile(Character letter) {
        game.setBlankTile(letter);
        paint();
    }


    /**
     * Call the game quit action, the view quit action, and repaint.
     */
    public void quit() {
        game.quit();
        paint();
        view.quit();
    }

    /**
     * Call the game pass action and repaint.
     */
    public void pass() {
        game.pass();
        paint();
    }

    /**
     * Call the game finish action and repaint.
     */
    public boolean finish() {
        boolean tmp = game.finish();
        paint();
        return tmp;
    }

    /**
     * Call the game reset action and repaint.
     */
    public void reset() {
        game.reset();
        view.reset();
        paint();
    }

    /**
     *
     * @return
     */
    public boolean undo() {
        boolean rc = game.undo();
        paint();
        return rc;
    }

    /**
     *
     * @return
     */
    public boolean redo() {
        boolean rc = game.redo();
        paint();
        return rc;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean create(String name) {
        boolean rc = game.create(name);
        paint();
        return rc;
    }

    /**
     *
     * @param name
     */
    public void load(String name) {
        game.load(name);
        paint();
    }

    /**
     *
     */
    public void save() {
        game.save();
    }

    /**
     * Call the game set x position.
     * @param x The x position.
     */
    public void setX(Integer x) {
        game.setX(x);
    }

    /**
     * Call the game set y position.
     * @param y The y position.
     */
    public void setY(Integer y) {
        game.setY(y);
    }

    /**
     * Call the game set letter.
     * @param n The letter.
     */
    public void setN(Integer n) {
        game.setN(n);
    }

    /**
     *
     * @param is
     */
    public void importXML(InputStream is) {
        State state = game.getState();
        Board board = state.getBoard();
        try {
            board.importFromXml(is);
        } catch (Exception e) {
            System.out.println("Error importing from XML in model: " + e);
        }

        state.updateOldBoard();
    }

    /**
     * Acquire the board and player hand and update the
     * view with the data.
     */
    public void paint() {
        ViewPlay play = view.getPlayScreen();
        State state = game.getState();
        Board board = state.getBoard();
        Player player = state.getPlayer();
        ArrayList<Player> players = state.getPlayers();

        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                play.setBoardLetter(j, i, board.getLetter(j, i));
//                if (board.getType(j, i) != BoardCell.Type.NORMAL) {
//                    System.out.println(board.getType(j, i).)
//                }
                play.setBoardCellType(j, i, board.getType(j, i));
            }
        }

        if (player != null) {
            // Only draw the current hand if a user is playing
            if (player instanceof PlayerUser) {
                PlayerHand hand = player.getHand();
                for (Integer i = 0; i < Config.HAND_SIZE; i++) {
                    play.setHandLetter(i, hand.getLetter(i));
                }
            }
        }

        for (Integer i = 0; i < players.size(); i++) {
            play.setScorePlayer(i, players.get(i));
        }

        play.setTurn(String.valueOf(state.getTurn()));

        if (player != null) {
            play.setPlayer(player);
        } 

        // Ensure that the view is updated
        view.revalidate();
        view.repaint();
    }

    /**
     * 
     * @return
     */
    public NameGen getNames() {
        return names;
    }

    /**
     * 
     * @param name
     */
    public void addUser(String name) {
        game.getState().addPlayer(new PlayerUser(name, game));
    }

    /**
     * @param name
     */
    public void addBot(String name, PlayerBot.DIFFICULTY difficulty) {
        game.getState().addPlayer(new PlayerBot(name, game, difficulty));
    }

    /**
     * 
     */
    public void fillAllHands() {
        LetterBag bag = game.getState().getBag();
        ArrayList<Player> players = game.getState().getPlayers();
        for (Player player : players) {
            bag.updateHand(player.getHand());
            player.step();
        }
    }

    public void fullReset() {
        game.fullReset();
        reset();
    }

    public Game getGame(){
        return game;
    }
}
