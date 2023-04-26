package com.example.skip_bo_brettspiel.Board.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FieldsTest {

    @Test
    void testNumberedFieldConstructorAndGetters() {
        NumberedField field = new NumberedField("Test", 5, 1, 10);
        assertEquals("Test", field.getName());
        assertEquals(5, field.getPositionOnBoard());
        assertEquals(1, field.getLowerBound());
        assertEquals(10, field.getUpperBound());
    }

    @Test
    void testNumberedFieldSetters() {
        NumberedField field = new NumberedField("Test", 5, 1, 10);
        field.setLowerBound(0);
        field.setUpperBound(20);
        assertEquals(0, field.getLowerBound());
        assertEquals(20, field.getUpperBound());
    }

    @Test
    void testOrangeFieldConstructor() {
        OrangeField field = new OrangeField("Test Field", 3);
        assertEquals("Test Field", field.getName());
        assertEquals(3, field.getPositionOnBoard());
    }

    @Test
    void testRedFieldConstructor() {
        RedField field = new RedField("Test Field", 3);
        assertEquals("Test Field", field.getName());
        assertEquals(3, field.getPositionOnBoard());
    }

    @Test
    void testPurpleFieldConstructor() {
        PurpleField field = new PurpleField("Test Field", 3);
        assertEquals("Test Field", field.getName());
        assertEquals(3, field.getPositionOnBoard());
    }

    @Test
    void testSkipBoFieldConstructor() {
        SkipBoField field = new SkipBoField("Test Field", 3);
        assertEquals("Test Field", field.getName());
        assertEquals(3, field.getPositionOnBoard());
    }

    @Test
    void testSwitchCardFieldConstructor() {
        SwitchCardField field = new SwitchCardField("Test Field", 3);
        assertEquals("Test Field", field.getName());
        assertEquals(3, field.getPositionOnBoard());
    }

    @Test
    void testPinkFieldConstructor() {
        PinkField field = new PinkField("Test Field", 3);
        assertEquals("Test Field 3", field.description());
    }
}
