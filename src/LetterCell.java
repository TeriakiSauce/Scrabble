import java.io.Serializable;

/**
 * @author Jaan
 * @version 1.1
 */
public class LetterCell implements Serializable {

    /**
     * The letter.
     */
    private Character letter;

    /**
     * The letter x position.
     */
    private Integer x;

    /**
     * The letter y position.
     */
    private Integer y;

    /**
     * Create a new letter cell.
     *
     * @param x      The x position.
     * @param y      The y position.
     * @param letter The letter.
     */
    public LetterCell(Integer x, Integer y, Character letter) {
        this.letter = letter;
        this.x = x;
        this.y = y;
    }

    /**
     * Get the letter.
     *
     * @return The letter.
     */
    public Character getLetter() {
        return letter;
    }

    /**
     * Get the x position.
     *
     * @return The x position.
     */
    public Integer getX() {
        return x;
    }

    /**
     * Get the y position.
     *
     * @return The y position.
     */
    public Integer getY() {
        return y;
    }

    /**
     * Returns a string representation of LetterCell
     * @return the string
     */
    public String toString() {
        return letter + "";
    }

    @Override
    public boolean equals(Object obj) {
        LetterCell cell = (LetterCell) obj;
        return letter == cell.letter && x == cell.getX() && y == cell.getY();
    }

}