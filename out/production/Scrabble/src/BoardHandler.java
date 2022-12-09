import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BoardHandler extends DefaultHandler {

    private Board board;
    private String x;
    private String y;
    private String type;
    private String currentTag;

    public BoardHandler(Board board) {
        this.board = board;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTag.equals("x")) {
            x = new String(ch, start, length);
        }
        if (currentTag.equals("y")) {
            y = new String(ch, start, length);
        }
        if (currentTag.equals("type")) {
            type = new String(ch, start, length);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("BoardCell")){
            board.setType(Integer.parseInt(x), Integer.parseInt(y), Enum.valueOf(BoardCell.Type.class, type));
            x = null;
            y = null;
            type = null;
        }
        currentTag = "";
    }
}