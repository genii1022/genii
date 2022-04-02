package com.example.genii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.getMenu().findItem(R.id.placeholder).setEnabled(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navView.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();

        FloatingActionButton fabButton = (FloatingActionButton) findViewById(R.id.fab);
        fabButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new AddFragment()).commit();
                if (navView.getSelectedItemId() == R.id.placeholder) {
                    EditText questionEl = (EditText)findViewById(R.id.et_questionInput);
                    String question = questionEl.getText().toString();

                    EditText answerEl = (EditText)findViewById(R.id.et_answerInput);
                    String answer = answerEl.getText().toString();

                    CardModel card = new CardModel(-1, question, answer);

                    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                    dataBaseHelper.addCard(card);

                    navView.setSelectedItemId(R.id.miHome);
                    return;
                }

                navView.setSelectedItemId(R.id.placeholder);
                fabButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_check_24));
                fabButton.getDrawable().setTint(getResources().getColor(R.color.peach));
            }
        });
    }
    private final NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.miHome:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.miPlay:
                            selectedFragment = new StartFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                    FloatingActionButton fabButton = (FloatingActionButton) findViewById(R.id.fab);
                    fabButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_add_24));
                    fabButton.getDrawable().setTint(getResources().getColor(R.color.black));
                    return true;
                }
            };
}