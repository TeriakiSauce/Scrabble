import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;

/**
 * @author Jaan
 * @version 1.2
 * For generating random bot names from a file.
 *
 * Names were generated from:
 * https://www.developmenttools.com/gamertag-generator/
 */
public class NameGen {

    /**
     * 
     */
    private LinkedList<String> names;

    /**
     * 
     */
    public NameGen() {
        names = new LinkedList<>();

        try {
            String line;
            Reader reader = new Reader(Config.NAMES_PATH);
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }

            if (names.isEmpty()) {
                throw new IOException("Found no names from " + Config.NAMES_PATH);
            }

        } catch (IOException e) {
            names.add("Error Generating Names");
        }

        Collections.shuffle(names);
    }

    /**
     * 
     * @return
     */
    public String getName() {
        String name = names.pop();
        names.add(name);
        return name;
    }
}
