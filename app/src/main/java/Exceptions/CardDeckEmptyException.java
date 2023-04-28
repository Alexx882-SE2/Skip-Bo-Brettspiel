package Exceptions;

public class CardDeckEmptyException extends Exception {
    public CardDeckEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
