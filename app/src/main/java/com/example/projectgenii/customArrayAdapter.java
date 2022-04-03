package com.example.projectgenii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class customArrayAdapter extends ArrayAdapter<Card> {

    private Context mContext;
    private int mResource;

    public customArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Card> objects){
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;



    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView Question = convertView.findViewById(R.id.questiontext);

        Question.setText(getItem(position).getCardQuestion());

        return convertView;



    }



}
