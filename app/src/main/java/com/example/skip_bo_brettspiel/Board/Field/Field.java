package com.example.skip_bo_brettspiel.Board.Field;

public abstract class Field {

    private String name;
    private int positionOnBoard;

    public Field(String name, int value) {
    }


    public String description(){
        return name + " " + positionOnBoard;
    }

}
