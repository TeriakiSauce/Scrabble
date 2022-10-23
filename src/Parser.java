package src;

import java.util.*;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

public class Parser {

    Scanner scanner;
    private String input;

    public enum ValidCommands {PLACE, PASS, CLEAR, QUIT};

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public void readInputCommand(){
        input = scanner.nextLine();
    }

    public String getInput(){
        return input;
    }

    public String CommandsString(){
        String string = "";
        for (ValidCommands word: ValidCommands.values()){
            string+= word + "    ";
        }
        return string;
    }

    public boolean CommandIsValid(){
        for (ValidCommands word: ValidCommands.values()){
            if (input.equalsIgnoreCase(word.toString()))
            {
                return true;
            }
        }
        return false;
    }
}
