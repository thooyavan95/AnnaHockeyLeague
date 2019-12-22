package com.example.annahockeyleague.Interfaces;

import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;

import java.util.ArrayList;

public interface ModelInterface {

    void fixtureDataCollected(ArrayList<Fixtures> data);

    void pointsTableDataCollected(ArrayList<PointsTable> data);

    void topScorersDataCollected(ArrayList<TopScorers> data);

    void dataCollectionFailure(Exception e);
}
