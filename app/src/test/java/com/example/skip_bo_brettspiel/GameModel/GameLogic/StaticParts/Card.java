package com.example.skip_bo_brettspiel.GameModel.GameLogic.StaticParts;
/**

 The Card class represents a card with a unique card number. The card number must be an integer between 0 and 12 (inclusive).
 */

public class Card {
    /**

     The unique card number.
     */

    private final int cardNumber;

    /* TODO: Add color enum and integrate it into constructor*/

    /**

     Constructs a new Card object with the specified card number.
     @param cardNumber the card number for this card. Must be an integer between 0 and 12 (inclusive).
     @throws IllegalArgumentException if the card number is not between 0 and 12 (inclusive).
     */

    public Card(int cardNumber){
        if(cardNumber>=0 && cardNumber <= 12){
            this.cardNumber = cardNumber;
        } else{
            throw new IllegalArgumentException("Card numbers should be between 0 and 12");
        }
    }

    /**

     Returns the card number for this card.
     @return the card number for this card.
     */

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString(){
        return Integer.toString(cardNumber);
    }
}
