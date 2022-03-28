package com.example.navigation_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CreateCard extends AppCompatActivity {

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);
        getSupportActionBar().hide(); //hides the action bar

        //When user clicks on "back" button, app will go back to home screen
        back = (ImageButton) findViewById(R.id.goBack);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                returnToHome();
            }
        });

    }

    public void returnToHome() // app will go back to home screen
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}