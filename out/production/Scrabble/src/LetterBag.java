import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

/**
 * Represents the bag (the source for the remaining letters used throughout the game). Provides
 * a method for populating a player hand, to refill the player's tiles.
 * @author Andrew
 * @version 1.1
 */
public class LetterBag implements Serializable {

    /**
     * The list of remaining tiles.
     */
    private List<Character> tiles;

    /**
     * The number of tiles per character.
     */
    private HashMap<Character, Integer> counts;

    /**
     * Create a new letter bag.
     */
    public LetterBag() {
        tiles = new LinkedList<>();
        counts = new HashMap<>() {{
            put('A', Config.A_COUNT*10);
            put('B', Config.B_COUNT*10);
            put('C', Config.C_COUNT*10);
            put('D', Config.D_COUNT*10);
            put('E', Config.E_COUNT*10);
            put('F', Config.F_COUNT*10);
            put('G', Config.G_COUNT*10);
            put('H', Config.H_COUNT*10);
            put('I', Config.I_COUNT*10);
            put('J', Config.J_COUNT*10);
            put('K', Config.K_COUNT*10);
            put('L', Config.L_COUNT*10);
            put('M', Config.M_COUNT*10);
            put('N', Config.N_COUNT*10);
            put('O', Config.O_COUNT*10);
            put('P', Config.P_COUNT*10);
            put('Q', Config.Q_COUNT*10);
            put('R', Config.R_COUNT*10);
            put('S', Config.S_COUNT*10);
            put('T', Config.T_COUNT*10);
            put('U', Config.U_COUNT*10);
            put('V', Config.V_COUNT*10);
            put('W', Config.W_COUNT*10);
            put('X', Config.X_COUNT*10);
            put('Y', Config.Y_COUNT*10);
            put('Z', Config.Z_COUNT*10);
        }};

        reset();
    }

    /**
     * Repopulate the tiles.
     */
    public void reset() {
        tiles.clear();

        for (Character character : counts.keySet()) {
            Integer count = counts.get(character);
            for (Integer i = 0; i < count; i++) {
                tiles.add(character);
            }
        }

        Collections.shuffle(tiles);
    }

    /**
     * Repopulate the player hand.
     * @param hand The player hand.
     */
    void updateHand(PlayerHand hand) {
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            if (!hand.hasLetter(i)) {
                hand.setLetter(i, getTile());
            }
        }
    }

    /**
     * Get a tile from the remaining tiles. If no tiles remain,
     * return null. Decrements the tile count.
     * @return The tile.
     */
    public Character getTile() {
        if (tiles.size() != 0) {
            return tiles.remove(0);
        }

        return null;
    }
}
