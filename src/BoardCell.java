/**
 * 
 */
public class BoardCell {

    /**
     * 
     */
    private Character letter;

    /**
     * 
     */
    public BoardCell() {
        this.letter = null;
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
     * @param letter
     */
    public void setLetter(Character letter) {
        this.letter = letter;
    }

    /**
     * 
     * @return
     */
    public Boolean  hasLetter() {
        return letter != null;
    }
}
