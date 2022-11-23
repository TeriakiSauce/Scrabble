import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;

public class PlayPanelHandBlankCell extends PlayPanelHandCell{
    /**
     * Create new panel hand cell.
     *
     * @param hand The hand.
     * @param n    The index.
     */

    public static boolean flag = false;

    public PlayPanelHandBlankCell(PlayPanelHand hand, Integer n) {
        super(hand, n);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (flag){
                        hand.onClick(n);
                    }
                    else {
                        Scanner s = new Scanner(System.in);
                        System.out.println("Enter a letter: ");
                        char tempChar = s.next().charAt(0);
                        String tempString = ("" + tempChar).toUpperCase();
                        hand.setLetter(n, tempString.charAt(0));
                        s.close();
                        flag = true;
                    }
                }
        });
    }


}
