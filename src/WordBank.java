/**
 * @author Jaan Soulier
 * @version 1.0
 */

import java.util.HashSet;
import java.util.HashMap;

/**
 * 
 */
public class WordBank
{
    /**
     * 
     */
    private HashSet<Integer> hashedWords = new HashSet<>();

    /**
     * 
     */
    private HashMap<Character, Integer> letterValues = new HashMap<>();

    /**
     * @param path
     */
    WordBank(String path)
    {
        String line;
        WordReader reader = new WordReader(path);

        while ((line = reader.getLine()) != null) 
        {
            hashedWords.add(line.hashCode());
        }

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
     * 
     * @param word
     * @return
     */
    public boolean isWordValid(String word)
    {
        if (word == null)
        {
            throw new NullPointerException();
        }

        return hashedWords.contains(word.hashCode());
    }

    /**
     * 
     * @param letter
     * @return
     */
    public int getLetterValue(Character letter)
    {
        return letterValues.get(letter).intValue();
    }

    /**
     * 
     * @param word
     * @return
     */
    public int getWordValue(String word)
    {
        if (word == null)
        {
            throw new NullPointerException();
        }

        int total = 0;
        for (Character letter : word.toCharArray())
        {
            total += getLetterValue(letter);
        }

        return total;
    }
}