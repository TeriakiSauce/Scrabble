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
public class PanelAction extends JPanel {

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
     * Create new panel action.
     */
    public PanelAction() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH
        ));

        pass = new JButton(Config.PASS_BUTTON_TEXT);
        quit = new JButton(Config.QUIT_BUTTON_TEXT);
        finish = new JButton(Config.FINISH_BUTTON_TEXT);
        reset = new JButton(Config.RESET_BUTTON_TEXT);

        add(pass);
        add(quit);
        add(finish);
        add(reset);
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
}
