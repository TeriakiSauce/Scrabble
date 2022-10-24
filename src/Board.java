import java.util.List;

/**
 * This class represents the game board.
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class Board {
    //The array making the board
    private Cell[][] gameBoard;
    private TileList tiles;
    private Hand player1Hand;
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
        populateHand(player1Hand, tiles);
        //populateHand(player2Hand, tiles);

        //Loops through each location on the board and creates a cell there
        for (char i = 'a'; i< size + 'a'; i++){
            for (int j = 0; j<size; j++){
                gameBoard[i][j] = new Cell(i,j);
            }
        }
        //Loops through the board and initializes cell with their adjacent cells
        for (char i = 'a'; i< size + 'a'; i++){
            for (int j = 0; j<size; j++){
                if (j+1<size){gameBoard[i][j].setUp(gameBoard[i][j+1]);}
                if (j>0){gameBoard[i][j].setDown(gameBoard[i][j-1]);}
                if (i+1<size+'a'){gameBoard[i][j].setRight(gameBoard[i+1][j]);}
                if (i>'a'){gameBoard[i][j].setLeft(gameBoard[i-1][j]);}
            }
        }
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

    public void populateHand(Hand hand, TileList tiles){
        while (hand.getSize() < 5){
            hand.addLetter(tiles.grabTile());
        }
    }
    public boolean checkHand(char letter){
        return player1Hand.checkLetter(letter);
    }
    public boolean isHandEmpty(){
        return player1Hand.getLetters().size() == 0;
    }

    public boolean isCellEmpty(int x, int y){
        return gameBoard[x][y].getLetter() == ' ';
    }
    public String printHand(){
        return "" + player1Hand.getLetters();
    }
    public boolean isCordValid(int x, int y){
        return 'a' <= x && x < 'a' + size && y >= 0 && y < size;
    }
    public String toString(){
        String result = "";
        for (char i = 'a'; i< size + 'a'; i++){
            result += "\n";
            for (int j = 0; j<size; j++){
                result += gameBoard[i][j] +"";
            }
        }
        return result;
    }
}
