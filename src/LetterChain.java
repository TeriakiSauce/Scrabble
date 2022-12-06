import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Represents several letters that a player has placed. Can be used to compute
 * the score of the placed word.
 * @author Jaan
 * @author Andrew
 * @author Tarik
 * @version 1.7
 */
public class LetterChain implements Serializable {
    /**
     * The letters and positions.
     */
    private ArrayList<BoardCell> cells;

    /**
     * The game.
     */
    private transient Game game;

    /**
     * The direction that the word was played, false for horizontal, true for vertical
     */
    private boolean isVertical;

    /**
     * The value that is certain chain will give when played
     */
    private int playValue;

    /**
     * Create new letter chain.
     * @param game The game.
     */
    public LetterChain(Game game) {
        this.game = game;
        cells = new ArrayList<>();
    }

    /**
     * Clear the chain.
     */
    public void clear() {
        cells.clear();
    }

    /**
     * Add a letter to the chain.
     * @param cell The cell to be added
     */
    public void addLetter(BoardCell cell) {
        cells.add(cell);
    }

    /**
     * Remove a letter at a specified position.
     * @param x The x position.
     * @param y The y position.
     */
    public void removeLetter(Integer x, Integer y) {
        Iterator<BoardCell> iterator = cells.iterator();
        while (iterator.hasNext()) {
            BoardCell cell = iterator.next();
            if (cell.getX() == x && cell.getY() == y) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * Check if a letter exists at the specified position.
     * @param x The x position.
     * @param y The y position.
     * @return If the letter exists.
     */
    public Boolean hasLetter(Integer x, Integer y) {
        for (BoardCell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the size of the chain.
     * @return The size.
     */
    public Integer getSize() {
        return cells.size();
    }

    /**
     * Returns isVertical
     * @return true if vertical, false otherwise
     */
    public boolean isVertical() {
        return isVertical;
    }

    /**
     * Returns premium tile multiplier
     * @return the multiplier
     */
    public Integer getMultiplier(BoardCell cell) {
        switch (cell.getType()) {
            case BLUE:
            case RED:
                return 3;
            case CYAN:
            case PINK:
                return 2;
            default:
                return 1;
        }
    }

    /**
     * Returns if premium tile multiplier is a word multiplier
     * @return true if word multiplier, false otherwise
     */
    public boolean isWordMultiplier(BoardCell.Type type) {
        switch (type) {
            case RED:
            case PINK:
                return true;
            default:
                return false;
        }
    }

    /**
     * Get the score from the placed letters. This is the main method for computing
     * the total score of the placed word.
     * @return The score.
     */
    public Integer getScore() {
        State state = game.getState();
        Integer scoreTotal = 0;
        Integer totalLetterBonus = 1;
        Integer totalWordBonus = 1;
        //Integer totalLetterBonus = 1;
        WordBank bank = game.getWordBank();
        // Returns 0 if size is empty or placement is invalid
        if (this.getSize() == 0){
            return 0;
        }
        // Returns 0 if  placement is invalid
        if (!(validPlacementX() || validPlacementY())){
            return 0;
        }
        //Sorts the list of letters according to its direction
        if (isVertical){
            cells.sort(Comparator.comparing(a -> a.getY()));
        } else {
            cells.sort(Comparator.comparing(a -> a.getX()));
        }

        // Returns 0 if the letter is not connected to another letter on the board or the middle square
        boolean connected = false;
        for (BoardCell cell : cells){
            if (cell.getX() == Config.BOARD_HEIGHT/2 && cell.getY() == Config.BOARD_HEIGHT/2){
                connected = true;
            }
            if (state.getOldBoard().hasLetter(cell.getX()+1, cell.getY())){
                connected = true;
            }
            if (state.getOldBoard().hasLetter(cell.getX()-1, cell.getY())){
                connected = true;
            }
            if (state.getOldBoard().hasLetter(cell.getX(), cell.getY()+1)){
                connected = true;
            }
            if (state.getOldBoard().hasLetter(cell.getX(), cell.getY()-1)){
                connected = true;
            }
        }
        if (!connected){
            return 0;
        }

        scoreTotal += getScore(cells.get(0).getX(), cells.get(0).getY());
        for (BoardCell cell : cells) {
            if (isWordMultiplier(cell.getType())) {
                totalWordBonus *= getMultiplier(cell);
                scoreTotal*=totalWordBonus;
            }
            else {
                totalLetterBonus = getMultiplier(cell);
                if (totalLetterBonus>1){
                    totalLetterBonus*= bank.getLetterValue(cell.getLetter());
                    scoreTotal+= totalLetterBonus - bank.getLetterValue(cell.getLetter());
                }
            }
            /*
            else {
                totalLetterBonus *= getMultiplier(cell);
                if (totalLetterBonus>1){
                    scoreTotal += bank.getLetterValue(cell.getLetter())*totalLetterBonus;
                }
            }

             */
        }
        return scoreTotal;
    }

    /**
     * Returns true if letters are placed in a valid  horizontal configuration
     * @return true if letters are valid, false otherwise
     */
    private boolean validPlacementX(){
        State state = game.getState();
        // Sorts the cells by their x values
        cells.sort(Comparator.comparing(a -> a.getX()));
        // Checks that cells are in the same row
        for (int i = 0; i <this.getSize(); i++) {
            if(i>0){
                if (!(cells.get(i).getY() == cells.get(i-1).getY())){
                    return false;
                }
            }
        }
        // Checks that there are no gaps between cells
        int y = cells.get(0).getY();
        for (int x = cells.get(0).getX(); x < cells.get(cells.size()-1).getX(); x++) {
            if (!(state.getBoard().hasLetter(x,y))){
                return false;
            }
        }

        isVertical = false;
        return true;
    }

    /**
     * Returns true if letters are placed in a valid vertical configuration
     * @return true if letters are valid, false otherwise
     */
    private boolean validPlacementY(){
        State state = game.getState();
        // Sorts the cells by their y values
        cells.sort(Comparator.comparing(a -> a.getY()));
        // Checks that cells are in the same column
        for (int i = 0; i <this.getSize(); i++) {
            if(i>0){
                if (!(cells.get(i).getX() == cells.get(i-1).getX())){
                    return false;
                }
            }
        }
        // Checks that there are no gaps between cells
        int x = cells.get(0).getX();
        for (int y = cells.get(0).getY(); y < cells.get(cells.size()-1).getY(); y++) {
            if (!(state.getBoard().hasLetter(x,y))){
                return false;
            }
        }
        isVertical = true;
        return true;
    }

    /**
     * Helper function for computing the score.
     * @param x The x position.
     * @param y The y position.
     * @return The score.
     */
    private Integer getScore(Integer x, Integer y) {
        State state = game.getState();
        Integer scoreHelper = 0;
        WordBank bank = game.getWordBank();
        String word;
        Board board = state.getBoard();

        if(isVertical){
            // Traverses towards the top of the word then counts the letters going down
            while (board.isValid(x, y-1) && board.hasLetter(x, y-1)) {
                y--;
            }
            word = walkVertical(1,x,y);
            if (bank.isWordValid(word)) {
                scoreHelper += bank.getWordValue(word);
            } else {return 0;}
            //Finding leftmost cell with a letter then adding the letters while traversing right
            for(BoardCell cell : cells){
                x = cell.getX();
                y = cell.getY();

                while (board.isValid(x-1, y) && board.hasLetter(x-1, y)) {
                    x--;
                }
                word = walkHorizontal(1,x,y);
                if (bank.isWordValid(word)) {
                    scoreHelper += bank.getWordValue(word);
                } else if (word.length() > 1){return 0;}
            }
        } else {
            // Traverses towards the left of the word then counts the letters going right
            while (board.isValid(x-1, y) && board.hasLetter(x-1, y)) {
                x--;
            }
            word = walkHorizontal(1,x,y);
            if (bank.isWordValid(word)) {
                scoreHelper += bank.getWordValue(word);
            } else {return 0;}
            //Finding topmost cell with a letter then adding the letters while traversing down
            for(BoardCell cell : cells){
                x = cell.getX();
                y = cell.getY();

                while (board.isValid(x, y-1) && board.hasLetter(x, y-1)) {
                    y--;
                }
                word = walkVertical(1,x,y);
                if (bank.isWordValid(word)) {
                    scoreHelper += bank.getWordValue(word);
                } else if (word.length() > 1){return 0;}
            }
        }
        return scoreHelper;
    }

    /**
     * Helper function for computing the word.
     * @param direction The travel direction.
     * @param x The x position.
     * @param y The y position.
     * @return The computed word.
     */
    private String walkHorizontal(Integer direction, Integer x, Integer y) {
        State state = game.getState();
        StringBuilder string = new StringBuilder();
        Board board = state.getBoard();

        while (board.isValid(x, y) && board.hasLetter(x, y)) {
            string.append(board.getLetter(x, y));
            x += direction;
        }

        return string.toString();
    }

    /**
     * Helper function for computing the word.
     * @param direction The travel direction.
     * @param x The x position.
     * @param y The y position.
     * @return The computed word.
     */
    private String walkVertical(Integer direction, Integer x, Integer y) {
        State state = game.getState();
        StringBuilder string = new StringBuilder();
        Board board = state.getBoard();

        while (board.isValid(x, y) && board.hasLetter(x, y)) {
            string.append(board.getLetter(x, y));
            y += direction;
        }

        return string.toString();
    }
    /**
     * Returns the coordinates of the beginning of the chain
     * @return
     */
    public int[] getBeginning(){
        int x = cells.get(0).getX();
        int y = cells.get(0).getY();
        return new int[]{x, y};
    }

    /**
     * Returns the coordinates of the end of the chain
     * @return
     */
    public int[] getEnd(){
        sortChain();
        int x = cells.get(cells.size()-1).getX();
        int y = cells.get(cells.size()-1).getY();
        return new int[]{x, y};
    }

    public int getPlayValue() {
        return playValue;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Sets the isVertical field
     */
    public void setIsVertical(boolean value){
        isVertical = value;
    }
    /**
     * Sorts the chain based on the x or y positions depending on orientation
     */
    public void sortChain(){
        if(isVertical){
            cells.sort(Comparator.comparing(a -> a.getY()));
        } else {
            cells.sort(Comparator.comparing(a -> a.getX()));
        }
    }

    public LetterChain makeCopy(LetterChain og){
        LetterChain copy = new LetterChain(og.game);
        copy.isVertical = og.isVertical;
        for (BoardCell cell : cells){
            copy.addLetter(cell);
        }
        return copy;
    }
    @Override
    public boolean equals(Object obj) {
        LetterChain chain = (LetterChain) obj;
        boolean equals = true;
        for(int i = 0; i < getSize();i++){
            if(!(chain.cells.get(i) == cells.get(i))){
                equals = true;
            }
        }
        if(!(chain.isVertical() == isVertical)){
            equals = false;
        }
        return equals;
    }

    /**
     * Returns a string representation of LetterChain
     * @return
     */
    public String toString(){
        String chain = new String();
        WordBank bank = game.getWordBank();
        for (BoardCell cell : cells){
            if (isVertical){
                chain += cell.toString() +"\n";
            }
            else{
                chain += cell.toString() +" ";
            }
        }
        return chain;
    }

    public ArrayList<BoardCell> getCells() {
        return cells;
    }
}
