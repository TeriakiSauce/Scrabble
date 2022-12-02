import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 */
public class ViewStart {

    /**
     * 
     */
    private StartPanelAction action;

    /**
     * 
     */
    private JLabel title;

    /**
     * 
     */
    private View view;

    /**
     * 
     * @param view
     */
    public ViewStart(View view) {
        this.view = view;
        action = new StartPanelAction();

        title = new JLabel("Scrabble");
        title.setFont(new Font("Verdana", Font.PLAIN, 124));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
    }

    /**
     * 
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(action, BorderLayout.CENTER);
        view.add(title, BorderLayout.NORTH);
    }

    /**
     *
     * @param listener
     */
    public void setActionOnNew(ActionListener listener) {
        action.setOnNew(listener);
    }

    /**
     *
     * @param listener
     */
    public void setActionOnLoad(ActionListener listener) {
        action.setOnLoad(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnHelp(ActionListener listener) {
        action.setOnHelp(listener);
    }

    /**
     *
     * @return
     */
    public String getLoadPath() {
        return JOptionPane.showInputDialog(action, "Specify a game to load");
    }

    /**
     *
     */
    public void showErrorNoInput() {
        JOptionPane.showMessageDialog(action, "You must specify a game!");
    }

    /**
     *
     */
    public void showErrorNoFile() {
        JOptionPane.showMessageDialog(action, "You must specify an existing game!");
    }
}
