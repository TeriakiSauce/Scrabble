import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * Represents the action panel of the view. Has several buttons for passing,
 * quitting, finishing, and resetting the game.
 * @author Jaan
 * @version 1.0
 */
public class PlayPanelAction extends JPanel {

    /**
     * The pass button.
     */
    private JButton pass;

    /**
     * The quit button.
     */
    private JButton quit;

    /**
     * The finish button.
     */
    private JButton finish;

    /**
     * The reset button.
     */
    private JButton reset;

    /**
     * The undo button.
     */
    private JButton undo;

    /**
     * The redo button.
     */
    private JButton redo;

    /**
     * Create new panel action.
     */
    public PlayPanelAction() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH
        ));

        pass = new JButton(Config.PLAY_PASS_BUTTON_TEXT);
        quit = new JButton(Config.PLAY_QUIT_BUTTON_TEXT);
        finish = new JButton(Config.PLAY_FINISH_BUTTON_TEXT);
        reset = new JButton(Config.PLAY_RESET_BUTTON_TEXT);
        undo = new JButton(Config.PLAY_UNDO_BUTTON_TEXT);
        redo = new JButton(Config.PLAY_REDO_BUTTON_TEXT);

        add(pass);
        add(quit);
        add(finish);
        add(reset);
        add(undo);
        add(redo);
    }

    /**
     * Set on pass button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnPass(ActionListener listener) {
        pass.addActionListener(listener);
    }

    /**
     * Set on quit button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnQuit(ActionListener listener) {
        quit.addActionListener(listener);
    }

    /**
     * Set on finish button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnFinish(ActionListener listener) {
        finish.addActionListener(listener);
    }

    /**
     * Set on reset button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnReset(ActionListener listener) {
        reset.addActionListener(listener);
    }

    /**
     * Set on undo button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnUndo(ActionListener listener) {
        undo.addActionListener(listener);
    }

    /**
     * Set on redo button clicked action listener.
     * @param listener The action listener.
     */
    public void setOnRedo(ActionListener listener) {
        redo.addActionListener(listener);
    }
}
