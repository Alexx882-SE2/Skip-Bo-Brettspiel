package com.example.skip_bo_brettspiel.api.client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.example.skip_bo_brettspiel.api.packages.request.PingRequest;
import com.example.skip_bo_brettspiel.api.packages.response.PingResponse;

import java.io.IOException;

public class ClientMain {
    public ClientMain() {
        Client client = new Client();
        client.start();
        try {
            client.connect(5000, "127.0.0.1", 54555);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        client.addListener(new ClientListener());

        Kryo kryo = client.getKryo();
        kryo.register(PingRequest.class);
        kryo.register(PingResponse.class);

        PingRequest pingRequest = new PingRequest();
        pingRequest.text = "Hello Server";
        client.sendTCP(pingRequest);
    }
}
