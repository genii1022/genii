package com.example.genii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HelpScreen extends AppCompatActivity
{
    private ImageButton back;
    private ImageButton home;
    private ImageButton categories;
    private ImageButton play;
    private ImageButton blitz;
    private ImageButton createNewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        //When user clicks on "back" button, app will go back to home screen
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                returnToHome();
            }
        });

        //When user clicks on "home" button, app will go to home screen
        home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                returnToHome();
            }
        });
    }

    public void returnToHome()
    {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}