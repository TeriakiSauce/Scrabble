import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 
 */
public class Reader {
    /**
     * 
     */
    private BufferedReader reader;

    /**
     * 
     * @param path
     */
    public Reader(String path) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        reader = new BufferedReader(new InputStreamReader(is));
    }

    /**
     * 
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
