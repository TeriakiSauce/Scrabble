/**
 *  This class represents the cells that make up the game board.
 *  @author Andrew Sahadeo
 *  @version 1.0
 */
public class Cell {
    // The game piece that may be placed in the cell.
    private char letter;
    private int x_location;
    private int y_location;
    private Cell up;
    private Cell down;
    private Cell right;
    private Cell left;

    /**
     * Initializes the cell with its location.
     * @param x the x location
     * @param y the y location
     */
    public Cell(int x, int y){
        x_location = x;
        y_location = y;
        letter = ' ';
    }

    /**
     * Sets the cell's letter
     * @param letter The letter placed on the cell.
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

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

    public Cell getUp() {
        return up;
    }

    public void setUp(Cell up) {
        this.up = up;
    }

    public Cell getDown() {
        return down;
    }

    public void setDown(Cell down) {
        this.down = down;
    }

    public Cell getRight() {
        return right;
    }

    public void setRight(Cell right) {
        this.right = right;
    }

    public Cell getLeft() {
        return left;
    }

    public void setLeft(Cell left) {
        this.left = left;
    }
}
