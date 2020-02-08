package com.example.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.R;

import java.util.ArrayList;

public class FixturesRecyclerView extends RecyclerView.Adapter<FixturesViewHolder> {

    private ArrayList<Fixtures> fixturesList;
    private FragmentConfig config;

    public FixturesRecyclerView(ArrayList<Fixtures> fixturesList, FragmentConfig config) {
        this.fixturesList = fixturesList;
        this.config = config;
    }

    @NonNull
    @Override
    public FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_layout, parent, false);
        return new FixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixturesViewHolder holder, int position) {


//        if (config == FragmentConfig.MEN) {
//
//            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_date)).setText(date);
//            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_time)).setText(time);
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_name)).setText(data.getTeam1Name());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_name)).setText(data.getTeam2Name());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_score)).setText(data.getTeam1Goal());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_score)).setText(data.getTeam2Goal());
//        } else {
//
//            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_date)).setText(date);
//            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_time)).setText(time);
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_name)).setText(data.getTeam1Name());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_name)).setText(data.getTeam2Name());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_score)).setText(data.getTeam1Goal());
//            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_score)).setText(data.getTeam2Goal());
//
//        }


            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_date)).setText("date");
            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_time)).setText("time");
            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_name)).setText(fixturesList.get(position).getTeam1Name());
            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_name)).setText(fixturesList.get(position).getTeam2Name());
            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_score)).setText(fixturesList.get(position).getTeam1Goal());
            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_score)).setText(fixturesList.get(position).getTeam2Goal());

    }

    @Override
    public int getItemCount() {
        return fixturesList.size();
    }
}
