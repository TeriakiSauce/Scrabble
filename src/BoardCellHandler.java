import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BoardCellHandler extends DefaultHandler {

    private BoardCell cell;
    private String letter;
    private String x;
    private String y;
    private String type;
    private String inVertChain;
    private String inHorizChain;
    private String northCell;
    private String southCell;
    private String eastCell;
    private String westCell;
    private String currentTag;

    public BoardCellHandler(BoardCell cell) {
        this.cell = cell;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTag.equals("letter")) {
            letter = new String(ch, start, length);
        }
        if (currentTag.equals("x")) {
            x = new String(ch, start, length);
        }
        if (currentTag.equals("y")) {
            y = new String(ch, start, length);
        }
        if (currentTag.equals("type")) {
            type = new String(ch, start, length);
        }
        if (currentTag.equals("inVertChain")) {
            inVertChain = new String(ch, start, length);
        }
        if (currentTag.equals("inHorizChain")) {
            inHorizChain = new String(ch, start, length);
        }
        if (currentTag.equals("northCell")) {
            northCell = new String(ch, start, length);
        }
        if (currentTag.equals("southCell")) {
            southCell = new String(ch, start, length);
        }
        if (currentTag.equals("westCell")) {
            westCell = new String(ch, start, length);
        }
        if (currentTag.equals("eastCell")) {
            eastCell = new String(ch, start, length);
        }
    }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equals("BoardCell")){
                BoardCell temp = new BoardCell(Integer.parseInt(x), Integer.parseInt(y), letter.charAt(0), Enum.valueOf(BoardCell.Type.class, type));
                x = null;
                y = null;
                letter = null;
                type = null;
            }
            currentTag = "";
        }
    }
