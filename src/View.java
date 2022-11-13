import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * Represents the view component of the model view controller.
 */
public class View extends JFrame {

    /**
     * The action panel.
     */
    private PanelAction action;

    /**
     * The board panel.
     */
    private PanelBoard board;

    /**
     * The hand panel.
     */
    private PanelHand hand;

    /**
     * The other/misc panel.
     */
    private PanelOther other;

    /**
     * The score panel.
     */
    private PanelScore score;

    /**
     * Create new view.
     */
    public View() {
        setTitle(Config.FRAME_TITLE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        action = new PanelAction();
        board = new PanelBoard();
        hand = new PanelHand();
        other = new PanelOther();
        score = new PanelScore();

        setLayout(new BorderLayout());
        add(action, BorderLayout.EAST);
        add(board, BorderLayout.CENTER);
        add(hand, BorderLayout.SOUTH);
        add(other, BorderLayout.NORTH);
        add(score, BorderLayout.WEST);
    }

    /**
     * Reset the view.
     */
    public void reset() {

    }
    
    /**
     * Quit the view. Just closed the window.
     */
    public void quit() {
        setVisible(false);
        dispose();
    }

    /**
     * Set the board on click action listener.
     * @param listener The action listener.
     */
    public void setBoardOnClick(PanelBoardListener listener) {
        board.setOnClick(listener);
    }

    /**
     * Set the hand on click action listener.
     * @param listener The action listener.
     */
    public void setHandOnClick(PanelHandListener listener) {
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
}
