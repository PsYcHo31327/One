public class Player {
    String name;
    Hand hand;

    public Player(String name) {
        super();
        this.name = name;
        this.hand = new Hand();
    }

    public Card draw(CardPile deck, CardPile discardPile) {
        // Refill the deck from the discard pile if it is empty
        if (deck.isEmpty()) {
            for (int i = 1; i < discardPile.size(); i++) {
                deck.add(discardPile.pop());
            }
        }

        // Draw a random card (so we don't have to shuffle)
        int cardIndex = (int)(Math.random() * deck.size());
        hand.add(deck.remove(cardIndex));

        return hand.peek();
    }

    public CardPile playableCards(CardPile discardPile) {
        Card topCard = discardPile.peekLast();
        CardPile usableCards = new CardPile(false);
        for (Card card : this.hand) {
            if (topCard == null
            || card.getCardValue().equals(topCard.getCardValue())
            || card.getCardColor().equals(topCard.getCardColor())
            || card.getCardValue().equals(Card.value.WILD)
            || card.getCardValue().equals(Card.value.DRAW_FOUR)) {
                usableCards.add(card);
            }
        }
        return usableCards;
    }

    public int handSize() {
        return this.hand.size();
    }

    public String getName() {
        return name;
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }
}