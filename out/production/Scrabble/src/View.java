import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

/**
 * Represents the view component of the model view controller.
 */
public class View extends JFrame {

    private static final LookAndFeel lightMode = new FlatLightLaf();
    private static final LookAndFeel darkMode = new FlatDarkLaf();

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
     * The setup screen.
     */
    private ViewSetup setup;

    /**
     * The editor screen;
     */
    private ViewEditor editor;

    /**
     * Create new view.
     */
    public View() {
        setLookAndFeel(lightMode);
        UIManager.put("Label.background", Config.BG_COLOR);
        UIManager.put("Label.foreground", Config.FG_COLOR);
        UIManager.put("Button.background", Config.BG_COLOR);
        UIManager.put("Button.foreground", Config.FG_COLOR);
        UIManager.put("TextField.background", Config.BG_COLOR);
        UIManager.put("TextField.foreground", Config.FG_COLOR);
        UIManager.put("TextArea.background", Config.BG_COLOR);
        UIManager.put("TextArea.foreground", Config.FG_COLOR);
        UIManager.put("OptionPane.background", Config.BG_COLOR);
        UIManager.put("OptionPane.foreground", Config.FG_COLOR);
        UIManager.put("Panel.background", Config.BG_COLOR);
        UIManager.put("Panel.foreground", Config.FG_COLOR);

        start = new ViewStart(this);
        help = new ViewHelp(this);
        play = new ViewPlay(this);
        setup = new ViewSetup(this);
        editor = new ViewEditor(this);

        setTitle(Config.FRAME_TITLE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Reset the view.
     */
    public void reset() {
        setup.clear();
        play.reset();
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
     * Get the editor screen.
     * @return The editor screen.
     */
    public ViewEditor getEditorScreen() {
        return editor;
    }

    /**
     * Set the screen to the editor screen.
     */
    public void setEditorScreen() {
        getContentPane().removeAll();
        editor.add();
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

    /**
     * Indicates that the bot is done calculating and has made its play
     */
    public void showBotDone(){
        JOptionPane.showMessageDialog(this, "Bot Calculations Completed", "BOT", JOptionPane.INFORMATION_MESSAGE);
    }

    private void setLookAndFeel(LookAndFeel feel) {
        try {
            UIManager.setLookAndFeel(feel);
            if (this != null) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize " + feel.getName() + ", it might not be supported");
        }
    }

}
