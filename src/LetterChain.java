import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */
public class LetterChain {

    /**
     * 
     */
    private ArrayList<LetterCell> cells;

    /**
     * 
     */
    private State state;

    /**
     * 
     * @param state 
     */
    public LetterChain(State state) {
        this.state = state;
        cells = new ArrayList<>();
    }

    /**
     * 
     */
    public void clear() {
        cells.clear();
    }

    /**
     * 
     * @param x
     * @param y
     * @param letter
     */
    public void addLetter(Integer x, Integer y, Character letter) {
        cells.add(new LetterCell(x, y, letter));
    }

    /**
     * 
     * @param x
     * @param y
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
     * 
     * @param x
     * @param y
     * @return
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
     *
     * @return
     */
    public Integer getSize() {
        return cells.size();
    }

    public Integer getScore() {
        Integer score = 0;


        for (LetterCell cell : cells) {
            score += getScore(cell.getX(), cell.getY());
        }

        return score;
    }

    public Integer getScore(Integer x, Integer y) {
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

    public String walkHorizontal(Integer direction, Integer x, Integer y) {
        StringBuilder string = new StringBuilder();
        Board board = state.getBoard();

        while (board.isValid(x, y) && board.hasLetter(x, y)) {
            string.append(board.getLetter(x, y));
            x += direction;
        }

        return string.toString();
    }

    public String walkVertical(Integer direction, Integer x, Integer y) {
        StringBuilder string = new StringBuilder();
        Board board = state.getBoard();

        while (board.isValid(x, y) && board.hasLetter(x, y)) {
            string.append(board.getLetter(x, y));
            y += direction;
        }

        return string.toString();
    }
}
