import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

/**
 * Represents the board component of the view.
 * @author Jaan 
 * @version 1.1
 */
public class PanelBoard extends JPanel {

    /**
     * The board cells.
     */
    private PanelBoardCell[][] cells;

    /**
     * The board listener.
     */
    private PanelBoardListener listener;

    /**
     * Create new panel board.
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
     * Set letter at specified position.
     * @param x The x position.
     * @param y The y position.
     * @param letter The letter.
     */
    public void setLetter(Integer x, Integer y, Character letter) {
        cells[x][y].setLetter(letter);
    }

    /**
     * Set on click action listener.
     * @param listener The action listener.
     */
    public void setOnClick(PanelBoardListener listener) {
        this.listener = listener;
    }

    /**
     * On click action callback.
     * @param x The x position.
     * @param y The y position.
     */
    public void onClick(Integer x, Integer y) {
        listener.actionPerformed(x, y);
    }
}
