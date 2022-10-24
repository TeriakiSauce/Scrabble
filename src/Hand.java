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
    private ArrayList<Character> letters;

    public Hand(String playerName){
        this.playerName = playerName;
        letters = new ArrayList<>();
    }
    public void addLetter(Character letter){
        letters.add(letter);
    }
    public boolean removeLetter(Character letter){
         return letters.remove(letter);
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

    public List getLetters(){
        return letters;
    }

    public boolean checkLetter(char letter) {
        return letters.contains(letter);
    }
}
