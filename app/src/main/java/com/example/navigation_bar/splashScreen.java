package com.example.navigation_bar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    View p1,p2,p3,p4,p5,p6,p7,p8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        p1 = findViewById(R.id.p_image1);
        p2 = findViewById(R.id.p_image2);
        p3 = findViewById(R.id.p_image3);
        p4 = findViewById(R.id.p_image4);
        p5 = findViewById(R.id.p_image5);
        p6 = findViewById(R.id.logo);
        p7 = findViewById(R.id.plogo);
        p8 = findViewById(R.id.plogo_2);


        p1.animate().translationYBy(2600).rotationX(-1500).alpha((float) 0).setDuration(3000).setStartDelay(1000);
        p2.animate().translationYBy(1600).rotationX(-1600).alpha((float) 0).setDuration(3000).setStartDelay(900);
        p3.animate().translationYBy(1700).rotationX(-1400).alpha((float) 0).setDuration(3000).setStartDelay(600);
        p4.animate().translationYBy(1800).rotationX(-1800).alpha((float) 0).setDuration(3000).setStartDelay(800);
        p5.animate().translationYBy(1000).rotationX(-1000).alpha((float) 0).setDuration(3000).setStartDelay(500);

        p6.animate().translationX(2200).setStartDelay(4000);;
        p7.animate().translationX(-2200).setStartDelay(4000);;
        p8.animate().translationX(-2200).setStartDelay(4000);;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(splashScreen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        },5000);
    }
}