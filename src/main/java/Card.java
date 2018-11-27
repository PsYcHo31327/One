public class Card {
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

    public void setCardValue(value cardValue) {
        this.cardValue = cardValue;
    } public value getCardValue() {
        return cardValue;
    }

    public void setCardColor(color cardColor) {
        this.cardColor = cardColor;
    } public color getCardColor() {
        return cardColor;
    }
}
