/**
 * This class contains all the data relating to the game's current state
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

    public boolean isValidResponse() {
        return validResponse;
    }

    public void setValidResponse(boolean validResponse) {
        this.validResponse = validResponse;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public void setVertical(boolean vertical) {
        isVertical = vertical;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isFirstLetterPlaced() {
        return firstLetterPlaced;
    }

    public void setFirstLetterPlaced(boolean firstLetterPlaced) {
        this.firstLetterPlaced = firstLetterPlaced;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incrementX(){
        x++;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementY(){
        y++;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void incrementTurns() {
        turns++;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addToPoints(int increase){
        points += increase;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void addToWord(){
        word += letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean isLetterValid() {
        return isLetterValid;
    }

    public void setLetterValid(boolean letterValid) {
        isLetterValid = letterValid;
    }

    public boolean isStopPlacingLetter() {
        return stopPlacingLetter;
    }

    public void setStopPlacingLetter(boolean stopPlacingLetter) {
        this.stopPlacingLetter = stopPlacingLetter;
    }
}
