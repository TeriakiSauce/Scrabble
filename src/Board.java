import java.util.List;

/**
 * This class represents the game board.
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class Board {
    //The array making the board
    private Cell[][] gameBoard;
    //List of all available tiles
    private TileList tiles;
    //The player's hand
    private Hand player1Hand;
    //Size of the board
    private int size;
    //To be implemented in milestone 2
    //private Hand player2Hand;

    /**
     * Initializes the game board as a 2d array of Cells.
     * @param size the length/width of the square board.
     */
    public Board(int size){

        this.size = size;
        gameBoard = new Cell[size +'a'][size];
        tiles = new TileList();

        player1Hand = new Hand("Player 1");
        //player2Hand = new Hand("Player 2");

        //Fill the player's hands
        populateHand();
        //populateHand(player2Hand, tiles);

        //Loops through each location on the board and creates a cell there
        for (char i = 'a'; i< size + 'a'; i++){
            for (int j = 0; j<size; j++){
                gameBoard[i][j] = new Cell(i,j);
            }
        }
        //To be implemented in Milestone 2
        /**
        //Loops through the board and initializes cell with their adjacent cells
        for (char i = 'a'; i< size + 'a'; i++){
            for (int j = 0; j<size; j++){
                if (j+1<size){gameBoard[i][j].setUp(gameBoard[i][j+1]);}
                if (j>0){gameBoard[i][j].setDown(gameBoard[i][j-1]);}
                if (i+1<size+'a'){gameBoard[i][j].setRight(gameBoard[i+1][j]);}
                if (i>'a'){gameBoard[i][j].setLeft(gameBoard[i-1][j]);}
            }
        }
         */
    }

    /**
     * Places a letter on the game board.
     * @param letter The letter being placed
     * @param x The x coordinate of the letter
     * @param y The y coordinate of the letter
     */
    public void placeLetter(char letter, int x, int y){
        gameBoard[x][y].setLetter(letter);
        player1Hand.removeLetter(letter);
    }

    /**
     * Fills up the player's hand with the available tiles
     */
    public void populateHand(){
        while (player1Hand.getSize() < 7){
            player1Hand.addLetter(tiles.grabTile());
        }
    }

    /**
     * Checks if the passed letter is in the player's hand
     * @param letter The character being checked
     * @return true if the letter is in the player's hand, false otherwise
     */
    public boolean checkHand(char letter){
        return player1Hand.checkLetter(letter);
    }

    /**
     * Checks if the player's hand is empty
     * @return true if the hand is empty, false otherwise
     */
    public boolean isHandEmpty(){
        return player1Hand.getLetters().size() == 0;
    }

    /**
     * Checks if the cell at x, y is empty
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(int x, int y){
        return gameBoard[x][y].getLetter() == ' ';
    }

    /**
     * Returns the string of the tiles in a player's hand
     * @return the string of the tiles in a player's hand
     */
    public String printHand(){
        return "" + player1Hand.getLetters();
    }

    /**
     * Checks whether the x and y variables are within the game board
     * @param x x coordinate
     * @param y y coordinate
     * @return true if the coordinate is within the board, false otherwise
     */
    public boolean isCordValid(int x, int y){
        return 'a' <= x && x < 'a' + size && y >= 0 && y < size;
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String toString(){
        String result = "";
        // For some reason this breaks the game
        /**for (int count = 0; 0 < size; count++){
            result += count + " ";
        }*/
        result += "  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14";

        for (char i = 'a'; i < size + 'a'; i++){
            result += "\n" + i;
            for (int j = 0; j<size; j++){
                result += gameBoard[i][j] +"";
            }
        }
        return result;
    }

}
