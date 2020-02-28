package com.ahl.annahockeyleague.Fragments.PlayerFragment;

import android.util.Log;

import com.ahl.annahockeyleague.Entity.PlayerDetails;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class PlayerPresenter implements PlayerModelInterface {

    private PlayerViewInterface playerViewInterface;
    private PlayerModel playerModel;
    private static final String TAG = PlayerPresenter.class.getSimpleName();

    public PlayerPresenter(PlayerViewInterface playerViewInterface) {
        Log.d(TAG, "player presenter constructor called");
        this.playerViewInterface = playerViewInterface;
        playerModel = new PlayerModel(PlayerPresenter.this);
    }

    public void playerList(ObjectId teamId)
    {
        Log.d(TAG, "player list called");
        playerModel.getPlayerList(teamId);
    }


    @Override
    public void foundPlayerList(ArrayList<PlayerDetails> arrayList) {

        Log.d(TAG, "found player list callback");
        playerViewInterface.showPlayers(arrayList);

    }

    @Override
    public void errorMsg(Exception e) {
        Log.d(TAG, "error msg callback");
        playerViewInterface.displayErrorMessage(e);
    }
}
