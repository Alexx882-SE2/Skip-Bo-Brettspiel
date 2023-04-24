package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.skip_bo_brettspiel.GameModel.Card;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;





public class StacksTest {

    private static Stacks stacks;

    @BeforeAll
    public static void setUp() {
        stacks = new Stacks();
    }

    @AfterAll
    public static void tearDown() {
        stacks = null;
    }

    @Test
    public void testGetTopCardWhenStackIsEmpty() {
        Stacks emptyStack = new Stacks();
        Card topCard = emptyStack.getTopCard();
        assertNull(topCard);
    }

    @Test
    public void testGetPlayerStack() {
        ArrayList<Card> playerStack = stacks.getPlayerStack();
        assertEquals(playerStack.size(), 0);
    }


    @Test
    public void testGetTopCardWhenStackIsNotEmpty() {
        Card card1 = new Card(1);
        Card card2 = new Card(2);
        stacks.getPlayerStack().add(card1);
        stacks.getPlayerStack().add(card2);
        Card topCard = stacks.getTopCard();
        assertEquals(topCard, card2);
    }

    @Test
    public void testGetPlayerStackSize() {
        Stacks sizeTwoStack = new Stacks();
        Card card1 = new Card(1);
        Card card2 = new Card(2);
        sizeTwoStack.getPlayerStack().add(card1);
        sizeTwoStack.getPlayerStack().add(card2);
        int size = sizeTwoStack.getPlayerStackSize();
        assertEquals(size, 2);
    }


    @Test
    public void testGetPlayerStackAsStringWhenStackIsNotEmpty() {
        Stacks sizeTwoStack = new Stacks();
        Card card1 = new Card(1);
        Card card2 = new Card(2);
        sizeTwoStack.getPlayerStack().add(card1);
        sizeTwoStack.getPlayerStack().add(card2);
        String expected = "Size of stack:2\t Top card:" + card2.toString();
        String actual = sizeTwoStack.getPlayerStackAsString();
        assertEquals(expected, actual);
    }

}
