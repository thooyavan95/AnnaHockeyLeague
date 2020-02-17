package com.example.annahockeyleague.Fragments.PlayerFragment;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Player;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class PlayerPresenter implements PlayerModelInterface {

    private PlayerViewInterface playerViewInterface;
    private PlayerModel playerModel;

    public PlayerPresenter(PlayerViewInterface playerViewInterface) {
        this.playerViewInterface = playerViewInterface;
        playerModel = new PlayerModel(PlayerPresenter.this);
    }

    public void playerList(ObjectId teamId, FragmentConfig config)
    {
        playerModel.getPlayerList(teamId,config);
    }


    @Override
    public void foundPlayerList(ArrayList<Player> arrayList) {

        playerViewInterface.showPlayers(arrayList);

    }
}
