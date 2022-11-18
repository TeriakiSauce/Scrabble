import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

/**
 * Represents the hand section of the view.
 * @author Jaan
 * @version 1.0
 */
public class PlayPanelHand extends JPanel {

    /**
     * The hand cells.
     */
    private PlayPanelHandCell[] cells;

    /**
     * The hand listener.
     */
    private PlayPanelHandListener listener;

    /**
     * Create new panel hand.
     */
    public PlayPanelHand() {
        setLayout(new GridLayout(
            1,
            Config.HAND_SIZE,
            -1,
            -1
        ));

        setBorder(BorderFactory.createEmptyBorder(
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH
        ));

        cells = new PlayPanelHandCell[Config.HAND_SIZE];
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            cells[i] = new PlayPanelHandCell(this, i);
            add(cells[i]);
        }
    }

    /**
     * Set letter at index.
     * @param n The index.
     * @param letter The letter.
     */
    public void setLetter(Integer n, Character letter) {
        cells[n].setLetter(letter);
    }

    /**
     * Set on click action listener.
     * @param listener The action listener.
     */
    public void setOnClick(PlayPanelHandListener listener) {
        this.listener = listener;
    }

    /**
     * On click callback.
     * @param n The index.
     */
    public void onClick(Integer n) {
        listener.actionPerformed(n);
    }
};