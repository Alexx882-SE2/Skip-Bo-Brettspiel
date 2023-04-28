package com.example.skip_bo_brettspiel.stacks;

import com.example.skip_bo_brettspiel.GameModel.Card;

import java.util.ArrayList;

public class BuildingStack extends Stack {

    private ArrayList<Integer> possibleValues;

    public BuildingStack() {
        super();
    }

    /**
     * This function determines the possible cardNumbers that can be played onto this stack
     *
     * @return a list containing possible cardNumbers that can be played onto this stack
     */
    public ArrayList<Integer> next() {
        this.possibleValues = new ArrayList<>();
        this.possibleValues.add(0);

        if (this.getTopCard().getCardNumber() == 12) {   //if current card on stack is 12 next one has to be 1
            this.possibleValues.add(1);
            return this.possibleValues;
        }
        this.possibleValues.add(this.getTopCard().getCardNumber() + 1);

        return this.possibleValues;
    }

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
