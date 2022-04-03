package com.example.projectgenii;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    private ImageButton back;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    String q;
    String p;
    ListView listView;
    EditText cardPopUp_Answer;
    TextView cardPopUp_Question;
    Button cardPopup_save, cardPopup_delete, deleteButton;
    ImageButton cardPopup_back, goback;
    ArrayList<Card> arrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_home, container, false); // USE THESE  LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY

        listView = v.findViewById(R.id.listview);


        ArrayList<String> InitialList = new ArrayList<>(CardMapping.getCache().keySet());

        for (int i = 0; i < InitialList.size(); i++) {
            arrayList.add(new Card(InitialList.get(i)));

        }


        ArrayAdapter arrayAdapter = new customArrayAdapter(getActivity(), R.layout.list_row, arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                q = String.format("%d", i);
                p = arrayList.get(i).CardQuestion; //important line to for usage TODO

                // arrayList.get(i).setCardQuestion("YO MOMMA FAT LOL"); // TODO


                RevealAndEdit(p, arrayAdapter, i);
                arrayAdapter.notifyDataSetChanged();

                //Toast.makeText(getActivity(), " Index is: " + q + " and " + " what's in it: " + p, Toast.LENGTH_SHORT).show();
            }
        });


        ImageButton help = v.findViewById(R.id.helpButton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), HelpScreen.class); // USE THESE LINES WHEN TRYING TO DO ONCLICKS FROM FRAGMENTS TO ACTIVITY
                startActivity(intent);

            }

        });

        return v;
    }

    public void RevealAndEdit(String questionName, ArrayAdapter arrayAdapter, int i) {
        dialogBuilder = new AlertDialog.Builder(getActivity());
        final View popupView = getLayoutInflater().inflate(R.layout.popup, null);
        /**TO DO**/

        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();

        cardPopUp_Question = popupView.findViewById(R.id.QuestionTitle);
        cardPopUp_Answer = popupView.findViewById(R.id.AnswerInput2);
        cardPopup_delete = popupView.findViewById(R.id.delete);
        cardPopup_save = popupView.findViewById(R.id.Save);
        cardPopup_back = popupView.findViewById(R.id.goBack);

        cardPopUp_Question.setText(questionName);
        cardPopUp_Answer.setText(CardMapping.cache.get(questionName));

        cardPopup_back.setOnClickListener(new View.OnClickListener() { // closes popup
            @Override
            public void onClick(View view) {
               arrayAdapter.notifyDataSetChanged();
                dialog.hide();
            }
        });

        cardPopup_save.setOnClickListener(new View.OnClickListener() //Save new Answer
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if (cardPopUp_Answer.length() <= 0) { //if the Answer input is empty, display error message
                    cardPopUp_Answer.setError("Please input an answer");
                } else {
                    String newValue = cardPopUp_Answer.getText().toString();
                    CardMapping.cache.replace(questionName, newValue);

                    saveData();
                    Toast.makeText(getActivity(), "New answer has been save", Toast.LENGTH_SHORT).show();
                    dialog.hide();
                }
            }

        });

        cardPopup_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
                AreYouSure(questionName, arrayAdapter, i);
            }
        });


        listView.setAdapter(arrayAdapter);// refresh the list with new question title


    }

    public void AreYouSure(String questionName,ArrayAdapter arrayAdapter, int i) {
        dialogBuilder = new AlertDialog.Builder(getActivity());
        final View popupView = getLayoutInflater().inflate(R.layout.are_u_sure_popup, null);
        /**TO DO**/

        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();

        deleteButton = popupView.findViewById(R.id.delete);
        goback = popupView.findViewById(R.id.goBack);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CardMapping.cache.remove(questionName);

                arrayAdapter.remove(arrayList.get(i));
                saveData();

                dialog.hide();


            }
        });

    }

    private void saveData()
    {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(CardMapping.cache);
        editor.putString("p", json);
        editor.apply();

    }


}

