import java.util.*;

/**
 * This is the main Game class that the gameplay loop and commands are made in.
 * @author Tarik Beldjehem
 * @author Andrew Sahadeo
 * @version 1.0
 */

public class Game {
    //variable that determines if the game is played
    private boolean quit;
    //variable that determines if the place command is done
    private boolean done;
    //deals with the user inputting a command
    private Parser parser;
    //counter to keep track of turns
    private int turns;
    //counter to keep track of points
    private int points;
    //Word bank of all valid words
    private WordBank bank;
    //The game board
    private Board gameBoard;
    //Size of game board
    public static final int SIZE = 15;
    //checks if the letter chosen is valid
    private boolean isLetterValid;
    //Checks if turn is in vertical alignment
    private boolean isVertical;

    /**
     * Initializes the game and the fields
     * @author Tarik Beldjehem
     */
    public Game() {

        quit = false;

        done = false;

        parser = new Parser();

        turns = 1;

        points = 0;

        bank = new WordBank("https://www.mit.edu/~ecprice/wordlist.10000");

        gameBoard = new Board(SIZE);
    }

    /**
     * Message that plays at the start of every game
     * @author Tarik Beldjehem
     */
    public void message(){
        System.out.println("You are on turn " + getTurns() + ".");
        System.out.println("You have " + getPoints() + " points.");
        System.out.println("Type an available command: " + parser);
    }

    /**
     * Game loop that continues until quit is true
     * @author Tarik Beldjehem
     */
    public void play(){
        System.out.println("The Game of Scrabble");
        System.out.println(gameBoard);
        while(!quit) {
            message();
            parser.readInputCommand();
            if (parser.commandIsValid()) {
                chooseCommand();
                turns++;
            }
            else{
                System.out.println("Enter a valid command.");
            }
        }
    }

    /**
     * Returns the amount of points
     * @author Tarik Beldjehem
     */
    public int getPoints(){
        return points;
    }

    /**
     * Returns the turn number
     * @author Tarik Beldjehem
     */
    public int getTurns(){
        return turns;
    }

    /**
     * Determines which command to execute depending on user input
     * @author Tarik Beldjehem
     */
    public void chooseCommand() {
        switch (parser.getInput().toUpperCase()) {
            case "PLACE":
                this.place();
                break;
            case "PASS":
                pass();
                break;
            default:
                quit();
        }
    }

