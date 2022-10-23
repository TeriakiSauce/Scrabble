import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Represents all the game's letters
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class TileList{

    //List of all available tiles
    private List<Character> tiles;

    /**
     * Creates list and populates according to scrabble rules.
     */
    public TileList(){

        tiles = new ArrayList<>();

        for (int i=0; i<9; i++){
            tiles.add('a');
        }
        for (int i=0; i<2; i++){
            tiles.add('b');
        }
        for (int i=0; i<2; i++){
            tiles.add('c');
        }
        for (int i=0; i<4; i++){
            tiles.add('d');
        }
        for (int i=0; i<12; i++){
            tiles.add('e');
        }
        for (int i=0; i<2; i++){
            tiles.add('f');
        }
        for (int i=0; i<3; i++){
            tiles.add('g');
        }
        for (int i=0; i<2; i++){
            tiles.add('h');
        }
        for (int i=0; i<9; i++){
            tiles.add('i');
        }
        tiles.add('j');

        tiles.add('k');

        for (int i=0; i<4; i++){
            tiles.add('l');
        }
        for (int i=0; i<2; i++){
            tiles.add('m');
        }
        for (int i=0; i<6; i++){
            tiles.add('n');
        }
        for (int i=0; i<8; i++){
            tiles.add('o');
        }
        for (int i=0; i<2; i++){
            tiles.add('p');
        }
        tiles.add('q');

        for (int i=0; i<6; i++){
            tiles.add('r');
        }
        for (int i=0; i<4; i++){
            tiles.add('s');
        }
        for (int i=0; i<6; i++){
            tiles.add('t');
        }
        for (int i=0; i<4; i++){
            tiles.add('u');
        }
        for (int i=0; i<2; i++){
            tiles.add('v');
        }
        for (int i=0; i<2; i++){
            tiles.add('w');
        }
        tiles.add('x');
        for (int i=0; i<2; i++){
            tiles.add('y');
        }
        tiles.add('z');
    }

    /**
     * Removes and returns a random tile.
     * @return A random tile from the list
     */
    public Character grabTile(){
        Collections.shuffle(tiles);
        return tiles.remove(0);
    }
    public int getSize(){
        return tiles.size();
    }
}