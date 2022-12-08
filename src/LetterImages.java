import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * A class that loads and stores the images
 * @author Andrew
 */
public class LetterImages {
    //String of all possible tiles excluding blank
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final HashMap<Character, BufferedImage> images = new HashMap<>();
    private static BufferedImage blank = null;

    /*Not Implemented Yet
    private static BufferedImage doubleWord = null;
    private static BufferedImage tripleWord = null;
    private static BufferedImage doubleLetter = null;
    private static BufferedImage tripleLetter = null;
    */

    public static void init() {
        blank = loadImage("scrabble-blank.jpg");

        /* Not Implemented Yet
        doubleWord = loadImage("doubleword.jpg");
        tripleWord = loadImage("tripleword.jpg");
        doubleLetter = loadImage("doubleletter.jpg");
        tripleLetter = loadImage("tripleletter.jpg");
         */

        //Loads all images into the hash map
        for (Character letter : ALPHABET.toCharArray()) {
            BufferedImage icon = loadImage("scrabble-" + letter + ".jpg");

            images.put(letter, icon);
        }
    }

    /**
     * Returns the tile image corresponding to letter
     * @param letter the letter you need a tile for
     * @return the image of the tile
     */
    public static BufferedImage getImage(Character letter) {

        return images.containsKey(letter) ? images.get(letter) : blank;
    }

    /* Not Implemented Yet
    public static BufferedImage getDoubleWord() {
        return doubleWord;
    }

    public static BufferedImage getTripleWord() {
        return tripleWord;
    }

    public static BufferedImage getDoubleLetter() {
        return doubleLetter;
    }

    public static BufferedImage getTripleLetter() {
        return tripleLetter;
    }
     */

    /**
     * Loads an image from the given path
     *
     */
    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        InputStream is = LetterImages.class.getResourceAsStream("images/" + path);
        System.out.println(path);
        if (is == null) {
            return null;
        }
        try {
            System.out.println("SUCCESS: " + path);
            image = ImageIO.read(is);
        } catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Resizes an image to the specified width and height
     */
    public static BufferedImage resize(BufferedImage image, int scaledWidth, int scaledHeight) {
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, image.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
    }
}