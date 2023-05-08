package com.example.skip_bo_brettspiel.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.skip_bo_brettspiel.GameModel.Player;
import com.example.skip_bo_brettspiel.PlayerListActivity;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class GameClient {
    public Client client;
    private final Player player;
    private final Context context;
    private ArrayList<Player> players;

    public GameClient(Player player, Context context) throws IOException {
        this.player = player;
        this.context = context;
        client = new Client();
        registerClasses();
        client.start();

        new Thread(() -> {
            try {
                client.connect(5000, "10.0.2.16", Network.TCP);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        client.addListener(new GameClientListener());
    }

    public List<InetAddress> discoverHosts() {
        return client.discoverHosts(Network.UDP, 5000);
    }

    public void registerClasses() {
        Kryo kryo = client.getKryo();
        kryo.register(Player.class);
        kryo.register(ArrayList.class);
    }

    public void stop() {
        client.stop();
    }

    private class GameClientListener extends Listener {

        @Override
        public void connected(Connection connection) {
            client.sendTCP(player);
        }

        @Override
        public void disconnected(Connection connection) {

        }

        @Override
        public void received(Connection connection, Object object) {
            if (object instanceof Player) {
                Player player = (Player) object;
                startIntent(player);
            }
            if (object instanceof ArrayList) {
                players = (ArrayList) object;
            }
        }

        public void startIntent(Player player) {
            Intent intent = new Intent(context, PlayerListActivity.class);

            Bundle extras = new Bundle();
            extras.putString("name", player.getName());
            extras.putString("color", player.getColor());
            intent.putExtras(extras);
            context.startActivity(intent);
        }
    }

}
