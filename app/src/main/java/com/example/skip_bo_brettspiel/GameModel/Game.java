package com.example.skip_bo_brettspiel.GameModel;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int numOfPlayers;
    private CardDealer dealer;
    private boolean started;
    private boolean gameFinished;

    public Game(ArrayList<Player> players){

        this.players = players;
        this.numOfPlayers = players.size();
        this.dealer = new CardDealer();
        this.started = false;
        this.gameFinished = false;

    }

    public void addPlayer(Player p){
        if(!started){
            if(numOfPlayers < 4){
                this.players.add(p);
                numOfPlayers++;
            }else{
                throw new IllegalArgumentException("Maximum 4 players allowed");
            }
        }else{
            throw new IllegalArgumentException("Game already started");
        }
    }

    public void startGame(){

        if(!started){
            if(this.players.size() < 5){
                this.started = true;
                numOfPlayers = this.players.size();
                dealer.getStartCards(this.players);
                while(!gameFinished){
                    for(int i = 0; i < numOfPlayers; i++){
                        waitForMove(i);
                    }
                }
            }else{
                throw new IllegalArgumentException("Maximum 4 players allowed");
            }
        }else{
            throw new IllegalArgumentException("Game already started");
        }

    }

    public void waitForMove(int playerIndex){
        String command = ""; //Fetch command from Client
        switch(command){
            //Switch for commands
        }
        this.gameFinished = true;

    }

    public boolean isStarted(){
        return this.started;
    }

}
