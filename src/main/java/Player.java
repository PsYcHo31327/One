public class Player {
    String name;
    Hand hand;

    public Player(String name) {
        super();
        this.name = name;
        this.hand = new Hand();
    }
}