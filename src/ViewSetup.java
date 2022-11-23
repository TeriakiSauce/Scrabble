import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * 
 */
public class ViewSetup extends JPanel {

    /**
     * 
     */
    private JLabel header;

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
     */
    private String selectedBot;

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
        header = new JLabel(Config.SETUP_BOT_HEADER_TEXT);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setVerticalAlignment(SwingConstants.CENTER);
        header.setBackground(Config.BG_COLOR);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedBot = list.getSelectedValue();
            }
        });

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
        view.add(header, BorderLayout.NORTH);
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
    public boolean showNameField() {
        while (true) {
            playerName = JOptionPane.showInputDialog(this, "Enter your player name");
            if (playerName == null) {
                return false;
            } else if (playerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid name!");
            } else {
                return true;
            }
        }
    }

    /**
     * 
     * @return
     */
    public String[] getBotNames() {
        Object objects[] = listModel.toArray();
        String names[] = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            names[i] = (String) objects[i];
        }

        return names;
    }

    /**
     * 
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * 
     * @return
     */
    public Integer getNumBots() {
        return listModel.size();
    }

    /**
     * 
     */
    public void showTooManyPlayersError() {
        JOptionPane.showMessageDialog(this, "Maximum of " + Config.MAX_PLAYERS
            + " players are supported!");
    }

    /**
     * 
     * @return
     */
    public String getSelectedBot() {
        return selectedBot;
    }

    /**
     * 
     */
    public void clearSelectedBot() {
        selectedBot = null;
    }

    /**
     * 
     * @param bot
     */
    public void removeSelectedBot(String bot) {
        int index = 0;
        Object objects[] = listModel.toArray();
        for (int i = 0; i < objects.length; i++) {
            if ((String) objects[i] == bot) {
                index = i;
                break;
            }
        }

        listModel.removeElementAt(index);
    }
}
