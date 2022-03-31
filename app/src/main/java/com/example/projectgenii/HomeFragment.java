package com.example.projectgenii;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_home, container, false); // USE THESE  LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY
        ImageButton help = v.findViewById(R.id.helpButton);

        help.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), HelpScreen.class); // USE THESE LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY
                startActivity(intent);
                

            }

        });

        return v;
    }

}

