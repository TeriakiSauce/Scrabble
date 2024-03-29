import java.util.Arrays;
import java.io.Serializable;

/**
 * Represents the tiles for the player.
 * @author Andrew/Tarik
 * @version 1.0
 */
public class PlayerHand implements Serializable {

    /**
     * The tiles.
     */
    protected Character[] tiles;

    /**
     * Create new player hand.
     */
    public PlayerHand() {
        tiles = new Character[Config.HAND_SIZE];
    }

    /**
     * Set the letter at the index.
     * @param n The index.
     * @param letter THe letter.
     */
    public void setLetter(Integer n, Character letter) {
        if (n==(Config.HAND_SIZE-1)){
            tiles[n] = ' '; //blank tile
        }
        else {
            tiles[n] = letter;
        }
    }

    /**
     * Set the blank tile at the last index.
     * @param letter THe letter.
     */
    public void setBlankTile(Character letter) {
        tiles[Config.HAND_SIZE-1] = letter; //blank tile
    }

    /**
     * Clears the player's hand
     */
    public void clear(){
        for(int i = 0; i < Config.HAND_SIZE; i++){
            tiles[i] = null;
        }
    }
    /**
     * Get the letter at the index.
     * @param n The index.
     * @return The letter.
     */
    public Character getLetter(Integer n) {
        return tiles[n];
    }

    /**
     * Get the letters in the hand
     * @return The letters
     */
    public Character[] getLetters() {
        return tiles;
    }

    /**
     * Check if there is a letter at the position.
     * @param n The index.
     * @return If the letter exists at the position.
     */
    public Boolean hasLetter(Integer n) {
        return tiles[n] != null;
    }

    /**
     * Remove the letter at the position.
     * @param n The index.
     */
    public void removeLetter(Integer n) {
        assert(tiles[n] != null);
        tiles[n] = null;
    }

    /**
     * Remove the specified letter
     * @param c the letter
     */
    public void removeLetter(Character c) {
        int index = Arrays.asList(tiles).indexOf(c);
        if(index >=0) {
            tiles[index] = null;
        }
    }

    /**
     * Make a deep copy of the player hand.
     * @return The deep copy of the player hand.
     */
    public PlayerHand makeCopy() {
        PlayerHand hand = new PlayerHand();
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            hand.setLetter(i, getLetter(i));
        }

        return hand;
    }
    /**
     * Compares the hand with the specified hand.
     * @param o the hand to be compared.
     * @return true if hands are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHand that = (PlayerHand) o;
        return Arrays.equals(tiles, that.tiles);
    }
}
