package src;

/**
 * @author Tarik Beldjehem
 * @version 1.0
 */

import java.util.*;

public class Game {

    List<Command> commands;
    boolean quit;
    Scanner scanner;

    public Game() {
        commands = new ArrayList<>();
        scanner = new Scanner(System.in);
        quit = false;

        Play();
    }

    public void startMessage(){
        System.out.println("Welcome to Scrabble!");
        System.out.println("Choose a command");


    }

    public void Play(){
        while(!quit) {
            startMessage();
            scanner.nextLine();
        }
    }

    private void Place(){
        return;
    }

    private void Pass(){
        return;
    }

    private void Clear(){
        return;
    }

    public static void main(String[] args) {
        Game game = new Game();


    }

}
