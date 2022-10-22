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
    private List<Command> commands;
    private String input;

    public enum ValidWord {PASS, PLACE, CLEAR};

    public Parser() {
        commands = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    public void getInput(){
        input = scanner.nextLine();
    }

    public void CommandIsValid(){

    }

    public void CommandIsChosen(){


    }


}
