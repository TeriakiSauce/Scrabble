import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents a cell within the board.
 * @author Jaan
 * @version 1.0
 */
public class PanelBoardCell extends JButton {

    /**
     * Create new panel board cell.
     * @param board The board.
     * @param x The x position.
     * @param y The y position.
     */
    public PanelBoardCell(PanelBoard board, Integer x, Integer y) {
        super(" ");
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
