import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
                if (!setup.showNameField()) {
                    view.setStartScreen();
                }
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
                if (setup.getNumBots() + 1 < Config.MAX_PLAYERS) {
                    NameGen names = model.getNames();
                    String name = names.getName() + " (bot)";
                    setup.addBot(name);
                } else {
                    setup.showTooManyPlayersError();
                }
            }
        });

        setup.setActionOnRemove(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String botName = setup.getSelectedBot();
                if (botName != null) {
                    setup.clearSelectedBot();
                    setup.removeSelectedBot(botName);
                }
            }
        });

        setup.setActionOnStart(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                view.setPlayScreen();
                String bots[] = setup.getBotNames();
                String playerName = setup.getPlayerName();
                model.addUser(playerName);
                for (int i = 0; i < bots.length; i++) {
                    model.addBot(bots[i]);
                }
                model.fillAllHands();
                model.paint();
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

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (view.getConfirmation()) {
                    view.quit();
                }
            }
        });
    }
}
