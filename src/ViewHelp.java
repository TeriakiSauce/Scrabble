import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
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
    private View view;

    /**
     * 
     */
    public ViewHelp(View view) {
        this.view = view;
        back = new JButton();
        text = new JTextArea();
        back.setText(Config.HELP_BACK_BUTTON_TEXT);
        text.setEditable(false);
        text.add(new JScrollBar());

        try {
            Path path = Path.of(Config.HELP_TEXT_PATH);
            String string = Files.readString(path);
            text.setText(string);
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
        view.add(text, BorderLayout.CENTER);
    }

    /**
     * 
     * @param listener
     */
    public void setOnBack(ActionListener listener) {
        back.addActionListener(listener);
    }
}
