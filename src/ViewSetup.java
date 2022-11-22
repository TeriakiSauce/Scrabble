import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 * 
 */
public class ViewSetup extends JPanel {

    /**
     * 
     */
    private JButton add;

    /**
     * 
     */
    private JButton remove;

    /**
     * 
     */
    private JButton start;

    /**
     * 
     */
    private JButton back;

    /**
     * 
     */
    private ArrayList<Player> bots;

    /**
     * 
     */
    private String playerName;

    /**
     * 
     */
    private JPanel actions;

    /**
     * 
     */
    private View view;

    /**
     * 
     */
    private JList<String> list;

    /**
     * 
     */
    private DefaultListModel<String> listModel;

    /**
     * 
     * @param view
     */
    public ViewSetup(View view) {
        this.view = view;
        actions = new JPanel();
        start = new JButton(Config.SETUP_START_TEXT);
        add = new JButton(Config.SETUP_ADD_TEXT);
        remove = new JButton(Config.SETUP_REMOVE_TEXT);
        back = new JButton(Config.SETUP_BACK_TEXT);
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));
        actions.add(start);
        actions.add(add);
        actions.add(remove);
        actions.add(back);
    }

    /**
     * 
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(actions, BorderLayout.EAST);
        view.add(list, BorderLayout.CENTER);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnStart(ActionListener listener) {
        start.addActionListener(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnAdd(ActionListener listener) {
        add.addActionListener(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnRemove(ActionListener listener) {
        remove.addActionListener(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnBack(ActionListener listener) {
        back.addActionListener(listener);
    }

    /**
     * 
     * @param name
     */
    public void addBot(String name) {
        listModel.addElement(name);
    }

    /**
     * 
     */
    public void showNameField() {
        playerName = JOptionPane.showInputDialog(this, "Enter your player name");
    }

    /**
     * 
     * @return
     */
    public ArrayList<Player> getBots() {
        return bots;
    }

    /**
     * 
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }
}
