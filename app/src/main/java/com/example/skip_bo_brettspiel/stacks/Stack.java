package com.example.skip_bo_brettspiel.stacks;

import com.example.skip_bo_brettspiel.GameModel.Card;

import java.util.ArrayList;

public abstract class Stack {
    private ArrayList<Card> cards;

    protected Stack() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * returns the top card of the stack or null if the card stack is empty
     *
     * @return top card of stack or null if the card stack is empty
     */
    public Card getTopCard() {
        if (cards.size() < 1) {
            return null;
        }
        return this.cards.get(cards.size() - 1);
    }

    /**
     * Gets the current size of the card stack
     *
     * @return size of card stack
     */
    public int getStackSize() {
        return this.cards.size();
    }
}
