import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @author Jaan Soulier
 * Reads all the words from a URL or file.
 * @author Jaan Soulier
 * @version 1.0
 */
public class WordReader {
    /**
     * @author Jaan Soulier
     * Exception for word reading.
     * @author Jaan Soulier
     * @version 1.0
     */
    public class WordReadingException extends RuntimeException {
        /**
         * @author Jaan Soulier
         * Create new WordReadingException.
         * @author Jaan Soulier
         * @version 1.0
         */
        public WordReadingException() {
            super();
        }

        /**
         * @author Jaan Soulier
         * Create new WordReadingException.
         * @param data Exception data.
         * @author Jaan Soulier
         * @version 1.0
         */
        public WordReadingException(String data) {
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
     * @author Jaan Soulier
     * Create new WordReader.
     * @param path URL to read words from.
     * @throws WordReadingException if word reading fails.
     * @author Jaan Soulier
     * @version 1.0
     */
    public WordReader(String path) {
        try {
            // if there is no URL, throw and try to read from file
            if (path == null) {
                throw new NullPointerException();
            }

            // read from URL into a buffered reader. if this fails, read from file
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (Exception outer) {
            try {
                // read words from hard coded path. if this fails, there is no recovery
                reader = new BufferedReader(new FileReader(BACKUP));
            } catch (Exception inner) {
                // nothing else to try, so throw unchecked exception
                throw new WordReadingException();
            }
        }
    }

    /**
     * @author Jaan Soulier
     * Read next line from buffer.
     * @return The next word or null.
     * @author Jaan Soulier
     * @version 1.0
     */
    public String getLine() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}