import javax.swing.SwingConstants;
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
        reset();
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
            setupLabel(players[n]);
            add(players[n]);
        }

        players[n].setName(player.getName());
        players[n].setScore(player.getScore());
    }

    /**
     * 
     * @param label
     */
    private void setupLabel(JLabel label) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
    }

    /**
     * 
     */
    public void reset() {
        removeAll();
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }

        // TODO: Bad solution
        JLabel space = new JLabel("\n");
        setupLabel(space);
        add(space);

        JLabel score = new JLabel(Config.PLAY_SCOREBOARD_TEXT);
        setupLabel(score);
        add(score);
    }
}
