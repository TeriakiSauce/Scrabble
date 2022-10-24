package src;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

import java.util.*;

public class Game {
    //variable that determines if the game is played
    private boolean quit;
    //deals with the user choosing a command
    private Parser parser;
    //counter to keep track of turns;
    private int turns;
    //counter to keep track of points;
    private int points;
    //Word bank of all valid words
    private WordBank bank;

    /**
     * Initializes the game and plays it
     */
    public Game() {

        quit = false;

        parser = new Parser();

        turns = 1;

        points = 0;

        bank = new WordBank("https://www.mit.edu/~ecprice/wordlist.10000");

        play();
    }
    /**
     * Message that plays at the start of every game
     */
    public void startMessage(){
        System.out.println("The Game of Scrabble");
        System.out.println("You are on turn " + getTurns());
        System.out.println("You have " + getPoints() + " points");
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
    /**
     * Returns the amount of points
     */
    public int getPoints(){
        return points;
    }


    /**
     * Returns the turn number
     */
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
        String input = "absolute";
        Scanner s = new Scanner(System.in);
        System.out.println("What word do you want to write?");
        while(!bank.isWordValid(input)) {
            input = s.nextLine();
            if (bank.isWordValid(input)) {
                bank.getWordValue(input);
                points++;
                System.out.println(input + " is a valid word");
                return;
            }
        }
        System.out.println("Sorry " + input + " is not a valid word");
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

