import java.util.Arrays;

/**
 * 
 */
public class PlayerHand {

    /**
     * 
     */
    protected Character[] tiles;

    /**
     * 
     */
    public PlayerHand() {
        tiles = new Character[Config.HAND_SIZE];
    }

    /**
     * 
     * @param n
     * @param letter
     */
    public void setLetter(Integer n, Character letter) {
        tiles[n] = letter;
    }

    /**
     * 
     * @param n
     * @return
     */
    public Character getLetter(Integer n) {
        return tiles[n];
    }

    /**
     * 
     * @param n
     * @return
     */
    public Boolean  hasLetter(Integer n) {
        return tiles[n] != null;
    }

    /**
     * 
     * @param n
     */
    public void removeLetter(Integer n) {
        assert(tiles[n] != null);
        tiles[n] = null;
    }

    /**
     * 
     * @return
     */
    public PlayerHand makeCopy() {
        PlayerHand hand = new PlayerHand();
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            hand.setLetter(i, getLetter(i));
        }

        return hand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHand that = (PlayerHand) o;
        return Arrays.equals(tiles, that.tiles);
    }

}
