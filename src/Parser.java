package src;

import java.util.*;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

public class Parser {
    //scanner that will read the input
    Scanner scanner;
    //string variable to store the input
    private String input;
    //all the valid commands
    public enum ValidCommands {PLACE, PASS, QUIT};

    /**
     * Initializes Parser and scanner object
     */
    public Parser() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads the user input
     */
    public void readInputCommand(){
        input = scanner.nextLine();
    }

    /**
     * Returns the input string
     */
    public String getInput(){
        return input;
    }

    /**
     * Returns a string representation of all the valid commands
     */
    public String commandsString(){
        String string = "";
        for (ValidCommands word: ValidCommands.values()){
            string+= word + "    ";
        }
        return string;
    }

    /**
     * Checks that the command is valid
     * Returns true if it is and false otherwise
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
