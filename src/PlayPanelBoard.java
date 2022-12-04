import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;

/**
 * Represents the board component of the view.
 * @author Jaan/Tarik
 * @version 1.1
 */
public class PlayPanelBoard extends JPanel {

    /**
     * The board cells.
     */
    private PlayPanelBoardCell[][] cells;

    /**
     * The board listener.
     */
    private PlayPanelBoardListener listener;

    /**
     * Create new panel board.
     */
    public PlayPanelBoard() {
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

        cells = new PlayPanelBoardCell[Config.BOARD_WIDTH][Config.BOARD_HEIGHT];
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i] = new PlayPanelBoardCell(this, j, i);
                add(cells[j][i]);
                cells[j][i].setOpaque(true);
                setPinkPremiumCells(j, i);
                setRedPremiumCells(j, i);
                setCyanPremiumCells(j, i);
                setBluePremiumCells(j, i);
                setMiddleCell(j, i);
            }
        }
    }

    /**
     * Sets red cells
     */
    public void setRedPremiumCells(int x, int y){
        //Set Premium 3x Word Score cell to Red
        int i;
        int j = 0;
        while (j < 15) {
            i = 0;
            while (i < 15) {
                if (x == i && y == j) {
                    cells[x][y].setBackground(Color.RED);
                }
                i += 7;
            }
            j+=7;
        }
    }

    /**
     * Sets pink cells
     */
    public void setPinkPremiumCells(int x, int y) {
        //Set Premium 2x Word Score cell to Magenta
        int i = 0;
        int j = 15;
        while (i < 15) {
            j--;
            if (x == i && y == i) {
                cells[x][y].setBackground(Color.MAGENTA);
            }
            if (x == i && y == j) {
                cells[x][y].setBackground(Color.MAGENTA);
            }
            i++;
        }
    }

    /**
     * Sets cyan cells
     */
    public void setCyanPremiumCells(int x, int y) {
        //Set Premium 2x Letter Score cell to Cyan
        if (y == 0 || y == 7 || y == 14) {
            if (x == 3 || x == 11) {
                cells[x][y].setBackground(Color.CYAN);
            }
        } else if (y == 2 || y == 12) {
            if (x == 6 || x == 8) {
                cells[x][y].setBackground(Color.CYAN);
            }
        } else if (y == 3 || y == 11) {
            if (x == 0 || x == 7 || x == 14) {
                cells[x][y].setBackground(Color.CYAN);
            }
        } else if (y == 6 || y == 8) {
            if (x == 2 || x == 6 || x == 8 || x == 12) {
                cells[x][y].setBackground(Color.CYAN);
            }
        }
    }

    /**
     * Sets blue cells
     */
    public void setBluePremiumCells(int x, int y) {
        //Set Premium 2x Letter Score cell to Blue
        if (y == 1 || y == 13) {
            if (x == 5 || x == 9) {
                cells[x][y].setBackground(Color.BLUE);
            }
        } else if (y == 5 || y == 9) {
            if (x == 1 || x == 5 || x == 9 || x ==13) {
                cells[x][y].setBackground(Color.BLUE);
            }
        }
    }

    /**
     * Sets middle cell
     */
    public void setMiddleCell(int x, int y){
        //Setting middle cell to light gray
        if(x == Config.BOARD_WIDTH/2 && y == Config.BOARD_HEIGHT/2){
            cells[x][y].setBackground(Color.LIGHT_GRAY);
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
    public void setOnClick(PlayPanelBoardListener listener) {
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
