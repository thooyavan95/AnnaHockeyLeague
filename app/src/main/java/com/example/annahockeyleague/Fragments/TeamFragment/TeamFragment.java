package com.example.annahockeyleague.Fragments.TeamFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Player;
import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.Fragments.PlayerFragment.PlayerFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.OnTeamSelected;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.TeamRecycleAdapter;
import com.example.annahockeyleague.R;
import com.example.annahockeyleague.TestInterface;

import java.util.ArrayList;

public class TeamFragment extends Fragment implements TeamViewInterface {

    private FragmentConfig config;
    private ProgressBar progressBar;
    private TeamPresenter fetch;
    private TestInterface testInterface;

    public TeamFragment()
    {

    }

    public TeamFragment(FragmentConfig config, TestInterface testInterface)
    {
        this.config = config;
        this.testInterface = testInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.team_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        progressBar = view.findViewById(R.id.team_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        fetch = new TeamPresenter(TeamFragment.this);
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
                    recyclerView.setBackgroundColor(getResources().getColor(R.color.colorWhisper));

                    TeamRecycleAdapter adapter = new TeamRecycleAdapter(teamsList, new OnTeamSelected() {
                        @Override
                        public void onTeamSelect(int position) {

                            testInterface.showPlayerFragment(teamsList.get(position));

                        }
                    });

                    recyclerView.setAdapter(adapter);

                    if(progressBar != null)
                    {
                        progressBar.setIndeterminate(false);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });

        }

    }
}
