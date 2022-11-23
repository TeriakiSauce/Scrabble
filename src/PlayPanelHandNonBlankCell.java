import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanelHandNonBlankCell extends PlayPanelHandCell{
    /**
     * Create new panel hand cell.
     *
     * @param hand The hand.
     * @param n    The index.
     */
    public PlayPanelHandNonBlankCell(PlayPanelHand hand, Integer n) {
        super(hand, n);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hand.onClick(n);
            }
        });
    }
}
