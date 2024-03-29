import java.net.URL;
import java.net.URLConnection;
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
    public static class WordReadingException extends RuntimeException {
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
     * Reader for reading words.
     */
    private Reader reader;

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
            if (path == null) {
                throw new NullPointerException();
            }
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            reader = new Reader(new InputStreamReader(connection.getInputStream()));
        } catch (Exception outer) {
            try {
                reader = new Reader(Config.WORD_BANK_BACKUP_PATH);
            } catch (Exception inner) {
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