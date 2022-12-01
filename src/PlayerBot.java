import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a bot player which has AI to decide what move it will make.
 * @author Andrew
 * @version 1.0
 */
public class PlayerBot extends Player {

    enum DIFFICULTY {EASY, MEDIUM, HARD}

    ;

    private DIFFICULTY difficulty;

    private List<LetterChain> validPlays;
    private List<LetterChain> possibleWords;
    private List<LetterChain> currentWords;
    private List<String> handCombos;

    /**
     * @param name
     * @param game
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
        /*
        for (LetterCell cell : play.getCells()) {
            chain.addLetter(cell);
            board.setLetter(cell);
            newHand.removeLetter(cell.getLetter());
            super.placeBoard();
        }*/
        System.out.println(play);
        System.out.println(play.getScore());
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
                        vertChain.addLetter(new LetterCell(i, j, currentCell.getLetter()));
                        currentCell.setInVertChain(true);
                        while (currentCell.getSouthCell().hasLetter()) {
                            currentCell = currentCell.getSouthCell();
                            vertChain.addLetter(new LetterCell(currentCell.getX(), currentCell.getY(), currentCell.getLetter()));
                            currentCell.setInVertChain(true);
                        }
                        vertChain.setIsVertical(true);
                        currentWords.add(vertChain);
                    }
                    currentCell = cells[i][j];
                    if (!currentCell.isInHorizChain()) {
                        LetterChain horizChain = new LetterChain(game);
                        horizChain.addLetter(new LetterCell(i, j, currentCell.getLetter()));
                        currentCell.setInHorizChain(true);
                        while (currentCell.getEastCell().hasLetter()) {
                            currentCell = currentCell.getEastCell();
                            horizChain.addLetter(new LetterCell(currentCell.getX(), currentCell.getY(), currentCell.getLetter()));
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
        Character[] characters = {'a','b','c'};
        int subsets = (int) Math.pow(2, characters.length);
        for (int i = 1; i < subsets; i++) {
            String str = "";
            int temp = i;
            for (int j = characters.length - 1; j >= 0; --j) {
                int remainder = temp % 2;
                temp /= 2;
                if (remainder != 0) {
                    str = characters[j] + str;
                }
            }
            for (int j = characters.length - 1; j >= 0; --j) {
                int remainder = temp % 2;
                temp /= 2;
                if (remainder != 0) {
                    str = characters[j] + str;
                }
            }
            ArrayList<String> perms = getPermutations(str, "", new ArrayList<>());
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
                    LetterChain temp_chain = new LetterChain(game);
                    temp_chain.setIsVertical(chain.isVertical());
                    for (int j = 0; j < string.length(); j++) {
                        if (j < i) {
                            int[] coords = chain.getBeginning();
                            if (temp_chain.getSize() > 0) {
                                coords = temp_chain.getBeginning();
                            }
                            if (chain.isVertical()) {
                                if (!(game.getState().getBoard().hasLetter(coords[0], coords[1] - 1))) {
                                    temp_chain.addLetter(new LetterCell(coords[0], coords[1] - 1, string.charAt(j)));
                                    game.getState().getBoard().setLetter(new LetterCell(coords[0], coords[1] - 1, string.charAt(j)));
                                }
                            } else if (!(game.getState().getBoard().hasLetter(coords[0] - 1, coords[1]))) {
                                temp_chain.addLetter(new LetterCell(coords[0] - 1, coords[1], string.charAt(j)));
                                game.getState().getBoard().setLetter(new LetterCell(coords[0] - 1, coords[1], string.charAt(j)));
                            }
                        } else {
                            int[] coords = chain.getEnd();
                            if (temp_chain.getSize() > 0 && (i != j)) {
                                coords = temp_chain.getEnd();
                            }
                            if (chain.isVertical()) {
                                if (!(game.getState().getBoard().hasLetter(coords[0], coords[1] + 1))) {
                                    temp_chain.addLetter(new LetterCell(coords[0], coords[1] + 1, string.charAt(j)));
                                    game.getState().getBoard().setLetter(new LetterCell(coords[0], coords[1] + 1, string.charAt(j)));
                                }
                            } else if (!(game.getState().getBoard().hasLetter(coords[0] + 1, coords[1]))) {
                                temp_chain.addLetter(new LetterCell(coords[0] + 1, coords[1], string.charAt(j)));
                                game.getState().getBoard().setLetter(new LetterCell(coords[0], coords[1] + 1, string.charAt(j)));
                            }
                        }
                        temp_chain.sortChain();
                    }

                    if (temp_chain.getScore() > 0) {
                        //System.out.println(temp_chain);
                        //System.out.println(temp_chain.getScore());
                        validPlays.add(temp_chain);
                    }
                    game.getState().revert();
                }
            }
        }
    }

    public LetterChain choosePlay() {
        validPlays.sort(Comparator.comparingInt(LetterChain::getPlayValue));
        LetterChain bestPlay = validPlays.get(validPlays.size() - 1);
        //System.out.println(bestPlay.getScore());
        //System.out.println(bestPlay);
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
}