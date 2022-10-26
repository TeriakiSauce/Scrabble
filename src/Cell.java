/**
 *  This class represents the cells that make up the game board.
 *  @author Andrew Sahadeo
 *  @version 1.0
 */
public class Cell {
    // The game piece that may be placed in the cell.
    private char letter;

    /**
     * Initializes the cell with its location.
     */
    public Cell() {
        letter = ' ';
    }

    /**
     * Sets the cell's letter
     * @param letter The letter placed on the cell.
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Returns the cell's letter
     * @return the cell's letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Returns the letter on the cell.
     * @return The letter placed on the cell, "" if there is none.
     */
    public String toString(){
        return "[" + letter + "]";
    }
}
