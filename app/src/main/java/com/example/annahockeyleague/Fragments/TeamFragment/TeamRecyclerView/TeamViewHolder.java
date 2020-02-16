package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.R;

import org.w3c.dom.Text;

public class TeamViewHolder extends RecyclerView.ViewHolder {

    public ImageView teamLogo;
    public TextView teamName;

    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);

        teamLogo = itemView.findViewById(R.id.team_logo);
        teamName = itemView.findViewById(R.id.team_name);

    }

}
