package com.example.skip_bo_brettspiel.Board.Field;

/**
 * Represents a numbered field on the board that has a range of values.
 * Inherits from the abstract class Field.
 */
public class NumberedField extends Field {
    private int lowerBound;
    private int upperBound;

    /**
     * Constructs a numbered field with a name, position value, and range of values.
     *
     * @param name       the name of the numbered field
     * @param value      the position value of the numbered field
     * @param lowerBound the lower bound of the range of values
     * @param upperBound the upper bound of the range of values
     */
    public NumberedField(String name, int value, int lowerBound, int upperBound) {
        super(name, value);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Gets the lower bound of the range of values for the numbered field.
     *
     * @return the lower bound of the range of values
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * Sets the lower bound of the range of values for the numbered field.
     *
     * @param lowerBound the new lower bound of the range of values
     */
    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    /**
     * Gets the upper bound of the range of values for the numbered field.
     *
     * @return the upper bound of the range of values
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Sets the upper bound of the range of values for the numbered field.
     *
     * @param upperBound the new upper bound of the range of values
     */
    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
}
