package com.ahl.annahockeyleague.Fragments.TeamFragment;

import com.ahl.annahockeyleague.Entity.Team;

import java.util.ArrayList;

public interface TeamViewInterface {

    void showTeams(ArrayList<Team> teamList);

    void displayErrorMessage(Exception e);

}
