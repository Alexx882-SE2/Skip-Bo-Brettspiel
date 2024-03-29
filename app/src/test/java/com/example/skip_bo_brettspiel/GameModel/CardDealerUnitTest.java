package com.example.skip_bo_brettspiel.GameModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CardDealerUnitTest {

    // FIXME too long test with too much functionality for unit test
    @Test
    public void dealStartCardsTest() {
        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        CardDealer dealer = new CardDealer();

        for (int k = 0; k < 100000; k++) { //Repeating this test, since even with faulty implementation probability to get 8 times same card with only 4 people is very small.
            int[] total = new int[13];
            dealer.getStartCards(players);
            for (Player player : players) {
                assertEquals(10, player.mainStack.size());
                for (Card card : player.mainStack) {
                    total[card.cardNumber]++;

                }
            }
            assertTrue(total[0] <= 12);
            for (int i = 1; i < 13; i++) {
                assertTrue(total[i] <= 8);
            }
        }

        int[] total = new int[13];
        for (Player player : players) {
            assertEquals(10, player.mainStack.size());
            for (Card card : player.mainStack) {
                total[card.cardNumber]++;
            }
        }
        assertTrue(total[0] <= 12);
        for (int i = 1; i < 13; i++) {
            assertTrue(total[i] <= 8);
        }

        Player player5 = new Player("Player5");
        players.add(player5);

        assertThrows(IllegalArgumentException.class, () -> dealer.getStartCards(players));
    }
}
