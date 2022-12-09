import javax.swing.*;
import java.awt.event.ActionListener;

public class EditorPanelAction extends JPanel {

    private JButton save;
    private JButton back;

    public EditorPanelAction() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        back = new JButton("Back");
        save = new JButton("Save");
        add(back);
        add(save);
    }

    public void setOnBack(ActionListener listener) {
        back.addActionListener(listener);
    }

    public void setOnSave(ActionListener listener) {
        save.addActionListener(listener);
    }
}
