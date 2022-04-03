package com.example.projectgenii;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.*;

public class CreateCard extends AppCompatActivity {

    private ImageButton back;


    Context activity = this;

    Button createB;

    public void create(View V)
    {
        EditText qInput = (EditText) findViewById(R.id.QuestionInput);
        String QuestionInput = qInput.getText().toString();
        EditText aInput = (EditText) findViewById(R.id.AnswerInput);
        String AnswerInput = aInput.getText().toString();


        if (QuestionInput.length() <= 0){ //if the question input is empty, display error message
            qInput.setError("Please input a title");
            return;
        }
        if (AnswerInput.length() <= 0){ //if the Answer input is empty, display error message
            aInput.setError("Please input an answer");
            return;
        }
        else {

            if (CardMapping.getCache().containsKey(QuestionInput)){ // no duplicate question can be allowed with the same title
                qInput.setError("There is an already existing question with the same title");
                return;
            }
            else{
                CardMapping.getCache().put(QuestionInput,AnswerInput);
                saveData();
                Intent intent = new Intent(this, MainActivity.class); // after the card has been inputted into the list return home.
                startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(), "Card has been created", Toast.LENGTH_SHORT);
                toast.show();

            }


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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }



    /**
     *     Save and get HashMap in SharedPreference
     */

    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(CardMapping.cache);
        editor.putString("p", json);
        editor.apply();

    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("p",null);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        CardMapping.cache = gson.fromJson(json,type);

        if (CardMapping.cache == null){
            CardMapping.cache = new HashMap<>();
        }
    }







}