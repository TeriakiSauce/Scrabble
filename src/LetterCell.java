/**
 * 
 */
public class LetterCell {

    /**
     * 
     */
    public Character letter;

    /**
     * 
     */
    public Integer x;

    /**
     * 
     */
    public Integer y;

    /**
     * 
     * @param x
     * @param y
     * @param letter
     */
    public LetterCell(Integer x, Integer y, Character letter) {
        this.letter = letter;
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return
     */
    public Character getLetter() {
        return letter;
    }

    /**
     * 
     * @return
     */
    public Integer getX() {
        return x;
    }

    /**
     * 
     * @return
     */
    public Integer getY() {
        return y;
    }
}
