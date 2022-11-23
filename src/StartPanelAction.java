import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;

/**
 * 
 */
public class StartPanelAction extends JPanel {

    /**
     * 
     */
    private JButton start;

    /**
     * 
     */
    private JButton help;

    /**
     * 
     */
    public StartPanelAction() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH
        ));

        start = new JButton(Config.START_START_BUTTON_TEXT);
        help = new JButton(Config.START_HELP_BUTTON_TEXT);

        start.setHorizontalAlignment(JLabel.CENTER);
        start.setVerticalAlignment(JLabel.CENTER);
        help.setHorizontalAlignment(JLabel.CENTER);
        help.setVerticalAlignment(JLabel.CENTER);

        add(start);
        add(help);
    }

    /**
     * 
     * @param listener
     */
    public void setOnStart(ActionListener listener) {
        start.addActionListener(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setOnHelp(ActionListener listener) {
        help.addActionListener(listener);
    }
}
