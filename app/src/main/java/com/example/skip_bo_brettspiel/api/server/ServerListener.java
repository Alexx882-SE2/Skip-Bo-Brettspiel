package com.example.skip_bo_brettspiel.api.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.skip_bo_brettspiel.api.packages.request.PingRequest;
import com.example.skip_bo_brettspiel.api.packages.response.PingResponse;

public class ServerListener extends Listener {
    @Override
    public void connected(Connection connection) {
        System.out.println("[server] client connected");
    }

    @Override
    public void disconnected(Connection connection) {
        System.out.println("[server] client disconnected");
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof PingRequest) {
            PingResponse pingResponse = new PingResponse();
            pingResponse.text = "Hello Client";
            connection.sendTCP(pingResponse);
        }
    }
}
