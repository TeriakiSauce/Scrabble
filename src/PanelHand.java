import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

/**
 * 
 */
public class PanelHand extends JPanel {

    /**
     * 
     */
    private PanelHandCell[] cells;

    /**
     * 
     */
    private PanelHandListener listener;

    /**
     * 
     */
    public PanelHand() {
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

        cells = new PanelHandCell[Config.HAND_SIZE];
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            cells[i] = new PanelHandCell(this, i);
            add(cells[i]);
        }
    }

    /**
     * 
     * @param n
     * @param letter
     */
    public void setLetter(Integer n, Character letter) {
        cells[n].setLetter(letter);
    }

    /**
     * 
     * @param listener
     */
    public void setOnClick(PanelHandListener listener) {
        this.listener = listener;
    }

    /**
     * 
     * @param n
     */
    public void onClick(Integer n) {
        listener.actionPerformed(n);
    }
};