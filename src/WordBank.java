import java.util.HashSet;
import java.util.HashMap;

/**
 * Stores all the valid words and provides queries for the words.
 * @author Jaan Soulier
 * @version 1.0
 */
public class WordBank
{
    /**
     * Exception for word not existing.
     * @author Jaan Soulier
     * @version 1.0
     */
    public class WordNotFoundException extends RuntimeException
    {
        /**
         * Create new WordNotFoundException.
         * @author Jaan Soulier
         * @version 1.0
         */
        public WordNotFoundException()
        {
            super();
        }

        /**
         * Create new WordNotFoundException.
         * @param data Exception data.
         * @author Jaan Soulier
         * @version 1.0
         */
        public WordNotFoundException(String data)
        {
            super(data);
        }
    };

    /**
     * Hashes of all the words to save memory.
     */
    private HashSet<Integer> hashedWords = new HashSet<>();

    /**
     * Values of all the letters in the alphabet.
     */
    private HashMap<Character, Integer> letterValues = new HashMap<>();

    /**
     * Create new WordBank.
     * @param path URL to read words from.
     * @throws WordReadingException if word reading fails.
     * @author Jaan Soulier
     * @version 1.0
     */
    public WordBank(String path)
    {
        // read words from URL or file
        String line;
        WordReader reader = new WordReader(path);

        // add hash codes of words to valid words
        while ((line = reader.getLine()) != null)
        {
            hashedWords.add(line.hashCode());
        }

        // TODO: should this be configurable?
        // add values of letters to letter values
        letterValues.put('E', 1);
        letterValues.put('A', 1);
        letterValues.put('I', 1);
        letterValues.put('O', 1);
        letterValues.put('N', 1);
        letterValues.put('R', 1);
        letterValues.put('T', 1);
        letterValues.put('L', 1);
        letterValues.put('S', 1);
        letterValues.put('U', 1);
        letterValues.put('D', 2);
        letterValues.put('G', 2);
        letterValues.put('B', 3);
        letterValues.put('C', 3);
        letterValues.put('M', 3);
        letterValues.put('P', 3);
        letterValues.put('F', 4);
        letterValues.put('H', 4);
        letterValues.put('V', 4);
        letterValues.put('W', 4);
        letterValues.put('Y', 4);
        letterValues.put('K', 5);
        letterValues.put('J', 8);
        letterValues.put('X', 8);
        letterValues.put('Q', 10);
        letterValues.put('Z', 10);
    }

    /**
     * Check if a word is valid.
     * @param word Word to query.
     * @throws NullPointerException if word is null.
     * @return If the word is valid or not.
     * @author Jaan Soulier
     * @version 1.0
     */
    public boolean isWordValid(String word)
    {
        // we can't accept null words
        if (word == null)
        {
            throw new NullPointerException();
        }

        // return if the valid words contains the word hash
        return hashedWords.contains(word.hashCode());
    }

    /**
     * Check the value of the letter.
     * @param letter Letter to query.
     * @throws NullPointerException if letter is null.
     * @throws NullPointerException if letter is invalid.
     * @return The value of the letter.
     * @author Jaan Soulier
     * @version 1.0
     */
    public int getLetterValue(Character letter)
    {
        // we can't accept null letters
        if (letter == null)
        {
            throw new NullPointerException();
        }

        // return the value of the letter in the letter values
        return letterValues.get(Character.toUpperCase(letter)).intValue();
    }

    /**
     * Check the value of the word.
     * @param word Word to query.
     * @throws NullPointerException if word is null.
     * @throws WordNotFoundException if word is invalid.
     * @return The value of the word.
     * @author Jaan Soulier
     * @version 1.0
     */
    public int getWordValue(String word)
    {
        // we can't accept invalid words
        if (!isWordValid(word))
        {
            throw new WordNotFoundException();
        }

        // iterate over letters and add value to total
        int total = 0;
        for (Character letter : word.toCharArray())
        {
            total += getLetterValue(letter);
        }

        return total;
    }
}