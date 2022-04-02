package com.example.genii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When user taps anywhere on the screen, app will go to gameplay screen
        screen = (ConstraintLayout) findViewById(R.id.launchLayout);
        screen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openGame();
            }
        });
    }

    public void openGame()
    {
        Intent intent = new Intent(this, GamePlay.class);
        startActivity(intent);
    }
}