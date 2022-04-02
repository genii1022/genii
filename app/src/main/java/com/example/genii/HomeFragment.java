package com.example.genii;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<CardModel> cards;
    HomeRecyclerViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        cards = dataBaseHelper.getAllCards();

        RecyclerView recyclerView = view.findViewById(R.id.rv_cards);
        adapter = new HomeRecyclerViewAdapter(getActivity(), cards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        EditText search = view.findViewById(R.id.et_searchBar);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return view;
    }

    private void filter(String text) {
        ArrayList<CardModel> filteredList = new ArrayList<>();
        for (CardModel card: cards) {
            if (card.getQuestion().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(card);
            }
        }
        adapter.filterList(filteredList);
    }
}
