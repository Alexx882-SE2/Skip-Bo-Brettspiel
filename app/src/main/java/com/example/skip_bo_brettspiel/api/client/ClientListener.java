package com.example.skip_bo_brettspiel.api.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.skip_bo_brettspiel.api.packages.response.PingResponse;

public class ClientListener extends Listener {
    @Override
    public void connected(Connection connection) {
        System.out.println("[client] client connected");
    }

    @Override
    public void disconnected(Connection connection) {
        System.out.println("[client] client connected");
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof PingResponse) {
            PingResponse pingResponse = (PingResponse) object;
            System.out.println("time: " + pingResponse.time);
            System.out.println(pingResponse.text);
        }
    }
}
