import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;

public class PlayPanelHandBlankCell extends PlayPanelHandCell{
    /**
     * Create new panel hand cell.
     *
     * @author Tarik
     *
     * @param hand The hand.
     * @param n    The index.
     */

    private JButton button;

    private View view;

    private int counter;

    public PlayPanelHandBlankCell(PlayPanelHand hand, Integer n, View view) {
        super(hand, n);
        counter = 0;
        this.view = view;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter > 0){
                    hand.onClick(n);
                }
                else {
                    String letter = JOptionPane.showInputDialog(view,"Enter a letter: ").toUpperCase();
                    hand.setLetter(n, letter.charAt(0));
                    //model.setBlankTile(letter.charAt(0));
                    counter++;

                }
            }
        });
    }


}
