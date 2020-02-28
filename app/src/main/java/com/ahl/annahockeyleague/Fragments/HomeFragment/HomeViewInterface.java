package com.ahl.annahockeyleague.Fragments.HomeFragment;

import com.ahl.annahockeyleague.Entity.Fixtures;
import com.ahl.annahockeyleague.Entity.PointsTable;
import com.ahl.annahockeyleague.Entity.TopScorers;

import java.util.ArrayList;

public interface HomeViewInterface {

    void setNextMatchFixture(Fixtures data);

    void setPrevoiusMatchFixture(Fixtures data);

    void setPointsTable(ArrayList<PointsTable> pointsData);

    void setTopScorers(ArrayList<TopScorers> topScorersData);

    void setFailureToast(Exception e);

    void setFixtures(ArrayList<Fixtures> fixdata);

}
