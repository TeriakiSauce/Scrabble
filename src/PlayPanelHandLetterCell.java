import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanelHandLetterCell extends PlayPanelHandCell{
    /**
     * Create new panel hand letter cell.
     *
     * @author Tarik
     *
     * @param hand The hand.
     * @param n    The index.
     */
    public PlayPanelHandLetterCell(PlayPanelHand hand, Integer n) {
        super(hand, n);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hand.onClick(n);
            }
        });
    }
}
