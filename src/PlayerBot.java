import java.util.*;
import java.io.Serializable;

/**
 * Represents a bot player which has AI to decide what move it will make.
 * @author Andrew
 * @version 1.0
 */
public class PlayerBot extends Player implements Serializable {

    enum DIFFICULTY {EASY, MEDIUM, HARD};

    private DIFFICULTY difficulty;

    private List<LetterChain> validPlays;
    private List<LetterChain> possibleWords;
    private List<LetterChain> currentWords;
    private List<String> handCombos;

    /**
     * @param name name of player
     * @param game game it's part of
     */
    public PlayerBot(String name, Game game) {
        super(name, game);

        possibleWords = new LinkedList<LetterChain>();
        validPlays = new LinkedList<LetterChain>();
        currentWords = new LinkedList<LetterChain>();
        handCombos = new ArrayList<String>();

    }


    /**
     *
     */
    @Override
    public void placeBoard() {
        State state = game.getState();
        Board board = state.getBoard();
        LetterChain chain = state.getChain();
        collectBoardWords();
        findHandCombos();
        calculatePossiblePoints();
        LetterChain play = choosePlay();
        for (BoardCell cell : play.getCells()) {
            cell.toUpperCase();
            newHand.removeLetter(cell.getLetter());
            board.setLetter(cell);
            chain.addLetter(cell);
            super.placeBoard();
        }
        validPlays.clear();
        handCombos.clear();

        System.out.println(chain);
        System.out.println(chain.getScore());
    }


    /**
     * Loops through the board and adds all the words that can be played on by the AI to currentWords.
     */
    public void collectBoardWords() {
        Board board = game.getState().getBoard();
        BoardCell[][] cells = board.getCells();
        for (Integer i = 0; i < Config.BOARD_HEIGHT; i++) {
            for (Integer j = 0; j < Config.BOARD_WIDTH; j++) {
                BoardCell currentCell = cells[i][j];
                if (currentCell.hasLetter()) {
                    if (!currentCell.isInVertChain()) {
                        LetterChain vertChain = new LetterChain(game);
                        vertChain.addLetter(currentCell);
                        currentCell.setInVertChain(true);
                        while (currentCell.getSouthCell() != null && currentCell.getSouthCell().hasLetter()) {
                            currentCell = currentCell.getSouthCell();
                            vertChain.addLetter(currentCell);
                            currentCell.setInVertChain(true);
                        }
                        vertChain.setIsVertical(true);
                        currentWords.add(vertChain);
                    }
                    currentCell = cells[i][j];
                    if (!currentCell.isInHorizChain()) {
                        LetterChain horizChain = new LetterChain(game);
                        horizChain.addLetter(currentCell);
                        currentCell.setInHorizChain(true);
                        while (currentCell.getEastCell() != null && currentCell.getEastCell().hasLetter()) {
                            currentCell = currentCell.getEastCell();
                            horizChain.addLetter(currentCell);
                            currentCell.setInHorizChain(true);
                        }
                        horizChain.setIsVertical(false);
                        currentWords.add(horizChain);
                    }
                }
            }
        }
    }

    /**
     * Returns a list of all possible combinations of the player's cards in their hand.
     */
    public void findHandCombos() {
        //Converting the array of Characters to array of chars
        Character[] handValues = newHand.getLetters();
        char[] characters = new char[Config.HAND_SIZE-1];
        for(int i = 0; i < Config.HAND_SIZE-1; i++){
            characters[i] = Character.toLowerCase(handValues[i]);
        }
        System.out.println(characters);
        int subsets = (int) Math.pow(2, characters.length);
        for (int i = 1; i < subsets; i++) {
            StringBuilder str = new StringBuilder();
            int temp = i;
            for (int j = characters.length - 1; j >= 0; --j) {
                int remainder = temp % 2;
                temp /= 2;
                if (remainder != 0) {
                    str.insert(0, characters[j]);
                }
            }
            for (int j = characters.length - 1; j >= 0; --j) {
                int remainder = temp % 2;
                temp /= 2;
                if (remainder != 0) {
                    str.insert(0, characters[j]);
                }
            }
            ArrayList<String> perms = getPermutations(str.toString(), "", new ArrayList<>());
            for (String string : perms) {
                if (!handCombos.contains(string)) {
                    handCombos.add(string);
                }
            }
        }
    }

