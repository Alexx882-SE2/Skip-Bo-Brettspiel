package com.example.skip_bo_brettspiel.GameModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PlayerUnitTest {

    @Test
    void test(){
        Player player = new Player();
        player.cards.add(new Card(0));
        assertEquals(0,player.cards.get(0).value);
        assertEquals(1,player.cards.size());
    }
}
