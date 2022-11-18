import javax.swing.JFrame;

/**
 * Represents the view component of the model view controller.
 */
public class View extends JFrame {

    /**
     * The start screen.
     */
    private ViewStart start;

    /**
     * The help screen.
     */
    private ViewHelp help;

    /**
     * The play screen.
     */
    private ViewPlay play;

    /**
     * Create new view.
     */
    public View() {
        setTitle(Config.FRAME_TITLE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        start = new ViewStart(this);
        help = new ViewHelp(this);
        play = new ViewPlay(this);
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
     * Get the start screen.
     * @return The start screen.
     */
    public ViewStart getStartScreen() {
        return start;
    }

    /**
     * Set the screen to the play screen.
     */
    public void setStartScreen() {
        getContentPane().removeAll();
        repaint();
        start.add();
    }

    /**
     * Get the help screen.
     * @return The help screen.
     */
    public ViewHelp getHelpScreen() {
        return help;
    }

    /**
     * Set the screen to the help screen.
     */
    public void setHelpScreen() {
        getContentPane().removeAll();
        repaint();
        help.add();
    }

    /**
     * Get the play screen.
     * @return The play screen.
     */
    public ViewPlay getPlayScreen() {
        return play;
    }

    /**
     * Set the screen to the play screen.
     */
    public void setPlayScreen() {
        getContentPane().removeAll();
        repaint();
        play.add();
    }
}
