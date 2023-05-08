package com.example.skip_bo_brettspiel.GameModel;

import com.esotericsoftware.kryonet.Connection;

import java.util.ArrayList;

public class Player {

    private String name;

    private String color;

    private Connection connection;

    public ArrayList<Card> cards = new ArrayList<>();

    public Player() {
    }

    public Player(String name, String color) {

        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
