import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * 
 */
public class PanelAction extends JPanel {

    /**
     * 
     */
    private JButton pass;

    /**
     * 
     */
    private JButton quit;

    /**
     * 
     */
    private JButton finish;

    /**
     * 
     */
    private JButton reset;

    /**
     * 
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
     * @param listener
     */
    public void setOnPass(ActionListener listener) {
        pass.addActionListener(listener);
    }

    /**
     * @param listener
     */
    public void setOnQuit(ActionListener listener) {
        quit.addActionListener(listener);
    }

    /**
     * @param listener
     */
    public void setOnFinish(ActionListener listener) {
        finish.addActionListener(listener);
    }

    /**
     * @param listener
     */
    public void setOnReset(ActionListener listener) {
        reset.addActionListener(listener);
    }
}
