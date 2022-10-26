import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a players hand.
 * @author Andrew Sahadeo
 * @version 1.0
 */
public class Hand {

    private String playerName;

    //The Players Hand
    private LinkedList<Character> letters;

    /**
     * Constructs a new Hand and creates a list of letters
     * @param playerName the player's name
     */
    public Hand(String playerName){
        this.playerName = playerName;
        letters = new LinkedList<>();
    }

    /**
     * Adds a letter to the hand
     * @param letter the letter to be added
     */
    public void addLetter(Character letter){
        letters.add(letter);
    }

    /**
     * Removes a letter from the hand
     * @param letter the letter to be removed
     */
    public void removeLetter(Character letter){
         letters.remove(letter);
    }

    public int getSize(){
        return letters.size();
    }

    public boolean isEmpty() {
        return letters.isEmpty();
    }

    /**
     * Returns the player's name (will be used in milestone 2)
     * @return players' name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the hand's list of letters
     * @return hand's list of letters
     */
    public List getLetters(){
        return letters;
    }

    /**
     * Checks if the hand contains the passed letter
     * @param letter the letter to be checked
     * @return true if the hand contains the letter, false otherwise
     */
    public boolean checkLetter(char letter) {
        return letters.contains(letter);
    }
}
