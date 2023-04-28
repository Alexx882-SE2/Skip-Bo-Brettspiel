package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.skip_bo_brettspiel.GameModel.Game;
import com.example.skip_bo_brettspiel.GameModel.Player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    private static ArrayList<Player> players;

    @BeforeAll
    public static void setup(){
        players = new ArrayList<>();
        players.add(new Player("Spieler1"));
        players.add(new Player("Spieler2"));
    }

    @Test
    public void createGameTest(){
        Game game1 = new Game(players);
    }

    @Test
    public void startGameBehaviour(){
        Game game1 = new Game(players);
        game1.addPlayer(new Player("Spieler100"));
        game1.startGame();
        Exception ex1 = assertThrows(IllegalArgumentException.class, () ->{
            game1.startGame();
        });

        String expectedMessage1 = "Game already started";
        String actualMessage1 = ex1.getMessage();

        assertTrue(actualMessage1.contains(expectedMessage1));

        players.add(new Player("Spieler3"));
        players.add(new Player("Spieler4"));
        players.add(new Player("Spieler5"));
        Game game2= new Game(players);

        Exception ex2 = assertThrows(IllegalArgumentException.class, () ->{
            game2.startGame();
        });

        String expectedMessage2 = "Game already started";
        String actualMessage2 = ex2.getMessage();

        assertTrue(actualMessage1.contains(expectedMessage2));

    }

}
