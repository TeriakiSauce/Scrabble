import javax.swing.JLabel;

public class PlayPanelScorePlayer extends JLabel {

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer score;

    /**
     * 
     */
    public PlayPanelScorePlayer() {
        name = "Name Not Set";
        score = 0;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        updateText();
    }

    /**
     * 
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     */
    private void updateText() {
        setText(name + ": " + String.valueOf(score));
    }
}
