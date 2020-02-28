package com.ahl.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.R;


public class TeamViewHolder extends RecyclerView.ViewHolder {

    public ImageView teamLogo;
    public TextView teamName;
    private static final String TAG = TeamViewHolder.class.getSimpleName();

    public TeamViewHolder(@NonNull View itemView, final OnTeamSelected onTeamSelected) {
        super(itemView);

        Log.d(TAG, "team view holder constructor");

        teamLogo = itemView.findViewById(R.id.team_logo);
        teamName = itemView.findViewById(R.id.team_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "team on click called");
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
