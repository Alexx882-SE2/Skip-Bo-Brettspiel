package GameLogic.DynamicParts;

import java.util.ArrayList;
import java.util.Collections;

import GameLogic.StaticParts.Card;

/**
 * This class represents the deck of cards which have not been dealt yet and from which it should be possible to pull new cards as required
 * The deck should contain 108 cards (8 times each card number (1-12) and 12 joker cards (cardNumber = 0)
 */
public class CardDeck {
    private ArrayList<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    /**
     * Fills the deck with cards  (12xJoker, 8x each number)
     */
    private void fillDeck() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 8; j++) {
                Card c = new Card(i);
                this.cards.add(c);
            }
            Card joker = new Card(0);
            this.cards.add(joker);
        }
    }

    /**
     * Shuffles the cards in the deck
     *
     * @return shuffled deck
     */
    private ArrayList<Card> shuffle() {
        Collections.shuffle(this.cards);
        return this.cards;
    }
}
