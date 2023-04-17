package com.example.skip_bo_brettspiel.GameModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardUnitTest {

    @Test
    public void testBasic(){
        for(int i = 0; i<13; i++){
            assertEquals(i,new Card(i).value);
        }
    }
}
