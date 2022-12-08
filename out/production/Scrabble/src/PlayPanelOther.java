import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

/**
 * 
 */
public class PlayPanelOther extends JPanel {

    /**
     * 
     */
    private JLabel turn;

    /**
     * 
     */
    private JLabel player;

    /**
     * 
     */
    public PlayPanelOther() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        turn = new JLabel("Turn Not Yet Set");
        player = new JLabel("Player Not Yet Set");
        add(turn);
        add(player);
    }

    /**
     * 
     * @param turn
     */
    public void setTurn(String turn) {
        this.turn.setText(Config.PLAY_TURN_TEXT + turn);
    }

    /**
     * 
     * @param player
     */
    public void setPlayer(Player player) {
        this.player.setText(Config.PLAY_PLAYER_TEXT + player.getName());
    }
}
