import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class PanelBoardCell extends JButton {

    /**
     * 
     * @param board
     * @param x
     * @param y
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
     * 
     * @param letter
     */
    public void setLetter(Character letter) {
        if (letter == null) {
            setText(" ");
        } else {
            setText(letter.toString());
        }
    }
}
