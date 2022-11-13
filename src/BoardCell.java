/**
 * Represents a specific cell or tile within the board. Allows for
 * the getting, setting, and checking of the contained letter.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class BoardCell {

    /**
     * The contained letter.
     */
    private Character letter;

    /**
     * Create new board cell.
     */
    public BoardCell() {
        this.letter = null;
    }

    /**
     * Get contained letter.
     * @return Contained letter.
     */
    public Character getLetter() {
        return letter;
    }

    /**
     * Set contained letter.
     * @param letter Contained letter.
     */
    public void setLetter(Character letter) {
        this.letter = letter;
    }

    /**
     * Check if letter is contained.
     * @return If letter is contained.
     */
    public Boolean hasLetter() {
        return letter != null;
    }
}
