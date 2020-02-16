package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.R;

public class TeamViewHolder extends RecyclerView.ViewHolder {

    public ImageView teamLogo;

    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);

        teamLogo = itemView.findViewById(R.id.team_logo);

    }

}
