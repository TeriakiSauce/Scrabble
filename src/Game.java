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
    //counter to keep track of turns;
    private int turns;

    /**
     * Initializes the game and plays it
     */
    public Game() {

        quit = false;

        parser = new Parser();

        commands = new ArrayList<>();

        turns = 1;

        play();
    }
    /**
     * Message that plays at the start of every game
     */
    public void startMessage(){
        System.out.println("The Game of Scrabble");
        System.out.println("You are on turn " + getTurns());
        System.out.println("Type a command");
        System.out.println("Available Commands: " + parser.commandsString());

    }

    /**
     * Game loop that continues until quit is true
     */
    public void play(){
        while(!quit) {
            startMessage();
            parser.readInputCommand();
            if (parser.commandIsValid()) {
                chooseCommand();
                turns++;


            }
            else{
                System.out.println("Enter a valid command");
            }
        }
    }

    public int getTurns(){
        return turns;
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
        System.out.println("Where do you want to place the letter?");
        return;
    }

    /**
     * Passes the turn of the player
     */
    public void pass(){
        System.out.println("Your turn was passed");
        return;
    }

    /**
     * Clears the board
     */
    public void clear(){
        System.out.println("The board was cleared");
        return;
    }

    /**
     * Quits the game
     */
    public void quit(){
        quit = true;
        System.out.println("Thanks for playing Scrabble!");
        return;
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}

