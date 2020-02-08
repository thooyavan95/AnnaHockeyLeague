package com.example.annahockeyleague.Fragments.HomeFragment;

import android.util.Log;

import com.example.annahockeyleague.AhlConfig.AhlConstants;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.AnnaHockeyLeague;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;
import com.example.annahockeyleague.Entity.Tournament;
import com.example.annahockeyleague.Fragments.HomeFragment.HomeModelInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.annahockeyleague.Entity.AnnaHockeyLeague.tournamentId;

public class HomeModel {

    private HomeModelInterface homeModelInterface;
    private static final String TAG = "HomeModel";
    public static final String DNS = "https://young-coast-02878.herokuapp.com/api/";
    private Gson gson;


    private OkHttpClient beginDataCollection;


    public HomeModel(HomeModelInterface homeModelInterface)
    {
        Log.d(TAG,"HomeModel constructor");
        this.homeModelInterface = homeModelInterface;
        beginDataCollection = new OkHttpClient();
        gson = new Gson();
    }


    public void beginDataCollection(final FragmentConfig config)
    {

        Log.d(TAG,"begin data collection");

//        OkHttpClient beginDataCollection = new OkHttpClient();

        Request requestTournamentId = new Request.Builder().url(AhlConstants.DNS + AhlConstants.TOURNAMENTS_API).build();
        beginDataCollection.newCall(requestTournamentId).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"tournament api call failed");
                homeModelInterface.dataCollectionFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String tournamentResponse = new String(response.body().bytes());

//                Gson gson = new Gson();
                Tournament tournament = gson.fromJson(tournamentResponse, Tournament.class);

                Log.d("response", tournament.getId().toString());

                AnnaHockeyLeague.setTournamentId(tournament.getId());

//                getFixturesData(config);
////                getPointsTableData(config);
////                getTopScorersData(config);

            }
        });

    }

    private void getFixturesData(FragmentConfig config)
    {

        Log.d(TAG,"method fixtures call");

//        OkHttpClient beginDataCollection = new OkHttpClient();

        Request requestFixturesList;

        if(FragmentConfig.MEN == config) {
            Log.d(TAG,"men fixture api called");
            requestFixturesList = new Request.Builder().url(AhlConstants.DNS + AhlConstants.FIXTURES_API + tournamentId + AhlConstants.CATEGORY_MEN).build();
        }
        else
        {
            Log.d(TAG,"women fixture api called");
            requestFixturesList = new Request.Builder().url(AhlConstants.DNS + AhlConstants.FIXTURES_API + tournamentId + AhlConstants.CATEGORY_WOMEN).build();
        }

        Log.d(TAG, String.valueOf(requestFixturesList));

        beginDataCollection.newCall(requestFixturesList).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"fixture api called failed");
                homeModelInterface.dataCollectionFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String responseFromServer = new String(response.body().bytes());
                Log.e("data "," "+responseFromServer);
//                Gson gson = new Gson();

                Type founderListType = new TypeToken<ArrayList<Fixtures>>(){}.getType();
                ArrayList<Fixtures> foundList = gson.fromJson(responseFromServer, founderListType);

//                Log.d("obj",foundList.get(0).toString());

                homeModelInterface.fixtureDataCollected(foundList);
            }
        });
    }


    private void getPointsTableData(FragmentConfig config)
    {
        Log.d(TAG,"method begin points table data collection");

            Request requestPointsTableData;

            if(FragmentConfig.MEN == config) {
                Log.d(TAG,"men points table api called");
                requestPointsTableData = new Request.Builder().url(AhlConstants.DNS + AhlConstants.POINTS_TABLE_API + tournamentId + AhlConstants.CATEGORY_MEN ).build();
            }
            else
            {
                Log.d(TAG,"women points table api called");
                requestPointsTableData = new Request.Builder().url(AhlConstants.DNS + AhlConstants.POINTS_TABLE_API + tournamentId + AhlConstants.CATEGORY_WOMEN).build();
            }

            beginDataCollection.newCall(requestPointsTableData).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.d(TAG,"points table api called failed");
                    homeModelInterface.dataCollectionFailure(e);
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    Log.d(TAG,"points table api call success");

                    String responseFromServer = new String(response.body().bytes());

//                    Gson gson = new Gson();

                    Type founderListType = new TypeToken<ArrayList<PointsTable>>(){}.getType();
                    ArrayList<PointsTable> foundList = gson.fromJson(responseFromServer, founderListType);

                    Log.d("obj",foundList.get(0).toString());

                    homeModelInterface.pointsTableDataCollected(foundList);

                }
            });

    }


    private void getTopScorersData(FragmentConfig config)
    {
        Log.d(TAG,"method begin top scorer data collection");


        Request topScorersRequest;
        if(FragmentConfig.MEN == config)
        {
            Log.d(TAG,"men Top scorer api called");
            topScorersRequest = new Request.Builder().url(AhlConstants.DNS + AhlConstants.TOP_SCORER_API + tournamentId + "?category=men&count=3").build();
        }
        else
        {
            Log.d(TAG,"women Top scorer api called");
            topScorersRequest = new Request.Builder().url(AhlConstants.DNS + AhlConstants.TOP_SCORER_API + tournamentId + "?category=women&count=2").build();
        }

        beginDataCollection.newCall(topScorersRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"top scorer api failed");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG,"top scorer api call success");

                String responseFromServer = new String(response.body().bytes());

                Log.d(TAG, responseFromServer);

//                Gson gson = new Gson();

                Type founderListType = new TypeToken<ArrayList<TopScorers>>(){}.getType();
                ArrayList<TopScorers> foundList = gson.fromJson(responseFromServer, founderListType);

//                Log.d("obj",foundList.get(0).toString());

                homeModelInterface.topScorersDataCollected(foundList);

            }
        });

    }
}
