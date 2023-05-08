package com.example.skip_bo_brettspiel;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skip_bo_brettspiel.GameModel.Player;
import com.example.skip_bo_brettspiel.api.GameClient;
import com.example.skip_bo_brettspiel.api.GameServer;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final ArrayList<Player> players = new ArrayList<>();

    public static boolean gameCreated = false;

    private static GameServer gameServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText usernameField = findViewById(R.id.editUsername);
        Button createGameButton = findViewById(R.id.createButton);
        Button joinGameButton = findViewById(R.id.joinButton);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        createGameButton.setOnClickListener(v -> {
            if (!gameCreated) {
                String playerName = usernameField.getText().toString();
                if (!playerName.isEmpty()) {
                    Player player = new Player(playerName, "");
                    try {
                        gameServer = new GameServer(players);
                        new GameClient(player, MainActivity.this);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a player name.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Already active lobby", Toast.LENGTH_SHORT).show();
            }
        });

        joinGameButton.setOnClickListener(v -> {
            if (gameCreated) {
                String playerName = usernameField.getText().toString();
                if (!playerName.isEmpty()) {
                    Player player = new Player(playerName, "");
                    try {
                        if (gameServer.getNumPlayers() > 3) {
                            Toast.makeText(MainActivity.this, "There are already 4 players in the lobby!", Toast.LENGTH_SHORT).show();
                        } else {
                            new GameClient(player, MainActivity.this);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a player name.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "No active lobby.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}