package com.example.skip_bo_brettspiel.GameModel;

import com.example.skip_bo_brettspiel.Datastructures.FigureColor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FigureTest {

    @Test
    public void testGetFigureColor() {
        Figure figure = new Figure(FigureColor.RED, 0);
        Assertions.assertEquals(FigureColor.RED, figure.getFigureColor());
    }

    @Test
    public void testSetFigureColor() {
        Figure figure = new Figure(FigureColor.RED, 0);
        figure.setFigureColor(FigureColor.BLUE);
        Assertions.assertEquals(FigureColor.BLUE, figure.getFigureColor());
    }

    @Test
    public void testGetPositionOnBoard() {
        Figure figure = new Figure(FigureColor.RED, 0);
        Assertions.assertEquals(0, figure.getPositionOnBoard());
    }

    @Test
    public void testSetPositionOnBoard() {
        Figure figure = new Figure(FigureColor.RED, 0);
        figure.setPositionOnBoard(5);
        Assertions.assertEquals(5, figure.getPositionOnBoard());
    }

    @Test
    public void testFigureColorValues() {
        FigureColor[] colors = FigureColor.values();
        Assertions.assertEquals(4, colors.length);
        Assertions.assertArrayEquals(new FigureColor[]{FigureColor.RED, FigureColor.BLUE, FigureColor.YELLOW, FigureColor.GREEN}, colors);
    }
}
