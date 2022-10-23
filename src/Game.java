package src;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

import java.util.*;

public class Game {
    //variable that determines if the game is played
    private boolean quit;
    //deals with all the user input
    private Parser parser;
    //list of all the commands
    private List<Command> commands;

    /**
     * Initializes the game and plays it
     */
    public Game() {

        quit = false;

        parser = new Parser();

        commands = new ArrayList<>();

        play();
    }
    /**
     * Message that plays at the start of every game
     */
    public void startMessage(){
        System.out.println("The Game of Scrabble");
        System.out.println("Type a command");
        System.out.println("Available Commands: " + parser.CommandsString());
    }

    /**
     * Game loop that continues until quit is true
     */
    public void play(){
        while(!quit) {
            startMessage();
            parser.readInputCommand();
            if (parser.CommandIsValid()) {
                chooseCommand();
            }
            else{
                System.out.println("Enter a valid command");
            }
        }
        System.out.println("Thanks for playing Scrabble!");
    }

    /**
     * Determines which command to execute depending on user input
     */
    public void chooseCommand() {
        switch (parser.getInput().toUpperCase()) {
            case "PLACE":
                this.place();
                break;
            case "PASS":
                pass();
                break;
            case "CLEAR":
                clear();
                break;
            default:
                quit();
        }
    }

    /**
     * Places a letter on the board until valid word is made
     */
    public void place(){
        System.out.println("The Place command was chosen!");
        return;
    }

    /**
     * Passes the turn of the player
     */
    public void pass(){
        System.out.println("The Pass command was chosen!");
        return;
    }

    /**
     * Initializes the game and plays it until quit is true
     */
    public void clear(){
        System.out.println("The Clear command was chosen!");
        return;
    }

    public void quit(){
        System.out.println("The Quit command was chosen!");
        quit = true;
        return;
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}

