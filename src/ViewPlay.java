import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class ViewPlay {

    /**
     * The action panel.
     */
    private PlayPanelAction action;

    /**
     * The board panel.
     */
    private PlayPanelBoard board;

    /**
     * The hand panel.
     */
    private PlayPanelHand hand;

    /**
     * The other/misc panel.
     */
    private PlayPanelOther other;

    /**
     * The score panel.
     */
    private PlayPanelScore score;

    /**
     * The view.
     */
    private View view;
    
    /**
     * Create new ViewPlayScreen.
     * @param view The view.
     */
    public ViewPlay(View view) {
        this.view = view;
        action = new PlayPanelAction();
        board = new PlayPanelBoard();
        hand = new PlayPanelHand();
        other = new PlayPanelOther();
        score = new PlayPanelScore();
    }

    /**
     * Add components to view.
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(action, BorderLayout.EAST);
        view.add(board, BorderLayout.CENTER);
        view.add(hand, BorderLayout.SOUTH);
        view.add(other, BorderLayout.NORTH);
        view.add(score, BorderLayout.WEST);
    }

    /**
     * Set the board on click action listener.
     * @param listener The action listener.
     */
    public void setBoardOnClick(PlayPanelBoardListener listener) {
        board.setOnClick(listener);
    }

    /**
     * Set the hand on click action listener.
     * @param listener The action listener.
     */
    public void setHandOnClick(PlayPanelHandListener listener) {
        hand.setOnClick(listener);
    }

    /**
     * Set action on pass button clicked action listener.
     * @param listener The action listener.
     */
    public void setActionOnPass(ActionListener listener) {
        action.setOnPass(listener);
    }

    /**
     * Set action on quit button clicked action listener.
     * @param listener The action listener.
     */
    public void setActionOnQuit(ActionListener listener) {
        action.setOnQuit(listener);
    }

    /**
     * Set action on finish button clicked action listener.
     * @param listener The action listener.
     */
    public void setActionOnFinish(ActionListener listener) {
        action.setOnFinish(listener);
    }

    /**
     * Set action on reset button clicked action listener.
     * @param listener The action listener.
     */
    public void setActionOnReset(ActionListener listener) {
        action.setOnReset(listener);
    }

    /**
     * Set board letter at specified position.
     * @param x The x position.
     * @param y The y position.
     * @param letter The letter.
     */
    public void setBoardLetter(Integer x, Integer y, Character letter) {
        board.setLetter(x, y, letter);
    }

    /**
     * Set hand letter at specified index.
     * @param n The index.
     * @param letter The letter.
     */
    public void setHandLetter(Integer n, Character letter) {
        hand.setLetter(n, letter);
    }

    /**
     * 
     * @param n
     * @param player
     */
    public void setScorePlayer(int n, Player player) {
        score.setPlayer(n, player);
    }

    /**
     * 
     * @param turn
     */
    public void setTurn(String turn) {
        other.setTurn(turn);
    }

    /**
     * 
     * @param player
     */
    public void setPlayer(Player player) {
        other.setPlayer(player);
    }
}
