package com.ahl.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.Entity.PlayerDetails;
import com.ahl.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlayerRecycleAdapter extends RecyclerView.Adapter<PlayerRecycleViewHolder> {

    private ArrayList<PlayerDetails> playerArrayList;
    private static final String TAG = PlayerRecycleAdapter.class.getSimpleName();

    public PlayerRecycleAdapter(ArrayList<PlayerDetails> playerArrayList) {
        Log.d(TAG, "player recycle adapter");
        this.playerArrayList = playerArrayList;
    }

    @NonNull
    @Override
    public PlayerRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "player recycle view holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_scorer_row_template, parent, false);
        return new PlayerRecycleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PlayerRecycleViewHolder holder, int position) {

        Log.d(TAG, "on bind view holder");
        holder.playerName.setText(playerArrayList.get(position).getPlayer().getName());
        Picasso.get().load(R.drawable.men_image).into(holder.playerImage);
        holder.playerPosition.setText(playerArrayList.get(position).getPlayer().getPosition().getPosition());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "get item count" + playerArrayList.size());
        return playerArrayList.size();
    }
}
