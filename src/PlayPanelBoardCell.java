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
     * Create new panel board cell.
     * @param board The board.
     * @param x The x position.
     * @param y The y position.
     */
    public PlayPanelBoardCell(PlayPanelBoard board, Integer x, Integer y) {
        super(" ");
        //Set Premium 3x Word Score cells to red
        int i = 0;
        while (i < 15){
            int j = 0;
            while (j < 15) {
                if (x == j && y == i) {
                    setBackground(Color.RED);
                }
                setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));

                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        board.onClick(x, y);
                    }
                });
                j+=7;
            }
            i+=7;
        }
        //Setting middle cell to light gray
        if(x == Config.BOARD_WIDTH/2 && y == Config.BOARD_HEIGHT/2){
            setBackground(Color.LIGHT_GRAY);
        }
        setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.onClick(x, y);
            }
        });
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
