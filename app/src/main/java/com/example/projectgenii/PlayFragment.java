package com.example.projectgenii;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class PlayFragment extends Fragment {


    Button playB;
    TextView Error;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_play, container, false); // USE THESE  LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY

        playB = v.findViewById(R.id.startGame);
        Error =  v.findViewById(R.id.warning);

        playB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CardMapping.cache.isEmpty() == true){

                    playB.setError("Must have atleast one card created before playing");
                   Error.setText("Must have atleast one card created before playing");

                }
                else {
                    Error.setText("");
                    Intent intent = new Intent(getActivity(), GamePlay.class); // USE THESE LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY
                    startActivity(intent);
                }

            }
        });


        // Inflate the layout for this fragment
        return v;
    }
}