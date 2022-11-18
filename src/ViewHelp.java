import java.awt.BorderLayout;

/**
 * 
 */
public class ViewHelp {

    /**
     * 
     */
    private HelpPanelAction action;

    /**
     * 
     */
    private View view;

    /**
     * 
     * @param view
     */
    public ViewHelp(View view) {
        this.view = view;
        action = new HelpPanelAction();
    }

    /**
     * 
     */
    public void add() {
        view.setLayout(new BorderLayout());
        view.add(action);
    }
}