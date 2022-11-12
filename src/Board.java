/**
 * 
 */
public class Board {

    /**
     * 
     */
    private BoardCell[][] cells;

    /**
     * 
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
     * 
     */
    public void clear() {
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i].setLetter(null);
            }
        }
    }

    /**
     * 
     * @param x
     * @param y
     * @param letter
     */
    public void setLetter(Integer x, Integer y, Character letter) {
        cells[x][y].setLetter(letter);
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public Character getLetter(Integer x, Integer y) {
        return cells[x][y].getLetter();
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public Boolean  hasLetter(Integer x, Integer y) {
        return cells[x][y].hasLetter();
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public void removeLetter(Integer x, Integer y) {
        cells[x][y].setLetter(null);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Boolean  isValid(Integer x, Integer y) {
        return x < Config.BOARD_WIDTH && y < Config.BOARD_HEIGHT;
    }

    /**
     * 
     * @return
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
