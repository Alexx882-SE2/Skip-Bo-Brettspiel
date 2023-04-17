package com.example.skip_bo_brettspiel;




import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import GameLogic.DynamicParts.Stacks;
import GameLogic.StaticParts.Card;
import GameLogic.StaticParts.GameCard;
import GameLogic.StaticParts.SkipBoCard;

public class StacksTest {

    @Test
    public void testGetPlayerStack() {
        Stacks stacks = new Stacks();
        assertNotNull(stacks.getPlayerStack());
    }

    @Test
    public void testGetTopCard() {
        Stacks stacks = new Stacks();
        Card card = new Card(2);
        stacks.getPlayerStack().add(card);
        GameCard topCard = stacks.getTopCard();
        assertTrue(topCard instanceof Card);
        assertSame(topCard, card);
    }


    @Test
    public void testGetTopCardFromEmptyStack() {
        Stacks stacks = new Stacks();
        assertThrows(IndexOutOfBoundsException.class, () -> stacks.getTopCard());
    }

}
