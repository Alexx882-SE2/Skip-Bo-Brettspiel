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

    // FIXME positionOnBoard and value in subclasses is not consistent
    /**
     * Constructs a Field object with the given name and position.
     *
     * @param name The name of the field.
     * @param positionOnBoard The position of the field on the board.
     */
    protected Field(String name, int positionOnBoard) {
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

    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    public String getName() {
        return name;
    }
}
