/**
 * Main class containg main method.
 * @author Andrew/Tarik/Jaan/Haravind
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Model model = new Model(view, game);
        new Controller(model, view);
    }
}
