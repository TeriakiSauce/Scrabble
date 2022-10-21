public class Cell {
    /**
     *
     */
    // The letter that is placed on the cell
    private String letter;

    // The cell's location on the board
    private int x_location;
    private int y_location;

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
    public void setLetter(String letter) {
        this.letter = letter;
    }

    /**
     * Returns the letter on the cell.
     * @return The letter placed on the cell, "" if there is none.
     */
    public String toString(){
        if (letter== null){
            return "";
        }
        return letter;
    }
}
