package com.example.skip_bo_brettspiel.GameModel;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {

    public void getStartCards(ArrayList<Player> players){
        if(players.size()>4){
            throw new IllegalArgumentException("Nut gud players to big plz make smaller or i cry");
        }
        Random random = new Random();
        int[] duplicates = new int[13];
        for (Player player : players) {
            player.cards.clear();
            for(int i = 0; i<10; i++){
                int value = random.nextInt(13);
                if(duplicates[value] < 8){
                    duplicates[value]++;
                } else if(value == 0 && duplicates[value] < 12) {
                    duplicates[value]++;
                } else {
                    i--;
                    continue;
                }
                player.cards.add(new Card(value )); //1-12 are values, 0 is special card
            }
        }
    }
}
