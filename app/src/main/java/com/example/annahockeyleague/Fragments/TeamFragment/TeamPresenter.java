package com.example.annahockeyleague.Fragments.TeamFragment;

import android.util.Log;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Team;

import java.util.ArrayList;

public class TeamPresenter implements TeamModelInterface {

    private TeamModel teamModel;
    private TeamViewInterface teamViewInterface;
    private static final String TAG = TeamPresenter.class.getSimpleName();


    public TeamPresenter(TeamViewInterface teamViewInterface)
    {
        Log.d(TAG, "team presenter constructor called");
        this.teamViewInterface = teamViewInterface;
        teamModel = new TeamModel(TeamPresenter.this);
    }

    public void getTeamList(FragmentConfig config)
    {
        Log.d(TAG, "get team list called");
        teamModel.getTeam(config);
    }

    @Override
    public void foundTeamList(ArrayList<Team> teamList) {

        Log.d(TAG, "found team list called");
        teamViewInterface.showTeams(teamList);

    }

    @Override
    public void errorMsg(Exception e) {
        Log.d(TAG, "error message" + e.toString());
        teamViewInterface.displayErrorMessage(e);
    }
}
