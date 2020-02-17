package com.example.annahockeyleague.Fragments.TeamFragment;

import android.util.Log;

import com.example.annahockeyleague.AhlConfig.AhlConstants;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.AnnaHockeyLeague;
import com.example.annahockeyleague.Entity.Player;
import com.example.annahockeyleague.Entity.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TeamModel {

    private TeamModelInterface modelInterface;
    private OkHttpClient okHttpClient;
    private Gson gson;


    public TeamModel(TeamModelInterface teamModelInterface) {

        this.modelInterface = teamModelInterface;
        okHttpClient = new OkHttpClient();
        gson = new Gson();
    }

    public void getTeam(FragmentConfig config)
    {

        Request requestTeam;

        if(config == FragmentConfig.MEN)
        {
             requestTeam = new Request.Builder().url(AhlConstants.DNS + "teams?tournament=" + AnnaHockeyLeague.getTournamentId() + "&category=men").build();
        }
        else
        {
             requestTeam = new Request.Builder().url(AhlConstants.DNS + "teams?tournament=" + AnnaHockeyLeague.getTournamentId() + "&category=women").build();
        }

        okHttpClient.newCall(requestTeam).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String responseList = new String(response.body().bytes());
                    Log.d("Team data", ""+responseList);

                Type founderListType = new TypeToken<ArrayList<Team>>(){}.getType();
                ArrayList<Team> foundList = gson.fromJson(responseList, founderListType);
                modelInterface.foundTeamList(foundList);
            }
        });

    }

}
