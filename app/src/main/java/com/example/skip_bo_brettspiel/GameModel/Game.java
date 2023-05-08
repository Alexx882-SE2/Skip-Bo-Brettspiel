package com.example.skip_bo_brettspiel.GameModel;

import com.example.skip_bo_brettspiel.Board.Board;
import com.example.skip_bo_brettspiel.Board.Field.BlueField;
import com.example.skip_bo_brettspiel.Board.Field.NumberedField;
import com.example.skip_bo_brettspiel.Board.Field.OrangeField;
import com.example.skip_bo_brettspiel.Board.Field.PinkField;
import com.example.skip_bo_brettspiel.Board.Field.PurpleField;
import com.example.skip_bo_brettspiel.Board.Field.RedField;
import com.example.skip_bo_brettspiel.Board.Field.SkipBoField;
import com.example.skip_bo_brettspiel.Board.Field.SwitchCardField;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int numOfPlayers;
    private CardDealer dealer;
    private boolean started;
    private boolean gameFinished;
    private Board gameboard;

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
                setupBoard();
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

    private void setupBoard(){
        this.gameboard = new Board(24);
        this.gameboard.addField(new BlueField("Blue Field 1", 1));
        this.gameboard.addField(new BlueField("Blue Field 2", 2));
        this.gameboard.addField(new NumberedField("5-8 Field 1", 3, 5, 8));
        this.gameboard.addField(new PinkField("Pink Field 1", 4));
        this.gameboard.addField(new NumberedField("9-12 Field 1", 5, 9, 12));
        this.gameboard.addField(new OrangeField("Orange Field 1", 6));
        this.gameboard.addField(new OrangeField("Orange Field 2", 7));
        this.gameboard.addField(new OrangeField("Orange Field 3", 8));
        this.gameboard.addField(new SkipBoField("SkipBo Field 1", 9));
        this.gameboard.addField(new SwitchCardField("Switch Card Field 1", 10));
        this.gameboard.addField(new NumberedField("1-4 Field 1", 11, 1, 4));
        this.gameboard.addField(new PurpleField("Purple Field 1", 12));
        this.gameboard.addField(new PurpleField("Purple Field 2", 13));
        this.gameboard.addField(new PurpleField("Purple Field 3", 14));
        this.gameboard.addField(new NumberedField("5-8 Field 2", 15, 5, 8));
        this.gameboard.addField(new PinkField("Pink Field 2", 16));
        this.gameboard.addField(new NumberedField("9-12 Field 2", 17, 9, 12));
        this.gameboard.addField(new RedField("Red Field 1", 18));
        this.gameboard.addField(new RedField("Red Field 2", 19));
        this.gameboard.addField(new RedField("Red Field 3", 20));
        this.gameboard.addField(new SkipBoField("SkipBo Field 2", 21));
        this.gameboard.addField(new SwitchCardField("Switch Card Field 2", 22));
        this.gameboard.addField(new NumberedField("1-4 Field 2", 23, 1, 4));
        this.gameboard.addField(new BlueField("Blue Field 2", 24));
    }

    public Board getBoard(){
        if(this.started){
            return this.gameboard;
        }else{
            throw new IllegalArgumentException("Game not started");
        }
    }

}
