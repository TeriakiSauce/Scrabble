import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */
public class LetterBag {

    /**
     * 
     */
    private List<Character> tiles;

    /**
     * 
     */
    private HashMap<Character, Integer> counts;

    /**
     * 
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
     * 
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
     * 
     * @param hand
     */
    void updateHand(PlayerHand hand) {
        for (Integer i = 0; i < Config.HAND_SIZE; i++) {
            if (!hand.hasLetter(i)) {
                hand.setLetter(i, getTile());
            }
        }
    }

    /**
     * 
     * @return
     */
    public Character getTile() {
        if (tiles.size() != 0) {
            return tiles.remove(0);
        }

        return null;
    }
}
