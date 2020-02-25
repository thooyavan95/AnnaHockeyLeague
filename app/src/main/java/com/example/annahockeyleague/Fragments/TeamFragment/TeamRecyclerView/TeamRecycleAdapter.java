package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.LogoSetter;
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
        Picasso.get().load(LogoSetter.setTeamLogo(arrayList.get(position))).fit().into(holder.teamLogo);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "get item count" + arrayList.size());
        return arrayList.size();
    }

}
