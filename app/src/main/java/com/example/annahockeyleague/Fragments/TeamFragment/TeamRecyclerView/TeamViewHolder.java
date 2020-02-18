package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.Fragments.PlayerFragment.PlayerFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamFragment;
import com.example.annahockeyleague.R;


public class TeamViewHolder extends RecyclerView.ViewHolder {

    public ImageView teamLogo;
    public TextView teamName;

    public TeamViewHolder(@NonNull View itemView, final OnTeamSelected onTeamSelected) {
        super(itemView);

        teamLogo = itemView.findViewById(R.id.team_logo);
        teamName = itemView.findViewById(R.id.team_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(onTeamSelected != null) {

                    if(getAdapterPosition() != RecyclerView.NO_POSITION)
                    {
                        onTeamSelected.onTeamSelect(getAdapterPosition());
                    }
                }
            }
        });

    }

}
