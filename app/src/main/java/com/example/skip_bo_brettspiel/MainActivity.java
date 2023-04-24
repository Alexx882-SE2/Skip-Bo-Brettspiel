package com.example.skip_bo_brettspiel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skip_bo_brettspiel.GameModel.Player;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText usernameField = findViewById(R.id.editUsername);
        Button createGameButton = findViewById(R.id.createButton);
        Button joinGameButton = findViewById(R.id.joinButton);
        Player currentPlayer = new Player(usernameField.getText().toString());

        createGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentPlayer.setName(usernameField.getText().toString());
                //Code to host a game on device.
            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentPlayer.setName(usernameField.getText().toString());
                //Code to join existing game.

            }
        });

    }
}