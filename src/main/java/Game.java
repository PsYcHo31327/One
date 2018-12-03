public class Game {
    Player[] players;
    CardPile deck;
    CardPile discardPile;
    int direction; // 0 = clockwise, 1 = counterclockwise
    int turn;

    public Game() {
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player " + i);
        }

        deck = new CardPile(true);

        for (Player p : players) {
            for (int i = 0; i < 7; i++) {
                p.draw(this.deck, this.discardPile);
            }
        }

        discardPile = new CardPile(false);

        direction = 0;
        turn = 0;
    }

    // Returns whether the player just won
    public boolean takeTurn() {
        // Calculate whose turn it is
        int playerTurn = Math.floorMod(turn, 4);
        Player player = players[playerTurn];

        // Decide what to do
        CardPile playableCards = player.playableCards(this.discardPile);
        if (!playableCards.isEmpty()) {
            play(playableCards.pop(), player);
        } else {
            player.draw(this.deck, this.discardPile);
            playableCards = player.playableCards(this.discardPile);
            if (!playableCards.isEmpty()) {
                play(playableCards.pop(), player);
            } else {
                System.out.println(player.getName() + " can't play a card");
            }
        }

        // Next turn
        turn += (direction == 0) ? 1 : -1;

        int handSize = player.handSize();

        // Check if the player has Uno or won
        if (handSize == 1) {
            System.out.println(player.getName() + ": Uno!");
        } else if (handSize < 1) {
            System.out.println(player.getName() + " Wins!");
            return true;
        }

        return false;
    }

    private void play(Card card, Player player) {
        System.out.println(player.getName() + " plays "
            + card.getCardColor().name() + " " + card.getCardValue().name());
        discardPile.add(card);
        player.removeCard(card);
        if (card.getCardValue().equals(Card.value.SKIP)) {
            turn += (direction == 0) ? 1 : -1;
        } else if (card.getCardValue().equals(Card.value.REVERSE)) {
            direction = (direction == 0) ? 1 : 0;
        } else if (card.getCardValue().equals(Card.value.DRAW_TWO)) {
            Player nextPlayer = players[Math.floorMod(turn + (direction == 0 ? 1 : -1), 4)];
            nextPlayer.draw(this.deck, this.discardPile);
            nextPlayer.draw(this.deck, this.discardPile);
        } else if (card.getCardValue().equals(Card.value.DRAW_FOUR)) {
            Player nextPlayer = players[Math.floorMod(turn + (direction == 0 ? 1 : -1), 4)];
            for (int i = 0; i < 4; i++) {
                nextPlayer.draw(this.deck, this.discardPile);
            }
        }
    }
}