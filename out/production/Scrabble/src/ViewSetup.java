import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
    private JPanel actions;

    /**
     *
     */
    private JPanel misc;

    /**
     *
     */
    private JTextField playerName;

    /**
     *
     */
    private JTextField gameTitle;

    /**
     *
     */
    private JLabel customBoardHeader;

    /**
     *
     */
    private JTextField customBoardField;

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
        playerName = new JTextField();
        gameTitle = new JTextField();
        customBoardField = new JTextField();

        misc = new JPanel();
        misc.setLayout(new BoxLayout(misc, BoxLayout.Y_AXIS));
        misc.add(new JLabel(Config.SETUP_PLAYER_HEADER_TEXT));
        misc.add(playerName);
        misc.add(new JLabel(Config.SETUP_GAME_HEADER_TEXT));
        misc.add(gameTitle);
        misc.add(new JLabel("Custom Board Name (Empty For Default)"));
        misc.add(customBoardField);
        misc.add(new JLabel(Config.SETUP_BOT_HEADER_TEXT));

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
        view.add(misc, BorderLayout.NORTH);
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
     * @param name
     */
    public void addBot(String name) {
        listModel.addElement(name);
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

    public PlayerBot.DIFFICULTY getBotDifficulty(){
        String dif = JOptionPane.showInputDialog("Choose The Bots Difficulty (1-3): ");
        switch (dif) {
            case "1" : {
                return PlayerBot.DIFFICULTY.EASY;
            }
            case "2" : {
                return PlayerBot.DIFFICULTY.MEDIUM;
            }
            default : {
                return PlayerBot.DIFFICULTY.HARD;
            }
        }
    }

    /**
     *
     * @return
     */
    public String getPlayerName() {
        return playerName.getText();
    }

    /**
     *
     * @return
     */
    public String getGameName() {
        return gameTitle.getText();
    }

    /**
     *
     * @return
     */
    public String getCustomBoardName() {
        return customBoardField.getText();
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

    /**
     * 
     */
    public void clear() {
        listModel.clear();
    }

    /**
     *
     */
    public void showNoPlayerNameError() {
        JOptionPane.showMessageDialog(this, "You must enter a player name!");
    }

    /**
     *
     */
    public void showNoGameNameError() {
        JOptionPane.showMessageDialog(this, "You must enter a game name!");
    }

    /**
     *
     * @return
     */
    public boolean showGameAlreadyExists() {
        return JOptionPane.showConfirmDialog(this,
                "Would you like to overwrite the game?",
                "The game name already exists.",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    /**
     *
     */
    public void showCustomBoardNotExists() {
        JOptionPane.showMessageDialog(this, "You must enter an existing custom board name!");
    }
}
