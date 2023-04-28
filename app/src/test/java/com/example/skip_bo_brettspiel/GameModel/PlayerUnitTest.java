package com.example.skip_bo_brettspiel.GameModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerUnitTest {

    @Test
    void test() {
        Player player = new Player("Player");
        player.mainStack.add(new Card(0));

        assertEquals(0, player.mainStack.get(0).cardNumber);
        assertEquals(1, player.mainStack.size());
        
        assertEquals("Player", player.getName());

        player.setName("Player2");
        assertEquals("Player2", player.getName());
    }
}
