package com.example.annahockeyleague.Interfaces;

import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;

import java.util.ArrayList;

public interface ViewInterface {

    void setNextMatchFixture(Fixtures data, String date, String time);

    void setPrevoiusMatchFixture(Fixtures data, String date, String time);

    void setPointsTable(ArrayList<PointsTable> pointsData);

    void setTopScorers(ArrayList<TopScorers> topScorersData);

    void setFailureToast(Exception e);

}
