import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanelHandBlankCell extends PlayPanelHandCell{
    /**
     * Create new panel hand cell.
     *
     * @param hand The hand.
     * @param n    The index.
     */
    public PlayPanelHandBlankCell(PlayPanelHand hand, Integer n) {
        super(hand, n);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter a letter: ");
            }
        });
    }
}
