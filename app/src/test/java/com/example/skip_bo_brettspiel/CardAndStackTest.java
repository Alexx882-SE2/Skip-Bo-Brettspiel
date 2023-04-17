package com.example.skip_bo_brettspiel;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import GameLogic.StaticParts.Card;

public class CardAndStackTest {

    @Test
    void testConstructor() {
        // Test valid card numbers
        for (int i = 1; i <= 12; i++) {
            Card card = new Card(i);
            assertEquals(i, card.getCardNumber());
        }

        // Test invalid card numbers
        assertThrows(IllegalArgumentException.class, () -> new Card(-1));
        assertThrows(IllegalArgumentException.class, () -> new Card(13));
    }

    @Test
    void testGetCardNumber() {
        Card card = new Card(5);
        assertEquals(5, card.getCardNumber());
    }

    @Test
    public void testToString() {
        Card card = new Card(5);
        assertEquals("5", card.toString());
    }


}
