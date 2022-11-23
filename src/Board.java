import java.util.Arrays;

/**
 * Represents all the cells in the game. Allows for the setting, getting,
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
                cells[i][j] = new BoardCell(i,j);
            }
        }
        init_adj();
        clear();
    }

    private void init_adj(){
        for (int i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (int j = 0; j < Config.BOARD_WIDTH; j++) {
                if(j-1 > 0){
                    cells[i][j].setNorthCell(cells[i][j-1]);
                }
                if(j+1 < Config.BOARD_HEIGHT){
                    cells[i][j].setSouthCell(cells[i][j+1]);
                }
                if(i-1 > 0){
                    cells[i][j].setWestCell(cells[i-1][j]);
                }
                if(i+1 < Config.BOARD_WIDTH){
                    cells[i][j].setEastCell(cells[i+1][j]);
                }
            }
        }
    }

    /**
     * Clear the board.
     */
    public void clear() {
        for (int i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (int j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[i][j].setLetter(null);
            }
        }
    }

    /**
     * Set letter at specified position.
     * @param cell The cell being set
     */
    public void setLetter(LetterCell cell) {
        cells[cell.getX()][cell.getY()].setLetter(cell.getLetter());
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
                board.setLetter(new LetterCell(j,i, getLetter(j,i)));
            }
        }

        return board;
    }
    /**
     * Compares this board with the specified board.
     * @param o the board to be compared.
     * @return true if the boards are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.deepEquals(cells, board.cells);
    }

    /**
     * Returns the board's cells
     * @return cells
     */
    public BoardCell[][] getCells() {
        return cells;
    }
}
