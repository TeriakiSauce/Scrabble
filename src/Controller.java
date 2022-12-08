import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        start.setActionOnNew(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setSetupScreen();
            }
        });

        start.setActionOnLoad(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    String path = start.getLoadPath();
                    if (path == null) {
                        return;
                    }

                    if (path.isEmpty()) {
                        start.showErrorNoInput();
                        continue;
                    }

                    Path filePath = Paths.get(path);
                    if (!Files.exists(filePath)) {
                        start.showErrorNoFile();
                    } else {
                        model.load(path);
                        view.setPlayScreen();
                        return;
                    }
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
                    setup.addBot(names.getName());
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
                String playerName = setup.getPlayerName();
                String gameName = setup.getGameName();

                if (playerName == null || playerName.isEmpty()) {
                    setup.showNoPlayerNameError();
                    return;
                }

                if (gameName == null || gameName.isEmpty()) {
                    setup.showNoGameNameError();
                    return;
                }

                Path path = Paths.get(gameName);
                if (Files.exists(path)) {
                    if (!setup.showGameAlreadyExists()) {
                        return;
                    }
                }

                view.setPlayScreen();
                String bots[] = setup.getBotNames();
                model.create(gameName);
                model.addUser(playerName);
                for (int i = 0; i < bots.length; i++) {
                    model.addBot(bots[i]);
                }
                model.fillAllHands();
                model.paint();
                model.save();
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
                if (n==Config.HAND_SIZE-1 && model.getCounter() == 0){
                    model.setBlankTile(JOptionPane.showInputDialog(view, "Enter a letter: ").toUpperCase().charAt(0));
                    model.incrementCounter();
                }
                else{
                    model.setN(n);
                    model.placeHand();
                }
            }
        });

        play.setActionOnPass(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getConfirmation()) {
                    model.pass();
                }
            }
        });

        play.setActionOnQuit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getConfirmation()) {
                    view.setStartScreen();
                    model.fullReset();
                }
            }
        });

        play.setActionOnFinish(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.finish()) {
                    play.showBadMove();
                }
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

        play.setActionOnUndo(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.undo()) {
                    // TODO: there is nothing to undo message
                }
            }
        });

        play.setActionOnRedo(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.redo()) {
                    // TODO: there is nothing to redo message
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
