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
 * 
 */
public class WordReader 
{
    /**
     * 
     */
    public static final String BACKUP = "words.txt";

    /**
     * 
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
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        } catch (Exception net)
        {
            try
            {
                reader = new BufferedReader(new FileReader(BACKUP));
            } catch (Exception file)
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
