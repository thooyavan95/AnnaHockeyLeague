package com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.Entity.TestTeamDetails;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamRecycleAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private ArrayList<TestTeamDetails> arrayList;

    public TeamRecycleAdapter(ArrayList<TestTeamDetails> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_template, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {

        Picasso.get().load(arrayList.get(position).getTestLogo()).fit().into(holder.teamLogo);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
