package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import Exceptions.CardDeckEmptyException;
import GameLogic.DynamicParts.CardDeck;
import GameLogic.StaticParts.Card;

public class CardDeckTest {
    private static CardDeck cd;

    @BeforeEach
    public void setUp() {
        cd = new CardDeck();
    }

    @AfterAll
    public static void cleanUp() {
        cd = null;
    }

    @Test
    void testFillDeck() {
        assertEquals(0, cd.getCards().size());
        cd.fillDeck();

        assertEquals(108, cd.getCards().size());
    }

    @Test
    void testShuffle() throws CardDeckEmptyException {
        cd.fillDeck();

        ArrayList<Card> beforeShuffle = new ArrayList<>(cd.getCards());
        assertEquals(beforeShuffle, cd.getCards());

        cd.shuffle();
        assertNotEquals(beforeShuffle, cd.getCards());
    }

    @Test
    void testShuffleEmptyDeck() {
        Exception e = assertThrows(CardDeckEmptyException.class, () -> cd.shuffle());
        assertEquals("Deck is empty", e.getMessage());
    }

    @Test
    void testGetRemainingCardCountEmptyDeck() {
        assertEquals(0, cd.getRemainingCardCount());
    }

    @Test
    void testGetRemainingCardCount() {
        assertEquals(0, cd.getRemainingCardCount());
        cd.fillDeck();

        assertEquals(108, cd.getRemainingCardCount());

        cd.getCards().remove(1);
        assertEquals(107, cd.getRemainingCardCount());
    }

    @Test
    void testGetRemainingCardCountOfCardNumberEmptyDeck() {
        assertEquals(0, cd.getRemainingCardCountOfCardNumber(0));
    }

    @Test
    void testGetRemainingCardCountOfCardNumber() {
        assertEquals(0, cd.getRemainingCardCountOfCardNumber(1));
        cd.fillDeck();

        assertEquals(8, cd.getRemainingCardCountOfCardNumber(1));
        cd.getCards().remove(1);

        assertEquals(7, cd.getRemainingCardCountOfCardNumber(1));
    }

}
