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
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TeamModel {

    private TeamModelInterface modelInterface;
    private Request.Builder request;
    private static final String TAG = TeamModel.class.getSimpleName();


    public TeamModel(TeamModelInterface teamModelInterface) {

          Log.d(TAG, "team model constructor");
        this.modelInterface = teamModelInterface;
        request = new Request.Builder();
    }

    public void getTeam(FragmentConfig config)
    {
          Log.d(TAG, "get team called");
        Request requestTeam;

        if(config == FragmentConfig.MEN)
        {
            Log.d(TAG, "men team request called");
              requestTeam = request.url(AhlConstants.DNS + "teams?tournament=" + AnnaHockeyLeague.getTournamentId() + "&category=men").build();
        }
        else
        {
            Log.d(TAG, "women team request called");
             requestTeam = request.url(AhlConstants.DNS + "teams?tournament=" + AnnaHockeyLeague.getTournamentId() + "&category=women").build();
        }

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build()
                .newCall(requestTeam).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                Log.d(TAG, "api call failed" + e);
                modelInterface.errorMsg(e);

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String responseList = new String(response.body().bytes());
                    Log.d("Team data", ""+responseList);

                Type founderListType = new TypeToken<ArrayList<Team>>(){}.getType();
                Gson gson = new Gson();
                ArrayList<Team> foundList = gson.fromJson(responseList, founderListType);
                modelInterface.foundTeamList(foundList);
            }
        });

    }

}
