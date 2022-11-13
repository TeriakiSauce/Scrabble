import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the controller component of the model view controller. Sets callbacks in
 * the view for when actions occur, and notifies the model.
 * @author Jaan
 * @version 1.0
 */
public class Controller {

    /**
     * Create new controller.
     * @param model The model.
     * @param view The view.
     */
    public Controller(Model model, View view) {
        view.setBoardOnClick(new PanelBoardListener() {
            @Override
            public void actionPerformed(Integer x, Integer y) {
                model.setX(x);
                model.setY(y);
                model.placeBoard();
            }
        });

        view.setHandOnClick(new PanelHandListener() {
            @Override
            public void actionPerformed(Integer n) {
                model.setN(n);
                model.placeHand();
            }
        });

        view.setActionOnPass(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.pass();
            }
        });

        view.setActionOnQuit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.quit();
            }
        });

        view.setActionOnFinish(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.finish();
            }
        });

        view.setActionOnReset(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset();
            }
        });
    }
}
