package src;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

public abstract class Command {

    private String word;

    public Command(){
        word = "";
    }
    public Command(String input) {
        word = input;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void doCommand(){

    }
}
