package com.example.projectgenii;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.transition.MaterialElevationScale;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlay extends AppCompatActivity {

    List<String> cards = new ArrayList<>();
    int index;
    String[][] List;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        getSupportActionBar().hide(); //hides the action bar


        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               returnToHome();
            }
        });

        cards = new ArrayList<>(CardMapping.getCache().keySet());

        List =  new String[cards.size()][1];

        for (int i = 0; i < cards.size(); i++) {
            List[i][0] = cards.get(i);
        }
        System.out.println(cards.get(0));

        index = 0;

        TextView mainTxt = (TextView) findViewById(R.id.qOrA);
        TextView header = (TextView) findViewById(R.id.header);

        mainTxt.setText(cards.get(index));

        TextView tip = (TextView) findViewById(R.id.tip);


        findViewById(R.id.card).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                if (CardMapping.cache.containsKey(cards.get(index)) && (mainTxt.getText() == cards.get(index)) ) {
                    header.setText("Answer");
                    mainTxt.setText(CardMapping.cache.get(cards.get(index)));
                    tip.setText("Click anywhere on the card to show the Question");
                }
                else{
                    header.setText("Question");
                    mainTxt.setText((cards.get(index)));
                    tip.setText("Click anywhere on the card to show the Answer");

                }
            }
        });


        findViewById(R.id.continueGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index >= (cards.size()-1)) {
                    findViewById(R.id.homeButton).callOnClick();
                    return;
                }

                index++;
                mainTxt.setText(cards.get(index));
                header.setText("Question");
                tip.setText("Click anywhere on the card to show the answer");
                System.out.println(mainTxt);
            }
        });


    }

    public void returnToHome() // app will go back to home screen
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }


}
