package com.ahl.annahockeyleague.Fragments.HomeFragment;

import com.ahl.annahockeyleague.Entity.Fixtures;
import com.ahl.annahockeyleague.Entity.PointsTable;
import com.ahl.annahockeyleague.Entity.TopScorers;

import java.util.ArrayList;

public interface HomeModelInterface {

    void fixtureDataCollected(ArrayList<Fixtures> data);

    void pointsTableDataCollected(ArrayList<PointsTable> data);

    void topScorersDataCollected(ArrayList<TopScorers> data);

    void dataCollectionFailure(Exception e);

}
