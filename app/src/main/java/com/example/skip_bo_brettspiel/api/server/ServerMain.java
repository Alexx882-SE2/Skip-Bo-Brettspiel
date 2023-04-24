package com.example.skip_bo_brettspiel.api.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.example.skip_bo_brettspiel.api.packages.request.PingRequest;
import com.example.skip_bo_brettspiel.api.packages.response.PingResponse;

import java.io.IOException;

public class ServerMain {
    public ServerMain() {
        Server server = new Server();
        server.start();

        try {
            server.bind(54555);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        server.addListener(new ServerListener());

        Kryo kryo = server.getKryo();
        kryo.register(PingRequest.class);
        kryo.register(PingResponse.class);
    }
}
