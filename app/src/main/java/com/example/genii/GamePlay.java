package com.example.genii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class GamePlay extends AppCompatActivity {

    // References to the widgets on the game-completed page
    private LinearLayout card;
    private TextView qOrA = (TextView)findViewById(R.id.qOrA);
    private TextView tapOnCard;
    private ImageButton homeBtn;
    private ImageButton continueBtn;
    private ImageButton backToQBtn;
    private HashMap<String, String> qAndA;
    private ArrayList<String> qAndADisplay;
    private int cardNum;
    private boolean onQuestion;  // Is true if card is flipped on the questions side, false otherwise

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        card = (LinearLayout) findViewById(R.id.card);
        tapOnCard = findViewById(R.id.tapCard);
        homeBtn = findViewById(R.id.homeButton);
        continueBtn = findViewById(R.id.continueGame);
        backToQBtn = findViewById(R.id.backToQ);
        onQuestion = true;
        cardNum = 0;

        continueBtn.setVisibility(View.INVISIBLE);
        backToQBtn.setVisibility(View.INVISIBLE);
        tapOnCard.setVisibility(View.VISIBLE);

        qAndA = new HashMap<>();
        qAndA.put("Q1", "A1");
        qAndA.put("Q2", "A2");
        qAndA.put("Q3", "A3");
        qAndA.put("Q4", "A4");
        qAndA.put("Q5", "A5");

        qAndADisplay = new ArrayList<>(qAndA.keySet());

        // Button listeners for the buttons on this page
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeScreen(); // Should go to home page; will change when merged with rest of proj.
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onQuestion)
                {
                    qOrA.setText(qAndA.get(qAndADisplay.get(cardNum)));
                    tapOnCard.setVisibility(View.INVISIBLE);
                    continueBtn.setVisibility(View.VISIBLE);
                    backToQBtn.setVisibility(View.VISIBLE);
                    onQuestion = false;
                }
            }
        });
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardNum < qAndADisplay.size())
                {
                    cardNum++;
                    qOrA.setText(qAndADisplay.get(cardNum));
                    continueBtn.setVisibility(View.INVISIBLE);
                    backToQBtn.setVisibility(View.INVISIBLE);
                    tapOnCard.setVisibility(View.VISIBLE);
                    onQuestion = true;
                }
                else
                {
                    openGameEnd();
                }
            }
        });
        backToQBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onQuestion = true;
                qOrA.setText(qAndADisplay.get(cardNum));
                continueBtn.setVisibility(View.INVISIBLE);
                backToQBtn.setVisibility(View.INVISIBLE);
                tapOnCard.setVisibility(View.VISIBLE);
                onQuestion = true;
            }
        });
    }

    public void openHomeScreen()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openGameEnd()
    {
        Intent intent = new Intent(this, GameCompleted.class);
        startActivity(intent);
    }
}