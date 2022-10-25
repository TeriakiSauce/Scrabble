import java.util.*;

/**
 * This is the main Game class that the gameplay loop and commands are made in.
 * @author Tarik Beldjehem
 * @author Andrew Sahadeo
 * @version 1.0
 */

public class Game2 {
    //deals with the user inputting a command
    private Parser parser;
    //Word bank of all valid words
    private WordBank bank;
    //The game board
    private Board gameBoard;
    //The game's state
    private GameState state;
    //Start of turn's board
    private Board savedBoard;
    //Start of turn's state
    private GameState savedState;
    //Size of game board
    public static final int SIZE = 15;
    //Scanner
    private Scanner scan;
    //String used for input
    private String input;

    /**
     * Initializes the game and the fields
     * @author Tarik Beldjehem
     */
    public Game2() {
        parser = new Parser();

        bank = new WordBank("https://www.mit.edu/~ecprice/wordlist.10000");

        gameBoard = new Board(SIZE);

        state = new GameState();

        input = "";

        scan = new Scanner(System.in);
    }

    /**
     * Message that plays at the start of every game
     * @author Tarik Beldjehem
     */
    public void message(){
        System.out.println("You are on turn " + state.getTurns() + ".");
        System.out.println("You have " + state.getPoints() + " points.");
        System.out.println("Type an available command: " + parser);
    }

    /**
     * Game loop that continues until quit is true
     * @author Tarik Beldjehem
     */
    public void play(){
        System.out.println("The Game of Scrabble");
        System.out.println(gameBoard);
        while(!state.isQuit()) {
            message();
            parser.readInputCommand();
            if (parser.commandIsValid()) {
                chooseCommand();
                state.incrementTurns();
            }
            else{
                System.out.println("Enter a valid command.");
            }
        }
    }

    /**
     * Determines which command to execute depending on user input
     * @author Tarik Beldjehem
     */
    public void chooseCommand() {
        switch (parser.getInput().toUpperCase()) {
            case "PLACE":
                this.place(gameBoard);
                break;
            case "PASS":
                System.out.println("The turn was passed.");
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
    public void place(Board board) {
        savedBoard = gameBoard;
        savedState = state;
        while (!state.isDone()) {
            state.setValidResponse(false);
            if (!state.isFirstLetterPlaced()) {
                getDirection();
                getCoordinates();
            } else {
                while(!state.stopPlacingLetter) {
                    getLetter();
                    placeLetter();
                    System.out.println(gameBoard);

                    if (state.isLetterValid()) {
                        incrementPosition();
                        state.addToWord();
                    }
                    getEndTurn();
                }

                if (gameBoard.isHandEmpty() || state.isStopPlacingLetter()) {
                    if (bank.isWordValid(state.getWord())) {
                        state.addToPoints(bank.getWordValue(state.getWord()));
                        System.out.println(state.getWord() + " is a valid word!");
                        state.setDone(true);
                        break;
                    }
                    else {
                        System.out.println("Sorry " + state.getWord() + " is not a valid word.");
                    }
                    getPassTurn();
                }
            }
        }
        state = new GameState();
        gameBoard.populateHand();
    }

    /**
     * Places a letter on the board
     * @author Tarik Beldjehem
     * @return letter the letter that has been placed
     */

    private void placeLetter(){
        if (gameBoard.checkHand(state.getLetter())) {
            gameBoard.placeLetter(state.getLetter(), state.getX(), state.getY());
            state.setLetterValid(true);
            return;
        } else {
            System.out.println("That letter is not in your hand.");
        }
        state.setLetterValid(false);
    }

    private void clear(){
        state = savedState;
        gameBoard = new Board(15);
    }
    /**
     * Obtains the direction from the user (left-right or up-down)
     */
    private void getDirection(){
        while (!state.isValidResponse()) {
            System.out.println("What direction will you place your word (1 = Left -> Right, 0 = Up -> Down)");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("0")) {
                state.setVertical(false);
                state.setValidResponse(true);
            } else if (input.equalsIgnoreCase("1")) {
                state.setVertical(true);
                state.setValidResponse(true);
            } else {
                System.out.println("Not a valid direction, enter 0 or 1.");
                state.setDone(true);
                state.setValidResponse(false);
            }
        }
        state.setValidResponse(false);
    }

    private void getCoordinates(){
        while(!state.isValidResponse()) {
            System.out.println("Where do you want to place your letter? Example: a0, g7, etc.");
            input = scan.nextLine();
            state.setX(input.charAt(0));
            state.setY(Character.getNumericValue(input.charAt(1)));

            if (gameBoard.isCordValid(state.getX(), state.getY())) {
                state.setValidResponse(true);
                if (gameBoard.isCellEmpty(state.getX(), state.getY())) {
                    getLetter();
                    placeLetter();
                    state.setFirstLetterPlaced(true);
                    System.out.println(gameBoard);
                    if (state.isLetterValid()) {
                        if (state.isVertical()) {
                            state.incrementY();
                        } else {
                            state.incrementX();
                        }
                        state.addToWord();
                        if (!gameBoard.isCellEmpty(state.getX(), state.getY())) {
                            state.setDone(true);
                        }
                    }
                } else {
                    System.out.println("That cell is not empty, try again.");
                    state.setDone(true);
                }
            } else {
                System.out.println("Please enter valid coordinates. example: a0, g7, etc.");
                state.setValidResponse(false);
            }
        }
        state.setValidResponse(false);
    }

    private void getLetter(){
        System.out.println("What letter do you want to place?");
        System.out.println("Your hand: " + gameBoard.printHand());
        state.setLetter(scan.nextLine().charAt(0));
    }

    private void getEndTurn() {
        while (!state.isValidResponse()) {
            System.out.println("Do you want to stop placing letters: y/n");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                state.setStopPlacingLetter(true);
                state.setValidResponse(true);
            } else if (input.equalsIgnoreCase("n")) {
                state.setStopPlacingLetter(false);
                state.setValidResponse(true);
            } else {
                System.out.println("Enter a valid response.");
                state.setValidResponse(false);
            }
        }
        state.setValidResponse(false);
    }

    private void getPassTurn(){
        while (!state.isValidResponse()) {
            System.out.println("Do you want to pass your turn?: y/n");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("The turn was passed.");
                state.setDone(true);
                state.setValidResponse(true);
                clear();
                System.out.println(gameBoard);
            } else if (input.equalsIgnoreCase("n")) {
                state.setValidResponse(true);
                clear();
                System.out.println(gameBoard);
                place(savedBoard);
            } else {
                System.out.println("Enter a valid response.");
                state.setValidResponse(false);
            }
        }
    }

    private void incrementPosition(){
        if (state.isVertical()) {
            state.incrementY();
        } else {
            state.incrementX();
        }
    }

    /**
     * Quits the game
     * @author Tarik Beldjehem
     */
    public void quit(){
        state.setQuit(true);
        System.out.println("Thanks for playing Scrabble!");
    }

    /**
     * The Main method that initializes and plays a game object for testing
     * @author Tarik Beldjehem
     */
    public static void main(String[] args) {
        Game2 game = new Game2();
        game.play();
    }

}