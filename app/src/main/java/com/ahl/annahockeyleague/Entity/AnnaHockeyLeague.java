package com.ahl.annahockeyleague.Entity;

import android.app.Application;

import org.bson.types.ObjectId;

public class AnnaHockeyLeague extends Application {

    public static String tournamentId;


    public static String getTournamentId() {
        return tournamentId;
    }

    public static void setTournamentId(ObjectId tournamentId) {
        AnnaHockeyLeague.tournamentId = tournamentId.toString();
    }

}
