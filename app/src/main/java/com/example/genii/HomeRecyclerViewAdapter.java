package com.example.genii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<CardModel> cards = new ArrayList<CardModel>();

    public HomeRecyclerViewAdapter(Context ct, List<CardModel> cardsList) {
        context = ct;
        cards = cardsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mainText.setText(cards.get(position).getQuestion());
        holder.card_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mainText.getText() == cards.get(holder.getAdapterPosition()).getQuestion()) {
                    holder.mainText.setText(cards.get(holder.getAdapterPosition()).getAnswer());
                    holder.hintText.setText("Click anywhere on the card to show the question");
                } else {
                    holder.mainText.setText(cards.get(holder.getAdapterPosition()).getQuestion());
                    holder.hintText.setText("Click anywhere on the card to show the answer");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void filterList(ArrayList<CardModel> filteredList) {
        cards = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mainText;
        TextView hintText;
        ConstraintLayout card_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.tv_mainText);
            card_layout = itemView.findViewById(R.id.card_constraint_layout);
            hintText = itemView.findViewById(R.id.tv_clickTip);
        }
    }
}
