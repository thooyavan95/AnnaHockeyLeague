package com.example.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.R;

public class PlayerRecycleViewHolder extends RecyclerView.ViewHolder {

    public ImageView playerImage;
    public TextView playerName;

    public PlayerRecycleViewHolder(@NonNull View itemView) {
        super(itemView);

        playerImage = itemView.findViewById(R.id.top_scorer_avatar);
        playerName = itemView.findViewById(R.id.top_scorer_name);

    }
}
