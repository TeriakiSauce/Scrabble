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
        System.out.println("Available Commands: " + parser.CommandsString());
    }

    public void Play(){
        while(!quit) {
            startMessage();
            parser.readInputCommand();
            if (parser.CommandIsValid()) {
                ChooseCommand();
            }
            else{
                System.out.println("Enter a valid command");
            }
        }
    }

    public void ChooseCommand() {
        switch (parser.getInput().toUpperCase()) {
            case "PLACE":
                this.Place();
                break;
            case "PASS":
                Pass();
                break;
            case "CLEAR":
                Clear();
                break;
            default:
                Quit();
        }
    }
    public void Place(){
        System.out.println("The Place command was chosen!");
        return;
    }

    public void Pass(){
        System.out.println("The Pass command was chosen!");
        return;
    }

    public void Clear(){
        System.out.println("The Clear command was chosen!");
        return;
    }

    public void Quit(){
        System.out.println("The Quit command was chosen!");
        return;
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}

