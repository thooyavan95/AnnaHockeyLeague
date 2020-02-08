package com.example.annahockeyleague.Entity;

import android.app.Application;

import androidx.viewpager.widget.ViewPager;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.R;
import com.google.android.material.tabs.TabLayout;

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
