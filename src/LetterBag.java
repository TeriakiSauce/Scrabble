import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the bag (the source for the remaining letters used throughout the game). Provides
 * a method for populating a player hand, to refill the player's tiles.
 * @author Andrew
 * @version 1.1
 */
public class LetterBag {

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
            put('A', Config.A_COUNT);
            put('B', Config.B_COUNT);
            put('C', Config.C_COUNT);
            put('D', Config.D_COUNT);
            put('E', Config.E_COUNT);
            put('F', Config.F_COUNT);
            put('G', Config.G_COUNT);
            put('H', Config.H_COUNT);
            put('I', Config.I_COUNT);
            put('J', Config.J_COUNT);
            put('K', Config.K_COUNT);
            put('L', Config.L_COUNT);
            put('M', Config.M_COUNT);
            put('N', Config.N_COUNT);
            put('O', Config.O_COUNT);
            put('P', Config.P_COUNT);
            put('Q', Config.Q_COUNT);
            put('R', Config.R_COUNT);
            put('S', Config.S_COUNT);
            put('T', Config.T_COUNT);
            put('U', Config.U_COUNT);
            put('V', Config.V_COUNT);
            put('W', Config.W_COUNT);
            put('X', Config.X_COUNT);
            put('Y', Config.Y_COUNT);
            put('Z', Config.Z_COUNT);
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
