import java.util.*;

/**
 * This is the main Game class that the gameplay loop and commands are made in.
 * @author Tarik Beldjehem
 * @author Andrew Sahadeo
 * @version 1.0
 */

public class Game {
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
    //counter to keep track of turns
    private int turns;
    //counter to keep track of points
    private int points;
    //
    private ArrayList<Hand> hands;

    /**
     * Initializes the game and the fields
     * @author Tarik Beldjehem
     */
    public Game() {
        parser = new Parser();

        bank = new WordBank("https://www.mit.edu/~ecprice/wordlist.10000");

        gameBoard = new Board(SIZE);

        hands = new ArrayList<>();

        state = new GameState(hands.size());

        input = "";

        scan = new Scanner(System.in);

        turns = 1;

        points = 0;

        Hand player1Hand = new Hand("Player 1");
        hands.add(player1Hand);
        gameBoard.populateHand(player1Hand);
        // Add player 2 hand for another player
    }

    /**
     * Message that plays at the start of every game
     * @author Tarik Beldjehem
     */
    public void message(){
        System.out.println("You are on turn " + turns + ".");
        System.out.println("You have " + points + " points.");
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
                turns++;
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

    public Hand getCurrentHand()
    {
        return hands.get(state.getCurrentPlayer());
    }

    /**
     * Places a letter on the board until valid word is made
     * Tarik Beldjehem
     * Andrew Sahadeo
     */
    public void place(Board board) {

        Hand hand = getCurrentHand();

        savedBoard = gameBoard;
        savedState = state;
        while (!state.isDone()) {
            state.setValidResponse(false);
            if (!state.isFirstLetterPlaced()) {
                getDirection();
                getCoordinates();
            } else {
                while(!state.shouldStopPlacingLetter()) {
                    getLetter();
                    placeLetter();
                    System.out.println(gameBoard);

                    if (state.isLetterValid()) {
                        incrementPosition();
                        state.addToWord();
                    }
                    getEndTurn();
                }

                if (hand.isEmpty() || state.isStopPlacingLetter()) {
                    if (bank.isWordValid(state.getWord())) {
                        state.setPoints(bank.getWordValue(state.getWord()));
                        points+= state.getPoints();
                        System.out.println(state.getWord() + " is a valid word!");
                        state.setDone(true);
                        break;
                    }
                    else {
                        System.out.println("Sorry " + state.getWord() + " is not a valid word.");
                        break;
                    }
                    //getPassTurn();            //not working properly
                }
            }
        }
        state = new GameState(hands.size());
        gameBoard.populateHand(hand);
    }

    /**
     * Places a letter on the board
     * @author Tarik Beldjehem
     * @return letter the letter that has been placed
     */

    private void placeLetter(){
        Hand hand = getCurrentHand();
        if (gameBoard.checkHand(hand, state.getLetter())) {
            gameBoard.placeLetter(hand, state.getLetter(), state.getX(), state.getY());
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
        Hand hand = getCurrentHand();
        System.out.println("What letter do you want to place?");
        System.out.println(hand.getPlayerName()+ " hand: " + hand.getLetters());
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

    /**Having issues getting this method to work

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

     */

    private void incrementPosition(){
        while (!gameBoard.isCellEmpty(state.getX(), state.getY())) {
            if (state.isVertical()) {
                state.incrementY();
            } else {
                state.incrementX();
            }
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

}