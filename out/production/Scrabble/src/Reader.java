import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author Jaan
 * @version 1.3
 * For reading files contained in the packaged jar.
 */
public class Reader {

    /**
     * 
     */
    private BufferedReader reader;

    /**
     * For reading from a file contained in the packaged jar.
     * @param path
     */
    public Reader(String path) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        reader = new BufferedReader(new InputStreamReader(is));
    }

    /**
     * For reading from an existing InputStreamReader.
     * Currently used for receiving an InputStreamReader from a URLConnection InputStream.
     * @param isr
     */
    public Reader(InputStreamReader isr) {
        this.reader = new BufferedReader(isr);
    }

    /**
     * 
     * @return
     * @throws IOException
     */
    public String readLine() throws IOException {
        return reader.readLine();
    }

    /**
     * 
     * @return
     * @throws IOException
     */
    public String readLines() throws IOException {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
