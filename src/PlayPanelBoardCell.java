import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents a cell within the board.
 * @author Jaan/Tarik
 * @version 1.0
 */
public class PlayPanelBoardCell extends JButton {

    /**
     * The x coordinate of the cell.
     */
    private Integer x;

    /**
     * The y coordinate of the cell.
     */
    private Integer y;

    /**
     * The Board to be passed.
     */
    private PlayPanelBoard board;

    /**
     * Create new panel board cell.
     * @param board The board.
     * @param x The x position.
     * @param y The y position.
     */
    public PlayPanelBoardCell(PlayPanelBoard board, Integer x, Integer y) {
        super(" ");
        this.x = x;
        this.y = y;
        this.board = board;
        setPinkPremiumCell();
        setRedPremiumCell();
        setCyanPremiumCell();
        setBluePremiumCell();
        setMiddleCell();
        setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.onClick(x, y);
            }
        });
    }

    /**
     * Sets red cells
     */
    public void setRedPremiumCell() {
        //Set Premium 3x Word Score cell to Red
        int i;
        int j = 0;
        while (j < 15) {
            i = 0;
            while (i < 15) {
                if (x == i && y == j) {
                    setBackground(Color.RED);
                }
                i += 7;
            }
            j+=7;
        }
    }

    /**
     * Sets pink cells
     */
    public void setPinkPremiumCell() {
        //Set Premium 2x Word Score cell to Magenta
        int i = 0;
        int j = 15;
        while (i < 15) {
            j--;
            if (x == i && y == i) {
                setBackground(Color.MAGENTA);
            }
            if (x == i && y == j) {
                setBackground(Color.MAGENTA);
            }
            i++;
        }
    }
    /**
     * Sets cyan cells
     */
    public void setCyanPremiumCell() {
        //Set Premium 2x Letter Score cell to Cyan
        if (y == 0 || y == 7 || y == 14) {
            if (x == 3 || x == 11) {
                setBackground(Color.CYAN);
            }
        } else if (y == 2 || y == 12) {
            if (x == 6 || x == 8) {
                setBackground(Color.CYAN);
            }
        } else if (y == 3 || y == 11) {
            if (x == 0 || x == 7 || x == 14) {
                setBackground(Color.CYAN);
            }
        } else if (y == 6 || y == 8) {
            if (x == 2 || x == 6 || x == 8 || x == 12) {
                setBackground(Color.CYAN);
            }
        }
    }

    /**
     * Sets blue cells
     */
    public void setBluePremiumCell() {
        //Set Premium 2x Letter Score cell to Blue
        if (y == 1 || y == 13) {
            if (x == 5 || x == 9) {
                setBackground(Color.BLUE);
            }
        } else if (y == 5 || y == 9) {
            if (x == 1 || x == 5 || x == 9 || x ==13) {
                setBackground(Color.BLUE);
            }
        }
    }

    /**
     * Sets middle cell
     */
    public void setMiddleCell(){
        //Setting middle cell to light gray
        if(x == Config.BOARD_WIDTH/2 && y == Config.BOARD_HEIGHT/2){
            setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * Set the letter for the cell.
     * @param letter The letter.
     */
    public void setLetter(Character letter) {
        if (letter == null) {
            setText(" ");
        } else {
            setText(letter.toString());
        }
    }
}
