import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;

/**
 * 
 */
public class StartPanelAction extends JPanel {

    /**
     *
     */
    private JButton newGame;

    /**
     *
     */
    private JButton load;

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

        newGame = new JButton(Config.START_NEW_BUTTON_TEXT);
        load = new JButton(Config.START_LOAD_BUTTON_TEXT);
        help = new JButton(Config.START_HELP_BUTTON_TEXT);

        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGame.setAlignmentY(Component.CENTER_ALIGNMENT);
        load.setAlignmentX(Component.CENTER_ALIGNMENT);
        load.setAlignmentY(Component.CENTER_ALIGNMENT);
        help.setAlignmentX(Component.CENTER_ALIGNMENT);
        help.setAlignmentY(Component.CENTER_ALIGNMENT);

        add(newGame);
        add(load);
        add(help);
    }

    /**
     *
     * @param listener
     */
    public void setOnNew(ActionListener listener) {
        newGame.addActionListener(listener);
    }

    /**
     *
     * @param listener
     */
    public void setOnLoad(ActionListener listener) {
        load.addActionListener(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setOnHelp(ActionListener listener) {
        help.addActionListener(listener);
    }
}
