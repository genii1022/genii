package com.example.genii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity
{
    private ImageButton help;
    private ImageButton home;
    private ImageButton categories;
    private ImageButton play;
    private ImageButton blitz;
    private ImageButton createNewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //When user clicks on "info" button, app will go back to help screen
        help = (ImageButton) findViewById(R.id.info);
        help.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openHelpScreen();
            }
        });
    }

    public void openHelpScreen()
    {
        Intent intent = new Intent(this, HelpScreen.class);
        startActivity(intent);
    }
}