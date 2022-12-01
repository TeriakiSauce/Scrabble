import java.util.Objects;
import java.io.Serializable;

/**
 * Represents a specific cell or tile within the board. Allows for
 * the getting, setting, and checking of the contained letter.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class BoardCell implements Serializable {

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

    /**
     * Compares this board cell with the specified board cell.
     * @param o the board cell to be compared.
     * @return true if the board cells are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCell boardCell = (BoardCell) o;
        return letter == boardCell.letter;
    }

}
