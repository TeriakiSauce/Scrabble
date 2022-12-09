import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class EditorPanelHandCell extends JButton {
    public EditorPanelHandCell(BoardCell.Type type) {
        switch (type) {
            case NORMAL: setBackground(Color.WHITE); break;
            case BLUE: setBackground(Color.BLUE); break;
            case RED: setBackground(Color.RED); break;
            case CYAN: setBackground(Color.CYAN); break;
            case PINK: setBackground(Color.MAGENTA); break;
            case MIDDLE: setBackground(Color.LIGHT_GRAY); break;
            default: assert(false);
        }
    }

    public void addListener(ActionListener listener) {
        addActionListener(listener);
    }
}
