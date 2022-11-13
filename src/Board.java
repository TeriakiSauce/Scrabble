/**
 * Represents all of the cells in the game. Allows for the setting, getting,
 * clearing, and checking of letters in the board.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class Board {

    /**
     * 2D array of cells.
     */
    private BoardCell[][] cells;

    /**
     * Create new board.
     */
    public Board() {
        cells = new BoardCell[Config.BOARD_WIDTH][Config.BOARD_HEIGHT];
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i] = new BoardCell();
            }
        }

        clear();
    }

    /**
     * Clear the board.
     */
    public void clear() {
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i].setLetter(null);
            }
        }
    }

    /**
     * Set letter at specified position.
     * @param x The x position.
     * @param y The y position.
     * @param letter The letter.
     */
    public void setLetter(Integer x, Integer y, Character letter) {
        cells[x][y].setLetter(letter);
    }

    /**
     * Get letter at specified position.
     * @param x The x position.
     * @param y The y position.
     * @return The letter.
     */
    public Character getLetter(Integer x, Integer y) {
        return cells[x][y].getLetter();
    }

    /**
     * Check if the board has a letter at specified position.
     * @param x The x position.
     * @param y The y position.
     * @return The letter.
     */
    public Boolean hasLetter(Integer x, Integer y) {
        return cells[x][y].hasLetter();
    }

    /**
     * Remove a letter at specified position.
     * @param x The x position.
     * @param y The y position.
     */
    public void removeLetter(Integer x, Integer y) {
        cells[x][y].setLetter(null);
    }

    /**
     * Check if position is valid.
     * @param x The x position.
     * @param y The y position.
     * @return If position is valid.
     */
    public Boolean isValid(Integer x, Integer y) {
        return x < Config.BOARD_WIDTH && y < Config.BOARD_HEIGHT;
    }

    /**
     * Make a deep copy of the board.
     * @return Board deep copy.
     */
    public Board makeCopy() {
        Board board = new Board();
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                board.setLetter(j, i, getLetter(j, i));
            }
        }

        return board;
    }
}
