import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

/**
 * 
 */
public class PanelBoard extends JPanel {

    /**
     * 
     */
    private PanelBoardCell[][] cells;

    /**
     * 
     */
    private PanelBoardListener listener;

    /**
     * 
     */
    public PanelBoard() {
        setLayout(new GridLayout(
            Config.BOARD_WIDTH,
            Config.BOARD_HEIGHT,
            -1,
            -1
        ));

        setBorder(BorderFactory.createEmptyBorder(
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH,
            Config.BOARD_BORDER_WIDTH
        ));

        cells = new PanelBoardCell[Config.BOARD_WIDTH][Config.BOARD_HEIGHT];
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i] = new PanelBoardCell(this, j, i);
                add(cells[j][i]);
            }
        }
    }

    /**
     * 
     * @param x
     * @param y
     * @param letter
     */
    public void setLetter(Integer x, Integer y, Character letter) {
        cells[x][y].setLetter(letter);
    }

    /**
     * 
     * @param listener
     */
    public void setOnClick(PanelBoardListener listener) {
        this.listener = listener;
    }

    /**
     * 
     * @param x
     * @param y
     */
    public void onClick(Integer x, Integer y) {
        listener.actionPerformed(x, y);
    }
}
