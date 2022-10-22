package src;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

import java.util.*;

public class Game {

    private boolean quit;
    private Parser parser;

    public Game() {

        quit = false;
        parser = new Parser();

        Play();
    }

    public void startMessage(){
        System.out.println("Welcome to Scrabble!");
        System.out.println("Type a command");
        System.out.println("Available Commands: " + parser.ValidCommandsString());
    }

    public void Play(){
        while(!quit) {
            startMessage();
            parser.getInputCommand();
            if (parser.CommandIsValid())
            {
                System.out.println("The command is valid!");
            }
        }
    }

    private void Place(){
        return;
    }

    private void Pass(){
        return;
    }

    private void Clear(){
        return;
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}
