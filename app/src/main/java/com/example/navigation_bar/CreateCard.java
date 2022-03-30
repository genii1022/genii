package com.example.navigation_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CreateCard extends AppCompatActivity {

    private ImageButton back;

    Button createB;

    public void create(View V)
    {
        EditText qInput = (EditText) findViewById(R.id.QuestionInput);
        String QuestionInput = qInput.getText().toString();
        EditText aInput = (EditText) findViewById(R.id.AnswerInput);
        String AnswerInput = aInput.getText().toString();

        if (QuestionInput.length() <= 0){ //if the question input is empty, display error message
            qInput.setError("Please input a title");

        }
        if (AnswerInput.length() <= 0){ //if the Answer input is empty, display error message
            aInput.setError("Please input an answer");

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);
        getSupportActionBar().hide(); //hides the action bar


        createB = (Button) findViewById(R.id.Create_Button);
        createB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                create(view);

            }
        });


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