package com.example.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.Entity.Player;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlayerRecycleAdapter extends RecyclerView.Adapter<PlayerRecycleViewHolder> {

    private ArrayList<Player> playerArrayList;

    public PlayerRecycleAdapter(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    @NonNull
    @Override
    public PlayerRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_scorer_row_template, parent, false);
        return new PlayerRecycleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PlayerRecycleViewHolder holder, int position) {

        holder.playerName.setText(playerArrayList.get(position).getName());
        Picasso.get().load(R.drawable.men_image).into(holder.playerImage);

    }

    @Override
    public int getItemCount() {
        return playerArrayList.size();
    }
}
