import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

/**
 * 
 */
public class PlayPanelScore extends JPanel {
    /**
     * 
     */
    private PlayPanelScorePlayer[] players;

    /**
     * 
     */
    public PlayPanelScore() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        players = new PlayPanelScorePlayer[Config.MAX_PLAYERS];
        add(new JLabel(Config.PLAY_SCOREBOARD_TEXT));
    }

    /**
     * 
     * @param n
     * @param player
     */
    public void setPlayer(int n, Player player) {
        assert(n < players.length);
        if (players[n] == null) {
            players[n] = new PlayPanelScorePlayer();
            add(players[n]);
        }

        players[n].setName(player.getName());
        players[n].setScore(player.getScore());
    }
}