    /**
     * Places a letter on the board until valid word is made
     * Tarik Beldjehem
     * Andrew Sahadeo
     */
    public void place() {
        String word = "";
        String input = "a1";
        char letter;
        String yesNo = "";
        int placeCounter = 0;
        Scanner scan = new Scanner(System.in);
        int x = 'a';
        int y = 0;
        done = false;
        boolean stopPlacingLetter = false;
        boolean firstLetterPlaced = false;
        boolean validResponse = false;

        while (!done) {
            validResponse = false;
            if (!firstLetterPlaced) {
                while (!validResponse) {
                    System.out.println("What direction will you place your word (1 = Left -> Right, 0 = Up -> Down)");
                    input = scan.nextLine();
                    if (input.equalsIgnoreCase("0")) {
                        isVertical = false;
                        validResponse = true;
                    } else if (input.equalsIgnoreCase("1")) {
                        isVertical = true;
                        validResponse = true;
                    } else {
                        System.out.println("Not a valid direction, enter 0 or 1.");
                        done = true;
                        validResponse = false;
                    }
                }
                validResponse = false;
                    while(!validResponse) {
                        System.out.println("Where do you want to place your letter? Example: a0, g7, etc.");
                        input = scan.nextLine();
                        x = input.charAt(0);
                        y = Character.getNumericValue(input.charAt(1));

                        if (gameBoard.isCordValid(x, y)) {
                            validResponse = true;
                            if (gameBoard.isCellEmpty(x, y)) {
                                System.out.println("What letter do you want to place?");
                                System.out.println("Your hand: " + gameBoard.printHand());
                                letter = scan.nextLine().charAt(0);
                                char temp_letter = placeLetter(x, y, letter);
                                firstLetterPlaced = true;
                                placeCounter++;
                                System.out.println(gameBoard);
                                if (isLetterValid) {
                                    if (isVertical) {
                                        y++;
                                    } else {
                                        x++;
                                    }
                                    word += temp_letter;
                                    if (!gameBoard.isCellEmpty(x, y)) {
                                        done = true;
                                    }
                                }
                            } else {
                                System.out.println("That cell is not empty, try again.");
                                done = true;
                            }
                        } else {
                            System.out.println("Please enter valid coordinates. example: a0, g7, etc.");
                            validResponse = false;
                        }
                    }
                validResponse = false;
            } else {
                while(!stopPlacingLetter) {
                    System.out.println("What letter do you want to place?");
                    System.out.println("Your hand: " + gameBoard.printHand());
                    letter = scan.nextLine().charAt(0);
                    char temp_letter = placeLetter(x, y, letter);
                    placeCounter++;
                    System.out.println(gameBoard);

                    if (isLetterValid) {
                        if (isVertical) {
                            y++;
                        } else {
                            x++;
                        }
                        word += temp_letter;
                    }
                    while (!validResponse) {
                        System.out.println("Do you want to stop placing letters: yes/no");
                        yesNo = scan.nextLine();
                        if (yesNo.equalsIgnoreCase("yes")) {
                            stopPlacingLetter = true;
                            validResponse = true;
                        } else if (yesNo.equalsIgnoreCase("no")) {
                            stopPlacingLetter = false;
                            validResponse = true;
                        } else {
                            System.out.println("Enter a valid response.");
                            validResponse = false;
                        }
                    }
                    validResponse = false;

                }

                if (gameBoard.isHandEmpty() || stopPlacingLetter) {
                    if (bank.isWordValid(word)) {
                        points += bank.getWordValue(word);
                        System.out.println(word + " is a valid word!");
                        done = true;
                        break;
                    }
                    else {
                        System.out.println("Sorry " + word + " is not a valid word.");
                    }
                    while (!validResponse) {
                        System.out.println("Do you want to pass your turn?: yes/no");
                        yesNo = scan.nextLine();
                        if (yesNo.equalsIgnoreCase("yes")) {
                            pass();
                            done = true;
                            //to be implemented
                            // clear(x, y, placeCounter);
                        } else if (yesNo.equalsIgnoreCase("no")) {
                            System.out.println("I AM HERE");
                            //why isn't this making the loop stop?
                            validResponse = true;
                        } else {
                            System.out.println("Enter a valid response.");
                            validResponse = false;
                        }
                    }
                }
            }
        }
    }

    /**
     * Passes the turn of the player
     */
    public void pass(){
        System.out.println("The turn was passed.");
    }

    /**
     * Places a letter on the board
     * @author Tarik Beldjehem
     * @param x the character coordinate
     * @param y the number coordinate
     * @param letter the letter to be placed
     * @return letter the letter that has been placed
     */

    private char placeLetter(int x, int y, char letter){
        if (gameBoard.checkHand(letter)) {
            gameBoard.placeLetter(letter, x, y);
            isLetterValid = true;
            return letter;
        } else {
            System.out.println("That letter is not in your hand.");
        }
        isLetterValid = false;
        return letter;
    }
    /**
     * Clears the letters placed on this turn
     * @author Tarik Beldjehem
     * @param x the character coordinate
     * @param y the number coordinate
     * @param counter the counter that keeps tracker of how many letters have been placed
     */
    /** Method does not work properly, to be implemented
    private void clear(int x, int y, int counter){
        for (int i = 0; i < counter; i++) {
            gameBoard.placeLetter(' ',x+i,y+i);
        }
    }
     */

    /**
     * Quits the game
     * @author Tarik Beldjehem
     */
    public void quit(){
        quit = true;
        System.out.println("Thanks for playing Scrabble!");
    }

    /**
     * The Main method that initializes and plays a game object for testing
     * @author Tarik Beldjehem
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

}

