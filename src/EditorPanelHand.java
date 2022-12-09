import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;

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
    private BoardCell.Type currentType;

    /**
     *
     */
    public EditorPanelHand() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        normal = new EditorPanelHandCell(BoardCell.Type.NORMAL);
        blue = new EditorPanelHandCell(BoardCell.Type.BLUE);
        cyan = new EditorPanelHandCell(BoardCell.Type.CYAN);
        pink = new EditorPanelHandCell(BoardCell.Type.PINK);
        red = new EditorPanelHandCell(BoardCell.Type.RED);
        currentType = null;

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentType = BoardCell.Type.NORMAL;
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentType = BoardCell.Type.BLUE;
            }
        });

        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentType = BoardCell.Type.CYAN;
            }
        });

        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentType = BoardCell.Type.PINK;
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentType = BoardCell.Type.RED;
            }
        });

        int width = 10;

        add(Box.createHorizontalGlue());
        add(normal);
        add(Box.createRigidArea(new Dimension(width, 0)));
        add(blue);
        add(Box.createRigidArea(new Dimension(width, 0)));
        add(cyan);
        add(Box.createRigidArea(new Dimension(width, 0)));
        add(pink);
        add(Box.createRigidArea(new Dimension(width, 0)));
        add(red);
        add(Box.createHorizontalGlue());
    }

    /**
     *
     */
    public void clear() {
        currentType = null;
    }

    /**
     *
     * @return
     */
    public BoardCell.Type getCurrentType() {
        return currentType;
    }
}
