package com.example.skip_bo_brettspiel.GameModel;

import android.util.Log;

import java.util.ArrayList;

/**
 * The Stacks class represents a stack of cards in the game.
 * It contains a list of GameCards, which can be either SkipBoCards or Cards.
 */
public class Stacks {


    private ArrayList<Card> playerStack = new ArrayList<>();

    /**
     * Returns the list of GameCards in the stack.

     * @return the list of GameCards in the stack.
     */
    public ArrayList<Card> getPlayerStack() {
        return playerStack;
    }

    /**
     * Returns the top card of the stack.

     * @return the top card of the stack.
     */
    public Card getTopCard() {
        try {
            return playerStack.get(playerStack.size() - 1);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("PlayerStack empty");
            return null; // or some better value
        }


    /**
     * Prints the size of the stack and the top card.
     */
    public String getPlayerStackAsString() {
        String playerStackString = "";
        try {
            playerStackString = "Size of stack:" + getPlayerStackSize() + "\t Top card:" + getTopCard().toString();
        } catch (IndexOutOfBoundsException e) {
            Log.e("getPlayerStackAsString", "Index out of bounds exception occurred", e);
        } catch (Exception e) {
            Log.e("getPlayerStackAsString", "Exception occurred", e);
        }
        return playerStackString;
    }
    }



        return playerStack.size();
    }


}
