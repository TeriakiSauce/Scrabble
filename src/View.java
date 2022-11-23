import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
     * 
     */
    private ViewSetup setup;

    /**
     * Create new view.
     */
    public View() {
        setTitle(Config.FRAME_TITLE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        start = new ViewStart(this);
        help = new ViewHelp(this);
        play = new ViewPlay(this);
        setup = new ViewSetup(this);
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
        start.add();
        revalidate();
        repaint();
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
        help.add();
        revalidate();
        repaint();
    }

    /**
     * Get the play screen.
     * @return The play screen.
     */
    public ViewPlay getPlayScreen() {
        return play;
    }

    /**
     * Set the screen to the setup screen.
     */
    public void setSetupScreen() {
        getContentPane().removeAll();
        setup.add();
        revalidate();
        repaint();
    }

    /**
     * Get the setup screen.
     * @return The setup screen.
     */
    public ViewSetup getSetupScreen() {
        return setup;
    }

    /**
     * Set the screen to the play screen.
     */
    public void setPlayScreen() {
        getContentPane().removeAll();
        play.add();
        revalidate();
        repaint();
    }

    /**
     * 
     * @return
     */
    public boolean getConfirmation() {
        return JOptionPane.showConfirmDialog(this, "Are you sure?",
            null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

}
