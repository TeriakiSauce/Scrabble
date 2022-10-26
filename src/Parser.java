
import java.util.*;

/**
 * This class deals with user input involving the commands
 * @author Tarik Beldjehem
 * @version 1.0
 */
public class Parser {
    //scanner that will read the input
    private Scanner scanner;
    //string variable to store the input
    private String input;
    //all the valid commands
    public enum ValidCommands {PLACE, PASS, QUIT};

    /**
     * Initializes Parser and scanner object
     * @author Tarik Beldjehem
     */
    public Parser() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads the user input
     * @author Tarik Beldjehem
     */
    public void readInputCommand(){
        input = scanner.nextLine();
    }

    /**
     * Returns the input string
     * @author Tarik Beldjehem
     * @return String input
     */
    public String getInput(){
        return input;
    }

    /**
     * Returns a string representation of all the valid commands
     * @author Tarik Beldjehem
     * @return String representation of Parser class
     */
    public String toString(){
        String string = "";
        for (ValidCommands word: ValidCommands.values()){
            string+= word + "    ";
        }
        return string;
    }

    /**
     * Checks that the command is valid
     * Returns true if it is and false otherwise
     * @author Tarik Beldjehem
     * @return boolean flag depending on command validity
     */
    public boolean commandIsValid(){
        for (ValidCommands word: ValidCommands.values()){
            if (input.equalsIgnoreCase(word.toString()))
            {
                return true;
            }
        }
        return false;
    }
}
