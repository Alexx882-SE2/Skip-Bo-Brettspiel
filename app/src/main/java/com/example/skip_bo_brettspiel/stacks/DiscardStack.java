package com.example.skip_bo_brettspiel.stacks;

import com.example.skip_bo_brettspiel.GameModel.Card;

public class DiscardStack extends Stack {
    /**
     * This class represents a discard stack for the players. Each player can have up to 4 discard stacks where he can store not needed cards in any order, but can only access the top card to play.
     */
    public DiscardStack() {
        super();
    }

    /**
     * Adds a card to the discard stack, all cards can be added in any order
     */
    public void addCard(Card c){
        this.getCards().add(c);
    }

    /**
     * Plays the top card of the DiscardStack onto the given BuildingStack
     * @param bs the target BuildingStack to play the card onto
     * @return true if card was played, false if card couldn't be added
     */
    public boolean playCard(BuildingStack bs){
        return bs.addCard(this.getTopCard());
    }

}
