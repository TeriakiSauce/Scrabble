/**
 *  This class represents the cells that make up the game board.
 *  @author Andrew Sahadeo
 *  @version 1.0
 */
public class Cell {
    // The game piece that may be placed in the cell.
    private char letter;
    private final int x_location;
    private final int y_location;

    /**
     * Initializes the cell with its location.
     * @param x the x location
     * @param y the y location
     */
    public Cell(int x, int y){
        x_location = x;
        y_location = y;
    }

    /**
     * Sets the cell's letter
     * @param letter The letter placed on the cell.
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Returns the letter on the cell.
     * @return The letter placed on the cell, "" if there is none.
     */
    public String toString(){
        if (letter == ' '){
            return "[ ]";
        }
        return "[" + letter + "]";
    }
}
