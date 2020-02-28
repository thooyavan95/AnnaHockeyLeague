package com.ahl.annahockeyleague.Fragments.HomeFragment;

import android.util.Log;

import com.ahl.annahockeyleague.AhlConfig.AhlConstants;
import com.ahl.annahockeyleague.Entity.AnnaHockeyLeague;
import com.ahl.annahockeyleague.Entity.Fixtures;
import com.ahl.annahockeyleague.Entity.PointsTable;
import com.ahl.annahockeyleague.Entity.TopScorers;
import com.ahl.annahockeyleague.Entity.Tournament;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

import static com.ahl.annahockeyleague.Entity.AnnaHockeyLeague.tournamentId;

public class HomeModel {

    private HomeModelInterface homeModelInterface;
    private static final String TAG = "HomeModel";
    private Gson gson;
    private Request.Builder request;


    private OkHttpClient.Builder httpClient;


    public HomeModel(HomeModelInterface homeModelInterface)
    {
        Log.d(TAG,"HomeModel constructor");
        this.homeModelInterface = homeModelInterface;
        httpClient = new OkHttpClient.Builder();
        request = new Request.Builder();
        gson = new Gson();
    }


    public void beginDataCollection(final String config)
    {

        Log.d(TAG,"begin data collection");

        httpClient = httpClient.connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS);


        Request requestTournamentId = request.url(AhlConstants.DNS + "tournament?season=2020&type=AHL").build();
        httpClient.build().newCall(requestTournamentId).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"tournament api call failed");
                homeModelInterface.dataCollectionFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String tournamentResponse = new String(response.body().bytes());

                Tournament tournament = gson.fromJson(tournamentResponse, Tournament.class);

                Log.d("response", tournament.getId().toString());

                AnnaHockeyLeague.setTournamentId(tournament.getId());

                    getFixturesData(config);
                getPointsTableData(config);
                getTopScorersData(config);

            }
        });

    }

    private void getFixturesData(String config)
    {

        Log.d(TAG,"method fixtures call");

        Request requestFixturesList;

        if(AhlConstants.men.equals(config)) {
            Log.d(TAG,"men fixture api called");
            requestFixturesList = request.url(AhlConstants.DNS + AhlConstants.FIXTURES_API + tournamentId + AhlConstants.CATEGORY_MEN).build();
        }
        else
        {
            Log.d(TAG,"women fixture api called");
            requestFixturesList = request.url(AhlConstants.DNS + AhlConstants.FIXTURES_API + tournamentId + AhlConstants.CATEGORY_WOMEN).build();
        }

        Log.d(TAG, String.valueOf(requestFixturesList));

        httpClient.build().newCall(requestFixturesList).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"fixture api called failed");
                homeModelInterface.dataCollectionFailure(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String responseFromServer = new String(response.body().bytes());
                Log.e("data "," "+responseFromServer);

                Type founderListType = new TypeToken<ArrayList<Fixtures>>(){}.getType();
                ArrayList<Fixtures> foundList = gson.fromJson(responseFromServer, founderListType);


                homeModelInterface.fixtureDataCollected(foundList);

            }
        });
    }


    private void getPointsTableData(String config)
    {
        Log.d(TAG,"method begin points table data collection");

            Request requestPointsTableData;

        if(AhlConstants.men.equals(config)) {
                Log.d(TAG,"men points table api called");
                requestPointsTableData = request.url(AhlConstants.DNS + AhlConstants.POINTS_TABLE_API + tournamentId + AhlConstants.CATEGORY_MEN ).build();
            }
            else
            {
                Log.d(TAG,"women points table api called");
                requestPointsTableData = request.url(AhlConstants.DNS + AhlConstants.POINTS_TABLE_API + tournamentId + AhlConstants.CATEGORY_WOMEN).build();
            }

            httpClient.build().newCall(requestPointsTableData).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.d(TAG,"points table api called failed");
                    homeModelInterface.dataCollectionFailure(e);
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {


                    String responseFromServer = new String(response.body().bytes());

                    Log.d(TAG,"points table api call success" + responseFromServer);

                    Type founderListType = new TypeToken<ArrayList<PointsTable>>(){}.getType();
                    ArrayList<PointsTable> foundList = gson.fromJson(responseFromServer, founderListType);


                    homeModelInterface.pointsTableDataCollected(foundList);

                }
            });

    }


    private void getTopScorersData(String config)
    {
        Log.d(TAG,"method begin top scorer data collection");


        Request topScorersRequest;
        if(AhlConstants.men.equals(config)) {
            Log.d(TAG,"men Top scorer api called");
            topScorersRequest = request.url(AhlConstants.DNS + AhlConstants.TOP_SCORER_API + tournamentId + "?category=men&count=3").build();
        }
        else
        {
            Log.d(TAG,"women Top scorer api called");
            topScorersRequest = request.url(AhlConstants.DNS + AhlConstants.TOP_SCORER_API + tournamentId + "?category=women&count=3").build();
        }

        httpClient.build().newCall(topScorersRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"top scorer api failed");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String responseFromServer = new String(response.body().bytes());

                Log.d(TAG,"top scorer api call success" + responseFromServer);

                Type founderListType = new TypeToken<ArrayList<TopScorers>>(){}.getType();
                ArrayList<TopScorers> foundList = gson.fromJson(responseFromServer, founderListType);

                homeModelInterface.topScorersDataCollected(foundList);

            }
        });

    }
}
