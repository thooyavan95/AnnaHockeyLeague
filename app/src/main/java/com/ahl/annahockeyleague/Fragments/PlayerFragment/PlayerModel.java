package com.ahl.annahockeyleague.Fragments.PlayerFragment;

import android.util.Log;

import com.ahl.annahockeyleague.AhlConfig.AhlConstants;
import com.ahl.annahockeyleague.Entity.PlayerDetails;
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

public class PlayerModel {

    private OkHttpClient.Builder okHttpClient;
    private PlayerModelInterface playerModelInterface;
    private static final String TAG = PlayerModel.class.getSimpleName();


    public PlayerModel(PlayerModelInterface playerModelInterface) {

        Log.d(TAG, "player model constructor called");
        this.playerModelInterface = playerModelInterface;
        okHttpClient = new OkHttpClient.Builder();
    }

    public void getPlayerList(ObjectId teamId)
    {
        Log.d(TAG, "get player list called");

        Request players;

            players = new Request.Builder().url(AhlConstants.DNS + "players/" + teamId ).build();

            okHttpClient.connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS);

            OkHttpClient client;
            client = okHttpClient.build();

        client.newCall(players).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                Log.d("players", e.toString());
                playerModelInterface.errorMsg(e);

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                Log.d("players", response.toString());

                        String players = new String(response.body().bytes());
                        Type founderListType = new TypeToken<ArrayList<PlayerDetails>>() {
                        }.getType();
                        Gson gson = new Gson();
                        ArrayList<PlayerDetails> playerList = gson.fromJson(players, founderListType);
                        playerModelInterface.foundPlayerList(playerList);
            }
        });

    }


}
