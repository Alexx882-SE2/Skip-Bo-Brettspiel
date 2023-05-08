package com.example.skip_bo_brettspiel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skip_bo_brettspiel.Board.Board;
import com.example.skip_bo_brettspiel.Board.Field.BlueField;
import com.example.skip_bo_brettspiel.Board.Field.NumberedField;
import com.example.skip_bo_brettspiel.Board.Field.OrangeField;
import com.example.skip_bo_brettspiel.Board.Field.PurpleField;
import com.example.skip_bo_brettspiel.Board.Field.RedField;
import com.example.skip_bo_brettspiel.Board.Field.SkipBoField;
import com.example.skip_bo_brettspiel.Board.Field.SwitchCardField;
import com.example.skip_bo_brettspiel.GameModel.Game;
import com.example.skip_bo_brettspiel.GameModel.Player;

import java.util.ArrayList;

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
                ArrayList<Player> players  = new ArrayList<Player>();
                players.add(currentPlayer);
                players.add(new Player("Player 2"));
                Game game = new Game(players);
                game.startGame();
                Board board = game.getBoard();
                //Temporary set the view to the board view
                setContentView(R.layout.board_view);
                Button backButton = findViewById(R.id.button_back);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.activity_main);
                    }
                });
                for(int i = 0; i < 24; i++){
                    String imageViewId = "field_" + (i+1);
                    int resId = getResources().getIdentifier(imageViewId, "id", getPackageName());
                    ImageView currentField = findViewById(resId);
                    if(board.getField(i) instanceof BlueField){
                        currentField.setImageResource(R.drawable.field_blue);
                    }else if(board.getField(i) instanceof OrangeField){
                        currentField.setImageResource(R.drawable.field_orange);
                    }else if(board.getField(i) instanceof PurpleField){
                        currentField.setImageResource(R.drawable.field_purple);
                    }else if(board.getField(i) instanceof RedField){
                        currentField.setImageResource(R.drawable.field_red);
                    }else if(board.getField(i) instanceof SkipBoField){
                        currentField.setImageResource(R.drawable.field_skip_bo);
                    }else if(board.getField(i) instanceof SwitchCardField){
                        currentField.setImageResource(R.drawable.field_swap);
                    }else if(board.getField(i) instanceof NumberedField){
                        switch (((NumberedField) board.getField(i)).getLowerBound()){
                            case 1:
                                currentField.setImageResource(R.drawable.field_1_4);
                                break;
                            case 5:
                                currentField.setImageResource(R.drawable.field_5_8);
                                break;
                            case 9:
                                currentField.setImageResource(R.drawable.field_9_12);
                                break;
                        }

                    }

                }

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