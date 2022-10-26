/**
 * This class contains all the data relating to the game's current state
 *  * @author Tarik Beldjehem
 *  * @author Andrew Sahadeo
 *   * @version 1.0
 */
public class GameState {
    //counter to keep track of turns
    private static int turns;
    //counter to keep track of points
    private static int points;
    //Checks if turn is in vertical alignment
    private boolean isVertical;
    // The current x coordinate
    private int x;
    // The current y coordinate
    private int y;
    // The current word
    private String word;
    // The current letter being placed
    private char letter;
    //variable that determines if the game is played
    private boolean quit;
    //variable that determines if the place command is done
    private boolean done;
    //checks if the letter chosen is valid
    private boolean isLetterValid;
    //Checks whether the first letter has been placed
    private boolean firstLetterPlaced;
    //Checks whether the info entered is valid
    private boolean validResponse;
    //Checks whether you should stop placing letters
    boolean stopPlacingLetter;

    /**
     * Creates the default game state
     * @author Andrew Sahadeo
     */
    public GameState(){
        turns = 1;
        points = 0;
        isVertical = true;
        x = 'a';
        y = 0;
        word = "";
        letter = ' ';
        quit = false;
        done = false;
        isLetterValid = false;
        firstLetterPlaced = false;
        validResponse = false;
        stopPlacingLetter = false;
    }

    /**
     * Returns validResponse that is true or false
     * @author Andrew Sahadeo
     * @return validResponse that is true or false
     */
    public boolean isValidResponse() {
        return validResponse;
    }

    /**
     * sets the validResponse to true or false depending on the parameter
     * @author Andrew Sahadeo
     * @param validResponse can be true or false
     */
    public void setValidResponse(boolean validResponse) {
        this.validResponse = validResponse;
    }

    /**
     * Returns isVertical that is true or false
     * @author Andrew Sahadeo
     * @return isVertical that is true or false
     */
    public boolean isVertical() {
        return isVertical;
    }

    /**
     * Returns isVertical that is true or false
     * @author Andrew Sahadeo
     * @param vertical that is true or false
     */
    public void setVertical(boolean vertical) {
        isVertical = vertical;
    }

    /**
     * Returns done that is true or false
     * @author Andrew Sahadeo
     * @return done which is true or false
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets done that is true or false
     * @author Andrew Sahadeo
     * @param done which is true or false
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Returns firstLetterPlaced that is true or false
     * @author Andrew Sahadeo
     * @return firstLetterPlaced which is true or false
     */
    public boolean isFirstLetterPlaced() {
        return firstLetterPlaced;
    }

    /**
     * Sets firstLetterPlaced that is true or false
     * @author Andrew Sahadeo
     * @param firstLetterPlaced which is true or false
     */
    public void setFirstLetterPlaced(boolean firstLetterPlaced) {
        this.firstLetterPlaced = firstLetterPlaced;
    }

    /**
     * Returns the x coordinate
     * @author Andrew Sahadeo
     * @return x the coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate
     * @author Andrew Sahadeo
     * @param x the coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Increments the x coordinate
     * @author Andrew Sahadeo
     */
    public void incrementX(){
        x++;
    }

    /**
     * Returns the y coordinate
     * @author Andrew Sahadeo
     * @return y the coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Creates the default game state
     * @author Andrew Sahadeo
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Increments the y coordinate
     * @author Andrew Sahadeo
     */
    public void incrementY(){
        y++;
    }

    /**
     * Returns the amount of turns
     * @author Andrew Sahadeo
     * @return turns the amount of turns passed
     */
    public int getTurns() {
        return turns;
    }

    /**
     * Sets the amount of turns
     * @author Andrew Sahadeo
     * @param turns the amount of turns passed
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }

    /**
     * Increments the turns
     * @author Andrew Sahadeo
     */
    public void incrementTurns() {
        turns++;
    }

    /**
     * Returns the amount of points
     * @author Andrew Sahadeo
     * @return points the amount of turns obtained
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the amount of points
     * @author Andrew Sahadeo
     * @return points the amount of turns obtained
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Increments points by the parameter provided
     * @author Andrew Sahadeo
     * @param increase the amount points is incremented by
     */
    public void addToPoints(int increase){
        this.points += increase;
    }

    /**
     * Returns the word
     * @author Andrew Sahadeo
     * @return word that is made
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word
     * @author Andrew Sahadeo
     * @param word that is made
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Increments word by letter
     * @author Andrew Sahadeo
     */
    public void addToWord(){
        word += letter;
    }

    /**
     * Returns the letter
     * @author Andrew Sahadeo
     * @return letter that is provided
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Sets the letter
     * @author Andrew Sahadeo
     * @param letter that is provided
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Returns quit that is true or false
     * @author Andrew Sahadeo
     * @return quit which is true or false
     */
    public boolean isQuit() {
        return quit;
    }

    /**
     * Sets quit that is true or false
     * @author Andrew Sahadeo
     * @param quit which is true or false
     */
    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    /**
     * Returns isLetterValid that is true or false
     * @author Andrew Sahadeo
     * @return isLetterValid which is true or false
     */
    public boolean isLetterValid() {
        return isLetterValid;
    }

    /**
     * Sets isLetterValid that is true or false
     * @author Andrew Sahadeo
     * @param letterValid which is true or false
     */
    public void setLetterValid(boolean letterValid) {
        isLetterValid = letterValid;
    }

    /**
     * Returns stopPlacingLetter that is true or false
     * @author Andrew Sahadeo
     * @return stopPlacingLetter which is true or false
     */
    public boolean isStopPlacingLetter() {
        return stopPlacingLetter;
    }

    /**
     * Sets stopPlacingLetter that is true or false
     * @author Andrew Sahadeo
     * @param stopPlacingLetter which is true or false
     */
    public void setStopPlacingLetter(boolean stopPlacingLetter) {
        this.stopPlacingLetter = stopPlacingLetter;
    }
}
