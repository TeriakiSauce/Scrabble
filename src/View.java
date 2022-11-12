import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * 
 */
public class View extends JFrame {

    /**
     * 
     */
    private PanelAction action;

    /**
     * 
     */
    private PanelBoard board;

    /**
     * 
     */
    private PanelHand hand;

    /**
     * 
     */
    private PanelOther other;

    /**
     * 
     */
    private PanelScore score;

    /**
     * 
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
     * 
     */
    public void reset() {

    }
    
    /**
     * 
     */
    public void quit() {
        setVisible(false);
        dispose();
    }

    /**
     * 
     * @param listener
     */
    public void setBoardOnClick(PanelBoardListener listener) {
        board.setOnClick(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setHandOnClick(PanelHandListener listener) {
        hand.setOnClick(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnPass(ActionListener listener) {
        action.setOnPass(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnQuit(ActionListener listener) {
        action.setOnQuit(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnFinish(ActionListener listener) {
        action.setOnFinish(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnReset(ActionListener listener) {
        action.setOnReset(listener);
    }

    /**
     * 
     * @param x
     * @param y
     * @param letter
     */
    public void setBoardLetter(Integer x, Integer y, Character letter) {
        board.setLetter(x, y, letter);
    }

    /**
     * 
     * @param n
     * @param letter
     */
    public void setHandLetter(Integer n, Character letter) {
        hand.setLetter(n, letter);
    }
}
