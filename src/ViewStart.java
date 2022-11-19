import java.awt.BorderLayout;
import java.awt.event.ActionListener;

/**
 * 
 */
public class ViewStart {

    /**
     * 
     */
    private StartPanelAction action;

    /**
     * 
     */
    private View view;

    /**
     * 
     * @param view
     */
    public ViewStart(View view) {
        this.view = view;
        action = new StartPanelAction();
    }

    /**
     * 
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(action);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnStart(ActionListener listener) {
        action.setOnStart(listener);
    }

    /**
     * 
     * @param listener
     */
    public void setActionOnHelp(ActionListener listener) {
        action.setOnHelp(listener);
    }
}
