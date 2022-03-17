package com.example.geniiproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * instance variables for buttons
     */
    private Button button1;//home
    private Button button2;//folder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Code for the buttons
         * Starts here
         */
        button1 = (Button) findViewById(R.id.home);
        button2 = (Button) findViewById(R.id.category);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfolderActivity();
            }
        });
    }

    public void openfolderActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //slide right
    }

    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        // startActivity(intent); // We're already on the home page, hence no need to click on it
    }

    /**
     * End here
     */
}