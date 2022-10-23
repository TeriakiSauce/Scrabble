import java.util.ArrayList;
import java.util.List;

/**
 * Represents a players hand.
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class Hand {

    private String playerName;

    //The Players Hand
    private List<Character> letters;

    public Hand(String playerName){
        this.playerName = playerName;
        letters = new ArrayList<>();
    }
    public void addLetter(Character letter){
        letters.add(letter);
    }
    public int getSize(){
        return letters.size();
    }

    /**
     * Returns the player's name
     * @return players' name
     */
    public String getPlayerName() {
        return playerName;
    }
}
