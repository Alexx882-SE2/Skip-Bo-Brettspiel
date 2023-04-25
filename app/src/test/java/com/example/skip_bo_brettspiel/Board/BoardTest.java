package com.example.skip_bo_brettspiel.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.skip_bo_brettspiel.Board.Field.BlueField;
import com.example.skip_bo_brettspiel.Board.Field.Field;

import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testAddField() {
        Board board = new Board(5);
        Field field = new BlueField("test", 1);
        board.addField(field);
        assertEquals(1, board.getField(0).getPositionOnBoard());
        assertEquals("test", board.getField(0).getName());
    }

    @Test
    public void testGetField() {
        Board board = new Board(5);
        Field field = new BlueField("test", 1);
        board.addField(field);
        assertEquals(field, board.getField(0));
    }

    @Test
    void testGetField_IndexOutOfBounds() {
        Board board = new Board(3);
        Field field1 = new BlueField("Field 1", 1);
        Field field2 = new BlueField("Field 2", 2);
        Field field3 = new BlueField("Field 3", 3);
        board.addField(field1);
        board.addField(field2);
        board.addField(field3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getField(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getField(3);
        });
    }

}
