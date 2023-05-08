package com.example.skip_bo_brettspiel.GameModel;

import com.example.skip_bo_brettspiel.Datastructures.FigureColor;

/**
 * The `Figure` class represents a player's figure on the game board.
 */
public class Figure {

    /**
     * The color of the figure.
     */
    private FigureColor figureColor;

    /**
     * The current position of the figure on the board.
     */
    private int positionOnBoard;

    /**
     * Creates a new `Figure` object with the given `figureColor` and `positionOnBoard`.
     *
     * @param figureColor The color of the figure.
     * @param positionOnBoard The current position of the figure on the board.
     */
    public Figure(FigureColor figureColor, int positionOnBoard) {
        this.figureColor = figureColor;
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Returns the `FigureColor` value that represents the color of the figure.
     *
     * @return The color of the figure.
     */
    public FigureColor getFigureColor() {
        return figureColor;
    }

    /**
     * Sets the `FigureColor` value that represents the color of the figure to the given `figureColor`.
     *
     * @param figureColor The new color of the figure.
     */
    public void setFigureColor(FigureColor figureColor) {
        this.figureColor = figureColor;
    }

    /**
     * Returns the current position of the figure on the board.
     *
     * @return The current position of the figure on the board.
     */
    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Sets the current position of the figure on the board to the given `positionOnBoard`.
     *
     * @param positionOnBoard The new position of the figure on the board.
     */
    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }
}
