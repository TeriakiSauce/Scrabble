/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Model model = new Model(view, game);
        new Controller(model, view);
    }
}
