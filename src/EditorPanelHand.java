import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class EditorPanelHand extends JPanel {

    /**
     *
     */
    private EditorPanelHandCell normal;

    /**
     *
     */
    private EditorPanelHandCell blue;

    /**
     *
     */
    private EditorPanelHandCell cyan;

    /**
     *
     */
    private EditorPanelHandCell pink;

    /**
     *
     */
    private EditorPanelHandCell red;

    /**
     *
     */
    private BoardCell.Type currentCell;

    /**
     *
     */
    public EditorPanelHand() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        normal = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        blue = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        cyan = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        pink = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        red = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        currentCell = null;

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCell = BoardCell.Type.NORMAL;
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCell = BoardCell.Type.BLUE;
            }
        });

        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCell = BoardCell.Type.CYAN;
            }
        });

        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCell = BoardCell.Type.PINK;
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCell = BoardCell.Type.RED;
            }
        });

        add(normal);
        add(blue);
        add(cyan);
        add(pink);
        add(red);
    }

    /**
     *
     */
    public void clear() {
        currentCell = null;
    }

    /**
     *
     * @return
     */
    public BoardCell.Type getCurrentCell() {
        return currentCell;
    }
}
