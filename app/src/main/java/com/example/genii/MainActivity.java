package com.example.genii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
         navView.getMenu().findItem(R.id.placeholder).setEnabled(false);
    }
}