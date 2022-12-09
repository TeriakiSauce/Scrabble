import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

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
public class Board extends DefaultHandler implements Serializable {

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
                setNormalCells(i, j);
                setPinkPremiumCells(i, j);
                setRedPremiumCells(i, j);
                setCyanPremiumCells(i, j);
                setBluePremiumCells(i, j);
                setMiddleCell(i, j);
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
     * Get cell at specified position.
     * @param x The x position.
     * @param y The y position.
     * @return The cell.
     */
    public BoardCell getCell(Integer x, Integer y) {
        return cells[x][y];
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
     * Sets normal cells
     */
    public void setNormalCells(int x, int y){
        cells[x][y] = new BoardCell(x,y, BoardCell.Type.NORMAL);
    }

    /**
     * Sets red cells
     */
    public void setRedPremiumCells(int x, int y){
        //Set Premium 3x Word Score cell to Red
        int i;
        int j = 0;
        while (j < 15) {
            i = 0;
            while (i < 15) {
                if (x == i && y == j) {
                    cells[x][y] = new BoardCell(x,y, BoardCell.Type.RED);
                }
                i += 7;
            }
            j+=7;
        }
    }

    /**
     * Sets pink cells
     */
    public void setPinkPremiumCells(int x, int y) {
        //Set Premium 2x Word Score cell to Magenta
        int i = 0;
        int j = 15;
        while (i < 15) {
            j--;
            if (x == i && y == i) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.PINK);
            }
            if (x == i && y == j) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.PINK);
            }
            i++;
        }
    }

    /**
     * Sets cyan cells
     */
    public void setCyanPremiumCells(int x, int y) {
        //Set Premium 2x Letter Score cell to Cyan
        if (y == 0 || y == 7 || y == 14) {
            if (x == 3 || x == 11) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.CYAN);
            }
        } else if (y == 2 || y == 12) {
            if (x == 6 || x == 8) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.CYAN);
            }
        } else if (y == 3 || y == 11) {
            if (x == 0 || x == 7 || x == 14) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.CYAN);
            }
        } else if (y == 6 || y == 8) {
            if (x == 2 || x == 6 || x == 8 || x == 12) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.CYAN);
            }
        }
    }

    /**
     * Sets blue cells
     */
    public void setBluePremiumCells(int x, int y) {
        //Set Premium 2x Letter Score cell to Blue
        if (y == 1 || y == 13) {
            if (x == 5 || x == 9) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.BLUE);
            }
        } else if (y == 5 || y == 9) {
            if (x == 1 || x == 5 || x == 9 || x ==13) {
                cells[x][y] = new BoardCell(x,y, BoardCell.Type.BLUE);
            }
        }
    }

    /**
     * Sets middle cell
     */
    public void setMiddleCell(int x, int y){
        //Setting middle cell to light gray
        if(x == Config.BOARD_WIDTH/2 && y == Config.BOARD_HEIGHT/2){
            cells[x][y] = new BoardCell(x,y, BoardCell.Type.MIDDLE);
        }
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
                BoardCell boardCell = new BoardCell(j,i, getLetter(j,i));
                board.setLetter(boardCell);
            }
        }
        return board;
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

    public void importFromXml(String fileName) throws ParserConfigurationException, IOException, SAXException {
        BoardHandler handler = new BoardHandler(this);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser;

        try {
            parser = saxParserFactory.newSAXParser();

            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(fileName);
        } catch (Exception e) {
            System.out.println("Error in initializing parser");
        }
    }

    /**
     * Returns the board's cells
     * @return cells
     */
    public BoardCell[][] getCells() {
        return cells;
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
}
