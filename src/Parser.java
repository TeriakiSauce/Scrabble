package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void getInputCommand(){
        input = scanner.nextLine();
    }

    public String ValidCommandsString(){
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

    public void CommandIsChosen(){


    }


}
