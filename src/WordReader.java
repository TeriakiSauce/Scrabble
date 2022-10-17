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
 * Provides abstraction layer for fetching words from either a local file or a url.
 */
public class WordReader 
{
    /**
     * Relative location for the local words backup file.
     */
    public static final String BACKUP = "words.txt";

    /**
     * Reader for writing either a local file or url data into for reading later.
     */
    private BufferedReader reader;

    /**
     * 
     * @param path 
     */
    WordReader(String path)
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
                throw new AssertionError();
            }
        }
    }

    /**
     * 
     * @return
     */
    String getLine()
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
