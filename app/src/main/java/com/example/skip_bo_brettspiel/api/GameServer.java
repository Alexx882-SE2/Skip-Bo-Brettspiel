package com.example.skip_bo_brettspiel.api;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.example.skip_bo_brettspiel.GameModel.Player;
import com.example.skip_bo_brettspiel.MainActivity;

import java.io.IOException;
import java.util.ArrayList;

public class GameServer {
    private final Server server;
    private final ArrayList<Player> players;
    private static int numPlayers = 0;

    public GameServer(ArrayList<Player> players) throws IOException {
        this.players = players;
        server = new Server();
        registerClasses();

        server.bind(Network.TCP);
        server.start();
        MainActivity.gameCreated = true;

        server.addListener(new GameServerListener());
    }

    public void registerClasses() {
        Kryo kryo = server.getKryo();
        kryo.register(Player.class);
        kryo.register(ArrayList.class);
    }

    public void stop() {
        server.stop();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    private class GameServerListener extends Listener {
        @Override
        public void connected(Connection connection) {

        }

        @Override
        public void received(Connection connection, Object object) {
            if (object instanceof Player) {
                // Create a new player and add them to the list of players
                Player player = (Player) object;
                String color = getPlayerColor(numPlayers);
                numPlayers++;
                player.setColor(color);
                players.add(player);
                // Send a message to the new player with their color
                connection.sendTCP(player);
                server.sendToAllTCP(players);
            }
        }

        @Override
        public void disconnected(Connection connection) {
            Player player = getPlayer(connection);
            if (player != null) {
                players.remove(player);
                server.sendToAllTCP(players);
            }
        }

        private Player getPlayer(Connection connection) {
            for (Player player : players) {
                if (player.getConnection() == connection) {
                    return player;
                }
            }
            return null;
        }

        private String getPlayerColor(int playerNum) {
            switch (playerNum) {
                case 0:
                    return "blue";
                case 1:
                    return "orange";
                case 2:
                    return "purple";
                case 3:
                    return "red";
                default:
                    return "gray";
            }
        }
    }
}
