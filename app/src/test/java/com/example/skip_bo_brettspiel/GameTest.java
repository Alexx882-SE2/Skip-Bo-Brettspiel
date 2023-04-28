package com.example.skip_bo_brettspiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void startNormalGameBehaviour(){
        Game game1 = new Game(players);
        game1.addPlayer(new Player("Spieler100"));
        game1.startGame();
        assertTrue(game1.isStarted());
    }

    @Test
    public void tooManyPlayersTest(){
        players.add(new Player("Spieler 3"));
        players.add(new Player("Spieler 4"));
        String tooManyPlayersException = "Maximum 4 players allowed";

        Game game1 = new Game(players);
        Exception ex1 = assertThrows(IllegalArgumentException.class, () ->{
            game1.addPlayer(new Player("Spieler 5"));
        });
        assertTrue(ex1.getMessage().contains(tooManyPlayersException));

        players.add(new Player("Spieler 6"));
        Exception ex2 = assertThrows(IllegalArgumentException.class, () ->{
            game1.startGame();
        });
        assertTrue(ex2.getMessage().contains(tooManyPlayersException));

    }

    @Test
    public void gameAlreadyStartedTest(){
        Game game1 = new Game(players);
        game1.startGame();
        String alreadyStartedException = "Game already started";

        Exception ex1 = assertThrows(IllegalArgumentException.class, () ->{
            game1.addPlayer(new Player("Spieler 3"));
        });
        assertTrue(ex1.getMessage().contains(alreadyStartedException));

        Exception ex2 = assertThrows(IllegalArgumentException.class, () ->{
            game1.startGame();
        });
        assertTrue(ex2.getMessage().contains(alreadyStartedException));



    }

}
