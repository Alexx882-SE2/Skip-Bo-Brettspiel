package com.example.skip_bo_brettspiel.GameModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CheatTest {

    Stacks stacks = new Stacks();
    ;
    Player player = new Player("p1");
    ;


    @Test
    void testCheat() {
        Card card1 = new Card(3);
        Card card2 = new Card(7);


        player.cheat(stacks.getPlayerStack(), card1);

        assertEquals(1, stacks.getPlayerStackSize());
        assertEquals(card1, stacks.getTopCard());

        player.cheat(stacks.getPlayerStack(), card2);
        assertEquals(2, stacks.getPlayerStackSize());
        assertEquals(card2, stacks.getTopCard());
    }


    @Test
    void testCheat_NullStack() {
        ArrayList<Card> stack = null;
        Card card = new Card(1);
        Player player = new Player("g");

        assertThrows(RuntimeException.class, () -> player.cheat(stack, card));
    }


    @Test
    public void testCheatWithValidStackAndCard() {
        ArrayList<Card> stack = new ArrayList<>();
        Card card = new Card(1);
        player.cheat(stack, card);
        Assertions.assertTrue(stack.contains(card));
    }





}

