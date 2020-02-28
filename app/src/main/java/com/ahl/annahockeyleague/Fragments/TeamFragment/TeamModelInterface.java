package com.ahl.annahockeyleague.Fragments.TeamFragment;
import com.ahl.annahockeyleague.Entity.Team;

import java.util.ArrayList;

public interface TeamModelInterface {

    void foundTeamList(ArrayList<Team> arrayList);

    void errorMsg(Exception e);

}
