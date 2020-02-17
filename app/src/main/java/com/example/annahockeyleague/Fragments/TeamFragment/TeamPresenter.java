package com.example.annahockeyleague.Fragments.TeamFragment;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Team;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class TeamPresenter implements TeamModelInterface {

    private TeamModel teamModel;
    private TeamViewInterface teamViewInterface;


    public TeamPresenter(TeamViewInterface teamViewInterface)
    {
        this.teamViewInterface = teamViewInterface;
        teamModel = new TeamModel(TeamPresenter.this);
    }

    public void getTeamList(FragmentConfig config)
    {
        teamModel.getTeam(config);
    }

    @Override
    public void foundTeamList(ArrayList<Team> teamList) {

        teamViewInterface.showTeams(teamList);

    }
}
