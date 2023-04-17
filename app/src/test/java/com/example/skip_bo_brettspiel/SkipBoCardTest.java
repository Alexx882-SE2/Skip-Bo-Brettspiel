package com.example.skip_bo_brettspiel;


import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

import GameLogic.StaticParts.SkipBoCard;

public class SkipBoCardTest {
    @Test
    public void testInstanceCount() {
        // Test that up to 12 instances can be created without error
        for (int i = 0; i < 12; i++) {
            new SkipBoCard();
        }
        // Test that trying to create a 13th instance throws an exception
        assertThrows(IllegalStateException.class, () -> new SkipBoCard());
    }
}
