package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamRecycleAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private ArrayList<Team> arrayList;
    private OnTeamSelected onTeamSelected;
    private static final String TAG = TeamRecycleAdapter.class.getSimpleName();

    public TeamRecycleAdapter(ArrayList<Team> arrayList, OnTeamSelected onTeamSelected) {
        Log.d(TAG, "team recycle adapter constructor");
        this.arrayList = arrayList;
        this.onTeamSelected = onTeamSelected;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "on create view holder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_template, parent, false);
        return new TeamViewHolder(view, onTeamSelected);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {

        Log.d(TAG, "on bind view holder");

        holder.teamName.setText(arrayList.get(position).getName());
        Picasso.get().load(setTeamLogo(arrayList.get(position))).fit().into(holder.teamLogo);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "get item count" + arrayList.size());
        return arrayList.size();
    }

    private int setTeamLogo(Team data)
    {
        Log.d(TAG, "set team logo called");

        int image = 0;

        switch (data.getTeamTag())
        {

            case M_RED:

            case W_RED:

                image =  R.drawable.red;
                break;

            case M_BLUE:

            case W_BLUE:

                image = R.drawable.bluz;
                break;

            case M_GREEN:

            case W_GREEN:

                image =  R.drawable.griffinz;
                break;

            case M_WHITE:

            case W_WHITE:

                image =  R.drawable.white;
                break;

            case M_VIOLET:

            case W_VIOLET:

                image =  R.drawable.driblerz;
                break;

            case M_YELLOW:

            case W_YELLOW:

                image =  R.drawable.yyy;
                break;

            case M_BLACK:

                image = R.drawable.android_image;
                break;

        }

        return image;
    }


}
