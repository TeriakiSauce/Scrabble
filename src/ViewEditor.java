import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.parsers.*;
import javax.xml.stream.*;
import java.awt.Color;
import java.io.OutputStreamWriter;

public class ViewEditor {
    private View view;

    private EditorPanelAction action;
    private EditorPanelBoard board;
    private EditorPanelHand hand;

    public ViewEditor(View view) {
        this.view = view;
        action = new EditorPanelAction();
        board = new EditorPanelBoard();
        hand = new EditorPanelHand();

        board.setOnClick(new PlayPanelBoardListener() {
            @Override
            public void actionPerformed(Integer x, Integer y) {
                if (hand.getCurrentType() != null) {
                    board.setCellType(x, y, hand.getCurrentType());
                }
            }
        });
    }

    public void add() {
        hand.clear();
        view.setLayout(new BorderLayout());
        view.add(board, BorderLayout.CENTER);
        view.add(hand, BorderLayout.SOUTH);
        view.add(action, BorderLayout.EAST);
    }

    public void setActionOnBack(ActionListener listener) {
        action.setOnBack(listener);
    }

    public void setActionOnSave(ActionListener listener) {
        action.setOnSave(listener);
    }

    public String getPath() {
        return JOptionPane.showInputDialog(board, "Specify a save name");
    }

    public void showErrorNoInput() {
        JOptionPane.showMessageDialog(board, "You must specify a save name!");
    }

    public boolean getOverwriteConfirmation() {
        return JOptionPane.showConfirmDialog(board,
                "Would you like to overwrite the save?",
                "The save name already exists.",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void export(String path) {
        try {
            OutputStream os = new FileOutputStream(new File(path));
            XMLStreamWriter sw = XMLOutputFactory.newInstance().createXMLStreamWriter(new OutputStreamWriter(os));

            sw.writeStartDocument();
            sw.writeStartElement("Board");
            sw.writeStartElement("BoardCell");

            for (Integer x = 0; x < Config.BOARD_WIDTH; x++) {
                for (Integer y = 0; y < Config.BOARD_HEIGHT; y++) {
                    PlayPanelBoardCell cell = board.getCell(x, y);
                    BoardCell.Type type = null;
                    if (cell.getBackground() == Color.WHITE) {
                        type = BoardCell.Type.NORMAL;
                    } else if (cell.getBackground() == Color.BLUE) {
                        type = BoardCell.Type.BLUE;
                    } else if (cell.getBackground() == Color.CYAN) {
                        type = BoardCell.Type.CYAN;
                    } else if (cell.getBackground() == Color.MAGENTA) {
                        type = BoardCell.Type.PINK;
                    } else if (cell.getBackground() == Color.RED) {
                        type = BoardCell.Type.RED;
                    } else if (cell.getBackground() == Color.LIGHT_GRAY) {
                        type = BoardCell.Type.MIDDLE;
                    } else {
                        assert(false);
                    }

                    sw.writeStartElement("x");
                    sw.writeCharacters(x.toString());
                    sw.writeEndElement();
                    sw.writeStartElement("y");
                    sw.writeCharacters(y.toString());
                    sw.writeEndElement();
                    sw.writeStartElement("type");
                    sw.writeCharacters(type.toString());
                    sw.writeEndElement();

                }
            }

            sw.writeEndElement();
            sw.writeEndElement();
            sw.writeEndDocument();
            sw.close();

        } catch (Exception e) {
            System.out.println("Failed to export to XML: " + e);
        }
    }
}
