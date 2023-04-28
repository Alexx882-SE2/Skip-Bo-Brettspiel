package com.example.skip_bo_brettspiel.Board;

import com.example.skip_bo_brettspiel.Board.Field.Field;
import com.example.skip_bo_brettspiel.Datastructures.RingBuffer;

/**
 * The Board class represents a game board that consists of a collection of fields.
 */
public class Board {

    /**
     * The collection of fields on the board.
     */
    private RingBuffer<Field> boardFields;

    /**
     * Creates a new Board object with a specified size.
     *
     * @param size the number of fields on the board
     */
    public Board(int size) {
        boardFields = new RingBuffer<>(size);
    }

    /**
     * Adds a field to the board.
     *
     * @param field the field to add
     */
    public void addField(Field field) {
        boardFields.add(field);
    }

    /**
     * Returns the field at the specified index on the board.
     *
     * @param index the index of the field to retrieve
     * @return the field at the specified index
     */
    public Field getField(int index) {
        return boardFields.get(index);
    }
}

