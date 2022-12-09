import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * 
 */
public class ViewHelp extends JPanel {
    /**
     * 
     */
    private JButton back;

    /**
     * 
     */
    private JTextArea text;

    /**
     * 
     */
    private JScrollPane pane;

    /**
     * 
     */
    private View view;

    /**
     * 
     */
    public ViewHelp(View view) {
        this.view = view;
        back = new JButton();
        text = new JTextArea();
        pane = new JScrollPane(text);
        back.setText(Config.HELP_BACK_BUTTON_TEXT);
        text.setEditable(false);

        try {
            Reader reader = new Reader(Config.HELP_TEXT_PATH);
            text.setText(reader.readLines());
        } catch (IOException e) {
            text.setText("Error Loading Help Text");
        }
    }

    /**
     * 
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(back, BorderLayout.NORTH);
        view.add(pane, BorderLayout.CENTER);
    }

    /**
     * 
     * @param listener
     */
    public void setOnBack(ActionListener listener) {
        back.addActionListener(listener);
    }
}
