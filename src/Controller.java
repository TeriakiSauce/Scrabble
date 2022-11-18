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
        ViewStart start = view.getStartScreen();
        ViewPlay play = view.getPlayScreen();

        start.setActionOnStart(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlayScreen();
            }
        });

        start.setActionOnHelp(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setHelpScreen();
            }
        });

        play.setBoardOnClick(new PlayPanelBoardListener() {
            @Override
            public void actionPerformed(Integer x, Integer y) {
                model.setX(x);
                model.setY(y);
                model.placeBoard();
            }
        });

        play.setHandOnClick(new PlayPanelHandListener() {
            @Override
            public void actionPerformed(Integer n) {
                model.setN(n);
                model.placeHand();
            }
        });

        play.setActionOnPass(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.pass();
            }
        });

        play.setActionOnQuit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setStartScreen();
            }
        });

        play.setActionOnFinish(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.finish();
            }
        });

        play.setActionOnReset(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset();
            }
        });
    }
}
