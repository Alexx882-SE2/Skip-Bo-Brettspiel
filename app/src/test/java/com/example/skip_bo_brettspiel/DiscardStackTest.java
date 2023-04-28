package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.skip_bo_brettspiel.GameModel.Card;
import com.example.skip_bo_brettspiel.stacks.BuildingStack;
import com.example.skip_bo_brettspiel.stacks.DiscardStack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscardStackTest {
    private DiscardStack ds;

    @BeforeEach
    void setUp() {
        ds = new DiscardStack();
    }

    @AfterEach
    void cleanUp() {
        ds = null;
    }

    @Test
    void testGetTopCard() {
        Card c = new Card(2);
        ds.getCards().add(c);

        assertEquals(c, ds.getTopCard());
    }

    @Test
    void testGetTopCardStackEmpty() {
        assertNull(ds.getTopCard());
    }

    @Test
    void testGetStackSize() {
        Card c = new Card(3);
        ds.getCards().add(c);

        assertEquals(1, ds.getStackSize());
    }

    @Test
    void testGetStackSizeEmptyStack() {
        assertEquals(0, ds.getStackSize());
    }

    @Test
    void testAddCard() {
        Card c = new Card(2);

        assertEquals(0, ds.getStackSize());
        ds.addCard(c);

        assertEquals(1, ds.getStackSize());
        assertEquals(c, ds.getTopCard());
    }

    @Test
    void testPlayCardEmptyBuildingStack() {
        BuildingStack bs = new BuildingStack();

        Card c = new Card(2);
        ds.addCard(c);

        assertTrue(ds.playCard(bs));
        assertEquals(1, bs.getStackSize());
    }

    @Test
    void testPlayCardNotEmptyBuildingStack() {
        BuildingStack bs = new BuildingStack();

        Card c1 = new Card(12);
        bs.addCard(c1);

        Card c2 = new Card(11);
        ds.addCard(c2);
        assertFalse(ds.playCard(bs));

        assertEquals(1, bs.getStackSize());
    }

    @Test
    void testPlayCardBuildingStackMax() {
        BuildingStack bs = new BuildingStack();

        Card c1 = new Card(12);
        bs.addCard(c1);

        Card c2 = new Card(1);
        ds.addCard(c2);

        assertTrue(ds.playCard(bs));
        assertEquals(2, bs.getStackSize());

        Card skipbo = new Card(0);
        ds.addCard(skipbo);

        assertTrue(ds.playCard(bs));
        assertEquals(3, bs.getStackSize());
    }
}
