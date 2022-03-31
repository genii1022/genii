package com.example.projectgenii;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity { //navigation bar code


    BottomNavigationView navigationView;

    FloatingActionButton AddButton;

    @Override
    protected void onCreate( Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //hides the action bar


        navigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.home);

        AddButton = findViewById(R.id.floatingButton); //the add button goes to the create screen
        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CreateCardScreen();
            }
        });


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.play:
                        fragment = new PlayFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();


                return true;
            }
        });

    }
    public void CreateCardScreen() // app will go back to create screen
    {
        Intent intent = new Intent(this, CreateCard.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }


}