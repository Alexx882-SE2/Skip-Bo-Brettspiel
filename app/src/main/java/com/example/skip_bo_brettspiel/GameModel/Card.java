package com.example.skip_bo_brettspiel.GameModel;

public class Card {
    public final int cardNumber;

    /**
     * Constructs a new Card object with the specified card number.
     *
     * @param value the card number for this card. Must be an integer between 0 and 12 (inclusive).
     * @throws IllegalArgumentException if the card number is not between 0 and 12 (inclusive).
     */
    public Card(int value) {
        if (value >= 0 && value <= 12) {
            this.cardNumber = value;
        } else {
            throw new IllegalArgumentException("Card numbers should be between 0 and 12");
        }
    }

    /**
     * Returns the card number for this card.
     *
     * @return the card number for this card.
     */

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(cardNumber);
    }


}
