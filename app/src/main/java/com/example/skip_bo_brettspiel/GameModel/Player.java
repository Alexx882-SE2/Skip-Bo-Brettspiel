package com.example.skip_bo_brettspiel.GameModel;

import java.util.ArrayList;

public class Player {

    private String name;

    public ArrayList<Card> mainStack = new ArrayList<Card>();
    public ArrayList<Card> handCards = new ArrayList<Card>();

    public Player(String name){

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
