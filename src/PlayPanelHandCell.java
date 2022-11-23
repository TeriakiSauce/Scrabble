import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents a cell within the panel hand.
 * @author Jaan
 * @version 1.0
 */
public abstract class PlayPanelHandCell extends JButton {

    /**
     * Create new panel hand cell.
     * @param hand The hand.
     * @param n The index.
     */
    public PlayPanelHandCell(PlayPanelHand hand, Integer n) {
        super(" ");
        setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));
        /*
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hand.onClick(n);
            }
        });
         */
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
