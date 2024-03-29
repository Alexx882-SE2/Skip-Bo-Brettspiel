package com.example.skip_bo_brettspiel.stacks;

import com.example.skip_bo_brettspiel.GameModel.Card;

import java.util.ArrayList;

public class BuildingStack extends Stack {

    /**
     * This class represents a BuildingStack, which are used to play your cards onto to get rid of your cards
     * They are started with a random card and once a stack reaches 12 cards, the next card has to be "1" or "Skipbo" again
     */
    public BuildingStack() {
        super();
    }

    /**
     * This function determines the possible cardNumbers that can be played onto this stack
     *
     * @return a list containing possible cardNumbers that can be played onto this stack
     */
    public ArrayList<Integer> next() {
        ArrayList<Integer> possibleValues = new ArrayList<>();
        if (this.getCards().isEmpty()) {
            for (int i = 0; i <= 12; i++) {
                possibleValues.add(i);
            }
            return possibleValues;
        }

        possibleValues.add(0);

        if (this.getTopCard().getCardNumber() == 12) {   //if current card on stack is 12 next one has to be 1
            possibleValues.add(1);
            return possibleValues;
        }
        possibleValues.add(this.getTopCard().getCardNumber() + 1);

        return possibleValues;
    }

    // FIXME naming convention to indicate expected failure, eg tryAddCard
    /**
     * attempts to add given card to stack
     *
     * @param c card to add to the stack
     * @return true if card was added, false if adding card was not possible
     */
    public boolean addCard(Card c) {
        ArrayList<Integer> possibleMoves = this.next();

        if (possibleMoves.contains(c.getCardNumber())) {
            this.getCards().add(c);
            return true;
        }
        return false;
    }
}
