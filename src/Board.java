import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Arrays;

/**
 * Represents all the cells in the game. Allows for the setting, getting,
 * clearing, and checking of letters in the board.
 * @author Andrew/Tarik
 * @version 1.1
 */
public class Board implements Serializable {

    /**
     * 2D array of cells.
     */
    private BoardCell[][] cells;

    /**
     * Create new board.
     */
    public Board() {
        cells = new BoardCell[Config.BOARD_WIDTH][Config.BOARD_HEIGHT];
        for (int i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (int j = 0; j < Config.BOARD_WIDTH; j++) {
                setNormalCells(i, j);
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
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                cells[j][i].setLetter(null);
            }
        }
    }

    /**
     * Set letter at specified position.
     * @param cell The cell being set
     */
    public void setLetter(BoardCell cell) {
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
        if(isValid(x,y)){
            return cells[x][y].hasLetter();
        }
        return false;
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
     * Sets normal cells
     */
    public void setNormalCells(int x, int y){
        cells[x][y] = new BoardCell(x,y, BoardCell.Type.NORMAL);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public BoardCell.Type getType(int x, int y) {
        return cells[x][y].getType();
    }

    /**
     *
     * @param x
     * @param y
     * @param type
     */
    public void setType(int x, int y, BoardCell.Type type) {
        cells[x][y].setType(type);
    }

    /**
     * Check if position is valid.
     * @param x The x position.
     * @param y The y position.
     * @return If position is valid.
     */
    public Boolean isValid(Integer x, Integer y) {
        return x < Config.BOARD_WIDTH && x > -1 && y < Config.BOARD_HEIGHT && y > -1;
    }

    /**
     * Make a deep copy of the board.
     * @return Board deep copy.
     */
    public Board makeCopy() {
        Board board = new Board();
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                BoardCell boardCell = new BoardCell(j,i, getLetter(j,i));
                board.setLetter(boardCell);
            }
        }
        return board;
    }

    /**
     * Returns the board's cells
     * @return cells
     */
    public BoardCell[][] getCells() {
        return cells;
    }

    public String toXML(){
        String str = "<Board>\n";
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                str+= cells[i][j].toXML();
            }
        }
        str+= "</Board>\n";
        return str;
    }

    public void exportToXML(String fileName){
        try{
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write(toXML().getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importFromXml(InputStream is) throws ParserConfigurationException, IOException, SAXException {
        BoardHandler handler = new BoardHandler(this);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser;

        try {
            parser = saxParserFactory.newSAXParser();
            parser.parse(new InputSource(is), handler);
        } catch (Exception e) {
            System.out.println("Error in initializing parser: " + e);
        }
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

    public String toString(){
        String result = "";
        // For some reason this breaks the game
        /**for (int count = 0; 0 < size; count++){
         result += count + " ";
         }*/
        result += "  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14";

        for (int i = 0; i < 15 ; i++){
            result += "\n" + i;
            for (int j = 0; j< 15; j++){
                result += cells[j][i] +"";
            }
        }
        return result;
    }

    public void removeTempLetters() {
        for (int i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (int j = 0; j < Config.BOARD_WIDTH; j++) {
                if (cells[i][j].isLower()) {
                    cells[i][j].setLetter(null);
                }
            }
        }
    }
}