    /**
     * Helper function that returns all permutations of a string
     *
     * @param str ex: "abb"
     * @return ex: "abb bab bba"
     */
    private ArrayList<String> getPermutations(String str, String ans, ArrayList<String> perms) {
        //base case
        if (str.length() == 0) {
            // add ans to arraylist
            perms.add(ans);
            return perms;
        }
        // Make a boolean value for each letter in the alphabet
        boolean[] alphabet = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            str = str.toLowerCase();
            char chr = str.charAt(i);

            // The string excluding the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Calls recursive call if the character hasn't already been used
            if (!alphabet[chr - 'a'])
                getPermutations(ros, ans + chr, perms);
            alphabet[chr - 'a'] = true;
        }
        return perms;
    }


    public void calculatePossiblePoints() {
        for (LetterChain chain : currentWords) {
            for (String string : handCombos) {
                for (int i = 0; i < string.length() + 1; i++) {
                    Board board = game.getState().getBoard();
                    LetterChain temp_chain = new LetterChain(game);
                    temp_chain.setIsVertical(chain.isVertical());
                    for (int j = 0; j < string.length(); j++) {
                        if (j < i) {
                            int[] coords = chain.getBeginning();
                            if (temp_chain.getSize() > 0) {
                                coords = temp_chain.getBeginning();
                            }
                            if (chain.isVertical()) {
                                if (isEmptySpace(coords[0], coords[1] - 1)) {
                                    temp_chain.addLetter(new BoardCell(coords[0], coords[1] - 1, string.charAt(j)));
                                    board.setLetter(new BoardCell(coords[0], coords[1] - 1, string.charAt(j)));
                                }
                            } else if (isEmptySpace(coords[0] - 1, coords[1])) {
                                temp_chain.addLetter(new BoardCell(coords[0] - 1, coords[1],string.charAt(j)));
                                board.setLetter(new BoardCell(coords[0] - 1, coords[1], string.charAt(j)));
                            }
                        } else {
                            int[] coords = chain.getEnd();
                            if (temp_chain.getSize() > 0 && (i != j)) {
                                coords = temp_chain.getEnd();
                            }
                            if (chain.isVertical()) {
                                if (isEmptySpace(coords[0], coords[1] + 1)) {
                                    temp_chain.addLetter(new BoardCell(coords[0], coords[1] + 1, string.charAt(j)));
                                    board.setLetter(new BoardCell(coords[0], coords[1] + 1, string.charAt(j)));
                                }
                            } else if (isEmptySpace(coords[0] + 1, coords[1])) {
                                temp_chain.addLetter(new BoardCell(coords[0] + 1, coords[1], string.charAt(j)));
                                board.setLetter(new BoardCell(coords[0] + 1, coords[1], string.charAt(j)));
                            }
                        }
                        temp_chain.sortChain();
                    }
                    if (temp_chain.getScore() > 0) {
                        validPlays.add(temp_chain);
                        //System.out.println(temp_chain);
                        //System.out.println(temp_chain.getScore());
                    }
                    board.removeTempLetters();
                }
            }
        }
    }

    private boolean isEmptySpace(int x, int y){
        Board board = game.getState().getBoard();
        return !(board.hasLetter(x, y)) && board.isValid(x, y);
    }

    public LetterChain choosePlay() {
        validPlays.sort(Comparator.comparingInt(LetterChain::getPlayValue));
        if(validPlays.size() == 0){
            return new LetterChain(game);
        }
        LetterChain bestPlay = validPlays.get(validPlays.size() - 1);

        return bestPlay;
    }

    /**
     * Returns current words on the board
     *
     * @return list of current words
     */
    public List<LetterChain> getCurrentWords() {
        return currentWords;
    }

    /**
     * Returns all permutations of a player's hand
     *
     * @return combos of letters in hand
     */
    public List<String> getHandCombos() {
        return handCombos;
    }

    public List<LetterChain> getValidWords(){return validPlays;}
}