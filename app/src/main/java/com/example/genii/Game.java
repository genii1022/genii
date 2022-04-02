package com.example.genii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game extends AppCompatActivity {
    List<CardModel> cards;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, MainActivity.class);
                startActivity(intent);
            }
        });

        DataBaseHelper dataBaseHelper = new DataBaseHelper(Game.this);
        cards = dataBaseHelper.getAllCards();

        Collections.shuffle(cards);

        index = 0;

        TextView mainTxt = (TextView) findViewById(R.id.tv_mainText);
        mainTxt.setText(cards.get(index).getQuestion());

        TextView tip = (TextView) findViewById(R.id.tv_clickTip);

        findViewById(R.id.game_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainTxt.getText() == cards.get(index).getQuestion()) {
                    mainTxt.setText(cards.get(index).getAnswer());
                    tip.setText("Click anywhere on the card to show the question");
                } else {
                    mainTxt.setText(cards.get(index).getQuestion());
                    tip.setText("Click anywhere on the card to show the answer");
                }
            }
        });

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index >= (cards.size()-1)) {
                    findViewById(R.id.btn_home).callOnClick();
                    return;
                }

                index++;
                mainTxt.setText(cards.get(index).getQuestion());
                tip.setText("Click anywhere on the card to show the answer");
            }
        });
    }
}