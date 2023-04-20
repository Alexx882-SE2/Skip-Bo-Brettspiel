package com.example.skip_bo_brettspiel.GameModel;

import java.util.ArrayList;

public class Player {

    private String name;

    public ArrayList<Card> cards = new ArrayList<>();

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
