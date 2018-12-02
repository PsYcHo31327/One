public class One {
    public static void main(String[] args) {
        // Initialize the game
        Game game = new Game();

        while (true) {
            if (game.takeTurn()) {
                break;
            }
        }
    }
}