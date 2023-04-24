package com.example.skip_bo_brettspiel.Board.Field;

public class NumberedField extends Field{
    private int lowerBound;
    private int upperBound;
    public NumberedField(String name, int value, int lowerBound, int upperBound) {
        super(name, value);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
}