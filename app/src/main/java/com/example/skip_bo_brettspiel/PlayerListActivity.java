package com.example.skip_bo_brettspiel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skip_bo_brettspiel.GameModel.Player;

import java.util.ArrayList;

public class PlayerListActivity extends AppCompatActivity {
    private static final ArrayList<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        ListView playerListView = findViewById(R.id.playerListView);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String color = extras.getString("color");

        Player player = new Player(name, color);
        players.add(player);

        PlayerListAdapter playerListAdapter = new PlayerListAdapter(this, players);
        playerListView.setAdapter(playerListAdapter);
    }

    public static class PlayerListAdapter extends ArrayAdapter<Player> {
        private final LayoutInflater inflater;
        private final ArrayList<Player> players;

        public PlayerListAdapter(Context context, ArrayList<Player> players) {
            super(context, R.layout.list_item_player, players);
            this.players = players;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item_player, parent, false);
            }
            Player player = players.get(position);

            TextView playerNameTextView = convertView.findViewById(R.id.playerNameTextView);
            playerNameTextView.setText(player.getName());

            TextView playerColorTextView = convertView.findViewById(R.id.playerColorTextView);
            playerColorTextView.setText(player.getColor());

            return convertView;
        }
    }
}