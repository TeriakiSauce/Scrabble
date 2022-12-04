import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

/**
 * Represents the hand section of the view.
 * @author Jaan
 * @version 1.0
 */
public class PlayPanelHand extends JPanel {

    private View view;

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
    public PlayPanelHand(View view) {
        this.view = view;
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
            if (i  == Config.HAND_SIZE-1){
                cells[i] = new PlayPanelHandBlankCell(this, i, view);
            }
            else {
                cells[i] = new PlayPanelHandLetterCell(this, i);
            }
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