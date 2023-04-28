package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.skip_bo_brettspiel.GameModel.Card;
import com.example.skip_bo_brettspiel.stacks.BuildingStack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BuildingStackTest {
    private BuildingStack bs;

    @BeforeEach
    public void setUp() {
        bs = new BuildingStack();
    }

    @AfterEach
    public void cleanUp() {
        bs = null;
    }

    @Test
    void testGetTopCard() {
        Card c = new Card(2);
        bs.getCards().add(c);

        assertEquals(c, bs.getTopCard());
    }

    @Test
    void testGetTopCardStackEmpty() {
        assertNull(bs.getTopCard());
    }

    @Test
    void testGetStackSize() {
        Card c = new Card(3);
        bs.getCards().add(c);

        assertEquals(1, bs.getStackSize());
    }

    @Test
    void testGetStackSizeEmptyStack() {
        assertEquals(0, bs.getStackSize());
    }

    @Test
    void testNext() {
        Card c = new Card(2);

        bs.getCards().add(c);
        ArrayList<Integer> possibleMoves = bs.next();

        assertTrue(possibleMoves.contains(3));
        assertTrue(possibleMoves.contains(0));
        assertEquals(2, possibleMoves.size());
    }

    @Test
    void testNextWhenCardIsMax() {
        Card c = new Card(12);
        bs.getCards().add(c);

        ArrayList<Integer> possibleMoves = bs.next();

        assertTrue(possibleMoves.contains(1));
        assertTrue(possibleMoves.contains(0));
        assertEquals(2, possibleMoves.size());
    }

    @Test
    void testNextEmptyStack() {
        ArrayList<Integer> possibleMoves = bs.next();

        assertEquals(13, possibleMoves.size());

        for (int i = 0; i <= 12; i++) {
            assertTrue(possibleMoves.contains(i));
        }
    }

    @Test
    void testAddCard() {
        Card c = new Card(1);
        Card skipbo = new Card(0);
        assertTrue(bs.addCard(c));

        assertFalse(bs.addCard(c)); //shouldnt be possible to add same card twice
        assertTrue(bs.addCard(skipbo)); //always possible to add joker card
    }
}
