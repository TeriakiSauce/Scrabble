/**
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class Board {
    //The array making the board
    private Cell[][] gameBoard;

    /**
     * Initializes the game board as a 2d array of Cells.
     * @param size the length/width of the square board.
     */
    public Board(int size){

        gameBoard = new Cell[size][size];

        //Loops through each location on the board and creates a cell there
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                gameBoard[i][j] = new Cell(i,j);
            }
        }
    }
}
