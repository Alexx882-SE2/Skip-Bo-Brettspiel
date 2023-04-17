package com.example.skip_bo_brettspiel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skip_bo_brettspiel.GameModel.Player;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText usernameField = findViewById(R.id.editUsername);
        Player currentPlayer = new Player(usernameField.getText().toString());

        // textWatcher is for watching any changes in editText
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // this function is called when text is edited
                currentPlayer.setName(usernameField.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        };

        usernameField.addTextChangedListener(textWatcher);
    }
}