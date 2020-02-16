package com.example.annahockeyleague.Fragments.TeamFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.TeamRecycleAdapter;
import com.example.annahockeyleague.R;

import java.util.ArrayList;

public class TeamFragment extends Fragment implements TeamViewInterface {

    private FragmentConfig config;

    public TeamFragment()
    {

    }

    public TeamFragment(FragmentConfig config)
    {
        this.config = config;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.team_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TeamPresenter fetch = new TeamPresenter(TeamFragment.this);
        fetch.getTeamList(config);

    }

    @Override
    public void showTeams(final ArrayList<Team> teamsList) {

        if(getView() != null && teamsList != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    RecyclerView recyclerView = getView().findViewById(R.id.team_recycle_view);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                    recyclerView.setHasFixedSize(true);

                    TeamRecycleAdapter adapter = new TeamRecycleAdapter(teamsList);
                    recyclerView.setAdapter(adapter);
                }
            });


        }

    }
}
