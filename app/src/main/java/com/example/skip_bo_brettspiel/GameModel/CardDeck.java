package com.example.skip_bo_brettspiel.GameModel;

import com.example.skip_bo_brettspiel.GameModel.Card;

import java.util.ArrayList;
import java.util.Collections;

import Exceptions.CardDeckEmptyException;


/**
 * This class represents the deck of cards which have not been dealt yet and from which it should be possible to pull new cards as required
 * The deck should contain 108 cards (8 times each card number (1-12) and 12 joker cards (cardNumber = 0)
 */
public class CardDeck {
    private ArrayList<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Fills the deck with cards  (12xJoker, 8x each number)
     */
    public void fillDeck() {
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
    public ArrayList<Card> shuffle() throws CardDeckEmptyException {
        if (this.cards.size() > 0) {
            Collections.shuffle(this.cards);
        } else {
            throw new CardDeckEmptyException("Deck is empty");
        }
        return this.cards;
    }

    /**
     * Gets the remaining cards in the deck
     *
     * @return number of remaining cards
     */
    public int getRemainingCardCount() {
        return this.cards.size();
    }

    /**
     * Gets the remaining cards of a certain value
     *
     * @param cardNumber the cardNumber to search for
     * @return number of cards remaining with the searched cardNumber
     */
    public int getRemainingCardCountOfCardNumber(int cardNumber) {
        return (int) this.cards.stream().filter(c -> c.getCardNumber() == cardNumber).count();
    }
}
