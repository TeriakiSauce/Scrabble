import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Represents several letters that a player has placed. Can be used to compute
 * the score of the placed word.
 * @author Jaan
 * @author Andrew
 * @version 1.5
 */
public class LetterChain {

    /**
     * The letters and positions.
     */
    private ArrayList<LetterCell> cells;

    /**
     * The state.
     */
    private State state;

    /**
     * The direction that the word was played, false for horizontal, true for vertical
     */
    private boolean isVertical;

    /**
     * Create new letter chain.
     * @param state The state.
     */
    public LetterChain(State state) {
        this.state = state;
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
     * @param x The x position.
     * @param y The y position.
     * @param letter The letter.
     */
    public void addLetter(Integer x, Integer y, Character letter) {
        cells.add(new LetterCell(x, y, letter));
    }

    /**
     * Remove a letter at a specified position.
     * @param x The x position.
     * @param y The y position.
     */
    public void removeLetter(Integer x, Integer y) {
        Iterator<LetterCell> iterator = cells.iterator();
        while (iterator.hasNext()) {
            LetterCell cell = iterator.next();
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
        for (LetterCell cell : cells) {
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
     * Get the score from the placed letters. This is the main method for computing
     * the total score of the placed word.
     * @return The score.
     */
    public Integer getScore() {
        Integer score = 0;
        // Returns 0 if size is empty or placement is invalid
        if (this.getSize() == 0){
            return 0;
        }
        if (!(validPlacementX() || validPlacementY())){
            return 0;
        }
        for (LetterCell cell : cells) {
            score += getScore(cell.getX(), cell.getY());
        }
        return score;
    }

    /**
     * Returns true if letters are placed in a valid  horizontal configuration
     * @return true if letters are valid, false otherwise
     */
    private boolean validPlacementX(){
        Board board = state.getBoard();
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
            if (!(board.hasLetter(x,y))){
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
        Board board = state.getBoard();
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
            if (!(board.hasLetter(x,y))){
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
        Integer score = 0;
        WordBank bank = state.getWordBank();
        String word;

        word = walkHorizontal(1, x, y);
        if (bank.isWordValid(word)) {
            score += bank.getWordValue(word);
        }

        word = walkHorizontal(-1, x, y);
        if (bank.isWordValid(word)) {
            score += bank.getWordValue(word);
        }

        word = walkVertical(1, x, y);
        if (bank.isWordValid(word)) {
            score += bank.getWordValue(word);
        }

        word = walkVertical(-1, x, y);
        if (bank.isWordValid(word)) {
            score += bank.getWordValue(word);
        }

        return score;
    }

    /**
     * Helper function for computing the word.
     * @param direction The travel direction.
     * @param x The x position.
     * @param y The y position.
     * @return The computed word.
     */
    private String walkHorizontal(Integer direction, Integer x, Integer y) {
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
        StringBuilder string = new StringBuilder();
        Board board = state.getBoard();

        while (board.isValid(x, y) && board.hasLetter(x, y)) {
            string.append(board.getLetter(x, y));
            y += direction;
        }

        return string.toString();
    }
}
