package GameLogic.StaticParts;
/**

 The Card class represents a card with a unique card number. The card number must be an integer between 1 and 12 (inclusive).
 */

public class Card {
    /**

     The unique card number.
     */

    private final int cardNumber;

    /* TODO: Add color enum and integrate it into constructor*/

    /**

     Constructs a new Card object with the specified card number.
     @param cardNumber the card number for this card. Must be an integer between 1 and 12 (inclusive).
     @throws IllegalArgumentException if the card number is not between 1 and 12 (inclusive).
     */

    public Card(int cardNumber){
        if(cardNumber>=1 && cardNumber <= 12){
            this.cardNumber = cardNumber;
        } else{
            throw new IllegalArgumentException("Card numbers should be between 1 and 12");
        }
    }

    /**

     Returns the card number for this card.
     @return the card number for this card.
     */

    public int getCardNumber() {
        return cardNumber;
    }
}
