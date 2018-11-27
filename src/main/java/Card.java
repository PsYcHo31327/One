<<<<<<< HEAD
public final class Card {
    private enum value {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, DRAW_FOUR, COLOR }
    private enum color {RED, BLUE, GREEN, YELLOW, WILD}
    private value cardValue;
    private color cardColor;

    public Card() {
        this(value.COLOR, color.WILD);
    }

    public Card(value v, color c) {
        this.cardValue = v;
        this.cardColor = c;
    }

    public value getCardValue() {
        return cardValue;
    }

    public color getCardColor() {
        return cardColor;
=======
public class Card {
    int suit;
    int face;

    public Card(int suit, int face) {
        this.suit = suit;
        this.face = face;
>>>>>>> Outline player class dependencies
    }
}