package com.example.skip_bo_brettspiel.Board.Field;

public abstract class Field {
    /**
      The name of the field.
     */
     private String name;
     /*
     * The position of the field on the board.
     */
    private int positionOnBoard;

    /**
     * Constructs a Field object with the given name and position.
     *
     * @param name The name of the field.
     * @param positionOnBoard The position of the field on the board.
     */
    public Field(String name, int positionOnBoard) {
        this.name = name;
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Returns a description of the field, including its name and position on the board.
     *
     * @return A description of the field.
     */
    public String description() {
        return name + " " + positionOnBoard;
    }

}
