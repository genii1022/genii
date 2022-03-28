package com.example.navigation_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity { //navigation bar code


    BottomNavigationView navigationView;

    FloatingActionButton AddButton;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); //hides the action bar

        AddButton = findViewById(R.id.floatingButton); //the add button goes to the create screen
        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CreateCardScreen();
            }
        });


        navigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.home);


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.folder:
                        fragment = new FolderFragment();
                        break;

                    case R.id.play:
                        fragment = new PlayFragment();
                        break;

                    case R.id.blitz:
                        fragment = new BlitzFragment();
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
    }

}