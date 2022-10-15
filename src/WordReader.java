import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordReader 
{

    BufferedReader reader;


    WordReader(String path) 
    {

        try
        {

            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        } catch (Exception e)
        {
            // try reading from file here
        }

    }

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
