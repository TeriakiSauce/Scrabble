import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;

public class EditorPanelHandCell extends JButton {
    public EditorPanelHandCell(BoardCell.Type type) {
        switch (type) {
            case NORMAL: setBackground(Color.WHITE);
            case BLUE: setBackground(Color.BLUE);
            case RED: setBackground(Color.RED);
            case CYAN: setBackground(Color.CYAN);
            case PINK: setBackground(Color.MAGENTA);
            case MIDDLE: setBackground(Color.LIGHT_GRAY);
        }
    }

    public void addListener(ActionListener listener) {
        addActionListener(listener);
    }
}
