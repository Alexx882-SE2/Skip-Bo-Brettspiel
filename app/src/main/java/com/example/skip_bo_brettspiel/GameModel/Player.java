package com.example.skip_bo_brettspiel.GameModel;

import com.esotericsoftware.kryonet.Connection;
import android.util.Log;

import java.util.ArrayList;

import Exceptions.NullStackException;

public class Player {

    private String name;

    private String color;

    private Connection connection;

    public ArrayList<Card> cards = new ArrayList<>();

    public Player() {
    }
    public ArrayList<Card> mainStack = new ArrayList<Card>();
    public ArrayList<Card> handCards = new ArrayList<Card>();


    public Player(String name) {

    public Player(String name, String color) {

        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Adds a Card object to the end of the given stack.
     *
     * @param stack The ArrayList of cards to add the new card to.
     * @param card  The Card object to add to the stack.
     */
    public void cheat(ArrayList<Card> stack, Card card) throws NullStackException {
        if (stack == null) { // validate input parameter
            throw new NullStackException("Invalid stack");
        }
        stack.add(card);
    }
}
