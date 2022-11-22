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
        ViewHelp help = view.getHelpScreen();
        ViewPlay play = view.getPlayScreen();
        ViewSetup setup = view.getSetupScreen();

        start.setActionOnStart(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setSetupScreen();
                setup.showNameField();
            }
        });

        start.setActionOnHelp(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setHelpScreen();
            }
        });

        setup.setActionOnAdd(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameGen names = model.getNames();
                String name = names.getName() + " (bot)";
                setup.addBot(name);
            }
        });

        setup.setActionOnRemove(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setup.setActionOnStart(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                view.setPlayScreen();
            }
        });

        setup.setActionOnBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getConfirmation()) {
                    view.setStartScreen();
                }
            }
        });

        help.setOnBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setStartScreen();
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
                if (view.getConfirmation()) {
                    view.setStartScreen();
                }
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
                if (view.getConfirmation()) {
                    model.reset();
                }
            }
        });
    }
}
