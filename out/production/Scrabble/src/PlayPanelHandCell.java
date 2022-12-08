import javax.swing.*;
import java.awt.*;
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
        super((ImageIcon)null);
        setMaximumSize(new Dimension(100,100));
        //setBorder(BorderFactory.createLineBorder(Config.BORDER_COLOR));
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
        setText(null);
        if (letter == null) {
            setIcon(null);
        } else {
            int size = Math.max(getWidth(), getHeight());
            setIcon(new ImageIcon(LetterImages.resize(LetterImages.getImage(letter), 80, 80)));
        }
    }
}
