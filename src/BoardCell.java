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
     * Tracks if the cell is in a vertical chain
     */
    private boolean inVertChain;
    /**
     * Tracks if the cell is in a horizontal chain
     */
    private boolean inHorizChain;

    /**
     * Represents the cell's x value
     */
    private Integer x;

    /**
     * Represents the cell's y value
     */
    private Integer y;

    /**
     * The possible types of board cells
     */
    public enum Type{
        NORMAL, BLUE, CYAN, PINK, RED, MIDDLE
    }

    /**
     * The type of this board cell
     */
    private Type type;

    /**
     * Tracks all the cell's adjacent cells
     */
    private BoardCell northCell;
    private BoardCell southCell;
    private BoardCell eastCell;
    private BoardCell westCell;

    /**
     * Create new board cell.
     */
    public BoardCell(int x, int y, Type type) {
        this.letter = null;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Create new board cell with a letter in it.
     */
    public BoardCell(int x, int y, Character letter ,Type type) {
        this.letter = letter;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * An alternative constructor used by the AI player to calculate points
     * @param x x value
     * @param y y value
     * @param letter letter in the cell
     */
    public BoardCell(int x, int y, Character letter){
        this.x = x;
        this.y = y;
        this.letter = letter;
        this.type = Type.NORMAL;
    }

    /**
     * Set the cell type.
     * @param type The type.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Get the cell type.
     * @return type The type.
     */
    public Type getType() {
        return type;
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
        return this.getX().equals(boardCell.getX()) && this.getY().equals(boardCell.getY()) && this.getType().equals(boardCell.getType());
    }

    public String toXML(){
        String str = "<BoardCell>\n";
        String xVal = "<x>" + this.getX() + "</x>\n";
        String yVal = "<y>" + this.getX() + "</y>\n";
        String tType = "<type>" + this.getType() + "</type>\n";

        str+= xVal + yVal + tType + "</BoardCell>\n";
        return str;
    }

    /**
     * Gets inVertChain
     * @return
     */
    public boolean isInVertChain() {
        return inVertChain;
    }

    /**
     * Sets inVertChain
     * @param inVertChain
     */
    public void setInVertChain(boolean inVertChain) {
        this.inVertChain = inVertChain;
    }
    /**
     * Gets inVertChain
     * @return
     */
    public boolean isInHorizChain() {
        return inHorizChain;
    }

    /**
     * Sets inHorizChain
     * @param inHorizChain
     */
    public void setInHorizChain(boolean inHorizChain) {
        this.inHorizChain = inHorizChain;
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

    public void toUpperCase(){
        letter = Character.toUpperCase(letter);
    }
    public boolean isLower() {
        if (letter == null){
            return false;
        }
        return Character.isLowerCase(letter);
    }
    /**
     * Getters and setters for all adjacent cells
     */
    public BoardCell getNorthCell() {
        return northCell;
    }
    public void setNorthCell(BoardCell northCell) {
        this.northCell = northCell;
    }
    public BoardCell getSouthCell() {
        return southCell;
    }
    public void setSouthCell(BoardCell southCell) {
        this.southCell = southCell;
    }
    public BoardCell getEastCell() {
        return eastCell;
    }
    public void setEastCell(BoardCell eastCell) {
        this.eastCell = eastCell;
    }
    public BoardCell getWestCell() {
        return westCell;
    }
    public void setWestCell(BoardCell westCell) {
        this.westCell = westCell;
    }

    /**
     * Returns a string representation of BoardCell
     * @return the string
     */
    @Override
    public String toString() {
        return "" + this.getType() + "[" + this.getLetter() + "," + this.getX() + "," + this.getY() + "]";
    }
}
