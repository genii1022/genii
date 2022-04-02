package com.example.genii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GameCompleted extends AppCompatActivity {


    // References to the buttons on the game-completed page
    ImageButton homeBtn;
    ImageButton playAgainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_completed);

        homeBtn = findViewById(R.id.homeButton);
        playAgainBtn = findViewById(R.id.playAgain);

        // Button listeners for the buttons on this page
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeScreen(); // Should go to home page; will change when merged with rest of proj.
            }
        });
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameScreen(); // Should go to game page; will change when merged with rest of proj.
            }
        });
    }

    public void openHomeScreen()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openGameScreen()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}