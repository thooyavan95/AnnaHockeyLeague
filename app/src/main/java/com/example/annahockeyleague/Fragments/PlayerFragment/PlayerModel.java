package com.example.annahockeyleague.Fragments.PlayerFragment;

import com.example.annahockeyleague.AhlConfig.AhlConstants;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Player;
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

public class PlayerModel {

    private OkHttpClient okHttpClient;
    private Gson gson;
    private PlayerModelInterface playerModelInterface;


    public PlayerModel(PlayerModelInterface playerModelInterface) {

        this.playerModelInterface = playerModelInterface;
        okHttpClient = new OkHttpClient();
        gson = new Gson();

    }

    public void getPlayerList(ObjectId teamId, FragmentConfig config)
    {
        Request players;

        if(config == FragmentConfig.MEN)
        {
            players = new Request.Builder().url(AhlConstants.DNS + "players/" + teamId ).build();
        }
        else
        {
            players = new Request.Builder().url(AhlConstants.DNS + "players/" + teamId).build();
        }

        okHttpClient.newCall(players).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String players = new String(response.body().bytes());
                Type founderListType = new TypeToken<ArrayList<Player>>(){}.getType();
                ArrayList<Player> playerList = gson.fromJson(players,founderListType);
                playerModelInterface.foundPlayerList(playerList);

            }
        });

    }


}
