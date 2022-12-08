import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents a cell within the board.
 * @author Jaan
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
        super((ImageIcon) null);
        this.x = x;
        this.y = y;
        this.board = board;
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
            setIcon(null);
            setText(null);
        } else {
            int size = Math.max(getWidth(), getHeight());
            setIcon(new ImageIcon(LetterImages.resize(LetterImages.getImage(letter), size, size)));
        }
    }
}
