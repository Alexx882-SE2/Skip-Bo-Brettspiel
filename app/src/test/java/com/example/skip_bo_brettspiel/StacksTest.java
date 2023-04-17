package com.example.skip_bo_brettspiel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import GameLogic.DynamicParts.Stacks;
import GameLogic.StaticParts.Card;
import GameLogic.StaticParts.GameCard;
import GameLogic.StaticParts.SkipBoCard;

public class StacksTest {



    private static Stacks stacks;

    @BeforeAll
    public static void setup() {
        stacks = new Stacks();
        stacks.getPlayerStack().add(new SkipBoCard());
        stacks.getPlayerStack().add(new Card(1));
        stacks.getPlayerStack().add(new Card(2));
    }

    @AfterAll
    public static void cleanup() {
        stacks = null;
    }

    @Test
    public void testGetPlayerStack() {
        ArrayList<GameCard> playerStack = stacks.getPlayerStack();
        assertNotNull(playerStack);
        assertEquals(3, playerStack.size());
        assertTrue(playerStack.get(0) instanceof SkipBoCard);
        assertTrue(playerStack.get(1) instanceof Card);
        assertTrue(playerStack.get(2) instanceof Card);
    }

    @Test
    public void testGetTopCard() {
        GameCard topCard = stacks.getTopCard();
        assertTrue(topCard instanceof Card);
        assertSame(topCard, stacks.getPlayerStack().get(2));
    }



    @Test
    public void testGetPlayerStackSize() {
        assertEquals(3, stacks.getPlayerStackSize());
    }


    @Test
    public void testGetPlayerStackSizeAsString(){
        Assertions.assertEquals("Size of stack:3\t Top card:2",stacks.getPlayerStackAsString());
    }
}
