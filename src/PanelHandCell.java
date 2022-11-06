import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class PanelHandCell extends JButton {

    /**
     * 
     * @param hand
     * @param n
     */
    public PanelHandCell(PanelHand hand, Integer n) {
        super(" ");
        setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hand.onClick(n);
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
