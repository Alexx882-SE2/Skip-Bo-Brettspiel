package Exceptions;

// FIXME move in your root package

public class CardDeckEmptyException extends Exception {
    public CardDeckEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
