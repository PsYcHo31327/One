import java.util.LinkedList;

public class CardPile extends LinkedList<Card> {
    // Build a complete (or empty) deck
    public CardPile(boolean fillDeck) {
        super();
        if (fillDeck) {
            for (Card.value v : Card.value.values()) {
                for (Card.color c : Card.color.values()) {
                    this.add(new Card(v, c));
                }
            }
        }
    }
}