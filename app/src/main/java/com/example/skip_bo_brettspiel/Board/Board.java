package com.example.skip_bo_brettspiel.Board;

import com.example.skip_bo_brettspiel.Board.Field.Field;
import com.example.skip_bo_brettspiel.Datastructures.RingBuffer;

public class Board {
    private RingBuffer<Field> boardFields;

    public Board(int size) {
        boardFields = new RingBuffer<>(size);
    }

    public void addField(Field field) {
        boardFields.add(field);
    }

    public Field getField(int index) {
        return boardFields.get(index);
    }
}
