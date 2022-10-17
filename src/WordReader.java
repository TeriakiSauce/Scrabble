/**
 * @author Jaan Soulier
 * @version 1.0
 */

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Reads all the words from a URL or file.
 */
public class WordReader 
{
    /**
     * Exception for word reading.
     */
    class WordReadingException extends RuntimeException
    {
        /**
         * Create new WordReadingException.
         */
        public WordReadingException()
        {
            super();
        }

        /**
         * Create new WordReadingException.
         * @param data Exception data.
         */
        public WordReadingException(String data)
        {
            super(data);
        }
    };

    /**
     * Backup location of words.
     */
    public static final String BACKUP = "words.txt";

    /**
     * Reader for reading words.
     */
    private BufferedReader reader;

    /**
     * Create new WordReader.
     * @param path URL to read words from.
     * @throws WordReadingException if word reading fails.
     */
    public WordReader(String path)
    {
        try
        {
            if (path == null)
            {
                throw new NullPointerException();
            }

            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (Exception outer)
        {
            try
            {
                reader = new BufferedReader(new FileReader(BACKUP));
            } catch (Exception inner)
            {
                throw new WordReadingException();
            }
        }
    }

    /**
     * Read next line from buffer.
     * @return The next word or null.
     */
    public String getLine()
    {
        try
        {
            return reader.readLine();
        } catch (Exception e)
        {
            return null;
        }
    }
}
