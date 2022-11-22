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

    private Integer x;

    private Integer y;

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
        setMiddleCell();
        setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.onClick(x, y);
            }
        });
    }

    public void setRedPremiumCell() {
        //Set Premium 3x Word Score cell to red
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

    public void setPinkPremiumCell() {
        //Set Premium 2x Word Score cell to magenta
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
        /*
        int i = 0;
        int j = 0;
        while (j < 15) {
            while (i < 15) {
                if (x == i && y == j) {
                    setBackground(Color.MAGENTA);
                }
                i++;
            }
            j++;
        }

         */

    }

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
