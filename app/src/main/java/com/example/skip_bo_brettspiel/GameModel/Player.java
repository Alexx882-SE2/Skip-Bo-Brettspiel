package com.example.skip_bo_brettspiel.GameModel;

import android.util.Log;

import java.util.ArrayList;

public class Player {

    private String name;

    public ArrayList<Card> cards = new ArrayList<>();


    //private static final String TAG = "PlayerCheat";

    public Player(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Adds a Card object to the end of the given stack.
     *
     * @param stack The ArrayList of cards to add the new card to.
     * @param card  The Card object to add to the stack.
     * @throws NullPointerException if the stack parameter is null.
     */
    public void cheat(ArrayList<Card> stack, Card card) {
        if (stack == null) { // validate input parameter
            Log.e("Player", "cannot input null stack");
            return;
        }

        try {
            stack.add(card);
        } catch (Exception e) {
            Log.e("Player", "Error adding card to stack", e);
        }


    }


}
