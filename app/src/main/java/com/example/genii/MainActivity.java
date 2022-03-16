package com.example.genii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When user taps anywhere on the screen, app will go to home screen
        screen = (ConstraintLayout) findViewById(R.id.launchLayout);
        screen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openHomeScreen();
            }
        });
    }

    public void openHomeScreen()
    {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}